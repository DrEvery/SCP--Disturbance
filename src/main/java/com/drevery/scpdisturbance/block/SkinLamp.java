package com.drevery.scpdisturbance.block;

import com.drevery.scpdisturbance.block.base.BaseTwoTallHorizontalBlock;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.state.properties.DoubleBlockHalf;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;

import java.util.stream.Stream;

public class SkinLamp extends BaseTwoTallHorizontalBlock {

    private static final VoxelShape SHAPE = Stream.of(
            Block.box(5.500000000000002, 23, 5.500000000000002, 10.500000000000002, 30, 10.500000000000002),
            Block.box(5.500000000000002, 0, 5.500000000000002, 10.500000000000002, 1, 10.500000000000002),
            Block.box(7.500000000000002, 1, 7.500000000000002, 8.500000000000002, 23.05, 8.500000000000002)
    ).reduce((v1, v2) -> VoxelShapes.join(v1, v2, IBooleanFunction.OR)).get();

    public SkinLamp(AbstractBlock.Properties properties) {
        super(properties);
    }

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        return state.getValue(HALF) == DoubleBlockHalf.LOWER ? SHAPE : SHAPE.move(0, -1, 0);
    }
}