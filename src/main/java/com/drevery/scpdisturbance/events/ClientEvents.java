package com.drevery.scpdisturbance.events;

import com.drevery.scpdisturbance.SCPDisturbance;
import com.drevery.scpdisturbance.client.model.armor.NVGModel;
import com.drevery.scpdisturbance.client.model.scp.*;
import com.drevery.scpdisturbance.client.render.RendererGenericEntity;
import com.drevery.scpdisturbance.registration.ModBlocks;
import com.drevery.scpdisturbance.registration.ModEntityTypes;
import com.drevery.scpdisturbance.registration.ModItems;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.CaveSpiderRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

import java.util.concurrent.atomic.AtomicBoolean;

import static net.minecraft.client.renderer.ItemBlockRenderTypes.setRenderLayer;

//Client Events are less common as they are mostly for rendering setup, however it's here if needed
@Mod.EventBusSubscriber(value = Dist.CLIENT, modid = SCPDisturbance.MOD_ID)
public class ClientEvents { //Forge Events used on normal events IE. LivingDeathEvent
    @SubscribeEvent
    public static void NVGEquip(LivingEvent.LivingUpdateEvent event)
    {if (!event.getEntityLiving().getLevel().isClientSide) return;
        if  (event.getEntityLiving() instanceof Player player) {
        if (player.isSpectator()) return;
        AtomicBoolean flag = new AtomicBoolean(false);
        player.getArmorSlots().forEach(itemStack -> flag.set(itemStack.is(ModItems.NVG.asItem())));
        if (flag.get()) {
            Minecraft.getInstance().gameRenderer.loadEffect(new ResourceLocation("shaders/post/creeper.json"));
            player.addEffect(new MobEffectInstance(MobEffects.NIGHT_VISION, 40, 0), player);
        }
        else Minecraft.getInstance().gameRenderer.checkEntityPostEffect(null);
    }
    }
    @Mod.EventBusSubscriber(value = Dist.CLIENT, modid = SCPDisturbance.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ModEvents { //Mod Events are less common and are mostly setup events

        @SubscribeEvent
        public static void clientSetupEvent(FMLClientSetupEvent event) {
            setBlockLayers();
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

        @SubscribeEvent
        public static void registerEntityLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
            event.registerLayerDefinition(SCP007Model.LAYER_LOCATION, SCP007Model::createBodyLayer);
            event.registerLayerDefinition(SCP049Model.LAYER_LOCATION, SCP049Model::createBodyLayer);
            event.registerLayerDefinition(SCP049_CuredModel.LAYER_LOCATION, SCP049_CuredModel::createBodyLayer);
            event.registerLayerDefinition(SCP049_JModel.LAYER_LOCATION, SCP049_JModel::createBodyLayer);
            event.registerLayerDefinition(SCP058Model.LAYER_LOCATION, SCP058Model::createBodyLayer);
            event.registerLayerDefinition(SCP058_TentacleModel.LAYER_LOCATION, SCP058_TentacleModel::createBodyLayer);
            event.registerLayerDefinition(SCP529Model.LAYER_LOCATION, SCP529Model::createBodyLayer);
            event.registerLayerDefinition(SCP049_Cured_RunnerModel.LAYER_LOCATION, SCP049_Cured_RunnerModel::createBodyLayer);
            event.registerLayerDefinition(NVGModel.LAYER_LOCATION, NVGModel::createBodyLayer);
        }

        @SubscribeEvent
        public static void registerEntityRenderer(EntityRenderersEvent.RegisterRenderers event) {
            event.registerEntityRenderer(ModEntityTypes.SCP_007.get(), context -> genericEntityRenderer(context, new SCP007Model<>(context.bakeLayer(SCP007Model.LAYER_LOCATION)), 0.6F, "textures/entity/scp007.png"));
            event.registerEntityRenderer(ModEntityTypes.SCP_049.get(), context -> genericEntityRenderer(context, new SCP049Model<>(context.bakeLayer(SCP049Model.LAYER_LOCATION)), 0.6F, "textures/entity/scp049.png"));
            event.registerEntityRenderer(ModEntityTypes.SCP_049_CURED.get(), context -> genericEntityRenderer(context, new SCP049_CuredModel<>(context.bakeLayer(SCP049_CuredModel.LAYER_LOCATION)), 0.6F, "textures/entity/scp_049_cured.png"));
            event.registerEntityRenderer(ModEntityTypes.SCP_049J.get(), context -> genericEntityRenderer(context, new SCP049_JModel<>(context.bakeLayer(SCP049_JModel.LAYER_LOCATION)), 0.7F, "textures/entity/scp049-j.png"));
            event.registerEntityRenderer(ModEntityTypes.SCP_058.get(), context -> genericEntityRenderer(context, new SCP058Model<>(context.bakeLayer(SCP058Model.LAYER_LOCATION)), 0.7F, "textures/entity/scp058.png"));
            event.registerEntityRenderer(ModEntityTypes.SCP_058_TENTACLE.get(), context -> genericEntityRenderer(context, new SCP058_TentacleModel<>(context.bakeLayer(SCP058_TentacleModel.LAYER_LOCATION)), 0.7F, "textures/entity/scp058-tentacle.png"));
            event.registerEntityRenderer(ModEntityTypes.SCP_529.get(), context -> genericEntityRenderer(context, new SCP529Model<>(context.bakeLayer(SCP529Model.LAYER_LOCATION)), 0.6F, "textures/entity/scp529.png"));
            event.registerEntityRenderer(ModEntityTypes.SCP_049_CURED_RUNNER.get(), context -> genericEntityRenderer(context, new SCP049_Cured_RunnerModel<>(context.bakeLayer(SCP049_Cured_RunnerModel.LAYER_LOCATION)), 0.6F, "textures/entity/scp_049_cured_runner.png"));
        }

        private static <E extends Mob, M extends EntityModel<E>> RendererGenericEntity<E, M> genericEntityRenderer(EntityRendererProvider.Context entityRenderDispatcher, M model, float shadowRadius, String textureLocation) {
            return new RendererGenericEntity<>(entityRenderDispatcher, model, shadowRadius, textureLocation);
        }
    }
}
