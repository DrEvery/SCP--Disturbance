package com.drevery.scpdisturbance.entity.scp;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.goal.TemptGoal;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.Cat;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;

public class SCP529Entity extends Cat {
    public SCP529Entity(EntityType<? extends SCP529Entity> type, Level worldIn) {
        super(type, worldIn);
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(3, new TemptGoal(this, 1.25D, Ingredient.of(Items.SALMON), false));
    }

    @Override
    public boolean canMate(Animal pOtherAnimal) {
        return false;
    }

    @Override
    public void setTame(boolean pTamed) {
    }

    @Override
    public void tame(Player pPlayer) {
    }

    @Override
    public InteractionResult mobInteract(Player pPlayer, InteractionHand pHand) {
        return InteractionResult.FAIL;
    }
}
