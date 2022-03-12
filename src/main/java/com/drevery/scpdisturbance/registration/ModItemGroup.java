package com.drevery.scpdisturbance.registration;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class ModItemGroup {
    public static final ItemGroup BLOCK_GROUP = new ItemGroup("scpBlockTab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModBlocks.SKIN_FLOOR.get());
        }
    };

    public static final ItemGroup ITEM_GROUP = new ItemGroup("scpItemTab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.HEART);
        }
    };
}
