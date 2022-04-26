package com.drevery.scpdisturbance.events;

import com.drevery.scpdisturbance.SCPDisturbance;
import com.drevery.scpdisturbance.item.MicroHIDItem;
import com.drevery.scpdisturbance.network.MicroHIDControlsMessage;
import com.drevery.scpdisturbance.registration.ModItems;
import net.minecraft.nbt.ByteTag;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ShortTag;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.FOVModifierEvent;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.client.event.sound.SoundEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.item.ItemTossEvent;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

/**
 * Important things to note goes here
 */
@Mod.EventBusSubscriber(modid = SCPDisturbance.MOD_ID)
public class MicroHIDEvents {

    @SubscribeEvent //Resorting to the Tick Event Not Great but better than 10+ events
    public static void playerTickEvent(TickEvent.PlayerTickEvent event) {
        if (event.player.level.isClientSide) return; //We want to run on serverside for nbt logic
        Player player = event.player; //easier to write and makes it look cleaner
        if (!isPlayerHoldingHID(player)) removeSpeedModifiers(event.player);
        else { //Is Holding the HID
            ItemStack hid = getHIDFromPlayer(player);
            CompoundTag nbt = hid.getTag(); //Tag used as read only
            if (nbt == null) {
                SCPDisturbance.LOGGER.warn("Provided HID Tag on Player[{}] was null! Generating Default Tag", player.getScoreboardName());
                hid.setTag(getDefaultHIDTag());
                return;
            }

            //Deserialize nbt to multiple variables
            boolean aim = nbt.getBoolean(MicroHIDItem.TAG_AIMING_KEY);
            boolean trigger = nbt.getBoolean(MicroHIDItem.TAG_TRIGGER_KEY);
            boolean charged = nbt.getBoolean(MicroHIDItem.TAG_CHARGED_KEY);

            short currentFailedTime = nbt.getShort(MicroHIDItem.TAG_FAILED_COOLDOWN_KEY);
            short currentChargeTime = nbt.getShort(MicroHIDItem.TAG_CHARGE_TIME_KEY);

            //CODE\\
            //All code in here is the firing mechanic, sound and all that nitty-gritty stuff
            //NO RETURNS IN THIS AS IT HAS TO SERIALISE TO PUT BACK INTO ITEM TO SAVE DATA
            //Sounds are Temp

            //Check if the trigger is being held and if the gun hasn't charged and isn't cooling down
            if (trigger && !charged && currentFailedTime == 0) {
                if (currentChargeTime == 0) player.level.playSound(null, player.blockPosition(), SoundEvents.PORTAL_TRIGGER, SoundSource.BLOCKS, .25F, .75F);
                if (currentChargeTime < MicroHIDItem.CHARGE_TIME) { //Still Charging
                    currentChargeTime++;
                } else { //Fully Charged
                    charged = true;
                    currentChargeTime = MicroHIDItem.SHOOT_DURATION;
                }
            }

            //charged == currently firing
            if (charged) {
                if (currentChargeTime > 0) {
                    player.level.playSound(null, player.blockPosition(), SoundEvents.GENERIC_EXPLODE, SoundSource.BLOCKS, .25F, 3F);
                    currentChargeTime--;
                }
            }

            if (charged && currentChargeTime == 0) {
                currentChargeTime = -1;
                //One time fire event for Depletion
            }

            //TODO USE CHARGED and currentChargeTime == 0 to detect depletion

            //If Trigger is false while it isn't fully charged and there is progress, start cool down
            if (!trigger && !charged && currentChargeTime > 0) { //Failed to hold while charging, start fail cooldown
                currentFailedTime = MicroHIDItem.CHARGE_FAIL_COOLDOWN;
                currentChargeTime = 0;
                player.level.playSound(null, player.blockPosition(), SoundEvents.GHAST_SCREAM, SoundSource.BLOCKS, 1, 1);
            }

            //Decrease the current failed time
            if (currentFailedTime > 0) currentFailedTime--;

            //END CODE\\

            //Serialise back to HID
            nbt.put(MicroHIDItem.TAG_AIMING_KEY, ByteTag.valueOf(aim));
            nbt.put(MicroHIDItem.TAG_TRIGGER_KEY, ByteTag.valueOf(trigger));
            nbt.put(MicroHIDItem.TAG_CHARGED_KEY, ByteTag.valueOf(charged));

            nbt.put(MicroHIDItem.TAG_FAILED_COOLDOWN_KEY, ShortTag.valueOf(currentFailedTime));
            nbt.put(MicroHIDItem.TAG_CHARGE_TIME_KEY, ShortTag.valueOf(currentChargeTime));
            hid.setTag(nbt);
        }
    }

    @SubscribeEvent //Ensures players stats have been reset if the item was thrown
    public static void itemTossEvent(ItemTossEvent event) {
        //TODO Might come into use later to prevent player from throwing the item when firing
        if (!isPlayerHoldingHID(event.getPlayer())) removeSpeedModifiers(event.getPlayer());
    }

    //Generic multi use method calls

    public static CompoundTag getDefaultHIDTag() {
        return ModItems.MICROHID.get().getDefaultInstance().getTag();
    }

    public static void removeSpeedModifiers(Player player) {
        getSpeedAttribute(player).removeModifier(MicroHIDItem.SPEED_MODIFIER_UUID);
        getSpeedAttribute(player).removeModifier(MicroHIDItem.SPEED_MODIFIER_AIM_UUID);
    }

