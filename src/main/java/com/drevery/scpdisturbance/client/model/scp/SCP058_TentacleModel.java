package com.drevery.scpdisturbance.client.model.scp;

import com.drevery.scpdisturbance.entity.scp.SCP058_TentacleEntity;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;

public class SCP058_TentacleModel<T extends SCP058_TentacleEntity> extends EntityModel<T> {
    private final ModelRenderer bone;
    private final ModelRenderer cube_r1;
    private final ModelRenderer cube_r2;
    private final ModelRenderer cube_r3;
    private final ModelRenderer bone2;
    private final ModelRenderer cube_r4;

    public SCP058_TentacleModel() {
        texWidth = 64;
        texHeight = 64;

        bone = new ModelRenderer(this);
        bone.setPos(0.0F, 24.0F, 0.0F);
        bone.texOffs(0, 12).addBox(-3.0F, -6.0F, -3.0F, 6.0F, 6.0F, 6.0F, 0.0F, false);
        bone.texOffs(19, 19).addBox(-3.0F, -11.0F, -2.5F, 6.0F, 5.0F, 5.0F, 0.0F, false);
        bone.texOffs(0, 24).addBox(-2.0F, -15.0F, -2.0F, 4.0F, 4.0F, 4.0F, 0.0F, false);
        bone.texOffs(27, 29).addBox(-2.0F, -18.0F, -1.0F, 4.0F, 3.0F, 3.0F, 0.0F, false);
        bone.texOffs(0, 0).addBox(-5.0F, -2.0F, -5.0F, 10.0F, 2.0F, 10.0F, 0.0F, false);

        cube_r1 = new ModelRenderer(this);
        cube_r1.setPos(0.5F, -23.0F, -2.0F);
        bone.addChild(cube_r1);
        setRotationAngle(cube_r1, 1.2654F, 0.0F, 0.0F);
        cube_r1.texOffs(32, 12).addBox(-2.0F, -3.0124F, -1.825F, 3.0F, 3.0F, 3.0F, 0.0F, false);

        cube_r2 = new ModelRenderer(this);
        cube_r2.setPos(1.0F, -21.0F, 0.0F);
        bone.addChild(cube_r2);
        setRotationAngle(cube_r2, 0.7418F, 0.0F, 0.0F);
        cube_r2.texOffs(18, 12).addBox(-3.0F, -2.8381F, -1.9484F, 4.0F, 3.0F, 3.0F, 0.0F, false);

        cube_r3 = new ModelRenderer(this);
        cube_r3.setPos(1.0F, -21.0F, 0.0F);
        bone.addChild(cube_r3);
        setRotationAngle(cube_r3, 0.3054F, 0.0F, 0.0F);
        cube_r3.texOffs(13, 29).addBox(-3.0F, 0.1619F, -1.9484F, 4.0F, 3.0F, 3.0F, 0.0F, false);

        bone2 = new ModelRenderer(this);
        bone2.setPos(0.5F, 0.0F, -5.0F);
        setRotationAngle(bone2, -0.3927F, 0.0F, 0.0F);


        cube_r4 = new ModelRenderer(this);
        cube_r4.setPos(0.0F, 0.0F, 0.0F);
        bone2.addChild(cube_r4);
        setRotationAngle(cube_r4, 2.2689F, 0.0F, 0.0F);
        cube_r4.texOffs(30, 0).addBox(-2.0F, -2.8558F, -1.6356F, 3.0F, 3.0F, 3.0F, 0.0F, false);
        cube_r4.texOffs(4, 4).addBox(-1.5F, -9.8558F, -1.6356F, 0.0F, 4.0F, 2.0F, 0.0F, false);
        cube_r4.texOffs(4, 0).addBox(0.5F, -9.8558F, -1.6356F, 0.0F, 4.0F, 2.0F, 0.0F, false);
        cube_r4.texOffs(0, 32).addBox(-2.0F, -5.8558F, -1.6356F, 3.0F, 3.0F, 3.0F, 0.0F, false);
        cube_r4.texOffs(0, 0).addBox(-0.5F, -10.8558F, -0.6356F, 0.0F, 5.0F, 2.0F, 0.0F, false);
    }

    @Override
    public void setupAnim(T pEntity, float pLimbSwing, float pLimbSwingAmount, float pAgeInTicks, float pNetHeadYaw, float pHeadPitch) {

    }

    @Override
    public void renderToBuffer(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
        bone.render(matrixStack, buffer, packedLight, packedOverlay);
        bone2.render(matrixStack, buffer, packedLight, packedOverlay);
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.xRot = x;
        modelRenderer.yRot = y;
        modelRenderer.zRot = z;
    }
}
