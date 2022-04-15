package com.drevery.scpdisturbance.client.render.scp049;

import com.drevery.scpdisturbance.client.model.scp049.Scp049Model;
import com.drevery.scpdisturbance.entity.scp049.Scp049Entity;
import com.drevery.scpdisturbance.utils.Utils;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class Scp049Renderer extends MobRenderer<Scp049Entity, Scp049Model<Scp049Entity>> {
    protected static final ResourceLocation TEXTURE = Utils.rl("textures/entity/texture-049.png");

    public Scp049Renderer(EntityRendererManager rendererManagerIn) {
        super(rendererManagerIn, new Scp049Model<>(), 0.6F);
    }

    @Override
    public ResourceLocation getTextureLocation(Scp049Entity entity){ return TEXTURE; }
}