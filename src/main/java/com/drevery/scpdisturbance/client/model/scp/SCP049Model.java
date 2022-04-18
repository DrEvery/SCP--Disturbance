package com.drevery.scpdisturbance.client.model.scp;

import com.drevery.scpdisturbance.entity.scp.SCP049Entity;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;

public class SCP049Model<T extends SCP049Entity> extends EntityModel<T> {
    private final ModelRenderer head;
    private final ModelRenderer cube_r1;
    private final ModelRenderer cube_r2;
    private final ModelRenderer torso;
    private final ModelRenderer cube_r3;
    private final ModelRenderer cube_r4;
    private final ModelRenderer rightarm;
    private final ModelRenderer cube_r5;
    private final ModelRenderer cube_r6;
    private final ModelRenderer cube_r7;
    private final ModelRenderer cube_r8;
    private final ModelRenderer cube_r9;
    private final ModelRenderer cube_r10;
    private final ModelRenderer leftarm;
    private final ModelRenderer cube_r11;
    private final ModelRenderer cube_r12;
    private final ModelRenderer cube_r13;
    private final ModelRenderer cube_r14;
    private final ModelRenderer cube_r15;
    private final ModelRenderer cube_r16;
    private final ModelRenderer rightleg;
    private final ModelRenderer cube_r17;
    private final ModelRenderer cube_r18;
    private final ModelRenderer cube_r19;
    private final ModelRenderer leftleg;
    private final ModelRenderer cube_r20;
    private final ModelRenderer cube_r21;
    private final ModelRenderer cube_r22;

