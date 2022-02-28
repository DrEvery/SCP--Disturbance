package com.drevery.scpdisturbance.client.model.scp058;
// Made with Blockbench 4.1.5
// Exported for Minecraft version 1.15 - 1.16 with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.drevery.scpdisturbance.entity.scp058.Scp058TentacleEntity;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;

public class Scp058TentacleModel<T extends Scp058TentacleEntity> extends EntityModel<T> {
    private final ModelRenderer bone;
    private final ModelRenderer cube_r1;
    private final ModelRenderer cube_r2;
    private final ModelRenderer cube_r3;
    private final ModelRenderer cube_r4;
    private final ModelRenderer cube_r5;
    private final ModelRenderer cube_r6;

    public Scp058TentacleModel() {
        texWidth = 64;
        texHeight = 64;

        bone = new ModelRenderer(this);
        bone.setPos(0.0F, 24.0F, 0.0F);
        bone.texOffs(0, 0).addBox(-7.0F, 0.0F, -7.0F, 14.0F, 0.0F, 14.0F, 0.0F, false);
        bone.texOffs(9, 30).addBox(-1.5F, -8.0F, -1.0F, 3.0F, 8.0F, 3.0F, 0.0F, false);

        cube_r1 = new ModelRenderer(this);
        cube_r1.setPos(0.0F, 0.0F, 0.0F);
        bone.addChild(cube_r1);
        setRotationAngle(cube_r1, 2.4435F, 0.0F, 0.0F);
        cube_r1.texOffs(0, 30).addBox(0.0F, 8.0F, 25.0F, 0.0F, 12.0F, 3.0F, 0.0F, false);

        cube_r2 = new ModelRenderer(this);
        cube_r2.setPos(0.0F, 0.0F, 0.0F);
        bone.addChild(cube_r2);
        setRotationAngle(cube_r2, 2.0071F, 0.0F, 0.0F);
        cube_r2.texOffs(0, 0).addBox(-1.5F, 3.0F, 31.0F, 3.0F, 8.0F, 3.0F, 0.0F, false);

        cube_r3 = new ModelRenderer(this);
        cube_r3.setPos(0.0F, 0.0F, 0.0F);
        bone.addChild(cube_r3);
        setRotationAngle(cube_r3, 0.8727F, 0.0F, 0.0F);
        cube_r3.texOffs(0, 11).addBox(-1.5F, -26.0F, 21.8F, 3.0F, 8.0F, 3.0F, 0.0F, false);

        cube_r4 = new ModelRenderer(this);
        cube_r4.setPos(0.0F, 0.0F, 0.0F);
        bone.addChild(cube_r4);
        setRotationAngle(cube_r4, 0.3054F, 0.0F, 0.0F);
        cube_r4.texOffs(12, 14).addBox(-1.5F, -28.7F, 8.2F, 3.0F, 8.0F, 3.0F, 0.0F, false);

        cube_r5 = new ModelRenderer(this);
        cube_r5.setPos(0.0F, 0.0F, 0.0F);
        bone.addChild(cube_r5);
        setRotationAngle(cube_r5, -0.0436F, 0.0F, 0.0F);
        cube_r5.texOffs(0, 22).addBox(-1.5F, -23.2F, 0.4F, 3.0F, 8.0F, 3.0F, 0.0F, false);

        cube_r6 = new ModelRenderer(this);
        cube_r6.setPos(0.0F, 0.0F, 0.0F);
        bone.addChild(cube_r6);
        setRotationAngle(cube_r6, -0.2618F, 0.0F, 0.0F);
        cube_r6.texOffs(21, 22).addBox(-1.5F, -15.5F, -3.0F, 3.0F, 8.0F, 3.0F, 0.0F, false);
    }

    @Override
    public void setupAnim(T pEntity, float pLimbSwing, float pLimbSwingAmount, float pAgeInTicks, float pNetHeadYaw, float pHeadPitch) {

    }

    @Override
    public void renderToBuffer(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
        bone.render(matrixStack, buffer, packedLight, packedOverlay);
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.xRot = x;
        modelRenderer.yRot = y;
        modelRenderer.zRot = z;
    }
}