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

public class MeatLamp extends HorizontalBlock
{
    public MeatLamp(Properties builder) {super(builder);}

    private static final VoxelShape SHAPE_N = Stream.of(
            Block.makeCuboidShape(7, 5, 9, 10, 9, 9),
            Block.makeCuboidShape(7, 0, 6, 10, 1, 9),
            Block.makeCuboidShape(7.5, 1, 6.5, 9.5, 3, 8.5),
            Block.makeCuboidShape(8, 5, 6.1, 9, 6, 7.1),
            Block.makeCuboidShape(8, 3, 7, 9, 8, 8),
            Block.makeCuboidShape(8, 5, 7.99, 9, 6, 8.99),
            Block.makeCuboidShape(7.1, 5, 7, 8.1, 6, 8),
            Block.makeCuboidShape(8.9, 5, 7, 9.9, 6, 8),
            Block.makeCuboidShape(7, 5, 6, 7, 9, 9),
            Block.makeCuboidShape(7, 5, 6, 10, 9, 6),
            Block.makeCuboidShape(10, 5, 6, 10, 9, 9)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR)).get();

    private static final VoxelShape SHAPE_S = Stream.of(
            Block.makeCuboidShape(6, 5, 7, 9, 9, 7),
            Block.makeCuboidShape(6, 0, 7, 9, 1, 10),
            Block.makeCuboidShape(6.5, 1, 7.5, 8.5, 3, 9.5),
            Block.makeCuboidShape(7, 5, 8.9, 8, 6, 9.9),
            Block.makeCuboidShape(7, 3, 8, 8, 8, 9),
            Block.makeCuboidShape(7, 5, 7.01, 8, 6, 8.01),
            Block.makeCuboidShape(7.9, 5, 8, 8.9, 6, 9),
            Block.makeCuboidShape(6.1, 5, 8, 7.1, 6, 9),
            Block.makeCuboidShape(9, 5, 7, 9, 9, 10),
            Block.makeCuboidShape(6, 5, 10, 9, 9, 10),
            Block.makeCuboidShape(6, 5, 7, 6, 9, 10)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR)).get();

    private static final VoxelShape SHAPE_W = Stream.of(
            Block.makeCuboidShape(6.008181818181818, 5, 6.991818181818182, 6.008181818181818, 9, 9.991818181818182),
            Block.makeCuboidShape(6.008181818181818, 0, 6.991818181818182, 9.008181818181818, 1, 9.991818181818182),
            Block.makeCuboidShape(6.508181818181818, 1, 7.491818181818182, 8.508181818181818, 3, 9.491818181818182),
            Block.makeCuboidShape(7.908181818181818, 5, 7.991818181818182, 8.908181818181818, 6, 8.991818181818182),
            Block.makeCuboidShape(7.008181818181818, 3, 7.991818181818182, 8.008181818181818, 8, 8.991818181818182),
            Block.makeCuboidShape(6.018181818181818, 5, 7.991818181818182, 7.018181818181818, 6, 8.991818181818182),
            Block.makeCuboidShape(7.008181818181818, 5, 7.091818181818182, 8.008181818181818, 6, 8.091818181818182),
            Block.makeCuboidShape(7.008181818181818, 5, 8.891818181818183, 8.008181818181818, 6, 9.891818181818183),
            Block.makeCuboidShape(6.008181818181818, 5, 6.991818181818182, 9.008181818181818, 9, 6.991818181818182),
            Block.makeCuboidShape(9.008181818181818, 5, 6.991818181818182, 9.008181818181818, 9, 9.991818181818182),
            Block.makeCuboidShape(6.008181818181818, 5, 9.991818181818182, 9.008181818181818, 9, 9.991818181818182)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR)).get();

    private static final VoxelShape SHAPE_E = Stream.of(
            Block.makeCuboidShape(10, 5, 7, 10, 9, 10),
            Block.makeCuboidShape(7, 0, 7, 10, 1, 10),
            Block.makeCuboidShape(7.5, 1, 7.5, 9.5, 3, 9.5),
            Block.makeCuboidShape(7.1, 5, 8, 8.1, 6, 9),
            Block.makeCuboidShape(8, 3, 8, 9, 8, 9),
            Block.makeCuboidShape(8.99, 5, 8, 9.99, 6, 9),
            Block.makeCuboidShape(8, 5, 8.9, 9, 6, 9.9),
            Block.makeCuboidShape(8, 5, 7.1, 9, 6, 8.1),
            Block.makeCuboidShape(7, 5, 10, 10, 9, 10),
            Block.makeCuboidShape(7, 5, 7, 7, 9, 10),
            Block.makeCuboidShape(7, 5, 7, 10, 9, 7)
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