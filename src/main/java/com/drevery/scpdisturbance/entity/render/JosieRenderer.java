package com.drevery.scpdisturbance.entity.render;

import com.drevery.scpdisturbance.SCPDisturbance;
import com.drevery.scpdisturbance.entity.model.JosieModel;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.entity.passive.CatEntity;
import net.minecraft.util.ResourceLocation;

public class JosieRenderer extends MobRenderer<CatEntity, JosieModel<CatEntity>>
{
    protected static final ResourceLocation TEXTURE =
        new ResourceLocation(SCPDisturbance.MOD_ID, "textures/entity/josie.png");
    public JosieRenderer(EntityRendererManager rendererManagerIn) {
        super(rendererManagerIn, new JosieModel(), 0.7F);
    }

    @Override
    public ResourceLocation getEntityTexture(CatEntity entity){return TEXTURE;}
}