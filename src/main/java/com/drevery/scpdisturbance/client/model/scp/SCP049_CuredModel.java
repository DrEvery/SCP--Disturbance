package com.drevery.scpdisturbance.client.model.scp;

import com.drevery.scpdisturbance.entity.scp.SCP049_CuredEntity;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;

public class SCP049_CuredModel<T extends SCP049_CuredEntity> extends EntityModel<T> {
    private final ModelRenderer head;
    private final ModelRenderer cube_r1;
    private final ModelRenderer torso;
    private final ModelRenderer cube_r2;
    private final ModelRenderer cube_r3;
    private final ModelRenderer cube_r4;
    private final ModelRenderer leftarm;
    private final ModelRenderer rightarm;
    private final ModelRenderer leftleg;
    private final ModelRenderer rightleg;

    public SCP049_CuredModel() {
        texWidth = 64;
        texHeight = 64;

        head = new ModelRenderer(this);
        head.setPos(0.0F, 1.0F, -4.0F);


        cube_r1 = new ModelRenderer(this);
        cube_r1.setPos(0.0F, 11.0F, 5.0F);
        head.addChild(cube_r1);
        setRotationAngle(cube_r1, 0.3927F, 0.0F, 0.0F);
        cube_r1.texOffs(0, 0).addBox(-4.0F, -20.0F, -5.0F, 8.0F, 8.0F, 8.0F, 0.0F, false);

        torso = new ModelRenderer(this);
        torso.setPos(0.0F, 24.0F, 0.0F);


        cube_r2 = new ModelRenderer(this);
        cube_r2.setPos(0.0F, -12.0F, 1.0F);
        torso.addChild(cube_r2);
        setRotationAngle(cube_r2, 0.3927F, 0.0F, 0.0F);
        cube_r2.texOffs(0, 16).addBox(-4.0F, -12.0F, -3.0F, 8.0F, 12.0F, 4.0F, 0.0F, false);

        cube_r3 = new ModelRenderer(this);
        cube_r3.setPos(-0.5F, -17.0F, -3.0F);
        torso.addChild(cube_r3);
        setRotationAngle(cube_r3, 1.5708F, 0.0F, 0.0F);
        cube_r3.texOffs(17, 0).addBox(-3.0F, -0.8499F, -7.2179F, 7.0F, 0.0F, 7.0F, 0.0F, false);

        cube_r4 = new ModelRenderer(this);
        cube_r4.setPos(-0.5F, -17.0F, -3.0F);
        torso.addChild(cube_r4);
        setRotationAngle(cube_r4, 1.309F, 0.0F, 0.0F);
        cube_r4.texOffs(25, 7).addBox(-2.0F, -0.8499F, -5.2179F, 5.0F, 0.0F, 7.0F, 0.0F, false);

        leftarm = new ModelRenderer(this);
        leftarm.setPos(4.0F, 3.0F, -4.0F);
        leftarm.texOffs(16, 32).addBox(0.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, false);

        rightarm = new ModelRenderer(this);
        rightarm.setPos(-4.0F, 3.0F, -4.0F);
        rightarm.texOffs(0, 32).addBox(-4.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, false);

        leftleg = new ModelRenderer(this);
        leftleg.setPos(2.0F, 12.0F, 0.0F);
        setRotationAngle(leftleg, -0.0873F, 0.0F, 0.0F);
        leftleg.texOffs(32, 32).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, false);

        rightleg = new ModelRenderer(this);
        rightleg.setPos(-2.0F, 12.0F, 0.0F);
        setRotationAngle(rightleg, 0.0436F, 0.0F, 0.0F);
        rightleg.texOffs(24, 16).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, false);
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

    }


    @Override
    public void renderToBuffer(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
        head.render(matrixStack, buffer, packedLight, packedOverlay);
        torso.render(matrixStack, buffer, packedLight, packedOverlay);
        leftarm.render(matrixStack, buffer, packedLight, packedOverlay);
        rightarm.render(matrixStack, buffer, packedLight, packedOverlay);
        leftleg.render(matrixStack, buffer, packedLight, packedOverlay);
        rightleg.render(matrixStack, buffer, packedLight, packedOverlay);
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.xRot = x;
        modelRenderer.yRot = y;
        modelRenderer.zRot = z;
    }
}
