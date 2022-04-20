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

public class FenceDown extends BaseHorizontalBlock {

    private static final VoxelShape[] SHAPE = Utils.makeHorizontalShapes(
            Stream.of(
                    Block.box(0, 0, 0, 2, 16, 2),
                    Block.box(14, 0, 0, 16, 16, 2),
                    Block.box(2, 3, 0.75, 14, 16, 1.25),
                    Block.box(14, 0, 0, 16, 16, 2),
                    Block.box(0, 0, 0, 2, 16, 2),
                    Block.box(2, 0, 0.5, 14, 3, 1.5)
            ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get());

    public FenceDown(Properties builder) {
        super(builder);
    }

    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return SHAPE[pState.getValue(FACING).get2DDataValue()];
    }


}

