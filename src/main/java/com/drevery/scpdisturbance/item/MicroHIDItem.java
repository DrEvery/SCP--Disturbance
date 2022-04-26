package com.drevery.scpdisturbance.item;

import com.drevery.scpdisturbance.events.MicroHIDEvents;
import io.github.connortron110.connorsapi.client.ItemModelEvents;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.ByteTag;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ShortTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraftforge.client.IItemRenderProperties;

import java.util.UUID;
import java.util.function.Consumer;

import static com.drevery.scpdisturbance.events.MicroHIDEvents.getSpeedAttribute;

//TODO No Jump limitation (could remove it entirely, but that's a huge nerf)
public class MicroHIDItem extends Item {

    public final static UUID SPEED_MODIFIER_UUID = UUID.fromString("5F49F0CE-2C51-4C2A-8478-897A1D1264F4");
    public final static UUID SPEED_MODIFIER_AIM_UUID = UUID.fromString("FFB92109-27DC-4392-9C13-90DC5A34A45B");
    private final static AttributeModifier SPEED_MODIFIER = new AttributeModifier(SPEED_MODIFIER_UUID, "microhid_speed_modifier", -0.2D, AttributeModifier.Operation.MULTIPLY_TOTAL);
    private final static AttributeModifier SPEED_MODIFIER_AIM = new AttributeModifier(SPEED_MODIFIER_AIM_UUID, "microhid_speed_modifier_aim", -0.7D, AttributeModifier.Operation.MULTIPLY_TOTAL);

    //Constants for the weapon to go off
    public static final int CHARGE_FAIL_COOLDOWN = 5*20; //IF the charge was canceled before the weapon fired, there is a cool down period before the weapon can be fired again
    public static final int CHARGE_TIME = 10*20;
    public static final int SHOOT_DURATION = 5*20;

    public static final short DAMAGE = 15; // Damage Per Second
    public static final short DAMAGE_AIM = 20;

    public static final String TAG_AIMING_KEY = "isAiming";
    public static final String TAG_TRIGGER_KEY = "isTrigger";
    public static final String TAG_CHARGED_KEY = "isCharged";

    //Tags used to keep track of time on the HID
    public static final String TAG_FAILED_COOLDOWN_KEY = "failedCooldown";
    public static final String TAG_CHARGE_TIME_KEY = "chargeTime";

    public MicroHIDItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public ItemStack getDefaultInstance() {
        ItemStack defaultInstance = new ItemStack(this);
        CompoundTag nbt = defaultInstance.getOrCreateTag();
        nbt.put(TAG_AIMING_KEY, ByteTag.ZERO);
        nbt.put(TAG_TRIGGER_KEY, ByteTag.ZERO);
        nbt.put(TAG_CHARGED_KEY, ByteTag.ZERO);
        nbt.put(TAG_FAILED_COOLDOWN_KEY, ShortTag.valueOf((short) 0));
        nbt.put(TAG_CHARGE_TIME_KEY, ShortTag.valueOf((short) 0));
        defaultInstance.setTag(nbt);
        return defaultInstance;
    }

    @Override //Creative Tab by default doesn't use `getDefaultInstance()`
    public void fillItemCategory(CreativeModeTab pCategory, NonNullList<ItemStack> pItems) {
        if (this.allowdedIn(pCategory)) {
            pItems.add(getDefaultInstance());
        }
    }

    @Override
    public Component getName(ItemStack pStack) {
        String s = ""; //TODO Make Better
        if (pStack.getOrCreateTag().getBoolean(TAG_CHARGED_KEY) && pStack.getOrCreateTag().getShort(TAG_CHARGE_TIME_KEY) == -1) {
            s = ".depleted";
        }
        return new TranslatableComponent(this.getDescriptionId(pStack) + s);
    }

    @Override
    public boolean shouldCauseReequipAnimation(ItemStack oldStack, ItemStack newStack, boolean slotChanged) {
        return false;
    }

    @Override
    public void inventoryTick(ItemStack pStack, Level pLevel, Entity pEntity, int pSlotId, boolean pIsSelected) {
        //Movement Effector
        if (pEntity instanceof LivingEntity livingEntity) {
            AttributeInstance attInst = getSpeedAttribute(livingEntity);
            if (pIsSelected) {
                if (!pStack.hasTag()) pStack.setTag(MicroHIDEvents.getDefaultHIDTag());
                if (pStack.getTag().getByte(TAG_AIMING_KEY) == 1 && !attInst.hasModifier(SPEED_MODIFIER_AIM)) {
                    attInst.addTransientModifier(SPEED_MODIFIER_AIM);
                    attInst.removeModifier(SPEED_MODIFIER_UUID);
                }

                if (pStack.getTag().getByte(TAG_AIMING_KEY) == 0 && !attInst.hasModifier(SPEED_MODIFIER)) {
                    attInst.addTransientModifier(SPEED_MODIFIER);
                    attInst.removeModifier(SPEED_MODIFIER_AIM_UUID);
                }
            } else if (attInst.hasModifier(SPEED_MODIFIER)) {
                attInst.removeModifier(SPEED_MODIFIER_UUID);
            }
        }
    }

    @Override
    public void initializeClient(Consumer<IItemRenderProperties> consumer) {
        consumer.accept(ItemModelEvents.stackRenderOverride());
    }
}
