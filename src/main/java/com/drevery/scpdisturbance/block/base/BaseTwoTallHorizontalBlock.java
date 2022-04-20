package com.drevery.scpdisturbance.block.base;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.level.block.state.properties.EnumProperty;

import javax.annotation.Nullable;

/**
 * A Horizontal Facing block that has a block on-top of it. <br>
 * Lower Half gets placed first
 */
public class BaseTwoTallHorizontalBlock extends HorizontalDirectionalBlock {

    public static final EnumProperty<DoubleBlockHalf> HALF = BlockStateProperties.DOUBLE_BLOCK_HALF;

    public BaseTwoTallHorizontalBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(HALF, DoubleBlockHalf.LOWER).setValue(FACING, Direction.NORTH));
    }

    @Nullable
    public BlockState getStateForPlacement(BlockPlaceContext pContext) {
        //Can the bottom and top exist with the Y values and are the blocks it's going to replace replaceable?
        BlockPos blockpos = pContext.getClickedPos();
        if ((blockpos.getY() < pContext.getLevel().getHeight() - 1) && pContext.getLevel().getBlockState(blockpos.above()).canBeReplaced(pContext)) {
            return this.defaultBlockState().setValue(FACING, pContext.getHorizontalDirection().getOpposite());
        } else return null;
    }

    @Override
    public void onPlace(BlockState pState, Level pLevel, BlockPos pPos, BlockState pOldState, boolean pIsMoving) {
        //getStateForPlacement was successful, lower block has been placed now place upper half with facing and upper state
        if (pState.getValue(HALF) == DoubleBlockHalf.LOWER) {
            pLevel.setBlockAndUpdate(pPos.above(), this.defaultBlockState().setValue(HALF, DoubleBlockHalf.UPPER).setValue(FACING, pState.getValue(FACING)));
        }
    }

    @Override
    public BlockState updateShape(BlockState pState, Direction pDirection, BlockState pNeighborState, LevelAccessor pLevel, BlockPos pCurrentPos, BlockPos pNeighborPos) {
        //The block has been updated in some way, check if the other half exists.
        BlockPos otherPartPos = pState.getValue(HALF) == DoubleBlockHalf.LOWER ? pCurrentPos.above() : pCurrentPos.below();
        return (pLevel.getBlockState(otherPartPos).is(this)) ? pState : Blocks.AIR.defaultBlockState();
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(HALF).add(FACING);
    }
}
