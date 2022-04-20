package com.drevery.scpdisturbance.block;

import com.drevery.scpdisturbance.block.base.BaseHorizontalBlock;
import com.drevery.scpdisturbance.entity.scp.SCP058_TentacleEntity;
import com.drevery.scpdisturbance.registration.ModEntityTypes;
import com.drevery.scpdisturbance.utils.Utils;
import io.github.connortron110.connorsapi.events.blocktickschedule.BlockScheduleHandler;
import io.github.connortron110.connorsapi.events.blocktickschedule.IScheduledBlockEvent;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

import javax.annotation.Nullable;

public class SCP058Egg extends BaseHorizontalBlock implements IScheduledBlockEvent {
    private static final VoxelShape[] SHAPE = Utils.makeHorizontalShapes(Shapes.join(Block.box(
            5, 8, 5, 11, 9, 11), Block.box(4, 0, 4, 12, 8, 12
    ), BooleanOp.OR));

    public SCP058Egg(Properties builder) {
        super(builder);
    }

    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return SHAPE[pState.getValue(FACING).get2DDataValue()];
    }

    @Override
    public void onPlace(BlockState pState, Level pLevel, BlockPos pPos, BlockState pOldState, boolean pIsMoving) {
        BlockScheduleHandler.scheduleEvent(pLevel, pPos, pState, 400);
        super.onPlace(pState, pLevel, pPos, pOldState, pIsMoving);
    }
    @Nullable
    @Override
    public void handleEvent(Level level, BlockPos pos, BlockState state) {
        level.setBlockAndUpdate(pos, Blocks.AIR.defaultBlockState());
        level.playSound(null, pos, SoundEvents.TURTLE_EGG_HATCH, SoundSource.BLOCKS, 0.7F, 0.9F +  0.2F);
       // level.addParticle(ParticleTypes.ENCHANT, pos.getX() + 0.5, pos.getY(), pos.getZ() + 0.5, 1, 1, 1); // Not working
        SCP058_TentacleEntity entity = ModEntityTypes.SCP_058_TENTACLE.get().create(level);
        entity.setPos(pos.getX() + 0.5, pos.getY(), pos.getZ() + 0.5);
        level.addFreshEntity(entity);
    }
}