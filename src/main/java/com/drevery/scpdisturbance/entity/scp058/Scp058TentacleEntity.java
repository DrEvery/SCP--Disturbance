package com.drevery.scpdisturbance.entity.scp058;

import net.minecraft.block.BlockState;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.monster.CaveSpiderEntity;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.monster.SpiderEntity;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class Scp058TentacleEntity extends CaveSpiderEntity {

    public Scp058TentacleEntity(EntityType<? extends CaveSpiderEntity> type, World worldIn) {
        super(type, worldIn);
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
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

