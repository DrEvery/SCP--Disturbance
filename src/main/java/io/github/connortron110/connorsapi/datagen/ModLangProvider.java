package io.github.connortron110.connorsapi.datagen;

import com.drevery.scpdisturbance.SCPDisturbance;
import com.drevery.scpdisturbance.registration.ModEntityTypes;
import net.minecraft.data.DataGenerator;
import net.minecraft.world.entity.EntityType;
import net.minecraftforge.common.data.LanguageProvider;
import net.minecraftforge.registries.RegistryObject;

public class ModLangProvider extends LanguageProvider {
    public ModLangProvider(DataGenerator gen, String locale) {
        super(gen, SCPDisturbance.MOD_ID, locale);
        gen.getInputFolders().forEach(file -> {
            SCPDisturbance.LOGGER.debug(file.getFileName().toString());
        });
    }

    @Override
    protected void addTranslations() {
        /*Entities*/ {
            entityWithEgg(ModEntityTypes.SCP_529, "SCP-529");
            entityWithEgg(ModEntityTypes.SCP_058, "SCP-058");
            entityWithEgg(ModEntityTypes.SCP_058_TENTACLE, "SCP-058-Tentacle");
        }
    }

    private <T extends EntityType<?>> void entity(RegistryObject<T> entry, String name) {
        add(entry.get(), name);
    }

    private <T extends EntityType<?>> void entityWithEgg(RegistryObject<T> entity, String name) {
        add(entity.get(), name);
        add(entity.getId().getPath() + "_spawn_egg", name + " Spawn Egg");
    }
}
