package com.drevery.scpdisturbance.registration;

import com.drevery.scpdisturbance.SCPDisturbance;
import com.drevery.scpdisturbance.Utils;
import com.drevery.scpdisturbance.entity.JosieEntity;
import com.drevery.scpdisturbance.entity.Scp058Entity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModEntityTypes {
    public static DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITIES, SCPDisturbance.MOD_ID);

    public static final RegistryObject<EntityType<JosieEntity>> SCP_529 =
            ENTITY_TYPES.register("scp_529",
                    () -> EntityType.Builder.of(JosieEntity::new, EntityClassification.CREATURE).sized(0.6F, 0.7F)
                            .clientTrackingRange(8).build(Utils.rl("scp_529").toString()));

    public static final RegistryObject<EntityType<Scp058Entity>> SCP_058 =
            ENTITY_TYPES.register("scp_058",
                    () -> EntityType.Builder.of(Scp058Entity::new, EntityClassification.CREATURE).sized(0.6F, 0.7F)
                            .clientTrackingRange(8).build(Utils.rl("scp_058").toString()));
}
