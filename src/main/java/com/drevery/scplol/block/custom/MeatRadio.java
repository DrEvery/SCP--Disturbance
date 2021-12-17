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


public class MeatRadio extends HorizontalBlock {
    public MeatRadio(Properties builder) {
        super(builder);
    }

    private static final VoxelShape SHAPE_N = Stream.of(
            Block.makeCuboidShape(4.5, 4.5, 7, 5.5, 5.5, 8),
            Block.makeCuboidShape(3.5, 0, 6, 12.5, 5, 9),
            Block.makeCuboidShape(6.5, 3, 7, 13.5, 3, 8)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR)).get();

    private static final VoxelShape SHAPE_S = Stream.of(
            Block.makeCuboidShape(10.560496685345067, 4.5, 8, 11.560496685345067, 5.5, 9),
            Block.makeCuboidShape(3.5604966853450657, 0, 7, 12.560496685345067, 5, 10),
            Block.makeCuboidShape(3.823768231134167, 6.048087016032092, 8, 10.823768231134167, 6.048087016032092, 9)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR)).get();

    private static final VoxelShape SHAPE_W = VoxelShapes.combineAndSimplify(
            Block.makeCuboidShape(6.9999999999999964, 4.5, 10.49999999999999, 8, 5.5, 11.49999999999999),
            Block.makeCuboidShape(5.9999999999999964, 0, 3.4999999999999973, 8.999999999999998, 5, 12.499999999999991),
            IBooleanFunction.OR);

    private static final VoxelShape SHAPE_E = VoxelShapes.combineAndSimplify(
            Block.makeCuboidShape(8, 4.5, 4.500000000000007, 9.000000000000004, 5.5, 5.500000000000007),
            Block.makeCuboidShape(7.000000000000002, 0, 3.5000000000000053, 10.000000000000004, 5, 12.500000000000004),
            IBooleanFunction.OR);

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
}