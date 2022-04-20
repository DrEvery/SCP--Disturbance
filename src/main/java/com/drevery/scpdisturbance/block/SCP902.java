package com.drevery.scpdisturbance.block;

import com.drevery.scpdisturbance.block.base.BaseHorizontalBlock;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;


public class SCP902 extends BaseHorizontalBlock {

    public static final BooleanProperty OPEN = BlockStateProperties.OPEN;

    public SCP902(Properties p_i48377_1_) {super(p_i48377_1_);}

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(FACING, OPEN);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext pContext) {
        return this.defaultBlockState().setValue(FACING, pContext.getHorizontalDirection().getOpposite());
    }
}
