package com.drevery.scpdisturbance.client.render.scp049j;

import com.drevery.scpdisturbance.client.model.scp049j.Scp049JModel;
import com.drevery.scpdisturbance.client.model.scp058.Scp058Model;
import com.drevery.scpdisturbance.entity.scp049j.Scp049JEntity;
import com.drevery.scpdisturbance.entity.scp058.Scp058Entity;
import com.drevery.scpdisturbance.utils.Utils;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class Scp049JRenderer extends MobRenderer<Scp049JEntity, Scp049JModel<Scp049JEntity>> {
    protected static final ResourceLocation TEXTURE = Utils.rl("textures/entity/texture-049j.png");

    public Scp049JRenderer(EntityRendererManager rendererManagerIn) {
        super(rendererManagerIn, new Scp049JModel<>(), 0.7F);
    }

    @Override
    public ResourceLocation getTextureLocation(Scp049JEntity entity){ return TEXTURE; }
}