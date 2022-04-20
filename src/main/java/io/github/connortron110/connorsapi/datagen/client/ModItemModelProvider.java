package io.github.connortron110.connorsapi.datagen.client;

import com.drevery.scpdisturbance.SCPDisturbance;
import com.drevery.scpdisturbance.registration.ModItems;
import net.minecraft.data.DataGenerator;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(DataGenerator generator, ExistingFileHelper existingFileHelper) {
        super(generator, SCPDisturbance.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        for (RegistryObject<? extends Item> registryObject : ModItems.ITEMS.getRegister().getEntries()) {
            if (registryObject.get() instanceof ForgeSpawnEggItem) {
                spawnEggItem(registryObject);
            }
        }
    }

    private void spawnEggItem(RegistryObject<? extends Item> reg) {
        getBuilder(getPath(reg)).parent(getExistingFile(mcLoc("item/template_spawn_egg")));
    }

    private String getPath(RegistryObject<?> reg) {
        return reg.getId().getPath();
    }
}
