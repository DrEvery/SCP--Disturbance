package com.drevery.scpdisturbance.block;

import com.drevery.scpdisturbance.block.base.BaseHorizontalBlock;
import com.drevery.scpdisturbance.utils.Utils;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.stream.Stream;

public class Painting extends BaseHorizontalBlock {

    private static final VoxelShape[] SHAPE = Utils.makeHorizontalShapes(
            Stream.of(
                    Block.box(0, 0, 15, 16, 16, 16),
                    Block.box(15, 0, 14, 16, 16, 15),
                    Block.box(0, 0, 14, 1, 16, 15),
                    Block.box(1, 0, 14, 15, 1, 15),
                    Block.box(1, 15, 14, 15, 16, 15),
                    Block.box(4, 5, 14, 12, 13, 15)
            ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get());

    public Painting(Properties builder) {
        super(builder);
    }

    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return SHAPE[pState.getValue(FACING).get2DDataValue()];
    }
}

