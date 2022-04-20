package com.drevery.scpdisturbance.client.model.scp;

import com.drevery.scpdisturbance.SCPDisturbance;
import com.drevery.scpdisturbance.entity.scp.SCP058Entity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;

public class SCP058Model<T extends SCP058Entity> extends EntityModel<T> {
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(SCPDisturbance.MOD_ID, "scp_058"), "main");
    private final ModelPart body;
    private final ModelPart legleft;
    private final ModelPart legright;
    private final ModelPart legback;

    public SCP058Model(ModelPart root) {
        this.body = root.getChild("body");
        this.legleft = root.getChild("legleft");
        this.legright = root.getChild("legright");
        this.legback = root.getChild("legback");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -5.0F, -5.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 12.0F, 0.0F));

        PartDefinition cube_r1 = body.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(0, 0).addBox(-5.0F, -8.0F, -10.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.0F, 14.0F, -4.0F, 0.0F, 1.0472F, 0.4363F));

        PartDefinition cube_r2 = body.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(3.0F, -8.0F, -10.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-4.0F, 14.0F, -4.0F, 0.0F, -1.0472F, -0.4363F));

        PartDefinition cube_r3 = body.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(6, 9).addBox(-6.0F, -19.0F, -11.0F, 3.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(0, 16).addBox(-7.0F, -18.0F, -12.0F, 5.0F, 3.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.5F, 14.0F, -4.0F, -0.8727F, 0.0F, 0.0F));

        PartDefinition tentacles = body.addOrReplaceChild("tentacles", CubeListBuilder.create(), PartPose.offset(0.0F, -4.8052F, 4.0F));

        PartDefinition cube_r4 = tentacles.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(24, 22).addBox(-4.0F, 25.3052F, 36.9F, 0.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.0F, 39.0F, -8.0F, 2.0944F, 0.0F, 0.0F));

        PartDefinition cube_r5 = tentacles.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(30, 14).addBox(-5.0F, -0.6948F, 46.9F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.0F, 39.0F, -8.0F, 1.4399F, 0.0F, 0.0F));

        PartDefinition cube_r6 = tentacles.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(30, 14).addBox(-5.0F, -22.4948F, 41.5F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.0F, 39.0F, -8.0F, 0.9163F, 0.0F, 0.0F));

        PartDefinition cube_r7 = tentacles.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(30, 14).addBox(-5.0F, -40.6948F, 22.5F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.0F, 39.0F, -8.0F, 0.3054F, 0.0F, 0.0F));

        PartDefinition cube_r8 = tentacles.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(30, 14).addBox(-5.0F, -44.3948F, -7.5F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.0F, 39.0F, -8.0F, -0.3927F, 0.0F, 0.0F));

        PartDefinition cube_r9 = tentacles.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(30, 15).addBox(-5.0F, -34.0F, -26.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.0F, 39.0F, -8.0F, -0.8727F, 0.0F, 0.0F));

        PartDefinition tentacles2small = body.addOrReplaceChild("tentacles2small", CubeListBuilder.create(), PartPose.offset(0.0F, -3.0F, 5.0F));

        PartDefinition cube_r10 = tentacles2small.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(10, 31).addBox(-7.5F, -27.1948F, 34.7F, 0.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(10, 31).addBox(-4.5F, -27.1948F, 34.7F, 0.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.0F, 37.1948F, -9.0F, 0.6545F, 0.0F, 0.0F));

        PartDefinition cube_r11 = tentacles2small.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(17, 34).addBox(-6.0F, -40.1948F, 15.7F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(17, 34).addBox(-3.0F, -40.1948F, 15.7F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.0F, 37.1948F, -9.0F, 0.0873F, 0.0F, 0.0F));

        PartDefinition cube_r12 = tentacles2small.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(33, 16).addBox(-3.0F, -39.1948F, -14.3F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(33, 16).addBox(-6.0F, -39.1948F, -14.3F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.0F, 37.1948F, -9.0F, -0.6545F, 0.0F, 0.0F));

        PartDefinition cube_r13 = tentacles2small.addOrReplaceChild("cube_r13", CubeListBuilder.create().texOffs(34, 9).addBox(-3.0F, -2.0F, -39.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(34, 9).addBox(-6.0F, -2.0F, -39.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.0F, 37.1948F, -9.0F, -1.789F, 0.0F, 0.0F));

        PartDefinition cube_r14 = tentacles2small.addOrReplaceChild("cube_r14", CubeListBuilder.create().texOffs(32, 15).addBox(-3.0F, -26.7948F, -29.9F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(32, 15).addBox(-6.0F, -26.7948F, -29.9F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.0F, 37.1948F, -9.0F, -1.1345F, 0.0F, 0.0F));

        PartDefinition legleft = partdefinition.addOrReplaceChild("legleft", CubeListBuilder.create(), PartPose.offset(-4.0F, 14.0F, -1.0F));

        PartDefinition cube_r15 = legleft.addOrReplaceChild("cube_r15", CubeListBuilder.create().texOffs(0, 4).addBox(-2.0F, 8.0F, 2.0F, 2.0F, 3.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(15, 16).addBox(-5.0F, 6.0F, 2.0F, 5.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(0, 3).addBox(-2.0F, 8.0F, 4.0F, 2.0F, 3.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(8.0F, 10.0F, -3.0F, 0.0F, 0.0F, 1.5708F));

        PartDefinition cube_r16 = legleft.addOrReplaceChild("cube_r16", CubeListBuilder.create().texOffs(24, 20).addBox(-14.0F, -3.0F, 2.0F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(15, 16).addBox(-12.0F, 1.0F, 2.0F, 4.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(8.0F, 10.0F, -3.0F, 0.0F, 0.0F, 0.8727F));

        PartDefinition legright = partdefinition.addOrReplaceChild("legright", CubeListBuilder.create(), PartPose.offset(4.0F, 14.0F, -1.0F));

        PartDefinition cube_r17 = legright.addOrReplaceChild("cube_r17", CubeListBuilder.create().texOffs(28, 2).mirror().addBox(0.0F, 8.0F, 2.0F, 2.0F, 3.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(15, 16).mirror().addBox(0.0F, 6.0F, 2.0F, 5.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(23, 19).mirror().addBox(0.0F, 8.0F, 4.0F, 2.0F, 3.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-8.0F, 10.0F, -3.0F, 0.0F, 0.0F, -1.5708F));

        PartDefinition cube_r18 = legright.addOrReplaceChild("cube_r18", CubeListBuilder.create().texOffs(24, 20).mirror().addBox(12.0F, -3.0F, 2.0F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(16, 16).mirror().addBox(8.0F, 1.0F, 2.0F, 4.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-8.0F, 10.0F, -3.0F, 0.0F, 0.0F, -0.8727F));

        PartDefinition legback = partdefinition.addOrReplaceChild("legback", CubeListBuilder.create(), PartPose.offset(0.0F, 15.0F, 2.0F));

        PartDefinition cube_r19 = legback.addOrReplaceChild("cube_r19", CubeListBuilder.create().texOffs(1, 3).mirror().addBox(0.0F, 8.0F, 2.0F, 2.0F, 3.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(15, 16).mirror().addBox(0.0F, 6.0F, 2.0F, 5.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(28, 3).mirror().addBox(0.0F, 8.0F, 4.0F, 2.0F, 3.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(3.0F, 9.0F, -6.0F, 1.5708F, 0.0F, -1.5708F));

        PartDefinition cube_r20 = legback.addOrReplaceChild("cube_r20", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(10.0F, -5.0F, 2.0F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(15, 16).mirror().addBox(8.0F, 1.0F, 2.0F, 4.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(3.0F, 9.0F, -6.0F, 1.5708F, -0.6981F, -1.5708F));

        return LayerDefinition.create(meshdefinition, 64, 64);
    }

    @Override
    public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.body.xRot = headPitch * ((float) Math.PI / 180F);
        this.body.yRot = netHeadYaw * ((float) Math.PI / 180F);

        this.legleft.xRot = (float) ((75 * Mth.sin(limbSwing * 0.6662F)) * (Math.PI / 180) * limbSwingAmount);
        this.legright.xRot = (float) ((75 * Mth.sin(-(limbSwing * 0.6662F))) * (Math.PI / 180) * limbSwingAmount);
        this.legback.xRot = (float) ((75 * Mth.sin((limbSwing * 0.8F))) * (Math.PI / 180) * limbSwingAmount);
    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        body.render(poseStack, buffer, packedLight, packedOverlay);
        legleft.render(poseStack, buffer, packedLight, packedOverlay);
        legright.render(poseStack, buffer, packedLight, packedOverlay);
        legback.render(poseStack, buffer, packedLight, packedOverlay);
    }
}
