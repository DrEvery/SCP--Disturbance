package com.drevery.scpdisturbance.events;

import com.drevery.scpdisturbance.SCPDisturbance;
import com.drevery.scpdisturbance.client.render.scp058.Scp058Renderer;
import com.drevery.scpdisturbance.client.render.scp058.Scp058TentacleRenderer;
import com.drevery.scpdisturbance.registration.ModBlocks;
import com.drevery.scpdisturbance.registration.ModEntityTypes;
import com.drevery.scpdisturbance.client.render.scp529.JosieRenderer;
import net.minecraft.client.renderer.RenderType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

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
            setRenderLayer(ModBlocks.BONE_BLOCKS.get(), RenderType.cutout());
            setRenderLayer(ModBlocks.SKIN_STAND.get(), RenderType.cutout());
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
            setRenderLayer(ModBlocks.SCP_058_EGG.get(), RenderType.cutout());

            //SCP-058

        }

        private static void setupEntityRenderers() {
            RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.SCP_529.get(), JosieRenderer::new);
            RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.SCP_058.get(), Scp058Renderer::new);
            RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.SCP_058_TENTACLE.get(), Scp058TentacleRenderer::new);
        }
    }
}
