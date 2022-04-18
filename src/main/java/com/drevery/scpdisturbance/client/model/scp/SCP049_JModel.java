package com.drevery.scpdisturbance.client.model.scp;

import com.drevery.scpdisturbance.entity.scp.SCP049_JEntity;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;

public class SCP049_JModel<T extends SCP049_JEntity> extends EntityModel<T> {
    private final ModelRenderer head;
    private final ModelRenderer cube_r1;
    private final ModelRenderer cube_r2;
    private final ModelRenderer cube_r3;
    private final ModelRenderer cube_r4;
    private final ModelRenderer cube_r5;
    private final ModelRenderer cube_r6;
    private final ModelRenderer cube_r7;
    private final ModelRenderer cube_r8;
    private final ModelRenderer cube_r9;
    private final ModelRenderer torso;
    private final ModelRenderer cube_r10;
    private final ModelRenderer cube_r11;
    private final ModelRenderer rightarm;
    private final ModelRenderer cube_r12;
    private final ModelRenderer cube_r13;
    private final ModelRenderer cube_r14;
    private final ModelRenderer cube_r15;
    private final ModelRenderer cube_r16;
    private final ModelRenderer cube_r17;
    private final ModelRenderer leftarm;
    private final ModelRenderer cube_r18;
    private final ModelRenderer cube_r19;
    private final ModelRenderer cube_r20;
    private final ModelRenderer cube_r21;
    private final ModelRenderer cube_r22;
    private final ModelRenderer cube_r23;
    private final ModelRenderer rightleg;
    private final ModelRenderer cube_r24;
    private final ModelRenderer cube_r25;
    private final ModelRenderer cube_r26;
    private final ModelRenderer leftleg;
    private final ModelRenderer cube_r27;
    private final ModelRenderer cube_r28;
    private final ModelRenderer cube_r29;

