package com.drevery.scpdisturbance.registration;

import com.drevery.scpdisturbance.SCPDisturbance;
import com.drevery.scpdisturbance.item.TestingItem;
import io.github.connortron110.connorsapi.registration.item.ItemDeferredRegister;
import io.github.connortron110.connorsapi.registration.item.ItemRegistryObject;

public class ModItems {
    public static final ItemDeferredRegister ITEMS = ItemDeferredRegister.create(SCPDisturbance.MOD_ID)
            .setDefaultItemGroup(ModItemGroup.BLOCK_GROUP); //TODO Change if necessary

    public static final ItemRegistryObject<TestingItem> DEBUG = ITEMS.register("debug", TestingItem::new)
            .tab(null) //We can override the Default item group (this will not have a tab)
            .stacksTo(1) //Change the stack size of the item
            .build(); //Always build it to return the item registry object
}
