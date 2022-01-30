package com.drevery.scpdisturbance.events;

import com.drevery.scpdisturbance.SCPDisturbance;
import com.drevery.scpdisturbance.commands.ReturnHomeCommand;
import com.drevery.scpdisturbance.commands.SetHomeCommand;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.server.command.ConfigCommand;

@Mod.EventBusSubscriber(modid = SCPDisturbance.MOD_ID)
public class CommonEvents { //Forge Events used on normal events IE. LivingDeathEvent

    @SubscribeEvent
    public static void onPlayerCloneEvent(PlayerEvent.Clone event) {
        if(!event.getOriginal().getEntityWorld().isRemote()) {
            event.getPlayer().getPersistentData().putIntArray(SCPDisturbance.MOD_ID + "homepos",
                    event.getOriginal().getPersistentData().getIntArray(SCPDisturbance.MOD_ID + "homepos"));
        }
    }

    @SubscribeEvent
    public static void onCommandsRegister(RegisterCommandsEvent event) {
        new SetHomeCommand(event.getDispatcher());
        new ReturnHomeCommand(event.getDispatcher());

        ConfigCommand.register(event.getDispatcher());
    }

    @Mod.EventBusSubscriber(modid = SCPDisturbance.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ModEvents { //Mod Events are less common and are mostly setup events

    }
}
