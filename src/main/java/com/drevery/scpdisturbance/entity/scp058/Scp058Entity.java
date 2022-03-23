package com.drevery.scpdisturbance.entity.scp058;

import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.attributes.Attribute;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.monster.CaveSpiderEntity;
import net.minecraft.entity.monster.SpiderEntity;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Difficulty;
import net.minecraft.world.World;
import org.apache.logging.log4j.spi.LoggerRegistry;

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
    }



