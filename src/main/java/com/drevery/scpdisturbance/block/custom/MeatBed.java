package com.drevery.scpdisturbance.block.custom;

import com.drevery.scpdisturbance.Utils;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.ItemStack;
import net.minecraft.state.EnumProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BedPart;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.util.math.vector.Vector3i;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.stream.Stream;

/**
 * Places Foot part of the bed
 */
public class MeatBed extends HorizontalBlock {

    public static final EnumProperty<BedPart> BED_PART = BlockStateProperties.BED_PART;
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

    public MeatBed(Properties builder) {
        super(builder);
        this.setDefaultState(this.stateContainer.getBaseState().with(BED_PART, BedPart.FOOT).with(HORIZONTAL_FACING, Direction.NORTH));
    }

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        if (state.get(BED_PART) == BedPart.FOOT) {
            Vector3i v = state.get(HORIZONTAL_FACING).getDirectionVec();
            return SHAPE[state.get(HORIZONTAL_FACING).getOpposite().getHorizontalIndex()].withOffset(v.getX(), v.getY(), v.getZ());
        }
        else return SHAPE[state.get(HORIZONTAL_FACING).getOpposite().getHorizontalIndex()];
    }

    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(HORIZONTAL_FACING).add(BED_PART);
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        if (context.getWorld().getBlockState(context.getPos().offset(context.getPlacementHorizontalFacing().getOpposite())).isReplaceable(context)) {
            return this.getDefaultState().with(HORIZONTAL_FACING, context.getPlacementHorizontalFacing());
        } else return null;
    }

    @Override
    public void onBlockPlacedBy(World worldIn, BlockPos pos, BlockState state, @Nullable LivingEntity livingEntity, ItemStack stack) {
        //getStateForPlacement was successful, lower block has been placed now place head with facing state
        worldIn.setBlockState(pos.offset(state.get(HORIZONTAL_FACING)),
                this.getDefaultState().with(BED_PART, BedPart.HEAD).with(HORIZONTAL_FACING, state.get(HORIZONTAL_FACING)));
    }

    @Override
    public BlockState updatePostPlacement(BlockState stateIn, Direction facing, BlockState facingState, IWorld worldIn, BlockPos currentPos, BlockPos facingPos) {
        BlockPos otherPartPos = stateIn.get(BED_PART) == BedPart.HEAD ? currentPos.offset(stateIn.get(HORIZONTAL_FACING).getOpposite()) : currentPos.offset(stateIn.get(HORIZONTAL_FACING));
        return (worldIn.getBlockState(otherPartPos).matchesBlock(this)) ? stateIn : Blocks.AIR.getDefaultState();
    }
}
