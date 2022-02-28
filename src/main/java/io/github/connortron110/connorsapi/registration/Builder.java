package io.github.connortron110.connorsapi.registration;

import net.minecraftforge.registries.IForgeRegistryEntry;

@FunctionalInterface
public interface Builder<T extends IForgeRegistryEntry<? super T>> {
    WrappedRegistryObject<T> build();
}
