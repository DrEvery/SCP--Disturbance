package com.drevery.scpdisturbance.block.base;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.ItemStack;
import net.minecraft.state.EnumProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.state.properties.DoubleBlockHalf;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;

import javax.annotation.Nullable;

/**
 * A Horizontal Facing block that has a block on-top of it. <br>
 * Lower Half gets placed first
 */
public class BaseTwoTallHorizontalBlock extends HorizontalBlock {

    public static final EnumProperty<DoubleBlockHalf> HALF = BlockStateProperties.DOUBLE_BLOCK_HALF;

    public BaseTwoTallHorizontalBlock(Properties properties) {
        super(properties);
        this.setDefaultState(this.stateContainer.getBaseState().with(HALF, DoubleBlockHalf.LOWER).with(HORIZONTAL_FACING, Direction.NORTH));
    }

    @Nullable
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        //Can the bottom and top exist with the Y values and are the blocks it's going to replace replaceable?
        BlockPos blockpos = context.getPos();
        if ((blockpos.getY() < context.getWorld().getHeight() - 1) && context.getWorld().getBlockState(blockpos.up()).isReplaceable(context)) {
            return this.getDefaultState().with(HORIZONTAL_FACING, context.getPlacementHorizontalFacing().getOpposite());
        } else return null;
    }

    @Override
    public void onBlockAdded(BlockState state, World worldIn, BlockPos pos, BlockState oldState, boolean isMoving) {
        //getStateForPlacement was successful, lower block has been placed now place upper half with facing and upper state
        if (state.get(HALF) == DoubleBlockHalf.LOWER) {
            worldIn.setBlockState(pos.up(), this.getDefaultState().with(HALF, DoubleBlockHalf.UPPER).with(HORIZONTAL_FACING, state.get(HORIZONTAL_FACING)));
        }
    }

    @Override
    public BlockState updatePostPlacement(BlockState stateIn, Direction facing, BlockState facingState, IWorld worldIn, BlockPos currentPos, BlockPos facingPos) {
        //The block has been updated in some way, check if the other half exists.
        BlockPos otherPartPos = stateIn.get(HALF) == DoubleBlockHalf.LOWER ? currentPos.up() : currentPos.down();
        return (worldIn.getBlockState(otherPartPos).matchesBlock(this)) ? stateIn : Blocks.AIR.getDefaultState();
    }

    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(HALF).add(HORIZONTAL_FACING);
    }
}
