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

public class Painting extends HorizontalBlock {
    public Painting(Properties builder) {
        super(builder);
    }
    private static final VoxelShape[] SHAPE = Utils.makeHorizontalShapes(
            Stream.of(
            Block.makeCuboidShape(0, 0, 15, 16, 16, 16),
            Block.makeCuboidShape(15, 0, 14, 16, 16, 15),
            Block.makeCuboidShape(0, 0, 14, 1, 16, 15),
            Block.makeCuboidShape(1, 0, 14, 15, 1, 15),
            Block.makeCuboidShape(1, 15, 14, 15, 16, 15),
            Block.makeCuboidShape(4, 5, 14, 12, 13, 15)
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

