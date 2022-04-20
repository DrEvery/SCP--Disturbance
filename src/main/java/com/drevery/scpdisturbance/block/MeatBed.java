package com.drevery.scpdisturbance.block;

import com.drevery.scpdisturbance.ModDamageSources;
import com.drevery.scpdisturbance.utils.Utils;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Vec3i;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BedPart;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

import javax.annotation.Nullable;
import java.util.stream.Stream;

/**
 * Places Foot part of the bed
 */
public class MeatBed extends HorizontalDirectionalBlock {

    public static final EnumProperty<BedPart> BED_PART = BlockStateProperties.BED_PART;
    private static final VoxelShape[] SHAPE = Utils.makeHorizontalShapes(Stream.of(
            Block.box(0, 4, 0, 16, 10, 16),
            Block.box(13, 0, -16, 16, 4, -13),
            Block.box(0, 0, -16, 3, 4, -13),
            Block.box(0, 4, -16, 16, 10, 0),
            Block.box(0, 0, 13, 3, 4, 16),
            Block.box(3, 9, 8.5, 13, 11, 15.5),
            Block.box(13, 0, 13, 16, 4, 16)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get());

    public MeatBed(Properties builder) {
        super(builder);
        this.registerDefaultState(this.stateDefinition.any().setValue(BED_PART, BedPart.FOOT).setValue(FACING, Direction.NORTH));
    }

    @Override
    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {
        pPlayer.hurt(ModDamageSources.SCP_002_BED, pPlayer.getMaxHealth());
        return super.use(pState, pLevel, pPos, pPlayer, pHand, pHit);
    }

    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        if (pState.getValue(BED_PART) == BedPart.FOOT) {
            Vec3i v = pState.getValue(FACING).getNormal();
            return SHAPE[pState.getValue(FACING).getOpposite().get2DDataValue()].move(v.getX(), v.getY(), v.getZ());
        }
        else return SHAPE[pState.getValue(FACING).getOpposite().get2DDataValue()];
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(FACING).add(BED_PART);
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext pContext) {
        if (pContext.getLevel().getBlockState(pContext.getClickedPos().relative(pContext.getHorizontalDirection())).canBeReplaced(pContext)) {
            return this.defaultBlockState().setValue(FACING, pContext.getHorizontalDirection());
        } else return null;
    }

    @Override
    public void setPlacedBy(Level pLevel, BlockPos pPos, BlockState pState, @Nullable LivingEntity pPlacer, ItemStack pStack) {
        //getStateForPlacement was successful, lower block has been placed now place head with facing state
        pLevel.setBlockAndUpdate(pPos.relative(pState.getValue(FACING)),
                this.defaultBlockState().setValue(BED_PART, BedPart.HEAD).setValue(FACING, pState.getValue(FACING)));
    }

    @Override
    public BlockState updateShape(BlockState pState, Direction pDirection, BlockState pNeighborState, LevelAccessor pLevel, BlockPos pCurrentPos, BlockPos pNeighborPos) {
        BlockPos otherPartPos = pState.getValue(BED_PART) == BedPart.HEAD ? pCurrentPos.relative(pState.getValue(FACING).getOpposite()) : pCurrentPos.relative(pState.getValue(FACING));
        return (pLevel.getBlockState(otherPartPos).is(this)) ? pState : Blocks.AIR.defaultBlockState();
    }
}
