package com.drevery.scpdisturbance.block;

import com.drevery.scpdisturbance.block.base.BaseHorizontalBlock;
import com.drevery.scpdisturbance.utils.Utils;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;

import java.util.stream.Stream;

public class SCP058Egg extends BaseHorizontalBlock {
    private static final VoxelShape[] SHAPE = Utils.makeHorizontalShapes(VoxelShapes.join(Block.box(
            5, 8, 5, 11, 9, 11), Block.box(4, 0, 4, 12, 8, 12
    ), IBooleanFunction.OR));

    public SCP058Egg(Properties builder) {
        super(builder);
    }

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        return SHAPE[state.getValue(FACING).get2DDataValue()];
    }
}