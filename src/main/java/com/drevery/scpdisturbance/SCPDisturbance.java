package com.drevery.scpdisturbance;

import com.drevery.scpdisturbance.block.ModBlocks;
// import com.drevery.scplol.entity.ModEntityTypes;
import com.drevery.scpdisturbance.entity.ModEntityTypes;
import com.drevery.scpdisturbance.item.ModItems;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(SCPDisturbance.MOD_ID)
public class SCPDisturbance {

    public static final String MOD_ID = "scpdisturbance";

    private static final Logger LOGGER = LogManager.getLogger();

    public SCPDisturbance() {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModBlocks.register(eventBus);
        ModItems.register(eventBus);
        ModEntityTypes.register(eventBus);

        // Register the doClientStuff method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void doClientStuff(final FMLClientSetupEvent event) {
        {
            //SCP-002
            event.enqueueWork(() -> {
                RenderTypeLookup.setRenderLayer(ModBlocks.MEAT_TABLE.get(), RenderType.getCutout());
                RenderTypeLookup.setRenderLayer(ModBlocks.BONE_BLOCKS.get(), RenderType.getCutout());
                RenderTypeLookup.setRenderLayer(ModBlocks.SKIN_STAND.get(), RenderType.getCutout());
                RenderTypeLookup.setRenderLayer(ModBlocks.MEAT_BED.get(), RenderType.getCutout());
                RenderTypeLookup.setRenderLayer(ModBlocks.MEAT_TV.get(), RenderType.getCutout());
                RenderTypeLookup.setRenderLayer(ModBlocks.SKIN_LAMP.get(), RenderType.getCutout());
                RenderTypeLookup.setRenderLayer(ModBlocks.BONE_DINOSAUR.get(), RenderType.getCutout());
                RenderTypeLookup.setRenderLayer(ModBlocks.CEILING_TRAP.get(), RenderType.getCutout());
                RenderTypeLookup.setRenderLayer(ModBlocks.MEAT_LAMP.get(), RenderType.getCutout());
                RenderTypeLookup.setRenderLayer(ModBlocks.MEAT_COUCH_CENTER.get(), RenderType.getCutout());
                RenderTypeLookup.setRenderLayer(ModBlocks.GENERATOR.get(), RenderType.getCutout());
                RenderTypeLookup.setRenderLayer(ModBlocks.METAL_DOOR.get(), RenderType.getCutout());
                RenderTypeLookup.setRenderLayer(ModBlocks.MEAT_NIGHTSTAND.get(), RenderType.getCutout());
                RenderTypeLookup.setRenderLayer(ModBlocks.INDUSTRIAL_LAMP.get(), RenderType.getCutout());
            //
            });
        }
    }
} 
