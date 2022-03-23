package com.drevery.scpdisturbance.entity.scp007;

import net.minecraft.block.BlockState;
import net.minecraft.entity.*;
import net.minecraft.entity.merchant.villager.VillagerEntity;
import net.minecraft.entity.passive.AmbientEntity;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;



public class Scp007Entity extends VillagerEntity {

    public Scp007Entity(EntityType<? extends VillagerEntity> type, World worldIn) {
        super(type, worldIn);
    }

    //TODO Sounds
    @Override
    protected SoundEvent getAmbientSound() {
        return null;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource pDamageSource) {
        return null;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return null;
    }

    @Override
    protected void playStepSound(BlockPos pPos, BlockState pBlock) {
    }
}