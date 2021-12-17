package com.drevery.scplol.block.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.entity.Entity;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.StateContainer;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

import java.util.stream.Stream;

public class CeilingTrap extends HorizontalBlock {
    public CeilingTrap(Properties builder) {
        super(builder);
    }
    private static final VoxelShape SHAPE_N = Stream.of(
            Block.makeCuboidShape(6, 15.9, 6, 11, 15.9, 11),
            Block.makeCuboidShape(9, 12.875, 8, 9, 15.875, 9),
            Block.makeCuboidShape(9, 10.375, 9, 9, 13.375, 10),
            Block.makeCuboidShape(9, 8.875, 8, 9, 10.875, 9),
            Block.makeCuboidShape(9, 8.875, 6, 9, 9.875, 8),
            Block.makeCuboidShape(9, 9.875, 5, 9, 11.875, 6)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR)).get();

    private static final VoxelShape SHAPE_S = Stream.of(
            Block.makeCuboidShape(6.833333333333333, 15.9, 4.833333333333334, 11.833333333333332, 15.9, 9.833333333333332),
            Block.makeCuboidShape(8.833333333333332, 12.875, 6.833333333333334, 8.833333333333332, 15.875, 7.833333333333333),
            Block.makeCuboidShape(8.833333333333332, 10.375, 5.833333333333334, 8.833333333333332, 13.375, 6.833333333333334),
            Block.makeCuboidShape(8.833333333333332, 8.875, 6.833333333333334, 8.833333333333332, 10.875, 7.833333333333333),
            Block.makeCuboidShape(8.833333333333332, 8.875, 7.833333333333333, 8.833333333333332, 9.875, 9.833333333333332),
            Block.makeCuboidShape(8.833333333333332, 9.875, 9.833333333333332, 8.833333333333332, 11.875, 10.833333333333332)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR)).get();

    private static final VoxelShape SHAPE_W = Stream.of(
            Block.makeCuboidShape(7.000000000000001, 15.9, 5.833333333333334, 12, 15.9, 10.833333333333332),
            Block.makeCuboidShape(9, 12.875, 7.833333333333333, 10, 15.875, 7.833333333333333),
            Block.makeCuboidShape(10, 10.375, 7.833333333333333, 11, 13.375, 7.833333333333333),
            Block.makeCuboidShape(9, 8.875, 7.833333333333333, 10, 10.875, 7.833333333333333),
            Block.makeCuboidShape(7.000000000000001, 8.875, 7.833333333333333, 9, 9.875, 7.833333333333333),
            Block.makeCuboidShape(6.000000000000001, 9.875, 7.833333333333333, 7.000000000000001, 11.875, 7.833333333333333)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR)).get();
    
    private static final VoxelShape SHAPE_E = Stream.of(
            Block.makeCuboidShape(5.833333333333333, 15.9, 5.000000000000002, 10.833333333333332, 15.9, 10),
            Block.makeCuboidShape(7.833333333333333, 12.875, 8, 8.833333333333332, 15.875, 8),
            Block.makeCuboidShape(6.833333333333333, 10.375, 8, 7.833333333333333, 13.375, 8),
            Block.makeCuboidShape(7.833333333333333, 8.875, 8, 8.833333333333332, 10.875, 8),
            Block.makeCuboidShape(8.833333333333332, 8.875, 8, 10.833333333333332, 9.875, 8),
            Block.makeCuboidShape(10.833333333333332, 9.875, 8, 11.833333333333332, 11.875, 8)
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
    public void onEntityCollision(BlockState state, World worldIn, BlockPos pos, Entity entityIn) {
        entityIn.setMotionMultiplier(state, new Vector3d(0.25D, (double)0.05F, 0.25D));
        entityIn.attackEntityFrom(DamageSource.GENERIC, 4F);
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



