package com.drevery.scpdisturbance.events;

import com.drevery.scpdisturbance.ModDamageSources;
import com.drevery.scpdisturbance.SCPDisturbance;
import com.drevery.scpdisturbance.block.ModBlocks;
import com.drevery.scpdisturbance.commands.ReturnHomeCommand;
import com.drevery.scpdisturbance.commands.SetHomeCommand;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.server.command.ConfigCommand;

import java.util.ArrayList;

@Mod.EventBusSubscriber(modid = SCPDisturbance.MOD_ID)
public class CommonEvents { //Forge Events used on normal events IE. LivingDeathEvent

    static final ArrayList<Block> SCP002_BED_REPLACEABLE = new ArrayList<>();
    static {
        SCP002_BED_REPLACEABLE.add(ModBlocks.FLOOR_TRAP.get());
        SCP002_BED_REPLACEABLE.add(ModBlocks.SKIN_LAMP.get());
        SCP002_BED_REPLACEABLE.add(ModBlocks.SKIN_STAND.get());
        SCP002_BED_REPLACEABLE.add(ModBlocks.BEAR.get());
    }

    @SubscribeEvent
    public static void onLivingDeathEvent(LivingDeathEvent event) {
        if (event.getSource() == ModDamageSources.SCP_002_BED) {
            Entity entity = event.getEntity();
            if (entity.getEntityWorld().isAirBlock(entity.getPosition())) {
                entity.getEntityWorld().setBlockState(entity.getPosition(),
                        SCP002_BED_REPLACEABLE.get(entity.getEntityWorld().rand.nextInt(SCP002_BED_REPLACEABLE.size())).getDefaultState());
            }
        }
    }

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
