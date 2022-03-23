package com.drevery.scpdisturbance.entity.scp058;

import jdk.jfr.internal.Logger;
import net.minecraft.block.BlockState;
import net.minecraft.entity.*;
import net.minecraft.entity.monster.SpiderEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Difficulty;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.IServerWorld;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class Scp058Entity extends SpiderEntity {

    public Scp058Entity(EntityType<? extends SpiderEntity> type, World worldIn) {
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

    @Override
    public boolean doHurtTarget(Entity pEntity) {
            if (super.doHurtTarget(pEntity)) {
                if (pEntity instanceof LivingEntity) {
                    int i = 0;
                    if (this.level.getDifficulty() == Difficulty.EASY) {
                        i = 7;
                    } else if (this.level.getDifficulty() == Difficulty.NORMAL) {
                        i = 15;
                    } else if (this.level.getDifficulty() == Difficulty.HARD) {
                        i = 30;
                    }

                    if (i > 0) {
                            ((LivingEntity) pEntity).setSecondsOnFire(20 * i);
                    }
                }

                return true;
            } else {
                return false;
            }
        }

    @Nullable
    @Override
    public ILivingEntityData finalizeSpawn(IServerWorld pLevel, DifficultyInstance pDifficulty, SpawnReason pReason, @Nullable ILivingEntityData pSpawnData, @Nullable CompoundNBT pDataTag) {
        return pSpawnData;
    }
}



