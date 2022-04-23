package com.drevery.scpdisturbance.events;

import com.drevery.scpdisturbance.ModDamageSources;
import com.drevery.scpdisturbance.SCPDisturbance;
import com.drevery.scpdisturbance.registration.ModBlocks;
import com.drevery.scpdisturbance.registration.ModEntityTypes;
import com.google.common.collect.ImmutableList;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.util.Lazy;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.server.command.ConfigCommand;

@Mod.EventBusSubscriber(modid = SCPDisturbance.MOD_ID)
public class CommonEvents { //Forge Events used on normal events IE. LivingDeathEvent

    static final ImmutableList<Lazy<Block>> SCP002_BED_PLACEABLES = ImmutableList.of(Lazy.of(ModBlocks.FLOOR_TRAP), Lazy.of(ModBlocks.SKIN_LAMP), Lazy.of(ModBlocks.BEAR), Lazy.of(ModBlocks.MEAT_NIGHTSTAND));
    static final ImmutableList<Lazy<Block>> SCP002_SKIN_PLACEABLES = ImmutableList.of(Lazy.of(ModBlocks.FLOOR_TRAP), Lazy.of(ModBlocks.SKIN_LAMP), Lazy.of(ModBlocks.BEAR), Lazy.of(ModBlocks.BONE_BLOCKS), Lazy.of(ModBlocks.MEAT_TABLE));

    @SubscribeEvent
    public static void onLivingDieTo002(LivingDeathEvent event) {
        Entity entity = event.getEntity();
        Level level = entity.getCommandSenderWorld();
        if (event.getSource() == ModDamageSources.SCP_002_SINK) {
            BlockPos startPos = entity.blockPosition();
            BlockPos pos = startPos;

            if (!level.getBlockState(pos).is(ModBlocks.SKIN_FLOOR.get()) && !level.getBlockState(pos).is(ModBlocks.FACE_SKIN_FLOOR.get())) {
                for (Direction direction : Direction.values()) {
                    if (level.getBlockState(pos.relative(direction)).is(ModBlocks.SKIN_FLOOR.get()) ||
                            level.getBlockState(pos.relative(direction)).is(ModBlocks.FACE_SKIN_FLOOR.get())) {
                        pos = pos.relative(direction);
                        break;
                    }
                }
                if (startPos.equals(pos)) return;
            }

            while(!level.isEmptyBlock(pos)) {
                pos = pos.above();
                if (pos.getY() - startPos.getY() > 10) return;
            }
            level.setBlockAndUpdate(pos, SCP002_SKIN_PLACEABLES.get(level.random.nextInt(SCP002_SKIN_PLACEABLES.size())).get().defaultBlockState());
        }
        else if (event.getSource() == ModDamageSources.SCP_002_BED) {
            if (level.isEmptyBlock(entity.blockPosition())) {
                level.setBlockAndUpdate(entity.blockPosition(),
                        SCP002_BED_PLACEABLES.get(level.random.nextInt(SCP002_BED_PLACEABLES.size())).get().defaultBlockState());
            }
        }
    }

    @SubscribeEvent(priority = EventPriority.LOWEST) //Calls the killed function on the entity that killed it to allow for some custom features
    public static void onPlayerDeath(LivingDeathEvent event) { //priority == Low so we have to make sure that the player has actually died
        if (event.getEntity() instanceof Player) {
            if (event.getSource().getEntity() != null) {
                event.getSource().getEntity().killed((ServerLevel) event.getEntity().level, (LivingEntity) event.getSource().getEntity());
            }
        }
    }

    @SubscribeEvent
    public static void onPlayerCloneEvent(PlayerEvent.Clone event) {
        if(!event.getOriginal().getCommandSenderWorld().isClientSide) {
            event.getPlayer().getPersistentData().putIntArray(SCPDisturbance.MOD_ID + "homepos",
                    event.getOriginal().getPersistentData().getIntArray(SCPDisturbance.MOD_ID + "homepos"));
        }
    }

    @SubscribeEvent
    public static void onCommandsRegister(RegisterCommandsEvent event) {
        ConfigCommand.register(event.getDispatcher());
    }

    @Mod.EventBusSubscriber(modid = SCPDisturbance.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ModEvents { //Mod Events are less common and are mostly setup events

    }
}
