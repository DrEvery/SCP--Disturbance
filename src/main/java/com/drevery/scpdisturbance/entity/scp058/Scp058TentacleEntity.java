package com.drevery.scpdisturbance.entity.scp058;

import net.minecraft.block.BlockState;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.monster.SpiderEntity;
import net.minecraft.entity.monster.ZombieEntity;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class Scp058TentacleEntity extends MonsterEntity {
    private static SoundEvent placeholder_placeholder;
    public static SoundEvent placeholder = placeholder_placeholder;
    public Scp058TentacleEntity(EntityType<? extends MonsterEntity> type, World worldIn) {
        super(type, worldIn);
    }

    public static AttributeModifierMap.MutableAttribute setCustomAttributes() {
        return MobEntity.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 20.0D)
                .add(Attributes.MOVEMENT_SPEED, 0D)
                .add(Attributes.ATTACK_DAMAGE, 4.5D)
                .add(Attributes.FOLLOW_RANGE, 1D)
                .add(Attributes.KNOCKBACK_RESISTANCE, 100D)
                .add(Attributes.ATTACK_KNOCKBACK, 3D)
                .add(Attributes.ATTACK_SPEED, 1.5D);
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return placeholder;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource pDamageSource) {
        return placeholder;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return placeholder;
    }

    @Override
    protected void playStepSound(BlockPos pPos, BlockState pBlock) {
        this.playSound(placeholder, 0, 0);
    }
}

