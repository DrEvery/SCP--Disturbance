package com.drevery.scpdisturbance.block;

import net.minecraft.block.BlockState;
import net.minecraft.block.DoorBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.World;

public class FenceGateMetal416 extends DoorBlock {

    public FenceGateMetal416(Properties p_i48413_1_) {
        super(p_i48413_1_);
    }

    @Override
    public ActionResultType use(BlockState pState, World pLevel, BlockPos pPos, PlayerEntity pPlayer, Hand pHand, BlockRayTraceResult pHit) {
        return super.use(pState, pLevel, pPos, pPlayer, pHand, pHit);

    }
}
