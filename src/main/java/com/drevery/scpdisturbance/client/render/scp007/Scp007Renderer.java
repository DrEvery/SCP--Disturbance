package com.drevery.scpdisturbance.client.render.scp007;

import com.drevery.scpdisturbance.client.model.scp007.Scp007Model;
import com.drevery.scpdisturbance.entity.scp007.Scp007Entity;
import com.drevery.scpdisturbance.utils.Utils;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class Scp007Renderer extends MobRenderer<Scp007Entity, Scp007Model<Scp007Entity>> {
    protected static final ResourceLocation TEXTURE = Utils.rl("textures/entity/texture-007.png");

    public Scp007Renderer(EntityRendererManager rendererManagerIn) {
        super(rendererManagerIn, new Scp007Model<>(), 1F);
    }

    @Override
    public ResourceLocation getTextureLocation(Scp007Entity entity){ return TEXTURE; }
}