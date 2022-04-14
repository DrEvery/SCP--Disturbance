package com.drevery.scpdisturbance.block;

import com.drevery.scpdisturbance.ModDamageSources;
import com.drevery.scpdisturbance.block.base.BaseHorizontalBlock;
import com.drevery.scpdisturbance.utils.Utils;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

import java.util.stream.Stream;

public class BarbedWire extends BaseHorizontalBlock {

    private static final VoxelShape[] SHAPE = Utils.makeHorizontalShapes(
            Stream.of(
                    Block.box(0, 0, 0, 16, 2, 1),
                    Block.box(0, 2, 0, 16, 4, 1),
                    Block.box(0, 8, 0.5, 16, 9, 0.5),
                    Block.box(0, 5, 0.5, 16, 6, 0.5),
                    Block.box(0, 4, 0, 1, 11, 1),
                    Block.box(15, 4, 0, 16, 11, 1)
            ).reduce((v1, v2) -> VoxelShapes.join(v1, v2, IBooleanFunction.OR)).get());

    public BarbedWire(Properties builder) {
        super(builder);
    }

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        return SHAPE[state.getValue(FACING).get2DDataValue()];
    }
    @Override
    public void entityInside(BlockState state, World worldIn, BlockPos pos, Entity entityIn) {
        entityIn.makeStuckInBlock(state, new Vector3d(0.25D, 0.05D, 0.25D));
        entityIn.hurt(ModDamageSources.BARBED_WIRE, 4F);
    }
}

