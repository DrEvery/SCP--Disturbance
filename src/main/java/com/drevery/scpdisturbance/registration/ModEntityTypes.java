package com.drevery.scpdisturbance.registration;

import com.drevery.scpdisturbance.SCPDisturbance;
import com.drevery.scpdisturbance.entity.scp.*;
import com.drevery.scpdisturbance.utils.Utils;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

@Mod.EventBusSubscriber(modid = SCPDisturbance.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEntityTypes {
    public static DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITIES, SCPDisturbance.MOD_ID);

    public static final RegistryObject<EntityType<SCP529Entity>> SCP_529 =
            registerWithEgg("scp_529", EntityType.Builder.of(SCP529Entity::new, EntityClassification.MONSTER).sized(0.6F, 0.7F), 0x7b7e80, 0x67c514);

    public static final RegistryObject<EntityType<SCP058Entity>> SCP_058 =
            registerWithEgg("scp_058", EntityType.Builder.of(SCP058Entity::new, EntityClassification.MONSTER).sized(0.8F, 1.1F), 0xad2727, 0x540f0f);

    public static final RegistryObject<EntityType<SCP007Entity>> SCP_007 =
            registerWithEgg("scp_007", EntityType.Builder.of(SCP007Entity::new, EntityClassification.CREATURE).sized(0.6F, 2F), 0x146aba, 0x0b7010);

    public static final RegistryObject<EntityType<SCP049Entity>> SCP_049 =
            registerWithEgg("scp_049", EntityType.Builder.of(SCP049Entity::new, EntityClassification.MONSTER).sized(0.6F, 2F), 0x146aba, 0x0b7010);

    public static final RegistryObject<EntityType<SCP049_JEntity>> SCP_049J =
            registerWithEgg("scp_049j", EntityType.Builder.of(SCP049_JEntity::new, EntityClassification.MONSTER).sized(0.6F, 2F), 0x146aba, 0x0b7010);

    public static final RegistryObject<EntityType<SCP049_CuredEntity>> SCP_049_2 =
            registerWithEgg("scp_049_2", EntityType.Builder.of(SCP049_CuredEntity::new, EntityClassification.MONSTER).sized(0.6F, 2F), 0x146aba, 0x0b7010);

    public static final RegistryObject<EntityType<SCP058_TentacleEntity>> SCP_058_TENTACLE =
            registerWithEgg("scp_058_tentacle", EntityType.Builder.of(SCP058_TentacleEntity::new, EntityClassification.MONSTER).sized(0.8F, 1.6F), 0, 0);

    @SubscribeEvent
    public static void onEntityAttributeCreation(EntityAttributeCreationEvent e) {
        e.put(SCP_529.get(), createBaseAttributes(5, 0.15, 3, 0).build());
        e.put(SCP_058.get(), createBaseAttributes(500, 0.5, 4.5, 0.1).build());
        e.put(SCP_007.get(), createBaseAttributes(10, 0.3, 0, 0).build());
        e.put(SCP_049.get(), createBaseAttributes(200, 0.2, 999999999, 0) .build());
        e.put(SCP_049J.get(), createBaseAttributes(50, 0.2, 0, 0).build());
        e.put(SCP_049_2.get(), createBaseAttributes(20, 0.1, 2, 0).build());
        e.put(SCP_058_TENTACLE.get(), createBaseAttributes(20, 0, 4, 0).add(Attributes.ATTACK_SPEED, 1.5).add(Attributes.KNOCKBACK_RESISTANCE, 100).add(Attributes.FOLLOW_RANGE, 2).build());
    }

    /**
     * Base Attributes for all entities (mostly has attributes related to hostile entities)
     *
     * @param health          Max Health of the Entity
     * @param moveSpeed       Speed of the Entity
     * @param attackDamage    Damage that the entity gives
     * @param attackKnockback Knock-back that the entity gives
     * @return Builder to append more Attributes if needed
     */
    private static AttributeModifierMap.MutableAttribute createBaseAttributes(double health, double moveSpeed, double attackDamage, double attackKnockback) {
        return MobEntity.createLivingAttributes()
                .add(Attributes.MAX_HEALTH, health)
                .add(Attributes.FOLLOW_RANGE, 32)
                .add(Attributes.MOVEMENT_SPEED, moveSpeed)
                .add(Attributes.ATTACK_DAMAGE, attackDamage)
                .add(Attributes.ATTACK_KNOCKBACK, attackKnockback);
    }

    private static <E extends Entity> RegistryObject<EntityType<E>> registerWithEgg(String name, EntityType.Builder<E> builder, int backgroundColor, int highlightColour) {
        RegistryObject<EntityType<E>> registryObject = register(name, builder);
        ModItems.ITEMS.register(name + "_spawn_egg", properties -> new ForgeSpawnEggItem(registryObject, backgroundColor, highlightColour, properties)).tab(ModItemGroup.ITEM_GROUP).build();
        return registryObject;
    }

    private static <E extends Entity> RegistryObject<EntityType<E>> register(String name, EntityType.Builder<E> builder) {
        return ENTITY_TYPES.register(name, () -> builder.build(Utils.rl(name).toString()));
    }
}
