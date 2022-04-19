package com.drevery.scpdisturbance.block.base;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.StateContainer;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.configurations.BlockStateConfiguration;
import net.minecraftforge.common.property.Properties;

/**
 * Use this class if you intend the block to have Horizontal Rotation features. <br>
 * If you intend to have more states other than Horizontal Facing, recommended to just extend off {@link HorizontalDirectionalBlock}
 */
public class BaseHorizontalBlock extends HorizontalDirectionalBlock {
    public BaseHorizontalBlock(Properties builder) {
        super(builder);
    }

   @Override
    protected void createBlockStateDefinition(BlockStateConfiguration.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }

    @Override
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite());
 }
}