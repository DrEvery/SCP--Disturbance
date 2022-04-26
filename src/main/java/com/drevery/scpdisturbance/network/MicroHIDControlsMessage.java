package com.drevery.scpdisturbance.network;

import com.drevery.scpdisturbance.SCPDisturbance;
import com.drevery.scpdisturbance.events.MicroHIDEvents;
import com.drevery.scpdisturbance.item.MicroHIDItem;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.network.NetworkEvent;
import org.apache.logging.log4j.Marker;
import org.apache.logging.log4j.MarkerManager;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Supplier;

public class MicroHIDControlsMessage {

    private static final Marker MARKER = MarkerManager.getMarker("MicroHIDControlsMessage");

    public final byte aim;
    public final byte trigger;

    /**
     * 0 for Not Pressed, 1 for Pressed, 2 for unknown
     */
    public MicroHIDControlsMessage(byte aim, byte trigger) {
        this.aim = aim;
        this.trigger = trigger;
    }

    public MicroHIDControlsMessage(FriendlyByteBuf buf) {
        this(buf.readByte(), buf.readByte());
    }

    public void encoder(FriendlyByteBuf buf) {
        buf.writeByte(aim);
        buf.writeByte(trigger);
    }

    public boolean handle(Supplier<NetworkEvent.Context> ctx) {
        AtomicBoolean handled = new AtomicBoolean(false);
        ctx.get().enqueueWork(() -> {
            ServerPlayer player = ctx.get().getSender();
            if (player != null) {
                if (MicroHIDEvents.isPlayerHoldingHID(player)) {
                    ItemStack hid = MicroHIDEvents.getHIDFromPlayer(player);
                    CompoundTag nbt = hid.getTag();
                    if (nbt != null) {
                        if (aim < 2) { //if True, Aim Needs to be changed
                            nbt.putByte(MicroHIDItem.TAG_AIMING_KEY, aim);
                        }

                        if (trigger < 2) { //if True, Shoot Needs to be changed
                            nbt.putByte(MicroHIDItem.TAG_TRIGGER_KEY, trigger);
                        }

                        hid.setTag(nbt);
                        handled.set(true);
                    } else {
                        SCPDisturbance.LOGGER.warn(MARKER, "Provided HID Tag on Player[{}] was null!", player.getScoreboardName());
                    }
                }
            }
        });
        ctx.get().setPacketHandled(handled.get());
        return handled.get();
    }
}
