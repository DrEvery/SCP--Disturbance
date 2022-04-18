package com.drevery.scpdisturbance.client.model.scp;


import com.drevery.scpdisturbance.entity.scp.SCP007Entity;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;

public class SCP007Model<T extends SCP007Entity> extends EntityModel<T> {

	private final ModelRenderer head;
	private final ModelRenderer torso;
	private final ModelRenderer planet;
	private final ModelRenderer rightleg;
	private final ModelRenderer leftleg;
	private final ModelRenderer rightarm;
	private final ModelRenderer leftarm;

	public SCP007Model() {
		texWidth = 64;
		texHeight = 64;

		head = new ModelRenderer(this);
		head.setPos(0.0F, 0.0F, 0.0F);
		head.texOffs(0, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, 0.0F, false);

		torso = new ModelRenderer(this);
		torso.setPos(0.0F, 8.0F, 0.0F);
		torso.texOffs(0, 16).addBox(-4.0F, -8.0F, -2.0F, 8.0F, 5.0F, 4.0F, 0.0F, false);

		planet = new ModelRenderer(this);
		planet.setPos(-0.0368F, 0.5F, -0.4096F);
		torso.addChild(planet);
		setRotationAngle(planet, 0.3054F, 0.0F, 0.0F);
		planet.texOffs(19, 20).addBox(-2.5132F, -2.5F, -2.0904F, 5.0F, 5.0F, 5.0F, 0.0F, false);

		rightleg = new ModelRenderer(this);
		rightleg.setPos(-2.0F, 12.0F, 0.0F);
		rightleg.texOffs(39, 20).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 6.0F, 4.0F, 0.0F, false);
		rightleg.texOffs(16, 40).addBox(-2.0F, 6.0F, -2.0F, 4.0F, 6.0F, 4.0F, 0.0F, false);

		leftleg = new ModelRenderer(this);
		leftleg.setPos(2.0F, 12.0F, 0.0F);
		leftleg.texOffs(0, 35).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 6.0F, 4.0F, 0.0F, false);
		leftleg.texOffs(32, 30).addBox(-2.0F, 6.0F, -2.0F, 4.0F, 6.0F, 4.0F, 0.0F, false);

		rightarm = new ModelRenderer(this);
		rightarm.setPos(-4.0F, 2.0F, 0.0F);
		rightarm.texOffs(16, 30).addBox(-4.0F, -2.0F, -2.0F, 4.0F, 6.0F, 4.0F, 0.0F, false);
		rightarm.texOffs(0, 25).addBox(-4.0F, 4.0F, -2.0F, 4.0F, 6.0F, 4.0F, 0.0F, false);

		leftarm = new ModelRenderer(this);
		leftarm.setPos(4.0F, 2.0F, 0.0F);
		leftarm.texOffs(32, 10).addBox(0.0F, -2.0F, -2.0F, 4.0F, 6.0F, 4.0F, 0.0F, false);
		leftarm.texOffs(32, 0).addBox(0.0F, 4.0F, -2.0F, 4.0F, 6.0F, 4.0F, 0.0F, false);
	}

	@Override
	public void setupAnim(T pEntity, float pLimbSwing, float pLimbSwingAmount, float pAgeInTicks, float pNetHeadYaw, float pHeadPitch) {
		this.head.xRot = pHeadPitch * ((float)Math.PI / 180F);
		this.head.yRot = pNetHeadYaw * ((float)Math.PI / 180F);

		final float degreeOfRotation = 75F;
		final float speedOfRotation = 0.6662F;

		this.leftleg.xRot = (float) (Math.toRadians(degreeOfRotation/2 * MathHelper.sin(pLimbSwing*speedOfRotation)) * pLimbSwingAmount);
		this.rightleg.xRot = (float) (Math.toRadians(degreeOfRotation/2 * MathHelper.sin(-pLimbSwing*speedOfRotation )) * pLimbSwingAmount);

		this.rightarm.xRot = (float) (Math.toRadians(degreeOfRotation/2 * MathHelper.sin(pLimbSwing*speedOfRotation)) * pLimbSwingAmount);
		this.leftarm.xRot = (float) (Math.toRadians(degreeOfRotation/2 * MathHelper.sin(-pLimbSwing*speedOfRotation )) * pLimbSwingAmount);

		this.planet.yRot = (float) (Math.toRadians(degreeOfRotation/2) * pAgeInTicks/50);
	}

	@Override
	public void renderToBuffer(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		head.render(matrixStack, buffer, packedLight, packedOverlay);
		torso.render(matrixStack, buffer, packedLight, packedOverlay);
		rightleg.render(matrixStack, buffer, packedLight, packedOverlay);
		leftleg.render(matrixStack, buffer, packedLight, packedOverlay);
		rightarm.render(matrixStack, buffer, packedLight, packedOverlay);
		leftarm.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.xRot = x;
		modelRenderer.yRot = y;
		modelRenderer.zRot = z;
	}
}