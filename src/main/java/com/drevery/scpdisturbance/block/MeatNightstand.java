package com.drevery.scpdisturbance.block;

import com.drevery.scpdisturbance.block.base.BaseHorizontalBlock;
import com.drevery.scpdisturbance.utils.Utils;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.stream.Stream;

public class MeatNightstand extends BaseHorizontalBlock {

    private static final VoxelShape[] SHAPE = Utils.makeHorizontalShapes(Stream.of(
            Block.box(7.5, 12, 0.5, 8.5, 13, 1.5),
            Block.box(3, 4, 1, 13, 8, 2),
            Block.box(1, 0, 2, 4, 3, 6),
            Block.box(1, 0, 11, 4, 3, 15),
            Block.box(12, 0, 2, 15, 3, 6),
            Block.box(12, 0, 11, 15, 3, 15),
            Block.box(0, 14, 1, 16, 15, 16),
            Block.box(3, 9.5, 1, 13, 13.5, 2),
            Block.box(1, 3, 2, 15, 14, 15),
            Block.box(7.5, 6, 0.5, 8.5, 7, 1.5)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get());

    public MeatNightstand(Properties builder) {
        super(builder);
    }

    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return SHAPE[pState.getValue(FACING).get2DDataValue()];
    }

    @Override
    public int getSignal(BlockState pState, BlockGetter pLevel, BlockPos pPos, Direction pDirection) {
        return 15;
    }
}
