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

public class MeatTV extends BaseHorizontalBlock {

    private static final VoxelShape[] SHAPE = Utils.makeHorizontalShapes(
            Stream.of(
                    Block.box(11, 4, 2.5, 11, 5, 3.5),
                    Block.box(6, 5, 2.5, 6, 6, 4.5),
                    Block.box(8, 2, 1.5, 8, 3, 3.5),
                    Block.box(6, 6, 3.5, 6, 7, 5.5),
                    Block.box(11, 3, 3.5, 11, 4, 5.5),
                    Block.box(8, 3, 3.5, 8, 4, 5.5),
                    Block.box(3, 0, 6, 13, 8, 12),
                    Block.box(5, 0, 5, 12, 2, 6),
                    Block.box(5, 7, 5, 12, 8, 6),
                    Block.box(3, 0, 5, 5, 8, 6),
                    Block.box(12, 0, 5, 13, 8, 6),
                    Block.box(5, 2, 5.5, 12, 7, 6.5)
            ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get());

    public MeatTV(Properties builder) {
        super(builder);
    }

    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return SHAPE[pState.getValue(FACING).get2DDataValue()];
    }
}
