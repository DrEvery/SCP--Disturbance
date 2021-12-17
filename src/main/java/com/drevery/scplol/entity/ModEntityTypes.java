package com.drevery.scplol.entity;

import com.drevery.scplol.SeriesOneAnomalies;
import net.minecraft.entity.EntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModEntityTypes
{
    public static DeferredRegister<EntityType<?>> ENTITY_TYPES
            =DeferredRegister.create(ForgeRegistries.ENTITIES, SeriesOneAnomalies.MOD_ID);

    public static void register(IEventBus eventBus)
    {
        ENTITY_TYPES.register(eventBus);
    }
}