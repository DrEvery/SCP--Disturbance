package com.drevery.scpdisturbance.client.model.scp529;
// Made with Blockbench 4.1.5
// Exported for Minecraft version 1.15 - 1.16 with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.drevery.scpdisturbance.entity.scp529.JosieEntity;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;

public class JosieModel<T extends JosieEntity> extends EntityModel<T> {
	private final ModelRenderer body;
	private final ModelRenderer body_r1;
	private final ModelRenderer head;
	private final ModelRenderer frontLegL;
	private final ModelRenderer frontLegR;

	public JosieModel() {
		texWidth = 64;
		texHeight = 32;

		body = new ModelRenderer(this);
		body.setPos(0.0F, 9.0F, -2.0F);


		body_r1 = new ModelRenderer(this);
		body_r1.setPos(0.0F, 8.2022F, 6.8571F);
		body.addChild(body_r1);
		setRotationAngle(body_r1, 1.5708F, 0.0F, 0.0F);
		body_r1.texOffs(20, 0).addBox(-2.0F, -8.0F, -3.0F, 4.0F, 9.0F, 6.0F, 0.0F, false);

		head = new ModelRenderer(this);
		head.setPos(0.0F, 5.2F, -1.2F);
		body.addChild(head);
		head.texOffs(0, 0).addBox(-2.5F, -0.9978F, -4.9429F, 5.0F, 4.0F, 5.0F, 0.0F, false);
		head.texOffs(0, 24).addBox(-1.5F, 0.9866F, -5.9429F, 3.0F, 2.0F, 2.0F, 0.0F, false);
		head.texOffs(0, 10).addBox(-2.0F, -1.9978F, -1.9429F, 1.0F, 1.0F, 2.0F, 0.0F, false);
		head.texOffs(6, 10).addBox(1.0F, -1.9978F, -1.9429F, 1.0F, 1.0F, 2.0F, 0.0F, false);

		frontLegL = new ModelRenderer(this);
		frontLegL.setPos(1.2F, 7.0F, 2.0F);
		body.addChild(frontLegL);
		frontLegL.texOffs(40, 0).addBox(-1.0F, -1.9978F, -1.1429F, 2.0F, 10.0F, 2.0F, 0.0F, false);

		frontLegR = new ModelRenderer(this);
		frontLegR.setPos(-1.2F, 7.0F, 2.0F);
		body.addChild(frontLegR);
		frontLegR.texOffs(40, 0).addBox(-1.0F, -1.9978F, -1.1429F, 2.0F, 10.0F, 2.0F, 0.0F, false);
	}



	@Override
	public void renderToBuffer(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		body.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.xRot = x;
		modelRenderer.yRot = y;
		modelRenderer.zRot = z;
	}

	@Override
	public void setupAnim(T pEntity, float pLimbSwing, float pLimbSwingAmount, float pAgeInTicks, float pNetHeadYaw, float pHeadPitch) {
		this.head.xRot = pHeadPitch * ((float)Math.PI / 180F);
		this.head.yRot = pNetHeadYaw * ((float)Math.PI / 180F);

		this.frontLegL.xRot = (float) ((75 * MathHelper.sin(pLimbSwing*0.6662F)) * (Math.PI/180) * pLimbSwingAmount);
		this.frontLegR.xRot = (float) ((75 * MathHelper.sin(-(pLimbSwing*0.6662F))) * (Math.PI/180) * pLimbSwingAmount);
	}
}