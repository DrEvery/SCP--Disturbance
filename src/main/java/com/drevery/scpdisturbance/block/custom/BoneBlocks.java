package com.drevery.scpdisturbance.block.custom;

import com.drevery.scpdisturbance.block.custom.base.BaseHorizontalBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;

public class BoneBlocks extends BaseHorizontalBlock {
    public BoneBlocks(Properties builder) {
        super(builder);
    }

    private static final VoxelShape SHAPE = Block.makeCuboidShape(0, 0, 0, 16, 4, 16);

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        return SHAPE;
    }
}
