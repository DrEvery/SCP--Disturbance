package com.drevery.scpdisturbance.block;

import com.drevery.scpdisturbance.Utils;
import com.drevery.scpdisturbance.block.base.BaseHorizontalBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;

public class BoneDinosaur extends BaseHorizontalBlock {
    public BoneDinosaur(Properties builder) {
        super(builder);
    }

    private static final VoxelShape[] SHAPE = Utils.makeHorizontalShapes(Block.box(5, 0, 0, 11, 7, 16));

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        return SHAPE[state.getValue(FACING).get2DDataValue()];
    }
}
