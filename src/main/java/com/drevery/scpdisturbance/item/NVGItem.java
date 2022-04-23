package com.drevery.scpdisturbance.item;

import com.drevery.scpdisturbance.SCPDisturbance;
import com.drevery.scpdisturbance.client.model.NVGModel;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.client.IItemRenderProperties;
import org.jetbrains.annotations.Nullable;

import java.util.function.Consumer;

public class NVGItem extends ArmorItem {
    public NVGItem(ArmorMaterial pMaterial, EquipmentSlot pSlot, Properties pProperties) {
        super(pMaterial, pSlot, pProperties);
    }

    @javax.annotation.Nullable
    @Override
    public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
        return SCPDisturbance.MOD_ID + ":textures/entity/nvg.png";
    }

    @Override
    public void initializeClient(Consumer<IItemRenderProperties> consumer) {
        consumer.accept(new IItemRenderProperties() {
            /**
             * Override this method to have an item handle its own armor rendering.
             *
             * @param entityLiving The entity wearing the armor
             * @param itemStack    The itemStack to render the model of
             * @param armorSlot    The slot the armor is in
             * @param _default     Original armor model. Will have attributes set.
             * @return A HumanoidModel to render instead of the default, will have the relevant properties copied in {@link #getBaseArmorModel(LivingEntity, ItemStack, EquipmentSlot, HumanoidModel).
             * Returning null will cause the default to render.
             * @see #getBaseArmorModel(LivingEntity, ItemStack, EquipmentSlot, HumanoidModel)
             */
            @Nullable
            @Override
            public HumanoidModel<?> getArmorModel(LivingEntity entityLiving, ItemStack itemStack, EquipmentSlot armorSlot, HumanoidModel<?> _default) {
                return new NVGModel<>(Minecraft.getInstance().getEntityModels().bakeLayer(NVGModel.LAYER_LOCATION));
            }
        });
    }
}
