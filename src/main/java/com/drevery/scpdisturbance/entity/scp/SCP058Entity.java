package com.drevery.scpdisturbance.entity.scp;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.goal.LeapAtTargetGoal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

public class SCP058Entity extends PathfinderMob {

    public SCP058Entity(EntityType<? extends PathfinderMob> type, Level worldIn) {
        super(type, worldIn);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(1, new LookAtPlayerGoal(this, Player.class, 8.0F));
        this.goalSelector.addGoal(3, new LeapAtTargetGoal(this, 0.4F));
        this.goalSelector.addGoal(2, new WaterAvoidingRandomStrollGoal(this, 0.8D));
        this.goalSelector.addGoal(2, new MeleeAttackGoal(this, 4.0D, false));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, true));
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
        this.playSound(SoundEvents.SPIDER_STEP, 0.15F, 1.0F);
    }

    @Override
    public boolean doHurtTarget(Entity pEntity) {
        boolean flag = super.doHurtTarget(pEntity);
        if (flag && pEntity instanceof LivingEntity) {
            pEntity.setSecondsOnFire(20);
        }
        return flag;
    }
}



