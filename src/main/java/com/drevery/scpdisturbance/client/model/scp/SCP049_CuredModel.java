package com.drevery.scpdisturbance.client.model.scp;

import com.drevery.scpdisturbance.SCPDisturbance;
import com.drevery.scpdisturbance.entity.scp.SCP049_CuredEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;

public class SCP049_CuredModel<T extends SCP049_CuredEntity> extends EntityModel<T> {
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(SCPDisturbance.MOD_ID, "scp_049_cured"), "main");
    // Made with Blockbench 4.2.2
// Exported for Minecraft version 1.17 with Mojang mappings
// Paste this class into your mod and generate all required imports
        private final ModelPart leftarm;
        private final ModelPart rightarm;
        private final ModelPart leftleg;
        private final ModelPart rightleg;
        private final ModelPart head;
        private final ModelPart torso;

        public SCP049_CuredModel(ModelPart root) {
            this.leftarm = root.getChild("leftarm");
            this.rightarm = root.getChild("rightarm");
            this.leftleg = root.getChild("leftleg");
            this.rightleg = root.getChild("rightleg");
            this.head = root.getChild("head");
            this.torso = root.getChild("torso");
        }

        public static LayerDefinition createBodyLayer() {
            MeshDefinition meshdefinition = new MeshDefinition();
            PartDefinition partdefinition = meshdefinition.getRoot();

            PartDefinition leftarm = partdefinition.addOrReplaceChild("leftarm", CubeListBuilder.create().texOffs(32, 0).addBox(-0.375F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.0F, 2.0F, 0.0F, -1.4021F, 0.045F, -0.258F));

            PartDefinition rightarm = partdefinition.addOrReplaceChild("rightarm", CubeListBuilder.create().texOffs(0, 32).addBox(-4.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, 2.0F, 0.0F, -1.2217F, 0.0F, 0.0F));

            PartDefinition leftleg = partdefinition.addOrReplaceChild("leftleg", CubeListBuilder.create().texOffs(16, 32).addBox(-1.5F, 0.125F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, 11.75F, 0.0F, 0.0F, 0.0F, -0.1309F));

            PartDefinition rightleg = partdefinition.addOrReplaceChild("rightleg", CubeListBuilder.create().texOffs(24, 16).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, 12.0F, 0.0F, 0.0051F, 0.011F, -0.0445F));

            PartDefinition head = partdefinition.addOrReplaceChild("head", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.2182F, 0.0F, 0.0F));

            PartDefinition cube_r1 = head.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(0, 0).addBox(-4.5F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.1308F, -0.0057F, -0.0433F));

            PartDefinition torso = partdefinition.addOrReplaceChild("torso", CubeListBuilder.create().texOffs(0, 16).addBox(-3.225F, -6.0F, -3.0F, 8.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, 6.0F, 1.0F, 0.0F, 0.0F, -0.0873F));

            return LayerDefinition.create(meshdefinition, 64, 64);
        }

        @Override
        public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
            this.head.xRot = headPitch * ((float)Math.PI / 180F);
            this.head.yRot = netHeadYaw * ((float)Math.PI / 180F);

            final float degreeOfRotation = 75F;
            final float speedOfRotation = 0.6662F;

            this.leftleg.xRot = (float) (Math.toRadians(degreeOfRotation/2 * Math.sin(limbSwing*speedOfRotation)) * limbSwingAmount);
            this.rightleg.xRot = (float) (Math.toRadians(degreeOfRotation/2 * Math.sin(-limbSwing*speedOfRotation )) * limbSwingAmount);

            this.rightarm.xRot = (float) (Math.toRadians(degreeOfRotation/2 * Math.sin(limbSwing*speedOfRotation)) * limbSwingAmount);
            this.leftarm.xRot = (float) (Math.toRadians(degreeOfRotation/2 * Math.sin(-limbSwing*speedOfRotation )) * limbSwingAmount);
        }

        @Override
        public void renderToBuffer(PoseStack poseStack, VertexConsumer buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
            leftarm.render(poseStack, buffer, packedLight, packedOverlay);
            rightarm.render(poseStack, buffer, packedLight, packedOverlay);
            leftleg.render(poseStack, buffer, packedLight, packedOverlay);
            rightleg.render(poseStack, buffer, packedLight, packedOverlay);
            head.render(poseStack, buffer, packedLight, packedOverlay);
            torso.render(poseStack, buffer, packedLight, packedOverlay);
        }
    }