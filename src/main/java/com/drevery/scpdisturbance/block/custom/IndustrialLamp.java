package com.drevery.scpdisturbance.block.custom;

import com.drevery.scpdisturbance.block.custom.base.BaseTwoTallHorizontalBlock;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;

public class IndustrialLamp extends BaseTwoTallHorizontalBlock {

    private static final VoxelShape SHAPE = Block.makeCuboidShape(3, 0, 3, 13, 17, 13);

    public IndustrialLamp(AbstractBlock.Properties properties) {
        super(properties);
    }

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        return SHAPE;
    }
}