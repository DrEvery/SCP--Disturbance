package io.github.connortron110.connorsapi.registration;

import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.forge.event.lifecycle.GatherDataEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.IForgeRegistryEntry;

public abstract class DeferredRegisterWrapper<T extends IForgeRegistryEntry<T>> {

    protected final DeferredRegister<T> register;
    private final String modId;

    protected DeferredRegisterWrapper(IForgeRegistry<T> registry, String modId) {
        this.register = DeferredRegister.create(registry, modId);
        this.modId = modId;
    }

    public String getModId() {
        return modId;
    }

    public DeferredRegister<T> getRegister() {
        return register;
    }

    public void register(IEventBus bus) {
        this.register.register(bus);
    }

    public abstract void addDataGen(GatherDataEvent event);
}