    public SCP049Model() {
        texWidth = 64;
        texHeight = 64;

        head = new ModelRenderer(this);
        head.setPos(0.0F, 0.0F, 0.0F);
        head.texOffs(0, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, 0.0F, false);

        cube_r1 = new ModelRenderer(this);
        cube_r1.setPos(-0.5F, -1.0F, -7.0F);
        head.addChild(cube_r1);
        setRotationAngle(cube_r1, 0.5672F, 0.0F, 0.0F);
        cube_r1.texOffs(32, 7).addBox(-1.0F, -2.0053F, -6.0F, 3.0F, 3.0F, 6.0F, 0.0F, false);

        cube_r2 = new ModelRenderer(this);
        cube_r2.setPos(-0.5F, -3.0F, -4.0F);
        head.addChild(cube_r2);
        setRotationAngle(cube_r2, 0.3054F, 0.0F, 0.0F);
        cube_r2.texOffs(40, 16).addBox(-1.0F, -1.0F, -4.0F, 3.0F, 4.0F, 5.0F, 0.0F, false);

        torso = new ModelRenderer(this);
        torso.setPos(0.0F, 5.0F, 2.0F);
        torso.texOffs(24, 0).addBox(-4.0F, 5.0F, -4.5F, 8.0F, 2.0F, 5.0F, 0.0F, false);
        torso.texOffs(45, 0).addBox(-0.5F, 4.5F, -5.0F, 4.0F, 3.0F, 1.0F, 0.0F, false);
        torso.texOffs(0, 16).addBox(-4.0F, -5.0F, -4.0F, 8.0F, 10.0F, 4.0F, 0.0F, false);

        cube_r3 = new ModelRenderer(this);
        cube_r3.setPos(-6.0F, -5.0F, 0.0F);
        torso.addChild(cube_r3);
        setRotationAngle(cube_r3, 0.0873F, 0.0F, 0.0F);
        cube_r3.texOffs(40, 25).addBox(2.0F, 0.0F, 0.0F, 8.0F, 5.0F, 0.0F, 0.0F, false);

        cube_r4 = new ModelRenderer(this);
        cube_r4.setPos(-6.0F, -5.0F, -4.0F);
        torso.addChild(cube_r4);
        setRotationAngle(cube_r4, -0.0873F, 0.0F, 0.0F);
        cube_r4.texOffs(44, 7).addBox(2.0F, 0.0F, 0.0F, 8.0F, 5.0F, 0.0F, 0.0F, false);

        rightarm = new ModelRenderer(this);
        rightarm.setPos(-4.0F, 2.0F, 0.0F);
        rightarm.texOffs(0, 32).addBox(-4.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, false);

        cube_r5 = new ModelRenderer(this);
        cube_r5.setPos(-2.0F, -2.0F, -2.0F);
        rightarm.addChild(cube_r5);
        setRotationAngle(cube_r5, -0.0873F, 0.0F, 0.0F);
        cube_r5.texOffs(36, 16).addBox(-2.0F, 0.0F, 0.0F, 4.0F, 3.0F, 0.0F, 0.0F, false);

        cube_r6 = new ModelRenderer(this);
        cube_r6.setPos(-4.0F, -2.0F, 0.0F);
        rightarm.addChild(cube_r6);
        setRotationAngle(cube_r6, 0.0F, 0.0F, 0.0873F);
        cube_r6.texOffs(20, 12).addBox(0.0F, 0.0F, -2.0F, 0.0F, 3.0F, 4.0F, 0.0F, false);

        cube_r7 = new ModelRenderer(this);
        cube_r7.setPos(-2.0F, 10.0F, -2.0F);
        rightarm.addChild(cube_r7);
        setRotationAngle(cube_r7, 0.0436F, 0.0F, 0.0F);
        cube_r7.texOffs(48, 49).addBox(-2.0F, -5.0F, 0.0F, 4.0F, 5.0F, 0.0F, 0.0F, false);

        cube_r8 = new ModelRenderer(this);
        cube_r8.setPos(-2.0F, -2.0F, 2.0F);
        rightarm.addChild(cube_r8);
        setRotationAngle(cube_r8, 0.0873F, 0.0F, 0.0F);
        cube_r8.texOffs(12, 32).addBox(-2.0F, 0.0F, 0.0F, 4.0F, 3.0F, 0.0F, 0.0F, false);

        cube_r9 = new ModelRenderer(this);
        cube_r9.setPos(-4.0F, 10.0F, 0.0F);
        rightarm.addChild(cube_r9);
        setRotationAngle(cube_r9, 0.0F, 0.0F, -0.0436F);
        cube_r9.texOffs(16, 44).addBox(0.0F, -5.0F, -2.0F, 0.0F, 5.0F, 4.0F, 0.0F, false);

        cube_r10 = new ModelRenderer(this);
        cube_r10.setPos(-2.0F, 10.0F, 2.0F);
        rightarm.addChild(cube_r10);
        setRotationAngle(cube_r10, -0.0436F, 0.0F, 0.0F);
        cube_r10.texOffs(40, 48).addBox(-2.0F, -5.0F, 0.0F, 4.0F, 5.0F, 0.0F, 0.0F, false);

        leftarm = new ModelRenderer(this);
        leftarm.setPos(4.0F, 2.0F, 0.0F);
        leftarm.texOffs(24, 16).addBox(0.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, false);

        cube_r11 = new ModelRenderer(this);
        cube_r11.setPos(2.0F, -2.0F, -2.0F);
        leftarm.addChild(cube_r11);
        setRotationAngle(cube_r11, -0.0873F, 0.0F, 0.0F);
        cube_r11.texOffs(28, 32).addBox(-2.0F, 0.0F, 0.0F, 4.0F, 3.0F, 0.0F, 0.0F, false);

        cube_r12 = new ModelRenderer(this);
        cube_r12.setPos(2.0F, -2.0F, 2.0F);
        leftarm.addChild(cube_r12);
        setRotationAngle(cube_r12, 0.0873F, 0.0F, 0.0F);
        cube_r12.texOffs(0, 0).addBox(-2.0F, 0.0F, 0.0F, 4.0F, 3.0F, 0.0F, 0.0F, false);

        cube_r13 = new ModelRenderer(this);
        cube_r13.setPos(2.0F, 10.0F, -2.0F);
        leftarm.addChild(cube_r13);
        setRotationAngle(cube_r13, 0.0436F, 0.0F, 0.0F);
        cube_r13.texOffs(48, 44).addBox(-2.0F, -5.0F, 0.0F, 4.0F, 5.0F, 0.0F, 0.0F, false);

        cube_r14 = new ModelRenderer(this);
        cube_r14.setPos(2.0F, 10.0F, 2.0F);
        leftarm.addChild(cube_r14);
        setRotationAngle(cube_r14, -0.0436F, 0.0F, 0.0F);
        cube_r14.texOffs(48, 39).addBox(-2.0F, -5.0F, 0.0F, 4.0F, 5.0F, 0.0F, 0.0F, false);

        cube_r15 = new ModelRenderer(this);
        cube_r15.setPos(4.0F, 10.0F, 0.0F);
        leftarm.addChild(cube_r15);
        setRotationAngle(cube_r15, 0.0F, 0.0F, 0.0873F);
        cube_r15.texOffs(24, 44).addBox(0.0F, -5.0F, -2.0F, 0.0F, 5.0F, 4.0F, 0.0F, false);

        cube_r16 = new ModelRenderer(this);
        cube_r16.setPos(4.0F, -2.0F, 0.0F);
        leftarm.addChild(cube_r16);
        setRotationAngle(cube_r16, 0.0F, 0.0F, -0.0873F);
        cube_r16.texOffs(0, 0).addBox(0.0F, 0.0F, -2.0F, 0.0F, 3.0F, 4.0F, 0.0F, false);

        rightleg = new ModelRenderer(this);
        rightleg.setPos(-2.0F, 12.0F, 0.0F);
        rightleg.texOffs(32, 32).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, false);

