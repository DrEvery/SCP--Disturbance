package com.drevery.scpdisturbance.block;

import com.drevery.scpdisturbance.block.base.BaseTwoTallHorizontalBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.stream.Stream;

public class SkinLamp extends BaseTwoTallHorizontalBlock {

    private static final VoxelShape SHAPE = Stream.of(
            Block.box(5.500000000000002, 23, 5.500000000000002, 10.500000000000002, 30, 10.500000000000002),
            Block.box(5.500000000000002, 0, 5.500000000000002, 10.500000000000002, 1, 10.500000000000002),
            Block.box(7.500000000000002, 1, 7.500000000000002, 8.500000000000002, 23.05, 8.500000000000002)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();

    public SkinLamp(Properties properties) {
        super(properties);
    }

    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return pState.getValue(HALF) == DoubleBlockHalf.LOWER ? SHAPE : SHAPE.move(0, -1, 0);
    }
}