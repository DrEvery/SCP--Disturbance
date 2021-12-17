package com.drevery.scplol.item;

import com.drevery.scplol.SeriesOneAnomalies;
import com.drevery.scplol.item.custom.TestingItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModItems
{
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, SeriesOneAnomalies.MOD_ID);

    public static final RegistryObject<Item> DEBUG = ITEMS.register("debug",
            () -> new Item(new Item.Properties().group(ItemGroup.MISC)));

    public static void register(IEventBus eventBus)
    {
        ITEMS.register(eventBus);
    }
}
