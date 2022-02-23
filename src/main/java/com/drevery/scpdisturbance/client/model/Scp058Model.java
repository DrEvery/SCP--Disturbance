package com.drevery.scpdisturbance.client.model;

// Made with Blockbench 4.1.5
// Exported for Minecraft version 1.15 - 1.16 with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.drevery.scpdisturbance.entity.Scp058Entity;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.passive.CatEntity;
import net.minecraft.util.math.MathHelper;

public class Scp058Model<T extends Scp058Entity> extends EntityModel<T> {
    private final ModelRenderer body;
    private final ModelRenderer cube_r1;
    private final ModelRenderer cube_r2;
    private final ModelRenderer cube_r3;
    private final ModelRenderer tentacles2small;
    private final ModelRenderer cube_r4;
    private final ModelRenderer cube_r5;
    private final ModelRenderer cube_r6;
    private final ModelRenderer cube_r7;
    private final ModelRenderer cube_r8;
    private final ModelRenderer legleft;
    private final ModelRenderer cube_r9;
    private final ModelRenderer cube_r10;
    private final ModelRenderer legright;
    private final ModelRenderer cube_r11;
    private final ModelRenderer cube_r12;
    private final ModelRenderer legback;
    private final ModelRenderer cube_r13;
    private final ModelRenderer cube_r14;
    private final ModelRenderer tentacles;
    private final ModelRenderer cube_r15;
    private final ModelRenderer cube_r16;
    private final ModelRenderer cube_r17;
    private final ModelRenderer cube_r18;
    private final ModelRenderer cube_r19;
    private final ModelRenderer cube_r20;

