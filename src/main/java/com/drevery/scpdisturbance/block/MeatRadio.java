package com.drevery.scpdisturbance.block;

import com.drevery.scpdisturbance.Utils;
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

public class MeatRadio extends BaseHorizontalBlock {

    private static final VoxelShape[] SHAPE = Utils.makeHorizontalShapes(Stream.of(
            Block.box(4.5, 4.5, 7, 5.5, 5.5, 8),
            Block.box(3.5, 0, 6, 12.5, 5, 9),
            Block.box(6.5, 3, 7, 13.5, 3, 8)
    ).reduce((v1, v2) -> VoxelShapes.join(v1, v2, IBooleanFunction.OR)).get());

    public MeatRadio(Properties builder) {
        super(builder);
    }

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        return SHAPE[state.getValue(FACING).get2DDataValue()];
    }
}