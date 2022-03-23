package com.drevery.scpdisturbance.client.model.scp007;
// Made with Blockbench 4.1.5
// Exported for Minecraft version 1.15 - 1.16 with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.drevery.scpdisturbance.entity.scp007.Scp007Entity;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

public class Scp007Model<T extends Scp007Entity> extends EntityModel<T> {

		private final ModelRenderer Head;
		private final ModelRenderer Body;
		private final ModelRenderer RightArm;
		private final ModelRenderer LeftArm;
		private final ModelRenderer RightLeg;
		private final ModelRenderer LeftLeg;
		private final ModelRenderer Planet;
		private final ModelRenderer Planet_r1;

		public Scp007Model() {
			texWidth = 64;
			texHeight = 64;

			Head = new ModelRenderer(this);
			Head.setPos(0.0F, 0.0F, 0.0F);
			Head.texOffs(0, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, 0.0F, false);

			Body = new ModelRenderer(this);
			Body.setPos(0.0F, 24.0F, 0.0F);
			Body.texOffs(0, 16).addBox(-4.0F, -24.0F, -2.0F, 8.0F, 5.0F, 4.0F, 0.0F, false);

			RightArm = new ModelRenderer(this);
			RightArm.setPos(-4.0F, 2.0F, 0.0F);
			RightArm.texOffs(0, 25).addBox(-4.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, false);

			LeftArm = new ModelRenderer(this);
			LeftArm.setPos(4.0F, 2.0F, 0.0F);
			LeftArm.texOffs(20, 21).addBox(0.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, false);

			RightLeg = new ModelRenderer(this);
			RightLeg.setPos(-2.0F, 24.0F, 0.0F);
			RightLeg.texOffs(32, 33).addBox(-2.0F, -12.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, false);

			LeftLeg = new ModelRenderer(this);
			LeftLeg.setPos(2.0F, 14.0F, 0.0F);
			LeftLeg.texOffs(32, 0).addBox(-2.1F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, false);

			Planet = new ModelRenderer(this);
			Planet.setPos(-0.25F, 9.0F, -0.25F);
			setRotationAngle(Planet, 0.0F, 1.1781F, 0.0F);


			Planet_r1 = new ModelRenderer(this);
			Planet_r1.setPos(-0.1353F, 0.0F, 0.3266F);
			Planet.addChild(Planet_r1);
			setRotationAngle(Planet_r1, 0.5236F, -0.6981F, 0.0F);
			Planet_r1.texOffs(32, 16).addBox(-2.0F, -2.5F, -2.0F, 4.0F, 4.0F, 4.0F, 0.0F, false);
		}

	@Override
	public void setupAnim(T pEntity, float pLimbSwing, float pLimbSwingAmount, float pAgeInTicks, float pNetHeadYaw, float pHeadPitch) {
		this.Head.xRot = pHeadPitch * ((float)Math.PI / 180F);
		this.Head.yRot = pNetHeadYaw * ((float)Math.PI / 180F);

		final float degreeOfRotation = 75F;
		final float speedOfRotation = 0.6662F;

		this.RightLeg.xRot = (float) (Math.toRadians(degreeOfRotation/2 * MathHelper.sin(pLimbSwing*speedOfRotation)) * pLimbSwingAmount);
		this.LeftLeg.xRot = (float) (Math.toRadians(degreeOfRotation/2 * MathHelper.sin(-pLimbSwing*speedOfRotation )) * pLimbSwingAmount);

		this.LeftArm.xRot = (float) (Math.toRadians(degreeOfRotation/2 * MathHelper.sin(pLimbSwing*speedOfRotation)) * pLimbSwingAmount);
		this.RightArm.xRot = (float) (Math.toRadians(degreeOfRotation/2 * MathHelper.sin(-pLimbSwing*speedOfRotation )) * pLimbSwingAmount);

		this.Planet.xRot = (float) (Math.toRadians(degreeOfRotation/2 * MathHelper.sin(-pLimbSwing*speedOfRotation )) * pLimbSwingAmount);
	}

		@Override
		public void renderToBuffer(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
			Head.render(matrixStack, buffer, packedLight, packedOverlay);
			Body.render(matrixStack, buffer, packedLight, packedOverlay);
			RightArm.render(matrixStack, buffer, packedLight, packedOverlay);
			LeftArm.render(matrixStack, buffer, packedLight, packedOverlay);
			RightLeg.render(matrixStack, buffer, packedLight, packedOverlay);
			LeftLeg.render(matrixStack, buffer, packedLight, packedOverlay);
			Planet.render(matrixStack, buffer, packedLight, packedOverlay);
		}

		public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
			modelRenderer.xRot = x;
			modelRenderer.yRot = y;
			modelRenderer.zRot = z;
		}
	}