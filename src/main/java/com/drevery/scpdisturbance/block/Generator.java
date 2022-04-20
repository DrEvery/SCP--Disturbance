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

public class Generator extends BaseHorizontalBlock {

    private static final VoxelShape[] SHAPE = Utils.makeHorizontalShapes(Stream.of(
            Block.box(1, 1, 2, 15, 3, 13),
            Block.box(0, 15, 1, 1, 16, 15),
            Block.box(2, 7, 1, 14, 12, 2),
            Block.box(0, 12, 1, 16, 13, 15),
            Block.box(0, 0, 0, 1, 16, 1),
            Block.box(15, 0, 15, 16, 16, 16),
            Block.box(15, 0, 0, 16, 16, 1),
            Block.box(0, 0, 15, 1, 16, 16),
            Block.box(15, 15, 1, 16, 16, 15),
            Block.box(9, 14.5, 7, 11, 15.5, 9),
            Block.box(2, 13, 2, 14, 15, 14),
            Block.box(2, 3, 3, 14, 12, 11),
            Block.box(3, 3, 11, 13, 11, 14),
            Block.box(4, 4, 2, 12, 12, 3),
            Block.box(0, 0, 1, 1, 1, 15),
            Block.box(15, 0, 1, 16, 1, 15),
            Block.box(1, 0, 15, 15, 1, 16),
            Block.box(1, 0, 0, 15, 1, 1),
            Block.box(5, 0, 1, 7, 1, 15),
            Block.box(9, 0, 1, 11, 1, 15)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get());

    public Generator(Properties builder) {
        super(builder);
    }

    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return SHAPE[pState.getValue(FACING).get2DDataValue()];
    }

    @Override
    public boolean isSignalSource(BlockState pState) {
        return true;
    }

    @Override
    public int getSignal(BlockState pState, BlockGetter pLevel, BlockPos pPos, Direction pDirection) {
        return 15;
    }
}
