package io.github.connortron110.connorsapi.registration;

import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.IForgeRegistryEntry;

import java.util.function.Supplier;

public class WrappedRegistryObject<T extends IForgeRegistryEntry<? super T>> implements Supplier<T> {
    protected final RegistryObject<T> registryObject;

    public WrappedRegistryObject(RegistryObject<T> registryObject) {
        this.registryObject = registryObject;
    }

    @Override
    public T get() {
        return registryObject.get();
    }
}
