package com.drevery.scplol;

import com.drevery.scplol.block.ModBlocks;
// import com.drevery.scplol.entity.ModEntityTypes;
import com.drevery.scplol.entity.ModEntityTypes;
import com.drevery.scplol.item.ModItems;
import com.sun.org.apache.bcel.internal.generic.RET;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.stream.Collectors;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(SeriesOneAnomalies.MOD_ID)
public class SeriesOneAnomalies
{

    public static final String MOD_ID = "scplol";

    // Directly reference a log4j logger.
    private static final Logger LOGGER = LogManager.getLogger();

    public SeriesOneAnomalies() {
        // Register the setup method for modloading
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModBlocks.register(eventBus);
        ModItems.register(eventBus);
        ModEntityTypes.register(eventBus);

        // Register the enqueueIMC method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::enqueueIMC);
        // Register the processIMC method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::processIMC);
        // Register the doClientStuff method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event)
    {
        // some preinit code
        LOGGER.info("HELLO FROM PREINIT");
        LOGGER.info("DIRT BLOCK >> {}", Blocks.DIRT.getRegistryName());
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
                RenderTypeLookup.setRenderLayer(ModBlocks.MEAT_PAINTING.get(), RenderType.getCutout());
                RenderTypeLookup.setRenderLayer(ModBlocks.FLOOR_TRAP.get(), RenderType.getCutout());
            //
            });
        }

    }

    private void enqueueIMC(final InterModEnqueueEvent event)
    {
        // some example code to dispatch IMC to another mod
        InterModComms.sendTo("examplemod", "helloworld", () -> { LOGGER.info("Hello world from the MDK"); return "Hello world";});
    }

    private void processIMC(final InterModProcessEvent event)
    {
        // some example code to receive and process InterModComms from other mods
        LOGGER.info("Got IMC {}", event.getIMCStream().
                map(m->m.getMessageSupplier().get()).
                collect(Collectors.toList()));
    }
    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(FMLServerStartingEvent event) {
        // do something when the server starts
        LOGGER.info("HELLO from server starting");
    }

    // You can use EventBusSubscriber to automatically subscribe events on the contained class (this is subscribing to the MOD
    // Event bus for receiving Registry Events)
    @Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents {
        @SubscribeEvent
        public static void onBlocksRegistry(final RegistryEvent.Register<Block> blockRegistryEvent) {
            // register a new block here
            LOGGER.info("HELLO from Register Block");
        }
    }
} 
