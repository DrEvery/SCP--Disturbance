package com.drevery.scpdisturbance.entity.scp007;

import com.mojang.authlib.GameProfile;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.AmbientEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;


public class Scp007Entity extends AmbientEntity {
    public Scp007Entity(EntityType<? extends AmbientEntity> type, World worldIn){super(type, worldIn);}
}
