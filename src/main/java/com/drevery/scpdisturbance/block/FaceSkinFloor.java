package com.drevery.scpdisturbance.block;

import com.drevery.scpdisturbance.ModDamageSources;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;

public class FaceSkinFloor extends Block {
    public FaceSkinFloor(Properties properties) {
        super(properties);
    }

    @Override
    public void entityInside(BlockState pState, Level pLevel, BlockPos pPos, Entity pEntity) {
        pEntity.makeStuckInBlock(pState, new Vec3(0.25D, 1D, 0.25D));
        pEntity.hurt(ModDamageSources.SCP_002_SINK, 4F);
    }
}