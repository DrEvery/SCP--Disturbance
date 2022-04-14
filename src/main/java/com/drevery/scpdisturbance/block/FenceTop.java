package com.drevery.scpdisturbance.block;

import com.drevery.scpdisturbance.utils.Utils;
import com.drevery.scpdisturbance.block.base.BaseHorizontalBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;

import java.util.stream.Stream;

public class FenceTop extends BaseHorizontalBlock {

    private static final VoxelShape[] SHAPE = Utils.makeHorizontalShapes(
            Stream.of(
                    Block.box(2, 0, 0.75, 14, 13, 1.25),
                    Block.box(14, 0, 0, 16, 16, 2),
                    Block.box(0, 0, 0, 2, 16, 2),
                    Block.box(2, 13, 0.5, 14, 16, 1.5)
            ).reduce((v1, v2) -> VoxelShapes.join(v1, v2, IBooleanFunction.OR)).get());

    public FenceTop(Properties builder) {
        super(builder);
    }

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        return SHAPE[state.getValue(FACING).get2DDataValue()];
    }
}

