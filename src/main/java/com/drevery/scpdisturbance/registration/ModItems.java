package com.drevery.scpdisturbance.registration;

import com.drevery.scpdisturbance.SCPDisturbance;
import io.github.connortron110.connorsapi.registration.item.ItemDeferredRegister;
import io.github.connortron110.connorsapi.registration.item.ItemRegistryObject;
import net.minecraft.item.Item;

public class ModItems {
    public static final ItemDeferredRegister ITEMS = ItemDeferredRegister.create(SCPDisturbance.MOD_ID)
            .setDefaultItemGroup(ModItemGroup.BLOCK_GROUP); //TODO Change if necessary

    public static final ItemRegistryObject<Item> DEBUG = ITEMS.register("debug", Item::new)
            .tab(null) //We can override the Default item group (this will not have a tab)
            .stacksTo(1) //Change the stack size of the item
            .build(); //Always build it to return the item registry object
}
