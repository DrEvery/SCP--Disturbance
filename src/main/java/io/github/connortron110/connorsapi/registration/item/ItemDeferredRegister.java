package io.github.connortron110.connorsapi.registration.item;

import io.github.connortron110.connorsapi.registration.DeferredRegisterWrapper;
import io.github.connortron110.connorsapi.registration.Factory;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.forge.event.lifecycle.GatherDataEvent;
import net.minecraftforge.registries.ForgeRegistries;

import javax.annotation.Nullable;

/**
 * Holds all the auto data generation things
 */
public class ItemDeferredRegister extends DeferredRegisterWrapper<Item> {

    @Nullable
    private CreativeModeTab defaultItemGroup;

    private ItemDeferredRegister(String modId) {
        super(ForgeRegistries.ITEMS, modId);
    }

    public static ItemDeferredRegister create(String modId) {
        return new ItemDeferredRegister(modId);
    }

    @Nullable
    public CreativeModeTab getDefaultItemGroup() {
        return defaultItemGroup;
    }

    public ItemDeferredRegister setDefaultItemGroup(@Nullable CreativeModeTab itemGroup) {
        this.defaultItemGroup = itemGroup;
        return this;
    }

    public <I extends Item> ItemBuilder<I> register(final String name, final Factory<Item.Properties, I> factory) {
        return new ItemBuilder<>(this, name, factory);
    }

    @Override
    public void addDataGen(GatherDataEvent event) {

    }
}
