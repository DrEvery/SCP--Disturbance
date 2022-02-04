 package com.drevery.scpdisturbance.block;

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

public class MeatLamp extends BaseHorizontalBlock {

    private static final VoxelShape SHAPE = Stream.of(
            Block.makeCuboidShape(6.5, 5, 6.508181818181818, 9.5, 9, 6.508181818181818),
            Block.makeCuboidShape(6.5, 0, 6.508181818181818, 9.5, 1, 9.508181818181818),
            Block.makeCuboidShape(7, 1, 7.008181818181818, 9, 3, 9.008181818181818),
            Block.makeCuboidShape(7.5, 5, 8.408181818181818, 8.5, 6, 9.408181818181818),
            Block.makeCuboidShape(7.5, 3, 7.508181818181818, 8.5, 8, 8.508181818181818),
            Block.makeCuboidShape(7.5, 5, 6.518181818181818, 8.5, 6, 7.518181818181818),
            Block.makeCuboidShape(6.6, 5, 7.508181818181818, 7.6, 6, 8.508181818181818),
            Block.makeCuboidShape(8.4, 5, 7.508181818181818, 9.4, 6, 8.508181818181818),
            Block.makeCuboidShape(6.5, 5, 6.508181818181818, 6.5, 9, 9.508181818181818),
            Block.makeCuboidShape(6.5, 5, 9.508181818181818, 9.5, 9, 9.508181818181818),
            Block.makeCuboidShape(9.5, 5, 6.508181818181818, 9.5, 9, 9.508181818181818)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR)).get();

    public MeatLamp(Properties builder) {
        super(builder);
    }

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        return SHAPE;
    }
}