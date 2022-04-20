package com.drevery.scpdisturbance.client.model.scp;

import com.drevery.scpdisturbance.SCPDisturbance;
import com.drevery.scpdisturbance.entity.scp.SCP049_JEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;

public class SCP049_JModel<T extends SCP049_JEntity> extends EntityModel<T> {
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(SCPDisturbance.MOD_ID, "scp_049j"), "main");
    private final ModelPart head;
    private final ModelPart torso;
    private final ModelPart rightarm;
    private final ModelPart leftarm;
    private final ModelPart rightleg;
    private final ModelPart rightleg2;

    public SCP049_JModel(ModelPart root) {
        this.head = root.getChild("head");
        this.torso = root.getChild("torso");
        this.rightarm = root.getChild("rightarm");
        this.leftarm = root.getChild("leftarm");
        this.rightleg = root.getChild("rightleg");
        this.rightleg2 = root.getChild("rightleg2");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition head = partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(54, 4).addBox(1.5F, -6.5F, -4.5F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 18).addBox(-3.0F, -6.0F, -4.6F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(45, 0).addBox(-2.0F, -4.0F, -5.0F, 4.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 16).addBox(2.0F, -6.0F, -4.6F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(55, 0).addBox(-3.5F, -6.5F, -4.5F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(24, 0).addBox(-0.5F, 0.0F, -4.0F, 1.0F, 2.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F));

        PartDefinition cube_r1 = head.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(40, 16).addBox(-4.0F, -5.6F, -6.5F, 2.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, 4.0F, -4.0F, 0.3491F, 0.0F, 0.0F));

        PartDefinition cube_r2 = head.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(32, 7).addBox(-5.0F, -6.0F, 0.0F, 3.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.5F, 4.0F, -4.0F, 0.6981F, 0.0F, 0.0F));

        PartDefinition cube_r3 = head.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(12, 29).addBox(0.0F, 0.0F, -1.0F, 0.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, 0.0F, 2.0F, 0.0F, 0.0F, 0.2182F));

        PartDefinition cube_r4 = head.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, 0.0F, -2.0F, 0.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, 0.0F, -2.0F, 0.0F, 0.0F, 0.4363F));

        PartDefinition cube_r5 = head.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(36, 16).addBox(-2.0F, 0.0F, 0.0F, 3.0F, 3.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, 0.0F, -4.0F, -0.1745F, 0.0F, 0.0F));

        PartDefinition cube_r6 = head.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(32, 7).addBox(-2.0F, -1.2F, 1.0F, 3.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, 0.0F, -5.0F, -0.1745F, 0.0F, 0.0F));

        PartDefinition cube_r7 = head.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(0, 55).addBox(-7.0F, 0.0F, 0.0F, 3.0F, 3.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(40, 19).addBox(-2.0F, 0.0F, 0.0F, 3.0F, 3.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, 0.0F, 4.0F, 0.2182F, 0.0F, 0.0F));

        PartDefinition cube_r8 = head.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(20, 12).addBox(0.0F, 0.0F, -2.0F, 0.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.0F, 0.0F, -2.0F, 0.0F, 0.0F, -0.4363F));

        PartDefinition cube_r9 = head.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(28, 29).addBox(0.0F, 0.0F, -1.0F, 0.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.0F, 0.0F, 2.0F, 0.0F, 0.0F, -0.2182F));

        PartDefinition torso = partdefinition.addOrReplaceChild("torso", CubeListBuilder.create().texOffs(24, 0).addBox(-4.0F, -14.0F, -2.5F, 8.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(-3.5F, -14.5F, -3.0F, 3.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 16).addBox(-4.0F, -24.0F, -2.0F, 8.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition cube_r10 = torso.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(40, 24).addBox(-4.0F, -1.0F, 0.0F, 8.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -23.0F, -2.0F, -0.2182F, 0.0F, 0.0F));

        PartDefinition cube_r11 = torso.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(44, 7).addBox(-4.0F, -1.0F, 0.0F, 8.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -23.0F, 2.0F, 0.2182F, 0.0F, 0.0F));

        PartDefinition rightarm = partdefinition.addOrReplaceChild("rightarm", CubeListBuilder.create().texOffs(32, 32).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(6.0F, 0.0F, 0.0F));

        PartDefinition cube_r12 = rightarm.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(40, 54).addBox(-3.0F, -5.0F, -1.0F, 4.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, 12.0F, -1.0F, 0.0436F, 0.0F, 0.0F));

        PartDefinition cube_r13 = rightarm.addOrReplaceChild("cube_r13", CubeListBuilder.create().texOffs(32, 53).addBox(-3.0F, -5.0F, 1.0F, 4.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, 12.0F, 1.0F, -0.0436F, 0.0F, 0.0F));

        PartDefinition cube_r14 = rightarm.addOrReplaceChild("cube_r14", CubeListBuilder.create().texOffs(50, 17).addBox(-2.0F, 0.0F, 0.0F, 4.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 2.0F, 0.0873F, 0.0F, 0.0F));

        PartDefinition cube_r15 = rightarm.addOrReplaceChild("cube_r15", CubeListBuilder.create().texOffs(24, 44).addBox(0.0F, 0.0F, -2.0F, 0.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.0436F));

        PartDefinition cube_r16 = rightarm.addOrReplaceChild("cube_r16", CubeListBuilder.create().texOffs(48, 52).addBox(-2.0F, 0.0F, 0.0F, 4.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -2.0F, -0.0873F, 0.0F, 0.0F));

        PartDefinition cube_r17 = rightarm.addOrReplaceChild("cube_r17", CubeListBuilder.create().texOffs(32, 44).addBox(0.0F, -5.0F, -2.0F, 0.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, 12.0F, 0.0F, 0.0F, 0.0F, 0.0436F));

        PartDefinition leftarm = partdefinition.addOrReplaceChild("leftarm", CubeListBuilder.create().texOffs(16, 32).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-6.0F, 0.0F, 0.0F));

        PartDefinition cube_r18 = leftarm.addOrReplaceChild("cube_r18", CubeListBuilder.create().texOffs(50, 12).addBox(-2.0F, 0.0F, 0.0F, 4.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 2.0F, 0.0873F, 0.0F, 0.0F));

        PartDefinition cube_r19 = leftarm.addOrReplaceChild("cube_r19", CubeListBuilder.create().texOffs(16, 44).addBox(0.0F, 0.0F, -2.0F, 0.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0436F));

        PartDefinition cube_r20 = leftarm.addOrReplaceChild("cube_r20", CubeListBuilder.create().texOffs(52, 29).addBox(-2.0F, 0.0F, 0.0F, 4.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -2.0F, -0.0873F, 0.0F, 0.0F));

        PartDefinition cube_r21 = leftarm.addOrReplaceChild("cube_r21", CubeListBuilder.create().texOffs(16, 53).addBox(-1.0F, -5.0F, -1.0F, 4.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, 12.0F, -1.0F, 0.0436F, 0.0F, 0.0F));

        PartDefinition cube_r22 = leftarm.addOrReplaceChild("cube_r22", CubeListBuilder.create().texOffs(24, 53).addBox(-1.0F, -5.0F, 1.0F, 4.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, 12.0F, 1.0F, -0.0436F, 0.0F, 0.0F));

        PartDefinition cube_r23 = leftarm.addOrReplaceChild("cube_r23", CubeListBuilder.create().texOffs(44, 25).addBox(0.0F, -5.0F, -2.0F, 0.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, 12.0F, 0.0F, 0.0F, 0.0F, -0.0436F));

        PartDefinition rightleg = partdefinition.addOrReplaceChild("rightleg", CubeListBuilder.create().texOffs(0, 32).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, 12.0F, 0.0F));

        PartDefinition cube_r24 = rightleg.addOrReplaceChild("cube_r24", CubeListBuilder.create().texOffs(48, 46).addBox(-2.0F, 0.0F, 0.0F, 4.0F, 6.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -2.0F, -0.0436F, 0.0F, 0.0F));

        PartDefinition cube_r25 = rightleg.addOrReplaceChild("cube_r25", CubeListBuilder.create().texOffs(48, 40).addBox(-2.0F, 0.0F, 0.0F, 4.0F, 6.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 2.0F, 0.0436F, 0.0F, 0.0F));

        PartDefinition cube_r26 = rightleg.addOrReplaceChild("cube_r26", CubeListBuilder.create().texOffs(8, 44).addBox(0.0F, 0.0F, -2.0F, 0.0F, 7.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.0436F));

        PartDefinition rightleg2 = partdefinition.addOrReplaceChild("rightleg2", CubeListBuilder.create().texOffs(24, 16).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, 12.0F, 0.0F));

        PartDefinition cube_r27 = rightleg2.addOrReplaceChild("cube_r27", CubeListBuilder.create().texOffs(48, 34).addBox(-2.0F, 0.0F, 0.0F, 4.0F, 6.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -2.0F, -0.0436F, 0.0F, 0.0F));

        PartDefinition cube_r28 = rightleg2.addOrReplaceChild("cube_r28", CubeListBuilder.create().texOffs(40, 48).addBox(-2.0F, 0.0F, 0.0F, 4.0F, 6.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 2.0F, 0.0436F, 0.0F, 0.0F));

        PartDefinition cube_r29 = rightleg2.addOrReplaceChild("cube_r29", CubeListBuilder.create().texOffs(0, 44).addBox(0.0F, 0.0F, -2.0F, 0.0F, 7.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0436F));

        return LayerDefinition.create(meshdefinition, 64, 64);
    }

    @Override
    public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.head.xRot = headPitch * ((float)Math.PI / 180F);
        this.head.yRot = netHeadYaw * ((float)Math.PI / 180F);

        final float degreeOfRotation = 75F;
        final float speedOfRotation = 0.6662F;

        this.rightleg2.xRot = (float) (Math.toRadians(degreeOfRotation/2 * Mth.sin(limbSwing*speedOfRotation)) * limbSwingAmount);
        this.rightleg.xRot = (float) (Math.toRadians(degreeOfRotation/2 * Mth.sin(-limbSwing*speedOfRotation )) * limbSwingAmount);

        this.rightarm.xRot = (float) (Math.toRadians(degreeOfRotation/2 * Mth.sin(limbSwing*speedOfRotation)) * limbSwingAmount);
        this.leftarm.xRot = (float) (Math.toRadians(degreeOfRotation/2 * Mth.sin(-limbSwing*speedOfRotation )) * limbSwingAmount);
    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        head.render(poseStack, buffer, packedLight, packedOverlay);
        torso.render(poseStack, buffer, packedLight, packedOverlay);
        rightarm.render(poseStack, buffer, packedLight, packedOverlay);
        leftarm.render(poseStack, buffer, packedLight, packedOverlay);
        rightleg.render(poseStack, buffer, packedLight, packedOverlay);
        rightleg2.render(poseStack, buffer, packedLight, packedOverlay);
    }
}

