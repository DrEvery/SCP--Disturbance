package com.drevery.scpdisturbance.entity.scp529;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.CatEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

public class JosieEntity extends CatEntity {
    public JosieEntity(EntityType<? extends CatEntity> type, World worldIn) {
        super(type, worldIn);
    }

    @Override
    public boolean canMate(AnimalEntity p_70878_1_) {
        return false;
    }

    @Override
    public void setTame(boolean pTamed) {
    }

    @Override
    public void tame(PlayerEntity pPlayer) {
    }

    @Override
    public ActionResultType mobInteract(PlayerEntity pPlayer, Hand pHand) {
    return ActionResultType.FAIL;
    }
}

