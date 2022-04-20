 package com.drevery.scpdisturbance.block;

import com.drevery.scpdisturbance.block.base.BaseHorizontalBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.stream.Stream;

public class MeatLamp extends BaseHorizontalBlock {

    private static final VoxelShape SHAPE = Stream.of(
            Block.box(6.5, 5, 6.508181818181818, 9.5, 9, 6.508181818181818),
            Block.box(6.5, 0, 6.508181818181818, 9.5, 1, 9.508181818181818),
            Block.box(7, 1, 7.008181818181818, 9, 3, 9.008181818181818),
            Block.box(7.5, 5, 8.408181818181818, 8.5, 6, 9.408181818181818),
            Block.box(7.5, 3, 7.508181818181818, 8.5, 8, 8.508181818181818),
            Block.box(7.5, 5, 6.518181818181818, 8.5, 6, 7.518181818181818),
            Block.box(6.6, 5, 7.508181818181818, 7.6, 6, 8.508181818181818),
            Block.box(8.4, 5, 7.508181818181818, 9.4, 6, 8.508181818181818),
            Block.box(6.5, 5, 6.508181818181818, 6.5, 9, 9.508181818181818),
            Block.box(6.5, 5, 9.508181818181818, 9.5, 9, 9.508181818181818),
            Block.box(9.5, 5, 6.508181818181818, 9.5, 9, 9.508181818181818)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();

    public MeatLamp(Properties builder) {
        super(builder);
    }

    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return SHAPE;
    }
}