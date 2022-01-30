package com.drevery.scpdisturbance.block.custom;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;

public class MeatBlock extends Block {
    public MeatBlock(AbstractBlock.Properties properties)
    {
        super(properties);
    }
    public void onEntityCollision(BlockState state, World worldIn, BlockPos pos, Entity entityIn)
    {
        entityIn.setMotionMultiplier(state, new Vector3d(0.25D, (double) 0.05F, 0.25D));
        entityIn.attackEntityFrom(DamageSource.GENERIC, 4F);
    }
}
