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

public class MeatTable extends BaseHorizontalBlock {

    private static final VoxelShape[] SHAPE = Utils.makeHorizontalShapes(Stream.of(
            Block.box(1, 0, 1, 2, 6, 2),
            Block.box(0, 6, 0, 16, 8, 16),
            Block.box(0, 15, 0, 16, 16, 16),
            Block.box(1, 8, 1, 2, 15, 2),
            Block.box(1, 8, 14, 2, 15, 15),
            Block.box(14, 8, 1, 15, 15, 2),
            Block.box(14, 0, 14, 15, 6, 15),
            Block.box(14, 8, 14, 15, 15, 15),
            Block.box(14, 0, 1, 15, 6, 2),
            Block.box(1, 0, 14, 2, 6, 15)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get());

    public MeatTable(Properties builder) {
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
