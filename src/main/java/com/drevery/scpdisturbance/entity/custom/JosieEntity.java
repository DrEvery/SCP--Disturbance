package com.drevery.scpdisturbance.entity.custom;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.passive.CatEntity;
import net.minecraft.world.World;


public class JosieEntity extends CatEntity {
    public JosieEntity(EntityType<? extends CatEntity> type, World worldIn){super(type, worldIn);}

    public static AttributeModifierMap.MutableAttribute setCustomAttributes() {
        return MobEntity.func_233666_p_()
                .createMutableAttribute(Attributes.MAX_HEALTH, 5.0D)
                .createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.15D)
                .createMutableAttribute(Attributes.ATTACK_DAMAGE, 3D)
                .createMutableAttribute(Attributes.FOLLOW_RANGE, 50.0D);
    }
}

