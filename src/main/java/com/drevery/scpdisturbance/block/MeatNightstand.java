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

public class MeatNightstand extends BaseHorizontalBlock {

    private static final VoxelShape[] SHAPE = Utils.makeHorizontalShapes(Stream.of(
            Block.box(7.5, 12, 0.5, 8.5, 13, 1.5),
            Block.box(3, 4, 1, 13, 8, 2),
            Block.box(1, 0, 2, 4, 3, 6),
            Block.box(1, 0, 11, 4, 3, 15),
            Block.box(12, 0, 2, 15, 3, 6),
            Block.box(12, 0, 11, 15, 3, 15),
            Block.box(0, 14, 1, 16, 15, 16),
            Block.box(3, 9.5, 1, 13, 13.5, 2),
            Block.box(1, 3, 2, 15, 14, 15),
            Block.box(7.5, 6, 0.5, 8.5, 7, 1.5)
    ).reduce((v1, v2) -> VoxelShapes.join(v1, v2, IBooleanFunction.OR)).get());

    public MeatNightstand(Properties builder) {
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