    public SCP049_JModel() {
        texWidth = 64;
        texHeight = 64;

        head = new ModelRenderer(this);
        head.setPos(0.0F, 0.0F, 0.0F);
        setRotationAngle(head, 0.0F, 0.0F, 0.0F);
        head.texOffs(0, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, 0.0F, false);
        head.texOffs(54, 4).addBox(1.5F, -6.5F, -4.5F, 2.0F, 2.0F, 1.0F, 0.0F, false);
        head.texOffs(0, 18).addBox(-3.0F, -6.0F, -4.6F, 1.0F, 1.0F, 1.0F, 0.0F, false);
        head.texOffs(45, 0).addBox(-2.0F, -4.0F, -5.0F, 4.0F, 4.0F, 1.0F, 0.0F, false);
        head.texOffs(0, 16).addBox(2.0F, -6.0F, -4.6F, 1.0F, 1.0F, 1.0F, 0.0F, false);
        head.texOffs(55, 0).addBox(-3.5F, -6.5F, -4.5F, 2.0F, 2.0F, 1.0F, 0.0F, false);
        head.texOffs(24, 0).addBox(-0.5F, 0.0F, -4.0F, 1.0F, 2.0F, 0.0F, 0.0F, false);

        cube_r1 = new ModelRenderer(this);
        cube_r1.setPos(3.0F, 4.0F, -4.0F);
        head.addChild(cube_r1);
        setRotationAngle(cube_r1, 0.3491F, 0.0F, 0.0F);
        cube_r1.texOffs(40, 16).addBox(-4.0F, -5.6F, -6.5F, 2.0F, 2.0F, 6.0F, 0.0F, false);

        cube_r2 = new ModelRenderer(this);
        cube_r2.setPos(3.5F, 4.0F, -4.0F);
        head.addChild(cube_r2);
        setRotationAngle(cube_r2, 0.6981F, 0.0F, 0.0F);
        cube_r2.texOffs(32, 7).addBox(-5.0F, -6.0F, 0.0F, 3.0F, 3.0F, 6.0F, 0.0F, false);

        cube_r3 = new ModelRenderer(this);
        cube_r3.setPos(-4.0F, 0.0F, 2.0F);
        head.addChild(cube_r3);
        setRotationAngle(cube_r3, 0.0F, 0.0F, 0.2182F);
        cube_r3.texOffs(12, 29).addBox(0.0F, 0.0F, -1.0F, 0.0F, 3.0F, 3.0F, 0.0F, false);

        cube_r4 = new ModelRenderer(this);
        cube_r4.setPos(-4.0F, 0.0F, -2.0F);
        head.addChild(cube_r4);
        setRotationAngle(cube_r4, 0.0F, 0.0F, 0.4363F);
        cube_r4.texOffs(0, 0).addBox(0.0F, 0.0F, -2.0F, 0.0F, 3.0F, 4.0F, 0.0F, false);

        cube_r5 = new ModelRenderer(this);
        cube_r5.setPos(-2.0F, 0.0F, -4.0F);
        head.addChild(cube_r5);
        setRotationAngle(cube_r5, -0.1745F, 0.0F, 0.0F);
        cube_r5.texOffs(36, 16).addBox(-2.0F, 0.0F, 0.0F, 3.0F, 3.0F, 0.0F, 0.0F, false);

        cube_r6 = new ModelRenderer(this);
        cube_r6.setPos(3.0F, 0.0F, -5.0F);
        head.addChild(cube_r6);
        setRotationAngle(cube_r6, -0.1745F, 0.0F, 0.0F);
        cube_r6.texOffs(32, 7).addBox(-2.0F, -1.2F, 1.0F, 3.0F, 4.0F, 0.0F, 0.0F, false);

        cube_r7 = new ModelRenderer(this);
        cube_r7.setPos(3.0F, 0.0F, 4.0F);
        head.addChild(cube_r7);
        setRotationAngle(cube_r7, 0.2182F, 0.0F, 0.0F);
        cube_r7.texOffs(0, 55).addBox(-7.0F, 0.0F, 0.0F, 3.0F, 3.0F, 0.0F, 0.0F, false);
        cube_r7.texOffs(40, 19).addBox(-2.0F, 0.0F, 0.0F, 3.0F, 3.0F, 0.0F, 0.0F, false);

        cube_r8 = new ModelRenderer(this);
        cube_r8.setPos(4.0F, 0.0F, -2.0F);
        head.addChild(cube_r8);
        setRotationAngle(cube_r8, 0.0F, 0.0F, -0.4363F);
        cube_r8.texOffs(20, 12).addBox(0.0F, 0.0F, -2.0F, 0.0F, 3.0F, 4.0F, 0.0F, false);

        cube_r9 = new ModelRenderer(this);
        cube_r9.setPos(4.0F, 0.0F, 2.0F);
        head.addChild(cube_r9);
        setRotationAngle(cube_r9, 0.0F, 0.0F, -0.2182F);
        cube_r9.texOffs(28, 29).addBox(0.0F, 0.0F, -1.0F, 0.0F, 3.0F, 3.0F, 0.0F, false);

        torso = new ModelRenderer(this);
        torso.setPos(0.0F, 24.0F, 0.0F);
        torso.texOffs(24, 0).addBox(-4.0F, -14.0F, -2.5F, 8.0F, 2.0F, 5.0F, 0.0F, false);
        torso.texOffs(0, 0).addBox(-3.5F, -14.5F, -3.0F, 3.0F, 3.0F, 1.0F, 0.0F, false);
        torso.texOffs(0, 16).addBox(-4.0F, -24.0F, -2.0F, 8.0F, 12.0F, 4.0F, 0.0F, false);

        cube_r10 = new ModelRenderer(this);
        cube_r10.setPos(0.0F, -23.0F, -2.0F);
        torso.addChild(cube_r10);
        setRotationAngle(cube_r10, -0.2182F, 0.0F, 0.0F);
        cube_r10.texOffs(40, 24).addBox(-4.0F, -1.0F, 0.0F, 8.0F, 5.0F, 0.0F, 0.0F, false);

        cube_r11 = new ModelRenderer(this);
        cube_r11.setPos(0.0F, -23.0F, 2.0F);
        torso.addChild(cube_r11);
        setRotationAngle(cube_r11, 0.2182F, 0.0F, 0.0F);
        cube_r11.texOffs(44, 7).addBox(-4.0F, -1.0F, 0.0F, 8.0F, 5.0F, 0.0F, 0.0F, false);

        rightarm = new ModelRenderer(this);
        rightarm.setPos(6.0F, 0.0F, 0.0F);
        rightarm.texOffs(32, 32).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, false);

