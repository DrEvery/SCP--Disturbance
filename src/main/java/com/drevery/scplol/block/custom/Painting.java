package com.drevery.scplol.block.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.StateContainer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;

import java.util.stream.Stream;

public class Painting extends HorizontalBlock {
    public Painting(Properties builder) {
        super(builder);
    }
    private static final VoxelShape SHAPE_N = Stream.of(
            Block.makeCuboidShape(0, 0, 15, 16, 16, 16),
            Block.makeCuboidShape(15, 0, 14, 16, 16, 15),
            Block.makeCuboidShape(0, 0, 14, 1, 16, 15),
            Block.makeCuboidShape(1, 0, 14, 15, 1, 15),
            Block.makeCuboidShape(1, 15, 14, 15, 16, 15),
            Block.makeCuboidShape(4, 5, 14, 12, 13, 15)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR)).get();

    private static final VoxelShape SHAPE_S = Stream.of(
            Block.makeCuboidShape(0, 0, 0, 16, 16, 1),
            Block.makeCuboidShape(0, 0, 1, 1, 16, 2),
            Block.makeCuboidShape(15, 0, 1, 16, 16, 2),
            Block.makeCuboidShape(1, 0, 1, 15, 1, 2),
            Block.makeCuboidShape(1, 15, 1, 15, 16, 2),
            Block.makeCuboidShape(4, 5, 1, 12, 13, 2)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR)).get();

    private static final VoxelShape SHAPE_W =
    Stream.of(
            Block.makeCuboidShape(15, 0, 0, 16, 16, 16),
            Block.makeCuboidShape(14, 0, 0, 15, 16, 1),
            Block.makeCuboidShape(14, 0, 15, 15, 16, 16),
            Block.makeCuboidShape(14, 0, 1, 15, 1, 15),
            Block.makeCuboidShape(14, 15, 1, 15, 16, 15),
            Block.makeCuboidShape(14, 5, 4, 15, 13, 12)
            ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR)).get();

    private static final VoxelShape SHAPE_E = Stream.of(
            Block.makeCuboidShape(0, 0, 0, 1, 16, 16),
            Block.makeCuboidShape(1, 0, 15, 2, 16, 16),
            Block.makeCuboidShape(1, 0, 0, 2, 16, 1),
            Block.makeCuboidShape(1, 0, 1, 2, 1, 15),
            Block.makeCuboidShape(1, 15, 1, 2, 16, 15),
            Block.makeCuboidShape(1, 5, 4, 2, 13, 12)
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
    protected void fillStateContainer(StateContainer.Builder< Block, BlockState > builder) {
        super.fillStateContainer(builder.add(HORIZONTAL_FACING));
    }

    @Override
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        return this.getDefaultState().with(HORIZONTAL_FACING, context.getPlacementHorizontalFacing().getOpposite());
    }
}

