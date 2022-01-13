package com.drevery.scplol.block.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.StateContainer;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;

import java.util.stream.Stream;

public class Generator extends HorizontalBlock
{
    public Generator(Properties builder) {
        super(builder);
    }

    private static final VoxelShape SHAPE_N = Stream.of(
            Block.makeCuboidShape(1, 1, 2, 15, 3, 13),
            Block.makeCuboidShape(0, 15, 1, 1, 16, 15),
            Block.makeCuboidShape(2, 7, 1, 14, 12, 2),
            Block.makeCuboidShape(0, 12, 1, 16, 13, 15),
            Block.makeCuboidShape(0, 0, 0, 1, 16, 1),
            Block.makeCuboidShape(15, 0, 15, 16, 16, 16),
            Block.makeCuboidShape(15, 0, 0, 16, 16, 1),
            Block.makeCuboidShape(0, 0, 15, 1, 16, 16),
            Block.makeCuboidShape(15, 15, 1, 16, 16, 15),
            Block.makeCuboidShape(9, 14.5, 7, 11, 15.5, 9),
            Block.makeCuboidShape(2, 13, 2, 14, 15, 14),
            Block.makeCuboidShape(2, 3, 3, 14, 12, 11),
            Block.makeCuboidShape(3, 3, 11, 13, 11, 14),
            Block.makeCuboidShape(4, 4, 2, 12, 12, 3),
            Block.makeCuboidShape(0, 0, 1, 1, 1, 15),
            Block.makeCuboidShape(15, 0, 1, 16, 1, 15),
            Block.makeCuboidShape(1, 0, 15, 15, 1, 16),
            Block.makeCuboidShape(1, 0, 0, 15, 1, 1),
            Block.makeCuboidShape(5, 0, 1, 7, 1, 15),
            Block.makeCuboidShape(9, 0, 1, 11, 1, 15)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR)).get();

    private static final VoxelShape SHAPE_S = Stream.of(
            Block.makeCuboidShape(1, 1, 3, 15, 3, 14),
            Block.makeCuboidShape(15, 15, 1, 16, 16, 15),
            Block.makeCuboidShape(2, 7, 14, 14, 12, 15),
            Block.makeCuboidShape(0, 12, 1, 16, 13, 15),
            Block.makeCuboidShape(15, 0, 15, 16, 16, 16),
            Block.makeCuboidShape(0, 0, 0, 1, 16, 1),
            Block.makeCuboidShape(0, 0, 15, 1, 16, 16),
            Block.makeCuboidShape(15, 0, 0, 16, 16, 1),
            Block.makeCuboidShape(0, 15, 1, 1, 16, 15),
            Block.makeCuboidShape(5, 14.5, 7, 7, 15.5, 9),
            Block.makeCuboidShape(2, 13, 2, 14, 15, 14),
            Block.makeCuboidShape(2, 3, 5, 14, 12, 13),
            Block.makeCuboidShape(3, 3, 2, 13, 11, 5),
            Block.makeCuboidShape(4, 4, 13, 12, 12, 14),
            Block.makeCuboidShape(15, 0, 1, 16, 1, 15),
            Block.makeCuboidShape(0, 0, 1, 1, 1, 15),
            Block.makeCuboidShape(1, 0, 0, 15, 1, 1),
            Block.makeCuboidShape(1, 0, 15, 15, 1, 16),
            Block.makeCuboidShape(9, 0, 1, 11, 1, 15),
            Block.makeCuboidShape(5, 0, 1, 7, 1, 15)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR)).get();

    private static final VoxelShape SHAPE_W = Stream.of(
            Block.makeCuboidShape(2, 1, 1, 13, 3, 15),
            Block.makeCuboidShape(1, 15, 15, 15, 16, 16),
            Block.makeCuboidShape(1, 7, 2, 2, 12, 14),
            Block.makeCuboidShape(1, 12, 0, 15, 13, 16),
            Block.makeCuboidShape(0, 0, 15, 1, 16, 16),
            Block.makeCuboidShape(15, 0, 0, 16, 16, 1),
            Block.makeCuboidShape(0, 0, 0, 1, 16, 1),
            Block.makeCuboidShape(15, 0, 15, 16, 16, 16),
            Block.makeCuboidShape(1, 15, 0, 15, 16, 1),
            Block.makeCuboidShape(7, 14.5, 5, 9, 15.5, 7),
            Block.makeCuboidShape(2, 13, 2, 14, 15, 14),
            Block.makeCuboidShape(3, 3, 2, 11, 12, 14),
            Block.makeCuboidShape(11, 3, 3, 14, 11, 13),
            Block.makeCuboidShape(2, 4, 4, 3, 12, 12),
            Block.makeCuboidShape(1, 0, 15, 15, 1, 16),
            Block.makeCuboidShape(1, 0, 0, 15, 1, 1),
            Block.makeCuboidShape(15, 0, 1, 16, 1, 15),
            Block.makeCuboidShape(0, 0, 1, 1, 1, 15),
            Block.makeCuboidShape(1, 0, 9, 15, 1, 11),
            Block.makeCuboidShape(1, 0, 5, 15, 1, 7)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR)).get();
    private static final VoxelShape SHAPE_E = Stream.of(
            Block.makeCuboidShape(3, 1, 1, 14, 3, 15),
            Block.makeCuboidShape(1, 15, 0, 15, 16, 1),
            Block.makeCuboidShape(14, 7, 2, 15, 12, 14),
            Block.makeCuboidShape(1, 12, 0, 15, 13, 16),
            Block.makeCuboidShape(15, 0, 0, 16, 16, 1),
            Block.makeCuboidShape(0, 0, 15, 1, 16, 16),
            Block.makeCuboidShape(15, 0, 15, 16, 16, 16),
            Block.makeCuboidShape(0, 0, 0, 1, 16, 1),
            Block.makeCuboidShape(1, 15, 15, 15, 16, 16),
            Block.makeCuboidShape(7, 14.5, 9, 9, 15.5, 11),
            Block.makeCuboidShape(2, 13, 2, 14, 15, 14),
            Block.makeCuboidShape(5, 3, 2, 13, 12, 14),
            Block.makeCuboidShape(2, 3, 3, 5, 11, 13),
            Block.makeCuboidShape(13, 4, 4, 14, 12, 12),
            Block.makeCuboidShape(1, 0, 0, 15, 1, 1),
            Block.makeCuboidShape(1, 0, 15, 15, 1, 16),
            Block.makeCuboidShape(0, 0, 1, 1, 1, 15),
            Block.makeCuboidShape(15, 0, 1, 16, 1, 15),
            Block.makeCuboidShape(1, 0, 5, 15, 1, 7),
            Block.makeCuboidShape(1, 0, 9, 15, 1, 11)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR)).get();
    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        switch (state.get(HORIZONTAL_FACING)) {
            case NORTH:
                return SHAPE_N;
            case SOUTH:
                return SHAPE_S;
            case WEST:
                return SHAPE_W;
            case EAST:
                return SHAPE_E;
            default:
                return SHAPE_N;
        }
    }

    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        super.fillStateContainer(builder.add(HORIZONTAL_FACING));
    }

    @Override
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        return this.getDefaultState().with(HORIZONTAL_FACING, context.getPlacementHorizontalFacing().getOpposite());
    }
    public boolean canProvidePower(BlockState state) {
        return true;
    }

    public int getWeakPower(BlockState blockState, IBlockReader blockAccess, BlockPos pos, Direction side) {
        return 15;
    }
}
