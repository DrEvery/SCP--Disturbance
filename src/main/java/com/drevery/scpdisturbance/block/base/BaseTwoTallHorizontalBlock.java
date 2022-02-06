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
        this.registerDefaultState(this.stateDefinition.any().setValue(HALF, DoubleBlockHalf.LOWER).setValue(FACING, Direction.NORTH));
    }

    @Nullable
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        //Can the bottom and top exist with the Y values and are the blocks it's going to replace replaceable?
        BlockPos blockpos = context.getClickedPos();
        if ((blockpos.getY() < context.getLevel().getHeight() - 1) && context.getLevel().getBlockState(blockpos.above()).canBeReplaced(context)) {
            return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite());
        } else return null;
    }

    @Override
    public void onPlace(BlockState state, World worldIn, BlockPos pos, BlockState oldState, boolean isMoving) {
        //getStateForPlacement was successful, lower block has been placed now place upper half with facing and upper state
        if (state.getValue(HALF) == DoubleBlockHalf.LOWER) {
            worldIn.setBlockAndUpdate(pos.above(), this.defaultBlockState().setValue(HALF, DoubleBlockHalf.UPPER).setValue(FACING, state.getValue(FACING)));
        }
    }

    @Override
    public BlockState updateShape(BlockState stateIn, Direction facing, BlockState facingState, IWorld worldIn, BlockPos currentPos, BlockPos facingPos) {
        //The block has been updated in some way, check if the other half exists.
        BlockPos otherPartPos = stateIn.getValue(HALF) == DoubleBlockHalf.LOWER ? currentPos.above() : currentPos.below();
        return (worldIn.getBlockState(otherPartPos).is(this)) ? stateIn : Blocks.AIR.defaultBlockState();
    }

    @Override
    protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(HALF).add(FACING);
    }
}
