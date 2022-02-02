package com.drevery.scpdisturbance.block.custom;

import com.drevery.scpdisturbance.ModDamageSources;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;

public class SkinFloor extends Block {
    public SkinFloor(AbstractBlock.Properties properties) {
        super(properties);
    }

    @Override
    public void onEntityCollision(BlockState state, World worldIn, BlockPos pos, Entity entityIn) {
        entityIn.setMotionMultiplier(state, new Vector3d(0.25D, 0.05D, 0.25D));
        entityIn.attackEntityFrom(ModDamageSources.SCP_002_SINK, 4F);
    }
}
