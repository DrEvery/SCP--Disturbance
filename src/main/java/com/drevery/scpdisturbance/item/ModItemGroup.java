package com.drevery.scpdisturbance.item;

import com.drevery.scpdisturbance.block.ModBlocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class ModItemGroup {
    public static final ItemGroup BLOCK_GROUP = new ItemGroup("scpBlockTab") {
        @Override
        public ItemStack createIcon()
        {
            return new ItemStack(ModBlocks.SKIN_FLOOR.get());
        }
    };
}
