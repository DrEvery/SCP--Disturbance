package io.github.connortron110.connorsapi.client;

import com.drevery.scpdisturbance.SCPDisturbance;
import com.drevery.scpdisturbance.client.model.item.MicroHIDModel;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.world.inventory.InventoryMenu;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.IItemRenderProperties;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.client.event.RegisterClientReloadListenersEvent;
import net.minecraftforge.client.event.TextureStitchEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(value = Dist.CLIENT, modid = SCPDisturbance.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ItemModelEvents {
    public static ItemModelRenderer itemModelRenderer;

    @SubscribeEvent //Initialises ItemModelRenderer
    public static void registerReloadListeners(RegisterClientReloadListenersEvent event) {
        Minecraft mc = Minecraft.getInstance();
        itemModelRenderer = new ItemModelRenderer(mc.getBlockEntityRenderDispatcher(), mc.getEntityModels());
        event.registerReloadListener(itemModelRenderer);
    }

    @SubscribeEvent
    public static void registerEntityLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(MicroHIDModel.LAYER_LOCATION, MicroHIDModel::createLayer);
    }

    @SubscribeEvent
    public static void textureStitchEvent(TextureStitchEvent.Pre stitchEvent) {
        if (stitchEvent.getAtlas().location().equals(InventoryMenu.BLOCK_ATLAS))
            stitchEvent.addSprite(ItemModelRenderer.hidMaterial.texture());
    }

    public static IItemRenderProperties stackRenderOverride() {
        return new IItemRenderProperties() {
            @Override
            public BlockEntityWithoutLevelRenderer getItemStackRenderer() {
                return itemModelRenderer;
            }
        };
    }
}
