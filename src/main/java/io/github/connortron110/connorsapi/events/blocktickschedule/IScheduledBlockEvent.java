package io.github.connortron110.connorsapi.events.blocktickschedule;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

public interface IScheduledBlockEvent {
    void handleEvent(Level level, BlockPos pos, BlockState state);
}
