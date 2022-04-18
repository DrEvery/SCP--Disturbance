package com.drevery.scpdisturbance.client.render;

import com.drevery.scpdisturbance.utils.Utils;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.entity.MobEntity;
import net.minecraft.util.ResourceLocation;

public class RendererGenericEntity<E extends MobEntity, M extends EntityModel<E>> extends MobRenderer<E, M> {

    private final ResourceLocation texture;

    public RendererGenericEntity(EntityRendererManager entityRenderDispatcher, M model, float shadowRadius, String textureLocation) {
        super(entityRenderDispatcher, model, shadowRadius);
        this.texture = Utils.rl(textureLocation);
    }

    @Override
    public ResourceLocation getTextureLocation(E pEntity) {
        return texture;
    }
}
