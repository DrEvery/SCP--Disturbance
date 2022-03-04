package com.drevery.scpdisturbance.client.render.scp058;

import com.drevery.scpdisturbance.client.model.scp058.Scp058TentacleModel;
import com.drevery.scpdisturbance.entity.scp058.Scp058TentacleEntity;
import com.drevery.scpdisturbance.utils.Utils;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class Scp058TentacleRenderer extends MobRenderer<Scp058TentacleEntity, Scp058TentacleModel<Scp058TentacleEntity>> {
    protected static final ResourceLocation TEXTURE = Utils.rl("textures/entity/texture-058tentacle.png");

    public Scp058TentacleRenderer(EntityRendererManager rendererManagerIn) {
        super(rendererManagerIn, new Scp058TentacleModel<>(), 0.7F);
    }

    @Override
    public ResourceLocation getTextureLocation(Scp058TentacleEntity entity){ return TEXTURE; }
}