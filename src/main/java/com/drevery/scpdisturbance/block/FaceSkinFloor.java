package com.drevery.scpdisturbance.block;

import com.drevery.scpdisturbance.ModDamageSources;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;

public class FaceSkinFloor extends Block {
    public FaceSkinFloor(AbstractBlock.Properties properties) {
        super(properties);
    }

    @Override
    public void entityInside(BlockState state, World worldIn, BlockPos pos, Entity entityIn) {
        entityIn.makeStuckInBlock(state, new Vector3d(0.25D, 1D, 0.25D));
        entityIn.hurt(ModDamageSources.SCP_002_SINK, 4F);
    }
}