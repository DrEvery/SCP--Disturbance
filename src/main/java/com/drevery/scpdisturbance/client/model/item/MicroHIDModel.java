package com.drevery.scpdisturbance.client.model.item;

import com.drevery.scpdisturbance.SCPDisturbance;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.Model;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;

public class MicroHIDModel extends Model {
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(SCPDisturbance.MOD_ID, "hid"), "main");
	private final ModelPart bone;
	private final ModelPart magazine;

	public MicroHIDModel(ModelPart root) {
		super(RenderType::entitySolid);
		this.bone = root.getChild("bone");
		this.magazine = root.getChild("magazine");
	}

	public static LayerDefinition createLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition bone = partdefinition.addOrReplaceChild("bone", CubeListBuilder.create().texOffs(2, 19).addBox(7.15F, -10.0F, -8.75F, 1.0F, 0.0F, 13.0F, new CubeDeformation(0.0F))
				.texOffs(0, 34).addBox(8.15F, -10.5F, -8.75F, 1.0F, 1.0F, 13.0F, new CubeDeformation(0.0F))
				.texOffs(30, 33).addBox(7.15F, -7.5F, -8.75F, 1.0F, 1.0F, 13.0F, new CubeDeformation(0.0F))
				.texOffs(0, 48).addBox(6.15F, -6.5F, -8.75F, 3.0F, 3.0F, 6.0F, new CubeDeformation(0.0F))
				.texOffs(30, 21).addBox(6.15F, -12.5F, 4.25F, 3.0F, 6.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(5.15F, -13.5F, 5.25F, 5.0F, 7.0F, 12.0F, new CubeDeformation(0.0F))
				.texOffs(30, 21).addBox(5.15F, -6.5F, 6.25F, 5.0F, 2.0F, 10.0F, new CubeDeformation(0.0F))
				.texOffs(23, 47).addBox(5.15F, -11.5F, 17.25F, 5.0F, 8.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(6.65F, -13.5F, 17.25F, 2.0F, 2.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(7.65F, -13.5F, 21.25F, 0.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(33, 41).addBox(7.15F, -6.5F, -0.75F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(45, 33).addBox(4.65F, -14.5F, 8.25F, 6.0F, 5.0F, 6.0F, new CubeDeformation(0.0F))
				.texOffs(0, 6).addBox(5.65F, -6.5F, -2.75F, 4.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(8, 0).addBox(4.15F, -6.5F, 15.25F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(15, 36).addBox(3.15F, -9.5F, 15.25F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(22, 0).addBox(2.65F, -17.5F, 10.25F, 10.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(36, 4).addBox(12.65F, -13.5F, 10.25F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(0, 41).addBox(10.65F, -12.5F, 10.25F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(0, 19).addBox(5.15F, -10.5F, -8.75F, 1.0F, 2.0F, 13.0F, new CubeDeformation(0.0F))
				.texOffs(22, 4).addBox(2.65F, -15.5F, 10.25F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(15, 36).addBox(6.15F, -7.5F, -7.75F, 1.0F, 1.0F, 8.0F, new CubeDeformation(0.0F))
				.texOffs(36, 0).addBox(6.15F, -10.5F, -8.75F, 1.0F, 1.0F, 13.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 17.0F, 0.0F));

		PartDefinition cube_r1 = bone.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(15, 21).addBox(0.0F, 0.2F, -8.0F, 1.0F, 2.0F, 13.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.15F, -9.5F, -0.75F, 0.0F, 0.0F, -0.3054F));

		PartDefinition cube_r2 = bone.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(21, 6).addBox(-1.0F, 0.2F, -8.0F, 1.0F, 2.0F, 13.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(9.15F, -9.5F, -0.75F, 0.0F, 0.0F, 0.3054F));

		PartDefinition cube_r3 = bone.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(6, 43).addBox(-1.0F, 0.0F, 0.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(8.15F, -7.5F, -6.75F, 0.0F, 0.7854F, 0.0F));

		PartDefinition cube_r4 = bone.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(25, 41).addBox(-0.2929F, 0.0F, -0.1213F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(5, 34).addBox(-0.2929F, 0.0F, 5.8787F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(15, 41).addBox(-0.2929F, 0.0F, 1.8787F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(36, 10).addBox(-0.2929F, 0.0F, 3.8787F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(4, 10).addBox(-0.5F, -0.5F, 3.8787F, 2.0F, 2.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(0, 10).addBox(-0.5F, -0.5F, 6.0F, 2.0F, 2.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(-0.5F, -0.5F, 6.5F, 2.0F, 2.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(9.15F, -7.5F, -4.75F, 0.0F, 0.0F, 0.0F));

		PartDefinition cube_r5 = bone.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(17, 26).addBox(1.9142F, 0.0F, 2.8787F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.9429F, -7.5F, 3.25F, -0.5236F, 0.0F, 0.0F));

		PartDefinition cube_r6 = bone.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(41, 7).addBox(-0.2929F, 0.0F, -0.1213F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(9.15F, -7.5F, 3.25F, -0.5236F, 0.0F, 0.0F));

		PartDefinition cube_r7 = bone.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(30, 28).addBox(0.0F, -1.0F, 0.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.15F, -6.5F, 0.25F, -0.2284F, -0.298F, 0.0681F));

		PartDefinition cube_r8 = bone.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(28, 9).addBox(-1.0109F, -1.2184F, 0.0411F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.15F, -4.5F, 3.25F, -0.7517F, -0.0881F, -0.1584F));

		PartDefinition cube_r9 = bone.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(45, 33).addBox(-4.0F, -0.5F, 5.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(33, 36).addBox(-4.0F, -1.0F, 3.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(10.65F, -9.5F, -0.75F, -0.829F, 0.0F, 0.0F));

		PartDefinition cube_r10 = bone.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(17, 21).addBox(-1.0297F, -0.5698F, -0.0988F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.15F, -3.5F, 5.25F, -0.579F, -0.071F, 0.0509F));

		PartDefinition cube_r11 = bone.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(6, 19).addBox(-0.5872F, -0.5671F, 0.1378F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.15F, -6.5F, 2.25F, -0.8393F, -0.298F, 0.0681F));

		PartDefinition cube_r12 = bone.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(25, 36).addBox(-1.0F, -3.0F, -0.9F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(13.65F, -13.5F, 11.25F, 0.0F, 0.0F, -0.3054F));

		PartDefinition cube_r13 = bone.addOrReplaceChild("cube_r13", CubeListBuilder.create().texOffs(43, 47).addBox(-7.0F, -3.0F, -3.0F, 2.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(10.15F, -6.5F, 11.25F, 0.7854F, 0.0F, 0.0F));

		PartDefinition cube_r14 = bone.addOrReplaceChild("cube_r14", CubeListBuilder.create().texOffs(5, 37).addBox(-0.5F, -0.5F, -1.25F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.15F, -1.5F, 9.25F, -0.0808F, -0.261F, -0.0117F));

		PartDefinition cube_r15 = bone.addOrReplaceChild("cube_r15", CubeListBuilder.create().texOffs(17, 19).addBox(-1.0F, -0.1501F, -0.3861F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.15F, -2.5F, 14.25F, -1.309F, 0.0F, 0.0F));

		PartDefinition cube_r16 = bone.addOrReplaceChild("cube_r16", CubeListBuilder.create().texOffs(36, 14).addBox(-6.4142F, -2.5858F, -1.0F, 5.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.65F, -15.5F, 19.25F, 0.0F, 0.0F, -0.7854F));

		PartDefinition cube_r17 = bone.addOrReplaceChild("cube_r17", CubeListBuilder.create().texOffs(0, 27).addBox(-2.0F, -2.0F, -1.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.65F, -13.5F, 19.25F, 0.0F, 0.0F, -0.7854F));

		PartDefinition cube_r18 = bone.addOrReplaceChild("cube_r18", CubeListBuilder.create().texOffs(0, 19).addBox(-1.0F, 0.0F, -1.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.15F, -3.5F, 16.25F, -0.829F, 0.0F, 0.0F));

		PartDefinition cube_r19 = bone.addOrReplaceChild("cube_r19", CubeListBuilder.create().texOffs(23, 21).addBox(-1.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(8, 10).addBox(-1.0F, 0.0F, -2.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.15F, -7.5F, -4.75F, 0.0F, 0.0F, -0.3054F));

		PartDefinition magazine = partdefinition.addOrReplaceChild("magazine", CubeListBuilder.create().texOffs(0, 19).addBox(2.15F, -15.5F, 9.25F, 1.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(0, 34).addBox(1.85F, -15.0F, 9.75F, 1.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	public ModelPart getBone() {
		return this.bone;
	}

	@Override
	public void renderToBuffer(PoseStack pPoseStack, VertexConsumer pBuffer, int pPackedLight, int pPackedOverlay, float pRed, float pGreen, float pBlue, float pAlpha) {
		bone.render(pPoseStack, pBuffer, pPackedLight, pPackedOverlay, pRed, pGreen, pBlue, pAlpha);
		magazine.render(pPoseStack, pBuffer, pPackedLight, pPackedOverlay, pRed, pGreen, pBlue, pAlpha);
	}
}
