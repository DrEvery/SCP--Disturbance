package com.drevery.scpdisturbance.registration;

import com.drevery.scpdisturbance.SCPDisturbance;
import com.drevery.scpdisturbance.entity.scp.*;
import com.drevery.scpdisturbance.utils.Utils;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

@Mod.EventBusSubscriber(modid = SCPDisturbance.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEntityTypes {
    public static DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITIES, SCPDisturbance.MOD_ID);


    //SCP-058

    public static final RegistryObject<EntityType<SCP058Entity>> SCP_058 =
            registerWithEgg("scp_058", EntityType.Builder.of(SCP058Entity::new, MobCategory.CREATURE).sized(0.8F, 1.1F), 0xad2727, 0x540f0f);

    public static final RegistryObject<EntityType<SCP058_TentacleEntity>> SCP_058_TENTACLE =
            registerWithEgg("scp_058_tentacle", EntityType.Builder.of(SCP058_TentacleEntity::new, MobCategory.CREATURE).sized(0.8F, 1.6F), 0x540f0f, 0xad2727);

    //SCP-049, SCP-049-J and SCP-049-2

    public static final RegistryObject<EntityType<SCP049Entity>> SCP_049 =
            registerWithEgg("scp_049", EntityType.Builder.of(SCP049Entity::new, MobCategory.CREATURE).sized(0.6F, 2F), 0x0f1012, 0x242426);

    public static final RegistryObject<EntityType<SCP049_JEntity>> SCP_049J =
            registerWithEgg("scp_049j", EntityType.Builder.of(SCP049_JEntity::new, MobCategory.CREATURE).sized(0.6F, 2F), 0x121217, 0x2f2f30);

    public static final RegistryObject<EntityType<SCP049_CuredEntity>> SCP_049_CURED =
            registerWithEgg("scp_049_cured", EntityType.Builder.of(SCP049_CuredEntity::new, MobCategory.CREATURE).sized(0.6F, 2F), 0x304a32, 0x4ed459);

    public static final RegistryObject<EntityType<SCP049_Cured_RunnerEntity>> SCP_049_CURED_RUNNER =
            registerWithEgg("scp_049_cured_runner", EntityType.Builder.of(SCP049_Cured_RunnerEntity::new, MobCategory.CREATURE).sized(0.6F, 2F), 0x197d21, 0x6ed476);

    //SCP-529

    public static final RegistryObject<EntityType<SCP529Entity>> SCP_529 =
            registerWithEgg("scp_529", EntityType.Builder.of(SCP529Entity::new, MobCategory.CREATURE).sized(0.6F, 0.7F), 0x7b7e80, 0x67c514);

    //SCP-007

    public static final RegistryObject<EntityType<SCP007Entity>> SCP_007 =
            registerWithEgg("scp_007", EntityType.Builder.of(SCP007Entity::new, MobCategory.CREATURE).sized(0.6F, 2F), 0x146aba, 0x0b7010);

    @SubscribeEvent
    public static void onEntityAttributeCreation(EntityAttributeCreationEvent e) {
        e.put(SCP_529.get(), createBaseAttributes(5, 0.15, 3, 0).build());
        e.put(SCP_058.get(), createBaseAttributes(500, 0.8, 10, 0.1).build());
        e.put(SCP_007.get(), createBaseAttributes(10, 0.3, 0, 0).build());
        e.put(SCP_049.get(), createBaseAttributes(200, 0.25, 999999999, 0).add(Attributes.KNOCKBACK_RESISTANCE, 2) .build());
        e.put(SCP_049J.get(), createBaseAttributes(50, 0.25, 0, 0).build());
        e.put(SCP_049_CURED.get(), createBaseAttributes(20,0.25, 4, 0).build());
        e.put(SCP_058_TENTACLE.get(), createBaseAttributes(20, 0.0, 4, 0).add(Attributes.ATTACK_SPEED, 0.75).add(Attributes.KNOCKBACK_RESISTANCE, 100).add(Attributes.FOLLOW_RANGE, 2).build());
        e.put(SCP_049_CURED_RUNNER.get(), createBaseAttributes(12, 0.8, 2, 0).add(Attributes.ATTACK_SPEED, 0.5).build());
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
    private static AttributeSupplier.Builder createBaseAttributes(double health, double moveSpeed, double attackDamage, double attackKnockback) {
        return Mob.createLivingAttributes()
                .add(Attributes.MAX_HEALTH, health)
                .add(Attributes.FOLLOW_RANGE, 32)
                .add(Attributes.MOVEMENT_SPEED, moveSpeed)
                .add(Attributes.ATTACK_DAMAGE, attackDamage)
                .add(Attributes.ATTACK_KNOCKBACK, attackKnockback);
    }

    private static <E extends Mob> RegistryObject<EntityType<E>> registerWithEgg(String name, EntityType.Builder<E> builder, int backgroundColor, int highlightColour) {
        RegistryObject<EntityType<E>> registryObject = register(name, builder);
        ModItems.ITEMS.register(name + "_spawn_egg", properties -> new ForgeSpawnEggItem(registryObject, backgroundColor, highlightColour, properties)).tab(ModItemGroup.ITEM_GROUP).build();
        return registryObject;
    }

    private static <E extends Entity> RegistryObject<EntityType<E>> register(String name, EntityType.Builder<E> builder) {
        return ENTITY_TYPES.register(name, () -> builder.build(Utils.rl(name).toString()));
    }
}
