package com.drevery.scpdisturbance.entity.scp529;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.CatEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;

public class JosieEntity extends CatEntity {
    public JosieEntity(EntityType<? extends CatEntity> type, World worldIn){
        super(type, worldIn);
    }

    public static AttributeModifierMap.MutableAttribute setCustomAttributes() {
        return MobEntity.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 5.0D)
                .add(Attributes.MOVEMENT_SPEED, 0.15D)
                .add(Attributes.ATTACK_DAMAGE, 3D)
                .add(Attributes.FOLLOW_RANGE, 50.0D);
    }

    @Override
    public boolean canMate(AnimalEntity p_70878_1_) {
        return false;
    }
}

