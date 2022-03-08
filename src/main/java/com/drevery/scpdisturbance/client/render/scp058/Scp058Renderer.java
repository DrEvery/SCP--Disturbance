package com.drevery.scpdisturbance.client.render.scp058;

import com.drevery.scpdisturbance.client.model.scp058.Scp058Model;
import com.drevery.scpdisturbance.entity.scp058.Scp058Entity;
import com.drevery.scpdisturbance.utils.Utils;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class Scp058Renderer extends MobRenderer<Scp058Entity, Scp058Model<Scp058Entity>> {
    protected static final ResourceLocation TEXTURE = Utils.rl("textures/entity/texture-058.png");

    public Scp058Renderer(EntityRendererManager rendererManagerIn) {
        super(rendererManagerIn, new Scp058Model<>(), 0.7F);
    }

    @Override
    public ResourceLocation getTextureLocation(Scp058Entity entity){ return TEXTURE; }
}