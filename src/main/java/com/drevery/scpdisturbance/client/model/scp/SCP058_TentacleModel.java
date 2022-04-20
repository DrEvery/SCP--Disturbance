package com.drevery.scpdisturbance.client.model.scp;

import com.drevery.scpdisturbance.SCPDisturbance;
import com.drevery.scpdisturbance.entity.scp.SCP058_TentacleEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;

public class SCP058_TentacleModel<T extends SCP058_TentacleEntity> extends EntityModel<T> {
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(SCPDisturbance.MOD_ID, "scp_058_tentacle"), "main");
    private final ModelPart bone;

    public SCP058_TentacleModel(ModelPart root) {
        this.bone = root.getChild("bone");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition bone = partdefinition.addOrReplaceChild("bone", CubeListBuilder.create().texOffs(0, 12).addBox(-3.0F, -6.0F, -3.0F, 6.0F, 6.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(19, 19).addBox(-3.0F, -11.0F, -2.5F, 6.0F, 5.0F, 5.0F, new CubeDeformation(0.0F))
                .texOffs(0, 24).addBox(-2.0F, -15.0F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(27, 29).addBox(-2.0F, -18.0F, -1.0F, 4.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(-5.0F, -2.0F, -5.0F, 10.0F, 2.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition cube_r1 = bone.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(32, 12).addBox(-2.0F, -3.0124F, -1.825F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, -23.0F, -2.0F, 1.2654F, 0.0F, 0.0F));

        PartDefinition cube_r2 = bone.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(18, 12).addBox(-3.0F, -2.8381F, -1.9484F, 4.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, -21.0F, 0.0F, 0.7418F, 0.0F, 0.0F));

        PartDefinition cube_r3 = bone.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(13, 29).addBox(-3.0F, 0.1619F, -1.9484F, 4.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, -21.0F, 0.0F, 0.3054F, 0.0F, 0.0F));

        PartDefinition bone2 = bone.addOrReplaceChild("bone2", CubeListBuilder.create(), PartPose.offsetAndRotation(0.5F, -24.0F, -5.0F, -0.3927F, 0.0F, 0.0F));

        PartDefinition cube_r4 = bone2.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(30, 0).addBox(-2.0F, -2.8558F, -1.6356F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(4, 4).addBox(-1.5F, -9.8558F, -1.6356F, 0.0F, 4.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(4, 0).addBox(0.5F, -9.8558F, -1.6356F, 0.0F, 4.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(0, 32).addBox(-2.0F, -5.8558F, -1.6356F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(-0.5F, -10.8558F, -0.6356F, 0.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 2.2689F, 0.0F, 0.0F));

        return LayerDefinition.create(meshdefinition, 64, 64);
    }

    @Override
    public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        bone.render(poseStack, buffer, packedLight, packedOverlay);
    }
}
