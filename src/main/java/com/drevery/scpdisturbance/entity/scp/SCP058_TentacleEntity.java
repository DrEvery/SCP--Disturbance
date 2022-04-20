package com.drevery.scpdisturbance.entity.scp;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

public class SCP058_TentacleEntity extends Monster {

    public SCP058_TentacleEntity(EntityType<? extends Monster> type, Level worldIn) {
        super(type, worldIn);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(1, new LookAtPlayerGoal(this, Player.class, 8.0F));
        this.goalSelector.addGoal(2, new MeleeAttackGoal(this, 5.0D, false));
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
    }

    public boolean doHurtTarget(Entity pEntity) {
        boolean flag = super.doHurtTarget(pEntity);
        if (flag && pEntity instanceof LivingEntity) {
            ((LivingEntity)pEntity).addEffect(new MobEffectInstance(MobEffects.WITHER,  20, 2));
        }
        return flag;
    }
}

