package com.drevery.scpdisturbance.block;

import com.drevery.scpdisturbance.block.base.BaseHorizontalBlock;
import com.drevery.scpdisturbance.entity.scp.SCP058_TentacleEntity;
import com.drevery.scpdisturbance.registration.ModEntityTypes;
import com.drevery.scpdisturbance.utils.Utils;
import io.github.connortron110.connorsapi.events.blocktickschedule.BlockScheduleHandler;
import io.github.connortron110.connorsapi.events.blocktickschedule.IScheduledBlockEvent;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.common.util.Constants;

import javax.annotation.Nullable;

public class SCP058Egg extends BaseHorizontalBlock implements IScheduledBlockEvent {
    private static final VoxelShape[] SHAPE = Utils.makeHorizontalShapes(VoxelShapes.join(Block.box(
            5, 8, 5, 11, 9, 11), Block.box(4, 0, 4, 12, 8, 12
    ), IBooleanFunction.OR));

    public SCP058Egg(Properties builder) {
        super(builder);
    }

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        return SHAPE[state.getValue(FACING).get2DDataValue()];
    }

    @Override
    public void onPlace(BlockState pState, World pLevel, BlockPos pPos, BlockState pOldState, boolean pIsMoving) {
        BlockScheduleHandler.scheduleEvent(pLevel, pPos, pState, 400);
        super.onPlace(pState, pLevel, pPos, pOldState, pIsMoving);
    }
    @Nullable
    @Override
    public void handleEvent(World level, BlockPos pos, BlockState state) {
        level.setBlock(pos, Blocks.AIR.defaultBlockState(), Constants.BlockFlags.BLOCK_UPDATE);
        level.playSound(null, pos, SoundEvents.TURTLE_EGG_HATCH, SoundCategory.BLOCKS, 0.7F, 0.9F +  0.2F);
       // level.addParticle(ParticleTypes.ENCHANT, pos.getX() + 0.5, pos.getY(), pos.getZ() + 0.5, 1, 1, 1); // Not working
        SCP058_TentacleEntity entity = ModEntityTypes.SCP_058_TENTACLE.get().create(level);
        entity.setPos(pos.getX() + 0.5, pos.getY(), pos.getZ() + 0.5);
        level.addFreshEntity(entity);
    }
}