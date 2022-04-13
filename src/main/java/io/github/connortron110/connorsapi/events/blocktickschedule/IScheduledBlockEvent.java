package io.github.connortron110.connorsapi.events.blocktickschedule;

import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public interface IScheduledBlockEvent {
    void handleEvent(World level, BlockPos pos, BlockState state);
}
