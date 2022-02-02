package com.drevery.scpdisturbance.entity;

import com.drevery.scpdisturbance.SCPDisturbance;
import com.drevery.scpdisturbance.entity.custom.JosieEntity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.CatEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModEntityTypes {
    public static DeferredRegister<EntityType<?>> ENTITY_TYPES
            = DeferredRegister.create(ForgeRegistries.ENTITIES, SCPDisturbance.MOD_ID);

    public static final RegistryObject<EntityType<JosieEntity>> SCP_529 =
            ENTITY_TYPES.register("scp_529",
                    () -> EntityType.Builder.create(JosieEntity::new,
                             EntityClassification.CREATURE).size(0.6F, 0.7F)
                                .trackingRange(8).build(new ResourceLocation(SCPDisturbance.MOD_ID, "scp_529")
                                    .toString()));

}
