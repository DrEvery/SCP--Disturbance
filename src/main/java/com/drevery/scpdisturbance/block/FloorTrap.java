package com.drevery.scpdisturbance.block;

import com.drevery.scpdisturbance.ModDamageSources;
import com.drevery.scpdisturbance.block.base.BaseHorizontalBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class FloorTrap extends BaseHorizontalBlock {

    private static final VoxelShape SHAPE = Block.box(2, 0, 2, 14, 12, 14);

    public FloorTrap(Properties properties) {
        super(properties);
    }

    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return SHAPE;
    }

    @Override
    public void entityInside(BlockState pState, Level pLevel, BlockPos pPos, Entity pEntity) {
        pEntity.makeStuckInBlock(pState, new Vec3(0.25D, 1D, 0.25D));
        pEntity.hurt(ModDamageSources.SCP_002_TRAP, 4F);
    }
}


