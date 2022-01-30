package com.drevery.scpdisturbance;

import com.drevery.scpdisturbance.block.ModBlocks;
import com.drevery.scpdisturbance.entity.ModEntityTypes;
import com.drevery.scpdisturbance.item.ModItems;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(SCPDisturbance.MOD_ID)
public class SCPDisturbance {

    public static final String MOD_ID = "scpdisturbance";
    public static final Logger LOGGER = LogManager.getLogger();

    public SCPDisturbance() {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModBlocks.BLOCKS.register(eventBus);
        ModItems.ITEMS.register(eventBus);
        ModEntityTypes.ENTITY_TYPES.register(eventBus);
    }
} 
