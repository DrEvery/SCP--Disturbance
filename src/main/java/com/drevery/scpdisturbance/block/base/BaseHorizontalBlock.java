package com.drevery.scpdisturbance.block.base;

import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;

/**
 * Use this class if you intend the block to have Horizontal Rotation features. <br>
 * If you intend to have more states other than Horizontal Facing, recommended to just extend off {@link HorizontalDirectionalBlock}
 */
public class BaseHorizontalBlock extends HorizontalDirectionalBlock {
    public BaseHorizontalBlock(Properties builder) {
        super(builder);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(FACING);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext pContext) {
        return this.defaultBlockState().setValue(FACING, pContext.getHorizontalDirection().getOpposite());
 }
}