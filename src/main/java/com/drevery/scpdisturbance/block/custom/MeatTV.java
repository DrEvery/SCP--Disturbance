package com.drevery.scpdisturbance.block.custom;

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

public class MeatTV extends HorizontalBlock
{
    public MeatTV(Properties builder) {
        super(builder);
    }

    private static final VoxelShape SHAPE_N = Stream.of(
            Block.makeCuboidShape(11, 4, 2.5, 11, 5, 3.5),
            Block.makeCuboidShape(6, 5, 2.5, 6, 6, 4.5),
            Block.makeCuboidShape(8, 2, 1.5, 8, 3, 3.5),
            Block.makeCuboidShape(6, 6, 3.5, 6, 7, 5.5),
            Block.makeCuboidShape(11, 3, 3.5, 11, 4, 5.5),
            Block.makeCuboidShape(8, 3, 3.5, 8, 4, 5.5),
            Block.makeCuboidShape(3, 0, 6, 13, 8, 12),
            Block.makeCuboidShape(5, 0, 5, 12, 2, 6),
            Block.makeCuboidShape(5, 7, 5, 12, 8, 6),
            Block.makeCuboidShape(3, 0, 5, 5, 8, 6),
            Block.makeCuboidShape(12, 0, 5, 13, 8, 6),
            Block.makeCuboidShape(5, 2, 5.5, 12, 7, 6.5)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR)).get();

    private static final VoxelShape SHAPE_S = Stream.of(
            Block.makeCuboidShape(5.0666666666666655, 4, 12.516666666666671, 5.0666666666666655, 5, 13.516666666666671),
            Block.makeCuboidShape(10.066666666666666, 5, 11.516666666666671, 10.066666666666666, 6, 13.516666666666671),
            Block.makeCuboidShape(8.066666666666665, 2, 12.516666666666671, 8.066666666666665, 3, 14.516666666666671),
            Block.makeCuboidShape(10.066666666666666, 6, 10.516666666666671, 10.066666666666666, 7, 12.516666666666671),
            Block.makeCuboidShape(5.0666666666666655, 3, 10.516666666666671, 5.0666666666666655, 4, 12.516666666666671),
            Block.makeCuboidShape(8.066666666666665, 3, 10.516666666666671, 8.066666666666665, 4, 12.516666666666671),
            Block.makeCuboidShape(3.0666666666666655, 0, 4.016666666666669, 13.066666666666666, 8, 10.016666666666671),
            Block.makeCuboidShape(4.0666666666666655, 0, 10.016666666666671, 11.066666666666666, 2, 11.016666666666671),
            Block.makeCuboidShape(4.0666666666666655, 7, 10.016666666666671, 11.066666666666666, 8, 11.016666666666671),
            Block.makeCuboidShape(11.066666666666666, 0, 10.016666666666671, 13.066666666666666, 8, 11.016666666666671),
            Block.makeCuboidShape(3.0666666666666655, 0, 10.016666666666671, 4.0666666666666655, 8, 11.016666666666671),
            Block.makeCuboidShape(4.0666666666666655, 2, 9.516666666666671, 11.066666666666666, 7, 10.516666666666671)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR)).get();

    private static final VoxelShape SHAPE_W = Stream.of(
            Block.makeCuboidShape(2.5749999999999997, 4, 4.991666666666667, 3.5749999999999997, 5, 4.991666666666667),
            Block.makeCuboidShape(2.5749999999999997, 5, 9.991666666666667, 4.574999999999999, 6, 9.991666666666667),
            Block.makeCuboidShape(1.5749999999999997, 2, 7.991666666666668, 3.5749999999999997, 3, 7.991666666666668),
            Block.makeCuboidShape(3.5749999999999997, 6, 9.991666666666667, 5.574999999999999, 7, 9.991666666666667),
            Block.makeCuboidShape(3.5749999999999997, 3, 4.991666666666667, 5.574999999999999, 4, 4.991666666666667),
            Block.makeCuboidShape(6.074999999999999, 0, 2.991666666666668, 12.075000000000001, 8, 12.991666666666669),
            Block.makeCuboidShape(3.5749999999999997, 3, 7.991666666666668, 5.574999999999999, 4, 7.991666666666668),
            Block.makeCuboidShape(5.074999999999999, 0, 3.9916666666666676, 6.074999999999999, 2, 10.991666666666667),
            Block.makeCuboidShape(5.074999999999999, 7, 3.9916666666666676, 6.074999999999999, 8, 10.991666666666667),
            Block.makeCuboidShape(5.074999999999999, 0, 10.991666666666667, 6.074999999999999, 8, 12.991666666666669),
            Block.makeCuboidShape(5.074999999999999, 0, 2.991666666666668, 6.074999999999999, 8, 3.9916666666666676),
            Block.makeCuboidShape(5.574999999999999, 2, 3.9916666666666676, 6.574999999999999, 7, 10.991666666666667)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR)).get();

    private static final VoxelShape SHAPE_E = Stream.of(
            Block.makeCuboidShape(12.491666666666667, 4, 11.025, 13.491666666666667, 5, 11.025),
            Block.makeCuboidShape(11.491666666666667, 5, 6.025, 13.491666666666667, 6, 6.025),
            Block.makeCuboidShape(12.491666666666667, 2, 8.025, 14.491666666666667, 3, 8.025),
            Block.makeCuboidShape(10.491666666666667, 6, 6.025, 12.491666666666667, 7, 6.025),
            Block.makeCuboidShape(10.491666666666667, 3, 11.025, 12.491666666666667, 4, 11.025),
            Block.makeCuboidShape(3.9916666666666654, 0, 3.025000000000001, 9.991666666666667, 8, 13.025),
            Block.makeCuboidShape(10.491666666666667, 3, 8.025, 12.491666666666667, 4, 8.025),
            Block.makeCuboidShape(9.991666666666667, 0, 5.025, 10.991666666666667, 2, 12.025),
            Block.makeCuboidShape(9.991666666666667, 7, 5.025, 10.991666666666667, 8, 12.025),
            Block.makeCuboidShape(9.991666666666667, 0, 3.025000000000001, 10.991666666666667, 8, 5.025),
            Block.makeCuboidShape(9.991666666666667, 0, 12.025, 10.991666666666667, 8, 13.025),
            Block.makeCuboidShape(9.491666666666667, 2, 5.025, 10.491666666666667, 7, 12.025)
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
}
