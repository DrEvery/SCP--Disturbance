package io.github.connortron110.connorsapi.client;

import com.drevery.scpdisturbance.SCPDisturbance;
import com.drevery.scpdisturbance.client.model.item.MicroHIDModel;
import com.drevery.scpdisturbance.registration.ModItems;
import com.drevery.scpdisturbance.utils.Utils;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Quaternion;
import com.mojang.math.Vector3f;
import net.minecraft.Util;
import net.minecraft.client.model.Model;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.block.model.ItemTransforms;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderDispatcher;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.texture.TextureAtlas;
import net.minecraft.client.resources.model.Material;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.client.ForgeHooksClient;

public class ItemModelRenderer extends BlockEntityWithoutLevelRenderer {

    public static Material hidMaterial = ForgeHooksClient.getBlockMaterial(Utils.rl("entity/microhid"));

    private MicroHIDModel hidModel;

    private EntityModelSet test;

    public ItemModelRenderer(BlockEntityRenderDispatcher pBlockEntityRenderDispatcher, EntityModelSet pEntityModelSet) {
        super(pBlockEntityRenderDispatcher, pEntityModelSet);
        test = pEntityModelSet;
    }

    @Override
    public void onResourceManagerReload(ResourceManager pResourceManager) {
        this.hidModel = new MicroHIDModel(this.test.bakeLayer(MicroHIDModel.LAYER_LOCATION));
    }

    @Override
    public void renderByItem(ItemStack pStack, ItemTransforms.TransformType pTransformType, PoseStack pPoseStack, MultiBufferSource pBuffer, int pPackedLight, int pPackedOverlay) {
        if (pStack.is(ModItems.MICROHID.asItem())) {
            VertexConsumer vertexconsumer = hidMaterial.sprite().wrap(ItemRenderer.getFoilBufferDirect(pBuffer, this.hidModel.renderType(hidMaterial.atlasLocation()), true, pStack.hasFoil()));

            pPoseStack.pushPose();
            pPoseStack.translate(1, 1, 0);
            pPoseStack.mulPose(Quaternion.fromXYZDegrees(new Vector3f(0 ,0 ,180)));
            this.hidModel.getBone().render(pPoseStack, vertexconsumer, pPackedLight, pPackedOverlay, 1, 1, 1, 1);
            pPoseStack.popPose();
        }
    }
}
