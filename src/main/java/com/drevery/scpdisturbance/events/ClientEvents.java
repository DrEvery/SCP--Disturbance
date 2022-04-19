package com.drevery.scpdisturbance.events;

import com.drevery.scpdisturbance.SCPDisturbance;
import com.drevery.scpdisturbance.client.model.scp.*;
import com.drevery.scpdisturbance.client.render.RendererGenericEntity;
import com.drevery.scpdisturbance.registration.ModBlocks;
import com.drevery.scpdisturbance.registration.ModEntityTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.entity.MobEntity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

import static net.minecraft.client.renderer.ItemBlockRenderTypes.setRenderLayer;
import static net.minecraft.client.renderer.RenderTypeLookup.setRenderLayer;

//Client Events are less common as they are mostly for rendering setup, however it's here if needed
@Mod.EventBusSubscriber(value = Dist.CLIENT, modid = SCPDisturbance.MOD_ID)
public class ClientEvents { //Forge Events used on normal events IE. LivingDeathEvent

    @Mod.EventBusSubscriber(value = Dist.CLIENT, modid = SCPDisturbance.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ModEvents { //Mod Events are less common and are mostly setup events

        @SubscribeEvent
        public static void clientSetupEvent(FMLClientSetupEvent event) {
            setBlockLayers();
            setupEntityRenderers();
        }

        //Separating different client events to save mental stress in the future
        private static void setBlockLayers() {
            //SCP-002
            setRenderLayer(ModBlocks.MEAT_TABLE.get(), RenderType.cutout());
            setRenderLayer(ModBlocks.TABLE_A.get(), RenderType.cutout());
            setRenderLayer(ModBlocks.BONE_BLOCKS.get(), RenderType.cutout());
            setRenderLayer(ModBlocks.MEAT_BED.get(), RenderType.cutout());
            setRenderLayer(ModBlocks.MEAT_TV.get(), RenderType.cutout());
            setRenderLayer(ModBlocks.SKIN_LAMP.get(), RenderType.cutout());
            setRenderLayer(ModBlocks.BONE_DINOSAUR.get(), RenderType.cutout());
            setRenderLayer(ModBlocks.CEILING_TRAP.get(), RenderType.cutout());
            setRenderLayer(ModBlocks.MEAT_LAMP.get(), RenderType.cutout());
            setRenderLayer(ModBlocks.MEAT_COUCH_CENTER.get(), RenderType.cutout());
            setRenderLayer(ModBlocks.GENERATOR.get(), RenderType.cutout());
            setRenderLayer(ModBlocks.METAL_DOOR.get(), RenderType.cutout());
            setRenderLayer(ModBlocks.MEAT_NIGHTSTAND.get(), RenderType.cutout());
            setRenderLayer(ModBlocks.INDUSTRIAL_LAMP.get(), RenderType.cutout());
            setRenderLayer(ModBlocks.SKIN_BOOKSHELF.get(), RenderType.cutout());

            //SCP-058
            setRenderLayer(ModBlocks.SCP_058_EGG.get(), RenderType.cutout());

            //SCP-416
            setRenderLayer(ModBlocks.FENCE_BOTTOM.get(), RenderType.cutout());
            setRenderLayer(ModBlocks.FENCE_MIDDLE.get(), RenderType.cutout());
            setRenderLayer(ModBlocks.FENCE_TOP.get(), RenderType.cutout());
            setRenderLayer(ModBlocks.BARBED_WIRE.get(), RenderType.cutout());
            setRenderLayer(ModBlocks.FENCE_GATE_METAL_416.get(), RenderType.cutout());

            //SCP-902
            setRenderLayer(ModBlocks.SCP_902.get(), RenderType.cutout());
        }

        private static void setupEntityRenderers() {
            RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.SCP_529.get(), manager -> genericEntityRenderer(manager, new SCP529Model<>(), 0.6F, "textures/entity/scp529.png"));
            RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.SCP_058.get(), manager -> genericEntityRenderer(manager, new SCP058Model<>(), 0.7F, "textures/entity/scp058.png"));
            RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.SCP_058_TENTACLE.get(), manager -> genericEntityRenderer(manager, new SCP058_TentacleModel<>(), 0.7F, "textures/entity/scp058-tentacle.png"));
            RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.SCP_007.get(), manager -> genericEntityRenderer(manager, new SCP007Model<>(), 0.6F, "textures/entity/scp007.png"));
            RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.SCP_049.get(), manager -> genericEntityRenderer(manager, new SCP049Model<>(), 0.6F, "textures/entity/scp049.png"));
            RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.SCP_049J.get(), manager -> genericEntityRenderer(manager, new SCP049_JModel<>(), 0.7F, "textures/entity/scp049-j.png"));
            RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.SCP_049_2.get(), manager -> genericEntityRenderer(manager, new SCP049_CuredModel<>(), 0.6F, "textures/entity/scp049-cured.png"));
        }

        private static <E extends MobEntity, M extends EntityModel<E>> RendererGenericEntity<E, M> genericEntityRenderer(EntityRendererManager entityRenderDispatcher, M model, float shadowRadius, String textureLocation) {
            return new RendererGenericEntity<>(entityRenderDispatcher, model, shadowRadius, textureLocation);
        }
    }
}
