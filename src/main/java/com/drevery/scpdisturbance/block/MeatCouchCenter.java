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

public class MeatCouchCenter extends BaseHorizontalBlock {

    private static final VoxelShape[] SHAPE = Utils.makeHorizontalShapes(Stream.of(
            Block.box(0, 0, 1, 16, 7, 11),
            Block.box(0, 7, 0, 16, 8, 11),
            Block.box(0, 0, 11, 16, 16, 16)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get());

    public MeatCouchCenter(Properties builder) {
        super(builder);
    }

    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return SHAPE[pState.getValue(FACING).get2DDataValue()];
    }
}

