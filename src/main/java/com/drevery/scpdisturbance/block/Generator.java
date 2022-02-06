package com.drevery.scpdisturbance.block;

import com.drevery.scpdisturbance.Utils;
import com.drevery.scpdisturbance.block.base.BaseHorizontalBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;

import java.util.stream.Stream;

public class Generator extends BaseHorizontalBlock {

    private static final VoxelShape[] SHAPE = Utils.makeHorizontalShapes(Stream.of(
            Block.box(1, 1, 2, 15, 3, 13),
            Block.box(0, 15, 1, 1, 16, 15),
            Block.box(2, 7, 1, 14, 12, 2),
            Block.box(0, 12, 1, 16, 13, 15),
            Block.box(0, 0, 0, 1, 16, 1),
            Block.box(15, 0, 15, 16, 16, 16),
            Block.box(15, 0, 0, 16, 16, 1),
            Block.box(0, 0, 15, 1, 16, 16),
            Block.box(15, 15, 1, 16, 16, 15),
            Block.box(9, 14.5, 7, 11, 15.5, 9),
            Block.box(2, 13, 2, 14, 15, 14),
            Block.box(2, 3, 3, 14, 12, 11),
            Block.box(3, 3, 11, 13, 11, 14),
            Block.box(4, 4, 2, 12, 12, 3),
            Block.box(0, 0, 1, 1, 1, 15),
            Block.box(15, 0, 1, 16, 1, 15),
            Block.box(1, 0, 15, 15, 1, 16),
            Block.box(1, 0, 0, 15, 1, 1),
            Block.box(5, 0, 1, 7, 1, 15),
            Block.box(9, 0, 1, 11, 1, 15)
    ).reduce((v1, v2) -> VoxelShapes.join(v1, v2, IBooleanFunction.OR)).get());

    public Generator(Properties builder) {
        super(builder);
    }

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        return SHAPE[state.getValue(FACING).get2DDataValue()];
    }

    @Override
    public boolean isSignalSource(BlockState state) {
        return true;
    }

    @Override
    public int getSignal(BlockState blockState, IBlockReader blockAccess, BlockPos pos, Direction side) {
        return 15;
    }
}
