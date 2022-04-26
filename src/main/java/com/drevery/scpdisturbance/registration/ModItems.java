package com.drevery.scpdisturbance.registration;

import com.drevery.scpdisturbance.SCPDisturbance;
import com.drevery.scpdisturbance.item.MicroHIDItem;
import com.drevery.scpdisturbance.item.NVGItem;
import com.drevery.scpdisturbance.item.TestingItem;
import io.github.connortron110.connorsapi.registration.item.ItemDeferredRegister;
import io.github.connortron110.connorsapi.registration.item.ItemRegistryObject;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.*;

public class ModItems {
    public static final ItemDeferredRegister ITEMS = ItemDeferredRegister.create(SCPDisturbance.MOD_ID)
            .setDefaultItemGroup(ModItemGroup.ITEM_GROUP);

    public static final ItemRegistryObject<SwordItem> DEBUG = ITEMS.register("debug", input -> new SwordItem(Tiers.NETHERITE, 99999, 999, input))
            .tab(null) //We can override the Default item group (this will not have a tab)
            .stacksTo(1) //Change the stack size of the item
            .build(); //Always build it to return the item registry object

    //Organs
    public static final ItemRegistryObject<Item> HEART = ITEMS.register("heart", Item::new).stacksTo(1).build();
    public static final ItemRegistryObject<Item> LIVER = ITEMS.register("liver", Item::new).stacksTo(1).build();
    public static final ItemRegistryObject<Item> KIDNEY = ITEMS.register("kidney", Item::new).stacksTo(1).build();
    public static final ItemRegistryObject<Item> LUNGS = ITEMS.register("lungs", Item::new).stacksTo(1).build();

    public static final ItemRegistryObject<MicroHIDItem> MICROHID = ITEMS.register("microhid", MicroHIDItem::new).stacksTo(1).build();

    //Night Vision Goggles
    public static final ItemRegistryObject<NVGItem> NVG = ITEMS.register("nvg", input -> new NVGItem(ArmorMaterials.GOLD, EquipmentSlot.HEAD, input)).stacksTo(64).build();
}
