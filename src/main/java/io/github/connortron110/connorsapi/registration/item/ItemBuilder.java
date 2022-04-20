package io.github.connortron110.connorsapi.registration.item;

import io.github.connortron110.connorsapi.registration.Builder;
import io.github.connortron110.connorsapi.registration.Factory;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.RegistryObject;

import javax.annotation.Nullable;

public class ItemBuilder<I extends Item> implements Builder<I> {
    private final ItemDeferredRegister register; //The Register this item is associated to
    private final String name;
    private final Factory<Item.Properties, I> factory;
    private ItemRegistryObject<I> registryObject;

    protected final Item.Properties properties = new Item.Properties(); //Property of the item to then build

    public ItemBuilder(ItemDeferredRegister register, String name, Factory<Item.Properties, I> factory) {
        this.register = register;
        this.name = name;
        this.factory = factory;

        if (register.getDefaultItemGroup() != null) properties.tab(register.getDefaultItemGroup());
    }

    //Add things!!!

    /**
     * Sets ItemGroup of the item and overrides Default item group set by {@link ItemDeferredRegister}
     * @param group the group you want the item to be set to
     * @return the builder instance
     */
    public ItemBuilder<I> tab(@Nullable CreativeModeTab group) {
        properties.tab(group);
        return this;
    }

    /**
     * Sets the maximum stack size
     * @param maxStackSize The size you want the stack to limit to
     * @return the builder instance
     */
    public ItemBuilder<I> stacksTo(int maxStackSize) {
        properties.stacksTo(maxStackSize);
        return this;
    }

    //Core things past this point
    @Override
    public ItemRegistryObject<I> build() {
        if (registryObject != null) return registryObject;
        RegistryObject<I> obj = register.getRegister().register(name, () -> factory.build(properties));
        this.registryObject = createRegistryObject(obj);
        return registryObject;
    }

    protected static <I extends Item> ItemRegistryObject<I> createRegistryObject(final RegistryObject<I> obj) {
        return new ItemRegistryObject<>(obj);
    }
}
