package com.drevery.scpdisturbance.client.model.scp;

import com.drevery.scpdisturbance.SCPDisturbance;
import com.drevery.scpdisturbance.entity.scp.SCP007Entity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
// Made with Blockbench 4.2.2
// Exported for Minecraft version 1.17 with Mojang mappings
// Paste this class into your mod and generate all required imports

// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
// Made with Blockbench 4.2.2
// Exported for Minecraft version 1.17 with Mojang mappings
// Paste this class into your mod and generate all required imports


// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
public class SCP007Model<T extends SCP007Entity> extends EntityModel<T> {

		public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(SCPDisturbance.MOD_ID, "scp_007"), "main");
		private final ModelPart head;
		private final ModelPart planet;
		private final ModelPart torso;
		private final ModelPart rightleg;
		private final ModelPart leftleg;
		private final ModelPart rightarm;
		private final ModelPart leftarm;


	public SCP007Model(ModelPart root) {
		this.head = root.getChild("head");
		this.torso = root.getChild("torso");
		this.rightarm = root.getChild("rightarm");
		this.leftarm = root.getChild("leftarm");
		this.rightleg = root.getChild("rightleg");
		this.leftleg = root.getChild("leftleg");
		this.planet = root.getChild("planet");
	}



	public static LayerDefinition createBodyLayer() {
			MeshDefinition meshdefinition = new MeshDefinition();
			PartDefinition partdefinition = meshdefinition.getRoot();

			PartDefinition head = partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

			PartDefinition planet = partdefinition.addOrReplaceChild("planet", CubeListBuilder.create().texOffs(19, 20).addBox(-2.5132F, -2.5F, -2.0904F, 5.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.0368F, 8.5F, -0.4096F, 0.3054F, 0.0F, 0.0F));

			PartDefinition torso = partdefinition.addOrReplaceChild("torso", CubeListBuilder.create().texOffs(0, 16).addBox(-4.0F, -8.0F, -2.0F, 8.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 8.0F, 0.0F));

			PartDefinition rightleg = partdefinition.addOrReplaceChild("rightleg", CubeListBuilder.create().texOffs(39, 20).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.0F))
					.texOffs(16, 40).addBox(-2.0F, 6.0F, -2.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, 12.0F, 0.0F));

			PartDefinition leftleg = partdefinition.addOrReplaceChild("leftleg", CubeListBuilder.create().texOffs(0, 35).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.0F))
					.texOffs(32, 30).addBox(-2.0F, 6.0F, -2.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, 12.0F, 0.0F));

			PartDefinition rightarm = partdefinition.addOrReplaceChild("rightarm", CubeListBuilder.create().texOffs(16, 30).addBox(-4.0F, -2.0F, -2.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.0F))
					.texOffs(0, 25).addBox(-4.0F, 4.0F, -2.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-4.0F, 2.0F, 0.0F));

			PartDefinition leftarm = partdefinition.addOrReplaceChild("leftarm", CubeListBuilder.create().texOffs(32, 10).addBox(0.0F, -2.0F, -2.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.0F))
					.texOffs(32, 0).addBox(0.0F, 4.0F, -2.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(4.0F, 2.0F, 0.0F));

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

			this.planet.yRot = (float) (Math.toRadians(degreeOfRotation/2) * ageInTicks/50);
		}

		@Override
		public void renderToBuffer(PoseStack poseStack, VertexConsumer buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
			head.render(poseStack, buffer, packedLight, packedOverlay);
			planet.render(poseStack, buffer, packedLight, packedOverlay);
			torso.render(poseStack, buffer, packedLight, packedOverlay);
			rightleg.render(poseStack, buffer, packedLight, packedOverlay);
			leftleg.render(poseStack, buffer, packedLight, packedOverlay);
			rightarm.render(poseStack, buffer, packedLight, packedOverlay);
			leftarm.render(poseStack, buffer, packedLight, packedOverlay);
		}
	}
