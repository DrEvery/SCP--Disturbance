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

public class MeatBed extends HorizontalBlock
{
    public MeatBed(Properties builder) {super(builder);}

    private static final VoxelShape[] SHAPE = Utils.makeHorizontalShapes(Stream.of(
            Block.makeCuboidShape(0, 0, 15, 16, 11, 16),
            Block.makeCuboidShape(-5, 15, -16, -3, 16, -16),
            Block.makeCuboidShape(0, 2, -16, 16, 6, 15),
            Block.makeCuboidShape(-4, 16, -16, 0, 17, -16),
            Block.makeCuboidShape(-2, 13, -16, 1, 16, -16),
            Block.makeCuboidShape(-1, 10, -16, 1, 13, -16),
            Block.makeCuboidShape(-2, 6, -16, 1, 10, -16),
            Block.makeCuboidShape(2, 17, -9, 2, 18, -6),
            Block.makeCuboidShape(2, 18, -7, 2, 19, -3),
            Block.makeCuboidShape(2, 10, -4, 2, 15, -1),
            Block.makeCuboidShape(2, 15, -5, 2, 18, -2),
            Block.makeCuboidShape(2, 6, -5, 2, 10, -2),
            Block.makeCuboidShape(2, 6, 7, 14, 7, 15),
            Block.makeCuboidShape(15, 0, -16, 16, 2, -15),
            Block.makeCuboidShape(0, 0, -16, 1, 2, -15),
            Block.makeCuboidShape(0, 0, 14, 1, 2, 15),
            Block.makeCuboidShape(15, 0, 14, 16, 2, 15)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR)).get());

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        return SHAPE[state.get(HORIZONTAL_FACING).getHorizontalIndex()];
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