        cube_r12 = new ModelRenderer(this);
        cube_r12.setPos(1.0F, 12.0F, -1.0F);
        rightarm.addChild(cube_r12);
        setRotationAngle(cube_r12, 0.0436F, 0.0F, 0.0F);
        cube_r12.texOffs(40, 54).addBox(-3.0F, -5.0F, -1.0F, 4.0F, 5.0F, 0.0F, 0.0F, false);

        cube_r13 = new ModelRenderer(this);
        cube_r13.setPos(1.0F, 12.0F, 1.0F);
        rightarm.addChild(cube_r13);
        setRotationAngle(cube_r13, -0.0436F, 0.0F, 0.0F);
        cube_r13.texOffs(32, 53).addBox(-3.0F, -5.0F, 1.0F, 4.0F, 5.0F, 0.0F, 0.0F, false);

        cube_r14 = new ModelRenderer(this);
        cube_r14.setPos(0.0F, 0.0F, 2.0F);
        rightarm.addChild(cube_r14);
        setRotationAngle(cube_r14, 0.0873F, 0.0F, 0.0F);
        cube_r14.texOffs(50, 17).addBox(-2.0F, 0.0F, 0.0F, 4.0F, 5.0F, 0.0F, 0.0F, false);

        cube_r15 = new ModelRenderer(this);
        cube_r15.setPos(2.0F, 0.0F, 0.0F);
        rightarm.addChild(cube_r15);
        setRotationAngle(cube_r15, 0.0F, 0.0F, -0.0436F);
        cube_r15.texOffs(24, 44).addBox(0.0F, 0.0F, -2.0F, 0.0F, 5.0F, 4.0F, 0.0F, false);

        cube_r16 = new ModelRenderer(this);
        cube_r16.setPos(0.0F, 0.0F, -2.0F);
        rightarm.addChild(cube_r16);
        setRotationAngle(cube_r16, -0.0873F, 0.0F, 0.0F);
        cube_r16.texOffs(48, 52).addBox(-2.0F, 0.0F, 0.0F, 4.0F, 5.0F, 0.0F, 0.0F, false);

        cube_r17 = new ModelRenderer(this);
        cube_r17.setPos(2.0F, 12.0F, 0.0F);
        rightarm.addChild(cube_r17);
        setRotationAngle(cube_r17, 0.0F, 0.0F, 0.0436F);
        cube_r17.texOffs(32, 44).addBox(0.0F, -5.0F, -2.0F, 0.0F, 5.0F, 4.0F, 0.0F, false);

