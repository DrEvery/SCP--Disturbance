package com.drevery.scplol.events;

import com.drevery.scplol.SCPDisturbance;
import com.drevery.scplol.commands.ReturnHomeCommand;
import com.drevery.scplol.commands.SetHomeCommand;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.server.command.ConfigCommand;

@Mod.EventBusSubscriber(modid = SCPDisturbance.MOD_ID)
public class ModEvents
{

    @SubscribeEvent
    public static void onCommandsRegister(RegisterCommandsEvent event) {
        new SetHomeCommand(event.getDispatcher());
        new ReturnHomeCommand(event.getDispatcher());

        ConfigCommand.register(event.getDispatcher());
    }

    @SubscribeEvent
    public static void onPlayerCloneEvent(PlayerEvent.Clone event) {
        if(!event.getOriginal().getEntityWorld().isRemote()) {
            event.getPlayer().getPersistentData().putIntArray(SCPDisturbance.MOD_ID + "homepos",
                    event.getOriginal().getPersistentData().getIntArray(SCPDisturbance.MOD_ID + "homepos"));
        }
    }
}
