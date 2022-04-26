package com.drevery.scpdisturbance;

import com.drevery.scpdisturbance.network.MicroHIDControlsMessage;
import com.drevery.scpdisturbance.registration.ModBlocks;
import com.drevery.scpdisturbance.registration.ModEntityTypes;
import com.drevery.scpdisturbance.registration.ModItems;
import com.drevery.scpdisturbance.registration.ModSounds;
import com.drevery.scpdisturbance.utils.Utils;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.network.NetworkDirection;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.simple.SimpleChannel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(SCPDisturbance.MOD_ID)
public class SCPDisturbance {

    public static final String MOD_ID = "scpdisturbance";
    public static final Logger LOGGER = LogManager.getLogger();

    private static final String PROTOCOL_VERSION = "1";
    public static final SimpleChannel NETWORK = NetworkRegistry.newSimpleChannel(
            Utils.rl("main"), () -> PROTOCOL_VERSION, PROTOCOL_VERSION::equals, PROTOCOL_VERSION::equals);

    public SCPDisturbance() {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModBlocks.BLOCKS.register(eventBus);
        ModItems.ITEMS.register(eventBus);
        ModEntityTypes.ENTITY_TYPES.register(eventBus);
        ModSounds.SOUNDS.register(eventBus);
        registerNetworkMessages();
    }

    private void registerNetworkMessages() {
        int id = 0;
        NETWORK.messageBuilder(MicroHIDControlsMessage.class, id++, NetworkDirection.PLAY_TO_SERVER)
                .encoder(MicroHIDControlsMessage::encoder)
                .decoder(MicroHIDControlsMessage::new)
                .consumer(MicroHIDControlsMessage::handle).add();
    }
} 