        leftarm = new ModelRenderer(this);
        leftarm.setPos(-6.0F, 0.0F, 0.0F);
        leftarm.texOffs(16, 32).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, false);

        cube_r18 = new ModelRenderer(this);
        cube_r18.setPos(0.0F, 0.0F, 2.0F);
        leftarm.addChild(cube_r18);
        setRotationAngle(cube_r18, 0.0873F, 0.0F, 0.0F);
        cube_r18.texOffs(50, 12).addBox(-2.0F, 0.0F, 0.0F, 4.0F, 5.0F, 0.0F, 0.0F, false);

        cube_r19 = new ModelRenderer(this);
        cube_r19.setPos(-2.0F, 0.0F, 0.0F);
        leftarm.addChild(cube_r19);
        setRotationAngle(cube_r19, 0.0F, 0.0F, 0.0436F);
        cube_r19.texOffs(16, 44).addBox(0.0F, 0.0F, -2.0F, 0.0F, 5.0F, 4.0F, 0.0F, false);

        cube_r20 = new ModelRenderer(this);
        cube_r20.setPos(0.0F, 0.0F, -2.0F);
        leftarm.addChild(cube_r20);
        setRotationAngle(cube_r20, -0.0873F, 0.0F, 0.0F);
        cube_r20.texOffs(52, 29).addBox(-2.0F, 0.0F, 0.0F, 4.0F, 5.0F, 0.0F, 0.0F, false);

        cube_r21 = new ModelRenderer(this);
        cube_r21.setPos(-1.0F, 12.0F, -1.0F);
        leftarm.addChild(cube_r21);
        setRotationAngle(cube_r21, 0.0436F, 0.0F, 0.0F);
        cube_r21.texOffs(16, 53).addBox(-1.0F, -5.0F, -1.0F, 4.0F, 5.0F, 0.0F, 0.0F, false);

        cube_r22 = new ModelRenderer(this);
        cube_r22.setPos(-1.0F, 12.0F, 1.0F);
        leftarm.addChild(cube_r22);
        setRotationAngle(cube_r22, -0.0436F, 0.0F, 0.0F);
        cube_r22.texOffs(24, 53).addBox(-1.0F, -5.0F, 1.0F, 4.0F, 5.0F, 0.0F, 0.0F, false);

        cube_r23 = new ModelRenderer(this);
        cube_r23.setPos(-2.0F, 12.0F, 0.0F);
        leftarm.addChild(cube_r23);
        setRotationAngle(cube_r23, 0.0F, 0.0F, -0.0436F);
        cube_r23.texOffs(44, 25).addBox(0.0F, -5.0F, -2.0F, 0.0F, 5.0F, 4.0F, 0.0F, false);

        rightleg = new ModelRenderer(this);
        rightleg.setPos(2.0F, 12.0F, 0.0F);
        rightleg.texOffs(0, 32).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, false);

        cube_r24 = new ModelRenderer(this);
        cube_r24.setPos(0.0F, 0.0F, -2.0F);
        rightleg.addChild(cube_r24);
        setRotationAngle(cube_r24, -0.0436F, 0.0F, 0.0F);
        cube_r24.texOffs(48, 46).addBox(-2.0F, 0.0F, 0.0F, 4.0F, 6.0F, 0.0F, 0.0F, false);

        cube_r25 = new ModelRenderer(this);
        cube_r25.setPos(0.0F, 0.0F, 2.0F);
        rightleg.addChild(cube_r25);
        setRotationAngle(cube_r25, 0.0436F, 0.0F, 0.0F);
        cube_r25.texOffs(48, 40).addBox(-2.0F, 0.0F, 0.0F, 4.0F, 6.0F, 0.0F, 0.0F, false);

        cube_r26 = new ModelRenderer(this);
        cube_r26.setPos(2.0F, 0.0F, 0.0F);
        rightleg.addChild(cube_r26);
        setRotationAngle(cube_r26, 0.0F, 0.0F, -0.0436F);
        cube_r26.texOffs(8, 44).addBox(0.0F, 0.0F, -2.0F, 0.0F, 7.0F, 4.0F, 0.0F, false);

        leftleg = new ModelRenderer(this);
        leftleg.setPos(-2.0F, 12.0F, 0.0F);
        leftleg.texOffs(24, 16).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, false);

        cube_r27 = new ModelRenderer(this);
        cube_r27.setPos(0.0F, 0.0F, -2.0F);
        leftleg.addChild(cube_r27);
        setRotationAngle(cube_r27, -0.0436F, 0.0F, 0.0F);
        cube_r27.texOffs(48, 34).addBox(-2.0F, 0.0F, 0.0F, 4.0F, 6.0F, 0.0F, 0.0F, false);

        cube_r28 = new ModelRenderer(this);
        cube_r28.setPos(0.0F, 0.0F, 2.0F);
        leftleg.addChild(cube_r28);
        setRotationAngle(cube_r28, 0.0436F, 0.0F, 0.0F);
        cube_r28.texOffs(40, 48).addBox(-2.0F, 0.0F, 0.0F, 4.0F, 6.0F, 0.0F, 0.0F, false);

        cube_r29 = new ModelRenderer(this);
        cube_r29.setPos(-2.0F, 0.0F, 0.0F);
        leftleg.addChild(cube_r29);
        setRotationAngle(cube_r29, 0.0F, 0.0F, 0.0436F);
        cube_r29.texOffs(0, 44).addBox(0.0F, 0.0F, -2.0F, 0.0F, 7.0F, 4.0F, 0.0F, false);
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