        cube_r17 = new ModelRenderer(this);
        cube_r17.setPos(0.0F, 0.0F, 2.0F);
        rightleg.addChild(cube_r17);
        setRotationAngle(cube_r17, 0.0873F, 0.0F, 0.0F);
        cube_r17.texOffs(32, 48).addBox(-2.0F, 0.0F, 0.0F, 4.0F, 9.0F, 0.0F, 0.0F, false);

        cube_r18 = new ModelRenderer(this);
        cube_r18.setPos(0.0F, 0.0F, -2.0F);
        rightleg.addChild(cube_r18);
        setRotationAngle(cube_r18, -0.0873F, 0.0F, 0.0F);
        cube_r18.texOffs(56, 21).addBox(-2.0F, 0.0F, 0.0F, 4.0F, 7.0F, 0.0F, 0.0F, false);

        cube_r19 = new ModelRenderer(this);
        cube_r19.setPos(-2.0F, 0.0F, 0.0F);
        rightleg.addChild(cube_r19);
        setRotationAngle(cube_r19, 0.0F, 0.0F, 0.0873F);
        cube_r19.texOffs(8, 44).addBox(0.0F, 0.0F, -2.0F, 0.0F, 7.0F, 4.0F, 0.0F, false);

        leftleg = new ModelRenderer(this);
        leftleg.setPos(2.0F, 12.0F, 0.0F);
        leftleg.texOffs(16, 32).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, false);

        cube_r20 = new ModelRenderer(this);
        cube_r20.setPos(-4.0F, 0.0F, 2.0F);
        leftleg.addChild(cube_r20);
        setRotationAngle(cube_r20, 0.0873F, 0.0F, 0.0F);
        cube_r20.texOffs(48, 30).addBox(2.0F, 0.0F, 0.0F, 4.0F, 9.0F, 0.0F, 0.0F, false);

        cube_r21 = new ModelRenderer(this);
        cube_r21.setPos(-4.0F, 0.0F, -2.0F);
        leftleg.addChild(cube_r21);
        setRotationAngle(cube_r21, -0.0873F, 0.0F, 0.0F);
        cube_r21.texOffs(56, 22).addBox(2.0F, 0.0F, 0.0F, 4.0F, 6.0F, 0.0F, 0.0F, false);

        cube_r22 = new ModelRenderer(this);
        cube_r22.setPos(2.0F, 0.0F, 0.0F);
        leftleg.addChild(cube_r22);
        setRotationAngle(cube_r22, 0.0F, 0.0F, -0.0873F);
        cube_r22.texOffs(0, 44).addBox(0.0F, 0.0F, -2.0F, 0.0F, 7.0F, 4.0F, 0.0F, false);
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
        rightarm.render(matrixStack, buffer, packedLight, packedOverlay);
        leftarm.render(matrixStack, buffer, packedLight, packedOverlay);
        rightleg.render(matrixStack, buffer, packedLight, packedOverlay);
        leftleg.render(matrixStack, buffer, packedLight, packedOverlay);
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.xRot = x;
        modelRenderer.yRot = y;
        modelRenderer.zRot = z;
    }
}
