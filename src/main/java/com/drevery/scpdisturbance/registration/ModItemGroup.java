package com.drevery.scpdisturbance.registration;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModItemGroup {
    public static final CreativeModeTab BLOCK_GROUP = new CreativeModeTab("scpBlockTab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModBlocks.SKIN_FLOOR.get());
        }
    };

    public static final CreativeModeTab ITEM_GROUP = new CreativeModeTab("scpItemTab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.HEART.get());
        }
    };
}
