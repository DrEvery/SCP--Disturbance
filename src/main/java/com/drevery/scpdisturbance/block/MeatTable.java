package com.drevery.scpdisturbance.block;

import com.drevery.scpdisturbance.utils.Utils;
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

public class MeatTable extends BaseHorizontalBlock {

    private static final VoxelShape[] SHAPE = Utils.makeHorizontalShapes(Stream.of(
            Block.box(1, 0, 1, 2, 6, 2),
            Block.box(0, 6, 0, 16, 8, 16),
            Block.box(0, 15, 0, 16, 16, 16),
            Block.box(1, 8, 1, 2, 15, 2),
            Block.box(1, 8, 14, 2, 15, 15),
            Block.box(14, 8, 1, 15, 15, 2),
            Block.box(14, 0, 14, 15, 6, 15),
            Block.box(14, 8, 14, 15, 15, 15),
            Block.box(14, 0, 1, 15, 6, 2),
            Block.box(1, 0, 14, 2, 6, 15)
    ).reduce((v1, v2) -> VoxelShapes.join(v1, v2, IBooleanFunction.OR)).get());

    public MeatTable(Properties builder) {
        super(builder);
    }

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        return SHAPE[state.getValue(FACING).get2DDataValue()];
    }

    @Override
    public int getSignal(BlockState blockState, IBlockReader blockAccess, BlockPos pos, Direction side) {
        return 15;
    }
}
