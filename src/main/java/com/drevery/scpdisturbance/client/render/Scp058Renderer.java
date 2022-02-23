package com.drevery.scpdisturbance.client.render;

import com.drevery.scpdisturbance.Utils;
import com.drevery.scpdisturbance.client.model.Scp058Model;
import com.drevery.scpdisturbance.entity.Scp058Entity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class Scp058Renderer extends MobRenderer<Scp058Entity, Scp058Model<Scp058Entity>> {
    protected static final ResourceLocation TEXTURE = Utils.rl("textures/entity/texture.png");

    public Scp058Renderer(EntityRendererManager rendererManagerIn) {
        super(rendererManagerIn, new Scp058Model<>(), 0.7F);
    }

    @Override
    public ResourceLocation getTextureLocation(Scp058Entity entity){ return TEXTURE; }
}