package com.drevery.scpdisturbance.client.render.scp049;

import com.drevery.scpdisturbance.client.model.scp049.Scp049_2Model;
import com.drevery.scpdisturbance.entity.scp049.Scp049_2Entity;
import com.drevery.scpdisturbance.utils.Utils;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class Scp049_2Renderer extends MobRenderer<Scp049_2Entity, Scp049_2Model<Scp049_2Entity>> {
    protected static final ResourceLocation TEXTURE = Utils.rl("textures/entity/texture-049-2.png");

    public Scp049_2Renderer(EntityRendererManager rendererManagerIn) {
        super(rendererManagerIn, new Scp049_2Model<>(), 0.6F);
    }

    @Override
    public ResourceLocation getTextureLocation(Scp049_2Entity entity){ return TEXTURE; }
}