package com.drevery.scpdisturbance.block.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.StateContainer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;

public class BoneDinosaur extends HorizontalBlock
{
    public BoneDinosaur(Properties builder) {
        super(builder);
    }

    private static final VoxelShape SHAPE_N = Block.makeCuboidShape(5, 0, 0, 11, 7, 16);

    private static final VoxelShape SHAPE_S = Block.makeCuboidShape(5, 0, 0, 11, 7, 16);

    private static final VoxelShape SHAPE_W = Block.makeCuboidShape(0, 0, 5, 16, 7, 11);

    private static final VoxelShape SHAPE_E = Block.makeCuboidShape(0, 0, 5, 16, 7, 11);

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
