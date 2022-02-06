package com.drevery.scpdisturbance.block.base;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.StateContainer;

/**
 * Use this class if you intend the block to have Horizontal Rotation features. <br>
 * If you intend to have more states other than Horizontal Facing, recommended to just extend off {@link HorizontalBlock}
 */
public class BaseHorizontalBlock extends HorizontalBlock {
    public BaseHorizontalBlock(Properties builder) {
        super(builder);
    }

    @Override
    protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }

    @Override
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite());
    }
}