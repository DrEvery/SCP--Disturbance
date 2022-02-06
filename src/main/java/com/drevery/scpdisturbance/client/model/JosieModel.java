package com.drevery.scpdisturbance.client.model;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.passive.CatEntity;

public class JosieModel<T extends CatEntity> extends EntityModel<T> {
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
		head.setPos(0.0F, -2.0F, -10.0F);
		body.addChild(head);
		head.texOffs(0, 0).addBox(-2.5F, 6.2022F, 3.8571F, 5.0F, 4.0F, 5.0F, 0.0F, false);
		head.texOffs(0, 24).addBox(-1.5F, 8.1866F, 2.8571F, 3.0F, 2.0F, 2.0F, 0.0F, false);
		head.texOffs(0, 10).addBox(-2.0F, 5.2022F, 6.8571F, 1.0F, 1.0F, 2.0F, 0.0F, false);
		head.texOffs(6, 10).addBox(1.0F, 5.2022F, 6.8571F, 1.0F, 1.0F, 2.0F, 0.0F, false);

		frontLegL = new ModelRenderer(this);
		frontLegL.setPos(1.2F, -3.0F, -5.0F);
		body.addChild(frontLegL);
		frontLegL.texOffs(40, 0).addBox(-1.0F, 8.0022F, 5.8571F, 2.0F, 10.0F, 2.0F, 0.0F, false);

		frontLegR = new ModelRenderer(this);
		frontLegR.setPos(-1.2F, -3.0F, -5.0F);
		body.addChild(frontLegR);
		frontLegR.texOffs(40, 0).addBox(-1.0F, 8.0022F, 5.8571F, 2.0F, 10.0F, 2.0F, 0.0F, false);
	}

	@Override
	public void setupAnim(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		//TODO Animations
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
}