    public static AttributeInstance getSpeedAttribute(LivingEntity entity) {
        return entity.getAttributes().getInstance(Attributes.MOVEMENT_SPEED);
    }

    public static ItemStack getHIDFromPlayer(Player player) {
        return player.getMainHandItem().is(ModItems.MICROHID.get()) ? player.getMainHandItem() : player.getOffhandItem();
    }

    public static boolean isPlayerHoldingHID(Player player) {
        return (player.getMainHandItem().is(ModItems.MICROHID.asItem()) || player.getOffhandItem().is(ModItems.MICROHID.asItem())) && !player.isSpectator();
    }

    //All Events below this (Besides The Client Class) is mostly to do with Server side authorization to ensure that any cheaters cannot find a workaround.

    @SubscribeEvent //Cancels all interactions when holding the HID (Server Side Check)
    public static void playerInteractEvent(PlayerInteractEvent event) {
        if (isPlayerHoldingHID(event.getPlayer())) {
            if (event.isCancelable()) {
                event.setCancellationResult(InteractionResult.FAIL);
                event.setCanceled(true);
                if (!event.getPlayer().level.isClientSide) SCPDisturbance.LOGGER.warn("Suspicious PlayerInteractEvent call for player {}, Event should be canceled client side, this can be due to a modified client or a client/server mismatch", event.getPlayer().getScoreboardName());
            }
        }
    }

    @SubscribeEvent //Cancels the ability to attack entities when holding the HID (Server Side Check)
    public static void playerAttackEntityEvent(AttackEntityEvent event) {
        if (isPlayerHoldingHID(event.getPlayer())) {
            event.setCanceled(true);
            if (!event.getPlayer().level.isClientSide) SCPDisturbance.LOGGER.warn("Suspicious AttackEntityEvent call for player {}, Event should be canceled client side, this can be due to a modified client or a client/server mismatch", event.getPlayer().getScoreboardName());
        }
    }


    //Client Sided mods, anything that can effect server needs to be synced
    @Mod.EventBusSubscriber(value = Dist.CLIENT, modid = SCPDisturbance.MOD_ID)
    public static class ClientSide {

        //Static vars should be fine for client side
        private static boolean delayHeld = false;
        private static boolean delayAim = false;

        @SubscribeEvent
        public static void fovModifyEvent(FOVModifierEvent event) {
            //TODO Also make it harder to turn when aiming down?
            //  Also Keep Model ViewPoint the same when aiming

            //Most of the if checks are for FOV smoothening and prevent jerk on FOV modification since the event is delayed by a tick
            Player player = event.getEntity();
            if (isPlayerHoldingHID(player)) {
                //Check for delay on held
                if (delayHeld)  event.setNewfov(event.getNewfov() + 0.05F);
                else delayHeld = true;

                //Check for aim
                ItemStack hid = getHIDFromPlayer(player);
                if (!hid.hasTag()) hid.setTag(getDefaultHIDTag());
                byte aiming = hid.getTag().getByte(MicroHIDItem.TAG_AIMING_KEY);
                if (aiming == 1) {
                    if (delayAim) event.setNewfov(event.getNewfov() + 0.1F);
                    else delayAim = true;
                } else {
                    if (delayAim) event.setNewfov(event.getNewfov() + 0.1F); //Final Smoothen before it cuts off
                    delayAim = false;
                }
            } else {
                if (delayHeld) event.setNewfov(event.getNewfov() + 0.05F); //Final Smoothen before it cuts off
                delayHeld = false;
                delayAim = false;
            }
        }

        /**
         * (QOL) Prevents from swinging arm and sending input to server. <br>
         * If a Hacker removes this event, Server can still prevent interactions however will log the potentially suspicious activity,
         * and also will be a big L for them as they will not be able to use MicroHID
         */
        @SubscribeEvent // Checks to see if the mouse was clicked
        public static void clickInputEvent(InputEvent.ClickInputEvent event) {
            net.minecraft.client.Minecraft mc = net.minecraft.client.Minecraft.getInstance();
            if (isPlayerHoldingHID(mc.player)) {
                event.setCanceled(true);
                event.setSwingHand(false);
                byte use = (byte) (event.isUseItem() ? (event.getKeyMapping().isDown() ? 1 : 0) : 2);
                byte charge = (byte) (event.isAttack() ? (event.getKeyMapping().isDown() ? 1 : 0) : 2);
                //This does spam the server but its really lightweight, so it shouldn't be that bad
                SCPDisturbance.NETWORK.sendToServer(new MicroHIDControlsMessage(use, charge));
            }
        }

        @SubscribeEvent //Used to check if the mouse was released
        public static void rawMouseClicked(InputEvent.RawMouseEvent event) {
            if (event.getAction() != 0) return;
            net.minecraft.client.Minecraft mc = net.minecraft.client.Minecraft.getInstance();
            if (mc.player == null) return;
            if (isPlayerHoldingHID(mc.player) && !mc.player.isSpectator()) {
                byte use = (byte) (event.getButton() == 1 ? event.getAction() : 2);
                byte charge = (byte) (event.getButton() == 0 ? event.getAction() : 2);
                SCPDisturbance.NETWORK.sendToServer(new MicroHIDControlsMessage(use, charge));
            }
        }


        @SubscribeEvent
        public static void mouseScroll(InputEvent.MouseScrollEvent event) {
            net.minecraft.client.Minecraft mc = net.minecraft.client.Minecraft.getInstance();
            //When scroll onto MicroHID with offhand full, don't do it lol
        }
    }
}
