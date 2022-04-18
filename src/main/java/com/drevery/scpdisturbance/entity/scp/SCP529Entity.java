package com.drevery.scpdisturbance.entity.scp;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.TemptGoal;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.CatEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

public class SCP529Entity extends CatEntity {
    public SCP529Entity(EntityType<? extends CatEntity> type, World worldIn) {
        super(type, worldIn);
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(3, new TemptGoal(this, 1.25D, Ingredient.of(Items.SALMON), false));
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
