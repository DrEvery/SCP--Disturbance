package com.drevery.scpdisturbance.client.render;

import com.drevery.scpdisturbance.Utils;
import com.drevery.scpdisturbance.client.model.JosieModel;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.entity.passive.CatEntity;
import net.minecraft.util.ResourceLocation;

public class JosieRenderer extends MobRenderer<CatEntity, JosieModel<CatEntity>> {
    protected static final ResourceLocation TEXTURE = Utils.rl("textures/entity/josie.png");

    public JosieRenderer(EntityRendererManager rendererManagerIn) {
        super(rendererManagerIn, new JosieModel<>(), 0.7F);
    }

    @Override
    public ResourceLocation getEntityTexture(CatEntity entity){
        return TEXTURE;
    }
}