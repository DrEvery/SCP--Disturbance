package com.drevery.scpdisturbance.events;

import com.drevery.scpdisturbance.ModDamageSources;
import com.drevery.scpdisturbance.SCPDisturbance;
import com.drevery.scpdisturbance.registration.ModBlocks;
import com.drevery.scpdisturbance.commands.ReturnHomeCommand;
import com.drevery.scpdisturbance.commands.SetHomeCommand;
import com.drevery.scpdisturbance.registration.ModEntityTypes;
import com.drevery.scpdisturbance.entity.JosieEntity;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import com.google.common.collect.ImmutableList;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.util.Lazy;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.server.command.ConfigCommand;

@Mod.EventBusSubscriber(modid = SCPDisturbance.MOD_ID)
public class CommonEvents { //Forge Events used on normal events IE. LivingDeathEvent

    static final ImmutableList<Lazy<Block>> SCP002_BED_PLACEABLES = ImmutableList.of(Lazy.of(ModBlocks.FLOOR_TRAP), Lazy.of(ModBlocks.SKIN_LAMP), Lazy.of(ModBlocks.BEAR), Lazy.of(ModBlocks.SKIN_STAND));
    static final ImmutableList<Lazy<Block>> SCP002_SKIN_PLACEABLES = ImmutableList.of(Lazy.of(ModBlocks.FLOOR_TRAP), Lazy.of(ModBlocks.SKIN_LAMP), Lazy.of(ModBlocks.BEAR), Lazy.of(ModBlocks.BONE_BLOCKS), Lazy.of(ModBlocks.MEAT_TABLE));

    @SubscribeEvent
    public static void onLivingDieTo002(LivingDeathEvent event) {
        Entity entity = event.getEntity();
        World world = entity.getEntityWorld();
        if (event.getSource() == ModDamageSources.SCP_002_SINK) {
            BlockPos startPos = entity.getPosition();
            BlockPos pos = startPos;

            if (!world.getBlockState(pos).matchesBlock(ModBlocks.SKIN_FLOOR.get()) && !world.getBlockState(pos).matchesBlock(ModBlocks.FACE_SKIN_FLOOR.get())) {
                for (Direction direction : Direction.values()) {
                    if (world.getBlockState(pos.offset(direction)).matchesBlock(ModBlocks.SKIN_FLOOR.get()) ||
                            world.getBlockState(pos.offset(direction)).matchesBlock(ModBlocks.FACE_SKIN_FLOOR.get())) {
                        pos = pos.offset(direction);
                        break;
                    }
                }
                if (startPos.equals(pos)) return;
            }

            while(!world.isAirBlock(pos)) {
                pos = pos.up();
                if (pos.getY() - startPos.getY() > 10) return;
            }
            world.setBlockState(pos, SCP002_SKIN_PLACEABLES.get(entity.getEntityWorld().rand.nextInt(SCP002_SKIN_PLACEABLES.size())).get().getDefaultState());
        }
        else if (event.getSource() == ModDamageSources.SCP_002_BED) {
            if (world.isAirBlock(entity.getPosition())) {
                world.setBlockState(entity.getPosition(),
                        SCP002_BED_PLACEABLES.get(entity.getEntityWorld().rand.nextInt(SCP002_BED_PLACEABLES.size())).get().getDefaultState());
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

        @SubscribeEvent
        public static void addEntityAttributes(EntityAttributeCreationEvent event) {
            event.put(ModEntityTypes.SCP_529.get(), JosieEntity.setCustomAttributes().create());
        }
    }
}
