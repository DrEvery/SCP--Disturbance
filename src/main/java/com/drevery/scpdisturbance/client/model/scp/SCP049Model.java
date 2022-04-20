package com.drevery.scpdisturbance.client.model.scp;

import com.drevery.scpdisturbance.SCPDisturbance;
import com.drevery.scpdisturbance.entity.scp.SCP049Entity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;

public class SCP049Model<T extends SCP049Entity> extends EntityModel<T> {
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(SCPDisturbance.MOD_ID, "scp_049"), "main");
    private final ModelPart head;
    private final ModelPart torso;
    private final ModelPart rightarm;
    private final ModelPart leftarm;
    private final ModelPart rightleg;
    private final ModelPart leftleg;

    public SCP049Model(ModelPart root) {
        this.head = root.getChild("head");
        this.torso = root.getChild("torso");
        this.rightarm = root.getChild("rightarm");
        this.leftarm = root.getChild("leftarm");
        this.rightleg = root.getChild("rightleg");
        this.leftleg = root.getChild("leftleg");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition head = partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition cube_r1 = head.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(32, 7).addBox(-1.0F, -2.0053F, -6.0F, 3.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, -1.0F, -7.0F, 0.5672F, 0.0F, 0.0F));

        PartDefinition cube_r2 = head.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(40, 16).addBox(-1.0F, -1.0F, -4.0F, 3.0F, 4.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, -3.0F, -4.0F, 0.3054F, 0.0F, 0.0F));

        PartDefinition torso = partdefinition.addOrReplaceChild("torso", CubeListBuilder.create().texOffs(24, 0).addBox(-4.0F, 5.0F, -4.5F, 8.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
                .texOffs(45, 0).addBox(-0.5F, 4.5F, -5.0F, 4.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 16).addBox(-4.0F, -5.0F, -4.0F, 8.0F, 10.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 5.0F, 2.0F));

        PartDefinition cube_r3 = torso.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(40, 25).addBox(2.0F, 0.0F, 0.0F, 8.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.0F, -5.0F, 0.0F, 0.0873F, 0.0F, 0.0F));

        PartDefinition cube_r4 = torso.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(44, 7).addBox(2.0F, 0.0F, 0.0F, 8.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.0F, -5.0F, -4.0F, -0.0873F, 0.0F, 0.0F));

        PartDefinition rightarm = partdefinition.addOrReplaceChild("rightarm", CubeListBuilder.create().texOffs(0, 32).addBox(-4.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-4.0F, 2.0F, 0.0F));

        PartDefinition cube_r5 = rightarm.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(36, 16).addBox(-2.0F, 0.0F, 0.0F, 4.0F, 3.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, -2.0F, -2.0F, -0.0873F, 0.0F, 0.0F));

        PartDefinition cube_r6 = rightarm.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(20, 12).addBox(0.0F, 0.0F, -2.0F, 0.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, -2.0F, 0.0F, 0.0F, 0.0F, 0.0873F));

        PartDefinition cube_r7 = rightarm.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(48, 49).addBox(-2.0F, -5.0F, 0.0F, 4.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, 10.0F, -2.0F, 0.0436F, 0.0F, 0.0F));

        PartDefinition cube_r8 = rightarm.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(12, 32).addBox(-2.0F, 0.0F, 0.0F, 4.0F, 3.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, -2.0F, 2.0F, 0.0873F, 0.0F, 0.0F));

        PartDefinition cube_r9 = rightarm.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(16, 44).addBox(0.0F, -5.0F, -2.0F, 0.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, 10.0F, 0.0F, 0.0F, 0.0F, -0.0436F));

        PartDefinition cube_r10 = rightarm.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(40, 48).addBox(-2.0F, -5.0F, 0.0F, 4.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, 10.0F, 2.0F, -0.0436F, 0.0F, 0.0F));

        PartDefinition leftarm = partdefinition.addOrReplaceChild("leftarm", CubeListBuilder.create().texOffs(24, 16).addBox(0.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(4.0F, 2.0F, 0.0F));

        PartDefinition cube_r11 = leftarm.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(28, 32).addBox(-2.0F, 0.0F, 0.0F, 4.0F, 3.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, -2.0F, -2.0F, -0.0873F, 0.0F, 0.0F));

        PartDefinition cube_r12 = leftarm.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(0, 0).addBox(-2.0F, 0.0F, 0.0F, 4.0F, 3.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, -2.0F, 2.0F, 0.0873F, 0.0F, 0.0F));

        PartDefinition cube_r13 = leftarm.addOrReplaceChild("cube_r13", CubeListBuilder.create().texOffs(48, 44).addBox(-2.0F, -5.0F, 0.0F, 4.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, 10.0F, -2.0F, 0.0436F, 0.0F, 0.0F));

        PartDefinition cube_r14 = leftarm.addOrReplaceChild("cube_r14", CubeListBuilder.create().texOffs(48, 39).addBox(-2.0F, -5.0F, 0.0F, 4.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, 10.0F, 2.0F, -0.0436F, 0.0F, 0.0F));

        PartDefinition cube_r15 = leftarm.addOrReplaceChild("cube_r15", CubeListBuilder.create().texOffs(24, 44).addBox(0.0F, -5.0F, -2.0F, 0.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.0F, 10.0F, 0.0F, 0.0F, 0.0F, 0.0873F));

        PartDefinition cube_r16 = leftarm.addOrReplaceChild("cube_r16", CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, 0.0F, -2.0F, 0.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.0F, -2.0F, 0.0F, 0.0F, 0.0F, -0.0873F));

        PartDefinition rightleg = partdefinition.addOrReplaceChild("rightleg", CubeListBuilder.create().texOffs(32, 32).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, 12.0F, 0.0F));

        PartDefinition cube_r17 = rightleg.addOrReplaceChild("cube_r17", CubeListBuilder.create().texOffs(32, 48).addBox(-2.0F, 0.0F, 0.0F, 4.0F, 9.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 2.0F, 0.0873F, 0.0F, 0.0F));

        PartDefinition cube_r18 = rightleg.addOrReplaceChild("cube_r18", CubeListBuilder.create().texOffs(56, 21).addBox(-2.0F, 0.0F, 0.0F, 4.0F, 7.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -2.0F, -0.0873F, 0.0F, 0.0F));

        PartDefinition cube_r19 = rightleg.addOrReplaceChild("cube_r19", CubeListBuilder.create().texOffs(8, 44).addBox(0.0F, 0.0F, -2.0F, 0.0F, 7.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0873F));

        PartDefinition leftleg = partdefinition.addOrReplaceChild("leftleg", CubeListBuilder.create().texOffs(16, 32).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, 12.0F, 0.0F));

        PartDefinition cube_r20 = leftleg.addOrReplaceChild("cube_r20", CubeListBuilder.create().texOffs(48, 30).addBox(2.0F, 0.0F, 0.0F, 4.0F, 9.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, 0.0F, 2.0F, 0.0873F, 0.0F, 0.0F));

        PartDefinition cube_r21 = leftleg.addOrReplaceChild("cube_r21", CubeListBuilder.create().texOffs(56, 22).addBox(2.0F, 0.0F, 0.0F, 4.0F, 6.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, 0.0F, -2.0F, -0.0873F, 0.0F, 0.0F));

        PartDefinition cube_r22 = leftleg.addOrReplaceChild("cube_r22", CubeListBuilder.create().texOffs(0, 44).addBox(0.0F, 0.0F, -2.0F, 0.0F, 7.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.0873F));

        return LayerDefinition.create(meshdefinition, 64, 64);
    }

    @Override
    public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.head.xRot = headPitch * ((float)Math.PI / 180F);
        this.head.yRot = netHeadYaw * ((float)Math.PI / 180F);

        final float degreeOfRotation = 75F;
        final float speedOfRotation = 0.6662F;

        this.leftleg.xRot = (float) (Math.toRadians(degreeOfRotation/2 * Mth.sin(limbSwing*speedOfRotation)) * limbSwingAmount);
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
        leftleg.render(poseStack, buffer, packedLight, packedOverlay);
    }
}
