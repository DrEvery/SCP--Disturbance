package com.drevery.scpdisturbance.entity.scp;

import com.drevery.scpdisturbance.registration.ModEntityTypes;
import net.minecraft.block.BlockState;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

public class SCP049Entity extends MonsterEntity {

    public SCP049Entity(EntityType<? extends MonsterEntity> type, World worldIn) {
        super(type, worldIn);
    }

    protected void registerGoals() {
        this.goalSelector.addGoal(1, new LookRandomlyGoal(this));
        this.goalSelector.addGoal(1, new LookAtGoal(this, PlayerEntity.class, 10.0F));
        this.goalSelector.addGoal(2, new WaterAvoidingRandomWalkingGoal(this, 0.8D));
        this.goalSelector.addGoal(2, new MeleeAttackGoal(this, 20.0D, false));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, PlayerEntity.class, true));
    }

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
        this.playSound(SoundEvents.METAL_STEP, 0.15F, 1.0F);
    }
    @Override
    public void killed(ServerWorld pLevel, LivingEntity pKilledEntity) {
        SCP049_CuredEntity entity = ModEntityTypes.SCP_049_2.get().create(pLevel);
        entity.setPos(pKilledEntity.getX(), pKilledEntity.getY(), pKilledEntity.getZ());
        pLevel.addFreshEntity(entity);
    }
}
