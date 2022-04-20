package com.drevery.scpdisturbance.client.render;

import com.drevery.scpdisturbance.utils.Utils;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Mob;

public class RendererGenericEntity<E extends Mob, M extends EntityModel<E>> extends MobRenderer<E, M> {

    private final ResourceLocation texture;

    public RendererGenericEntity(EntityRendererProvider.Context entityRenderDispatcher, M model, float shadowRadius, String textureLocation) {
        super(entityRenderDispatcher, model, shadowRadius);
        this.texture = Utils.rl(textureLocation);
    }

    @Override
    public ResourceLocation getTextureLocation(E pEntity) {
        return texture;
    }
}
