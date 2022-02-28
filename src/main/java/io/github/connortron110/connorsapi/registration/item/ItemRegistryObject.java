package io.github.connortron110.connorsapi.registration.item;

import io.github.connortron110.connorsapi.registration.WrappedRegistryObject;
import net.minecraft.item.Item;
import net.minecraft.util.IItemProvider;
import net.minecraftforge.fml.RegistryObject;

/**
 * Seems like a useless class however with the implementation of {@link IItemProvider} we can now call
 * the object directly, and it will get the item for us with no fuss!
 */
public class ItemRegistryObject<I extends Item> extends WrappedRegistryObject<I> implements IItemProvider {
    public ItemRegistryObject(RegistryObject<I> registryObject) {
        super(registryObject);
    }

    @Override
    public Item asItem() {
        return get();
    }
}
