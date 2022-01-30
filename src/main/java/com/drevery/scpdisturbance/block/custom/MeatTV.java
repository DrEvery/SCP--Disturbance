package com.drevery.scpdisturbance.block.custom;

import com.drevery.scpdisturbance.Utils;
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

    private static final VoxelShape[] SHAPE = Utils.makeHorizontalShapes(
            Stream.of(
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
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR)).get());

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        return SHAPE[state.get(HORIZONTAL_FACING).getHorizontalIndex()];
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
