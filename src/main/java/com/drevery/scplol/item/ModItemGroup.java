package com.drevery.scplol.item;

import com.drevery.scplol.block.ModBlocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;

public class ModItemGroup
{
    public static final ItemGroup BLOCK_GROUP = new ItemGroup("scpBlockTab")
    {
        @Override
        public ItemStack createIcon()
        {
            return new ItemStack(ModBlocks.SKIN_FLOOR.get());
        }
    };



}
