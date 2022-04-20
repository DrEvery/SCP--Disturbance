package com.drevery.scpdisturbance.block;

import com.drevery.scpdisturbance.block.base.BaseTwoTallHorizontalBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class IndustrialLamp extends BaseTwoTallHorizontalBlock {

    private static final VoxelShape SHAPE = Block.box(3, 0, 3, 13, 17, 13);

    public IndustrialLamp(Properties properties) {
        super(properties);
    }

    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return SHAPE;
    }
}