    public Scp058Model() {
        texWidth = 64;
        texHeight = 64;

        body = new ModelRenderer(this);
        body.setPos(0.0F, 12.0F, 0.0F);
        body.texOffs(0, 0).addBox(-4.0F, -5.0F, -5.0F, 8.0F, 8.0F, 8.0F, 0.0F, false);

        cube_r1 = new ModelRenderer(this);
        cube_r1.setPos(4.0F, 14.0F, -4.0F);
        body.addChild(cube_r1);
        setRotationAngle(cube_r1, 0.0F, 1.0472F, 0.4363F);
        cube_r1.texOffs(31, 28).addBox(-5.0F, -8.0F, -10.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);

        cube_r2 = new ModelRenderer(this);
        cube_r2.setPos(-4.0F, 14.0F, -4.0F);
        body.addChild(cube_r2);
        setRotationAngle(cube_r2, 0.0F, -1.0472F, -0.4363F);
        cube_r2.texOffs(6, 28).addBox(3.0F, -8.0F, -10.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);

        cube_r3 = new ModelRenderer(this);
        cube_r3.setPos(4.5F, 14.0F, -4.0F);
        body.addChild(cube_r3);
        setRotationAngle(cube_r3, -0.8727F, 0.0F, 0.0F);
        cube_r3.texOffs(22, 28).addBox(-6.0F, -19.0F, -11.0F, 3.0F, 1.0F, 3.0F, 0.0F, false);
        cube_r3.texOffs(0, 16).addBox(-7.0F, -18.0F, -12.0F, 5.0F, 3.0F, 5.0F, 0.0F, false);

        tentacles2small = new ModelRenderer(this);
        tentacles2small.setPos(0.0F, 9.0F, 5.0F);


        cube_r4 = new ModelRenderer(this);
        cube_r4.setPos(6.0F, 37.1948F, -9.0F);
        tentacles2small.addChild(cube_r4);
        setRotationAngle(cube_r4, 0.6545F, 0.0F, 0.0F);
        cube_r4.texOffs(20, 19).addBox(-7.5F, -27.1948F, 34.7F, 0.0F, 2.0F, 1.0F, 0.0F, false);
        cube_r4.texOffs(15, 15).addBox(-4.5F, -27.1948F, 34.7F, 0.0F, 2.0F, 1.0F, 0.0F, false);

        cube_r5 = new ModelRenderer(this);
        cube_r5.setPos(4.0F, 37.1948F, -9.0F);
        tentacles2small.addChild(cube_r5);
        setRotationAngle(cube_r5, 0.0873F, 0.0F, 0.0F);
        cube_r5.texOffs(35, 3).addBox(-6.0F, -40.1948F, 15.7F, 1.0F, 2.0F, 1.0F, 0.0F, false);
        cube_r5.texOffs(32, 19).addBox(-3.0F, -40.1948F, 15.7F, 1.0F, 2.0F, 1.0F, 0.0F, false);

        cube_r6 = new ModelRenderer(this);
        cube_r6.setPos(4.0F, 37.1948F, -9.0F);
        tentacles2small.addChild(cube_r6);
        setRotationAngle(cube_r6, -0.6545F, 0.0F, 0.0F);
        cube_r6.texOffs(24, 32).addBox(-3.0F, -39.1948F, -14.3F, 1.0F, 2.0F, 1.0F, 0.0F, false);
        cube_r6.texOffs(7, 35).addBox(-6.0F, -39.1948F, -14.3F, 1.0F, 2.0F, 1.0F, 0.0F, false);

        cube_r7 = new ModelRenderer(this);
        cube_r7.setPos(4.0F, 37.1948F, -9.0F);
        tentacles2small.addChild(cube_r7);
        setRotationAngle(cube_r7, -1.789F, 0.0F, 0.0F);
        cube_r7.texOffs(32, 32).addBox(-3.0F, -2.0F, -39.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
        cube_r7.texOffs(24, 35).addBox(-6.0F, -2.0F, -39.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);

        cube_r8 = new ModelRenderer(this);
        cube_r8.setPos(4.0F, 37.1948F, -9.0F);
        tentacles2small.addChild(cube_r8);
        setRotationAngle(cube_r8, -1.1345F, 0.0F, 0.0F);
        cube_r8.texOffs(28, 32).addBox(-3.0F, -26.7948F, -29.9F, 1.0F, 2.0F, 1.0F, 0.0F, false);
        cube_r8.texOffs(11, 35).addBox(-6.0F, -26.7948F, -29.9F, 1.0F, 2.0F, 1.0F, 0.0F, false);

        legleft = new ModelRenderer(this);
        legleft.setPos(-4.0F, 14.0F, -1.0F);


        cube_r9 = new ModelRenderer(this);
        cube_r9.setPos(8.0F, 10.0F, -3.0F);
        legleft.addChild(cube_r9);
        setRotationAngle(cube_r9, 0.0F, 0.0F, 1.5708F);
        cube_r9.texOffs(36, 13).addBox(-2.0F, 8.0F, 2.0F, 2.0F, 3.0F, 0.0F, 0.0F, false);
        cube_r9.texOffs(0, 24).addBox(-5.0F, 6.0F, 2.0F, 5.0F, 2.0F, 2.0F, 0.0F, false);
        cube_r9.texOffs(36, 0).addBox(-2.0F, 8.0F, 4.0F, 2.0F, 3.0F, 0.0F, 0.0F, false);

        cube_r10 = new ModelRenderer(this);
        cube_r10.setPos(8.0F, 10.0F, -3.0F);
        legleft.addChild(cube_r10);
        setRotationAngle(cube_r10, 0.0F, 0.0F, 0.8727F);
        cube_r10.texOffs(0, 28).addBox(-14.0F, -3.0F, 2.0F, 2.0F, 6.0F, 2.0F, 0.0F, false);
        cube_r10.texOffs(22, 24).addBox(-12.0F, 1.0F, 2.0F, 4.0F, 2.0F, 2.0F, 0.0F, false);

        legright = new ModelRenderer(this);
        legright.setPos(4.0F, 14.0F, -1.0F);


        cube_r11 = new ModelRenderer(this);
        cube_r11.setPos(-8.0F, 10.0F, -3.0F);
        legright.addChild(cube_r11);
        setRotationAngle(cube_r11, 0.0F, 0.0F, -1.5708F);
        cube_r11.texOffs(32, 35).addBox(0.0F, 8.0F, 2.0F, 2.0F, 3.0F, 0.0F, 0.0F, false);
        cube_r11.texOffs(20, 20).addBox(0.0F, 6.0F, 2.0F, 5.0F, 2.0F, 2.0F, 0.0F, false);
        cube_r11.texOffs(0, 36).addBox(0.0F, 8.0F, 4.0F, 2.0F, 3.0F, 0.0F, 0.0F, false);

        cube_r12 = new ModelRenderer(this);
        cube_r12.setPos(-8.0F, 10.0F, -3.0F);
        legright.addChild(cube_r12);
        setRotationAngle(cube_r12, 0.0F, 0.0F, -0.8727F);
        cube_r12.texOffs(14, 24).addBox(12.0F, -3.0F, 2.0F, 2.0F, 6.0F, 2.0F, 0.0F, false);
        cube_r12.texOffs(24, 4).addBox(8.0F, 1.0F, 2.0F, 4.0F, 2.0F, 2.0F, 0.0F, false);

        legback = new ModelRenderer(this);
        legback.setPos(0.0F, 15.0F, 2.0F);


        cube_r13 = new ModelRenderer(this);
        cube_r13.setPos(3.0F, 9.0F, -6.0F);
        legback.addChild(cube_r13);
        setRotationAngle(cube_r13, 1.5708F, 0.0F, -1.5708F);
        cube_r13.texOffs(28, 35).addBox(0.0F, 8.0F, 2.0F, 2.0F, 3.0F, 0.0F, 0.0F, false);
        cube_r13.texOffs(15, 16).addBox(0.0F, 6.0F, 2.0F, 5.0F, 2.0F, 2.0F, 0.0F, false);
        cube_r13.texOffs(35, 30).addBox(0.0F, 8.0F, 4.0F, 2.0F, 3.0F, 0.0F, 0.0F, false);

        cube_r14 = new ModelRenderer(this);
        cube_r14.setPos(3.0F, 9.0F, -6.0F);
        legback.addChild(cube_r14);
        setRotationAngle(cube_r14, 1.5708F, -0.6981F, -1.5708F);
        cube_r14.texOffs(0, 0).addBox(10.0F, -5.0F, 2.0F, 2.0F, 6.0F, 2.0F, 0.0F, false);
        cube_r14.texOffs(24, 0).addBox(8.0F, 1.0F, 2.0F, 4.0F, 2.0F, 2.0F, 0.0F, false);

        tentacles = new ModelRenderer(this);
        tentacles.setPos(0.0F, 7.1948F, 4.0F);


        cube_r15 = new ModelRenderer(this);
        cube_r15.setPos(4.0F, 39.0F, -8.0F);
        tentacles.addChild(cube_r15);
        setRotationAngle(cube_r15, 2.0944F, 0.0F, 0.0F);
        cube_r15.texOffs(0, 14).addBox(-4.0F, 25.3052F, 36.9F, 0.0F, 4.0F, 2.0F, 0.0F, false);

        cube_r16 = new ModelRenderer(this);
        cube_r16.setPos(4.0F, 39.0F, -8.0F);
        tentacles.addChild(cube_r16);
        setRotationAngle(cube_r16, 1.4399F, 0.0F, 0.0F);
        cube_r16.texOffs(8, 30).addBox(-5.0F, -0.6948F, 46.9F, 2.0F, 3.0F, 2.0F, 0.0F, false);

        cube_r17 = new ModelRenderer(this);
        cube_r17.setPos(4.0F, 39.0F, -8.0F);
        tentacles.addChild(cube_r17);
        setRotationAngle(cube_r17, 0.9163F, 0.0F, 0.0F);
        cube_r17.texOffs(30, 14).addBox(-5.0F, -22.4948F, 41.5F, 2.0F, 3.0F, 2.0F, 0.0F, false);

        cube_r18 = new ModelRenderer(this);
        cube_r18.setPos(4.0F, 39.0F, -8.0F);
        tentacles.addChild(cube_r18);
        setRotationAngle(cube_r18, 0.3054F, 0.0F, 0.0F);
        cube_r18.texOffs(32, 8).addBox(-5.0F, -40.6948F, 22.5F, 2.0F, 3.0F, 2.0F, 0.0F, false);

        cube_r19 = new ModelRenderer(this);
        cube_r19.setPos(4.0F, 39.0F, -8.0F);
        tentacles.addChild(cube_r19);
        setRotationAngle(cube_r19, -0.3927F, 0.0F, 0.0F);
        cube_r19.texOffs(16, 32).addBox(-5.0F, -44.3948F, -7.5F, 2.0F, 3.0F, 2.0F, 0.0F, false);

        cube_r20 = new ModelRenderer(this);
        cube_r20.setPos(4.0F, 39.0F, -8.0F);
        tentacles.addChild(cube_r20);
        setRotationAngle(cube_r20, -0.8727F, 0.0F, 0.0F);
        cube_r20.texOffs(32, 22).addBox(-5.0F, -34.0F, -26.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);
    }

    @Override
    public void setupAnim(T pEntity, float pLimbSwing, float pLimbSwingAmount, float pAgeInTicks, float pNetHeadYaw, float pHeadPitch) {

        this.body.xRot = pHeadPitch * ((float)Math.PI / 180F);
        this.body.yRot = pNetHeadYaw * ((float)Math.PI / 180F);

        this.legleft.xRot = (float) ((75 * MathHelper.sin(pLimbSwing*0.6662F)) * (Math.PI/180) * pLimbSwingAmount);
        this.legright.xRot = (float) ((75 * MathHelper.sin(-(pLimbSwing*0.6662F))) * (Math.PI/180) * pLimbSwingAmount);
        this.legback.xRot = (float) ((75 * MathHelper.sin((pLimbSwing*0.6662F))) * (Math.PI/180) * pLimbSwingAmount);

    }

    @Override
    public void renderToBuffer(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
        body.render(matrixStack, buffer, packedLight, packedOverlay);
        tentacles2small.render(matrixStack, buffer, packedLight, packedOverlay);
        legleft.render(matrixStack, buffer, packedLight, packedOverlay);
        legright.render(matrixStack, buffer, packedLight, packedOverlay);
        legback.render(matrixStack, buffer, packedLight, packedOverlay);
        tentacles.render(matrixStack, buffer, packedLight, packedOverlay);
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.xRot = x;
        modelRenderer.yRot = y;
        modelRenderer.zRot = z;
    }
}