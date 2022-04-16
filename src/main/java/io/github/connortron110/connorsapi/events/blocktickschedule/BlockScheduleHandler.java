package io.github.connortron110.connorsapi.events.blocktickschedule;

import com.drevery.scpdisturbance.SCPDisturbance;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//TODO Could use break events to remove blocks from positions however can increase work that this class does
//TODO Possible Client/Server Sync when triggering or activating an event

/**
 * This class correctly handles block positioned events, compared to Minecraft's implementation this will not break when chunks are loaded/unloaded <br>
 * Handles Everything from world saves, to chunk saves. Based on the tick system and only computes at the end of the tick. <br>
 * Tries to adapt to be as efficient as possible by not counting every tick when the tick amount is large.
 * <br><br> Avoids running on client at all cost to avoid lag
 */
@Mod.EventBusSubscriber(modid = SCPDisturbance.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class BlockScheduleHandler {

    @SubscribeEvent //Ticks for every dimension
    public static void postTick(TickEvent.WorldTickEvent event) {
        //Only compute if on server and at the end of the tick
        if (event.side.isServer() && event.phase.equals(TickEvent.Phase.END)) {
            //New code basically does it for each world as this method alone is basically a for loop for every world
            List<Info> oldList = scheduledBlocks.getOrDefault(event.world, new ArrayList<>());
            List<Info> newList = new ArrayList<>(); //Could possibly be optimized

            //TODO "Smart" Delay Tick Events
            oldList.forEach(info -> {
                if (info.ticks > 0) {
                    //Still Ticking
                    info.ticks = info.ticks - 1;
                    newList.add(info);
                }
                else {
                    //Ticks have ended, now to trigger the event;
                    if (checkShouldTrigger(event.world, info.pos, info.state)) {
                        if (event.world.getBlockState(info.pos).getBlock() instanceof IScheduledBlockEvent) {
                            //Use with the state at that position as state can change through ticking and not cancel the event
                            ((IScheduledBlockEvent) event.world.getBlockState(info.pos).getBlock()).handleEvent(event.world, info.pos, event.world.getBlockState(info.pos));
                        }
                    }
                }
            });

            scheduledBlocks.put(event.world, newList);
        }
    }

    //Stores the information for each world
    private static final HashMap<IBlockReader, List<Info>> scheduledBlocks = new HashMap<>();

    /**
     * Call this method if you want to schedule a block event
     * @param level The World the event takes place in
     * @param pos The Position of the Event
     * @param state The state the block is in, Used to determine if the block is still there to avoid crashes
     * @param ticks The amount of ticks to pass
     */
    public static void scheduleEvent(IBlockReader level, BlockPos pos, BlockState state, int ticks) {
        Info info = new Info(pos, state, ticks);
        List<Info> list = scheduledBlocks.getOrDefault(level, new ArrayList<>());
        list.add(info);
        scheduledBlocks.put(level, list);
    }

    //Used internally to check if the block still exists
    private static boolean checkShouldTrigger(IBlockReader level, BlockPos pos, BlockState state) {
        return level.getBlockState(pos).getBlock() == state.getBlock();
    }

    //TODO Focus on the QOL later

    //TODO Chunk Load/Unload Handling

    //Used when a level is loaded
    void levelLoad() {
        //TODO probably use capabilities
    }

    //Used when a level is closed
    void levelSave() {

    }

    //Class used to get the info of the scheduled event
    private static class Info {
        final BlockPos pos;
        final BlockState state;
        int ticks;

        Info(BlockPos pos, BlockState state, int ticks) {
            this.pos = pos;
            this.state = state;
            this.ticks = ticks;
        }
    }
}
