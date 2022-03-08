package com.drevery.scpdisturbance.block;

import com.drevery.scpdisturbance.ModDamageSources;
import com.drevery.scpdisturbance.utils.Utils;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.ItemStack;
import net.minecraft.state.EnumProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BedPart;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.util.math.vector.Vector3i;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.stream.Stream;

/**
 * Places Foot part of the bed
 */
public class MeatBed extends HorizontalBlock {

    public static final EnumProperty<BedPart> BED_PART = BlockStateProperties.BED_PART;
    private static final VoxelShape[] SHAPE = Utils.makeHorizontalShapes(Stream.of(
            Block.box(0, 0, 15, 16, 11, 16),
            Block.box(-5, 15, -16, -3, 16, -16),
            Block.box(0, 2, -16, 16, 6, 15),
            Block.box(-4, 16, -16, 0, 17, -16),
            Block.box(-2, 13, -16, 1, 16, -16),
            Block.box(-1, 10, -16, 1, 13, -16),
            Block.box(-2, 6, -16, 1, 10, -16),
            Block.box(2, 17, -9, 2, 18, -6),
            Block.box(2, 18, -7, 2, 19, -3),
            Block.box(2, 10, -4, 2, 15, -1),
            Block.box(2, 15, -5, 2, 18, -2),
            Block.box(2, 6, -5, 2, 10, -2),
            Block.box(2, 6, 7, 14, 7, 15),
            Block.box(15, 0, -16, 16, 2, -15),
            Block.box(0, 0, -16, 1, 2, -15),
            Block.box(0, 0, 14, 1, 2, 15),
            Block.box(15, 0, 14, 16, 2, 15)
    ).reduce((v1, v2) -> VoxelShapes.join(v1, v2, IBooleanFunction.OR)).get());

    public MeatBed(Properties builder) {
        super(builder);
        this.registerDefaultState(this.stateDefinition.any().setValue(BED_PART, BedPart.FOOT).setValue(FACING, Direction.NORTH));
    }

    @Override
    public ActionResultType use(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockRayTraceResult blockRayTraceResult) {
        player.hurt(ModDamageSources.SCP_002_BED, player.getMaxHealth());
        return super.use(state, world, pos, player, hand, blockRayTraceResult);
    }

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        if (state.getValue(BED_PART) == BedPart.FOOT) {
            Vector3i v = state.getValue(FACING).getNormal();
            return SHAPE[state.getValue(FACING).getOpposite().get2DDataValue()].move(v.getX(), v.getY(), v.getZ());
        }
        else return SHAPE[state.getValue(FACING).getOpposite().get2DDataValue()];
    }

    @Override
    protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(FACING).add(BED_PART);
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        if (context.getLevel().getBlockState(context.getClickedPos().relative(context.getHorizontalDirection())).canBeReplaced(context)) {
            return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection());
        } else return null;
    }

    @Override
    public void setPlacedBy(World worldIn, BlockPos pos, BlockState state, @Nullable LivingEntity livingEntity, ItemStack stack) {
        //getStateForPlacement was successful, lower block has been placed now place head with facing state
        worldIn.setBlockAndUpdate(pos.relative(state.getValue(FACING)),
                this.defaultBlockState().setValue(BED_PART, BedPart.HEAD).setValue(FACING, state.getValue(FACING)));
    }

    @Override
    public BlockState updateShape(BlockState stateIn, Direction facing, BlockState facingState, IWorld worldIn, BlockPos currentPos, BlockPos facingPos) {
        BlockPos otherPartPos = stateIn.getValue(BED_PART) == BedPart.HEAD ? currentPos.relative(stateIn.getValue(FACING).getOpposite()) : currentPos.relative(stateIn.getValue(FACING));
        return (worldIn.getBlockState(otherPartPos).is(this)) ? stateIn : Blocks.AIR.defaultBlockState();
    }
}
