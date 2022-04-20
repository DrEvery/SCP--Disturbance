package io.github.connortron110.connorsapi.datagen;

import com.drevery.scpdisturbance.SCPDisturbance;
import io.github.connortron110.connorsapi.datagen.client.ModItemModelProvider;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.forge.event.lifecycle.GatherDataEvent;

@Mod.EventBusSubscriber(modid = SCPDisturbance.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGenerators {

    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator gen = event.getGenerator();
        gen.addProvider(new ModItemModelProvider(gen, event.getExistingFileHelper()));
        //gen.addProvider(new ModLangProvider(gen, "en_us")); //FIXME
        gen.addProvider(new SoundsProvider(gen, event.getExistingFileHelper()));
    }
}