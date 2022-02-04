package com.drevery.scpdisturbance.registration;

import com.drevery.scpdisturbance.SCPDisturbance;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, SCPDisturbance.MOD_ID);

    public static final RegistryObject<Item> DEBUG = ITEMS.register("debug",
            () -> new Item(new Item.Properties().group(ItemGroup.MISC)));

}
