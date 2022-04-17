package com.drevery.scpdisturbance.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.World;


public class SCP902 extends HorizontalBlock {

    public static final BooleanProperty OPEN = BlockStateProperties.OPEN;

    public SCP902(Properties p_i48377_1_) {super(p_i48377_1_);}

    @Override
    protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }

    @Override
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite());
    }

    //Unfinished, not working, probably did it wrong, mom i zoned out and woke up to code being here AGAIN!!! -Every
    public ActionResultType use(BlockState state, World level, BlockPos pos, PlayerEntity player, Hand hand, BlockRayTraceResult hit) {
        if (this.material == Material.METAL) {
            return ActionResultType.PASS;
        } else {
            state = state.cycle(OPEN);
            level.setBlock(pos, state, 2);
        }
        return ActionResultType.SUCCESS;
    }

    public BlockState open(BlockState state, World level, BlockPos pos) {
        state = state.cycle(OPEN);
        level.setBlock(pos, state, 3);
        return state;
    }
}
