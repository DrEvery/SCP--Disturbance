package com.drevery.scpdisturbance.block;

import com.drevery.scpdisturbance.ModDamageSources;
import com.drevery.scpdisturbance.block.base.BaseHorizontalBlock;
import com.drevery.scpdisturbance.utils.Utils;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

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
            ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get());

    public BarbedWire(Properties builder) {
        super(builder);
    }

    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return SHAPE[pState.getValue(FACING).get2DDataValue()];
    }
    @Override
    public void entityInside(BlockState pState, Level pLevel, BlockPos pPos, Entity pEntity) {
        pEntity.makeStuckInBlock(pState, new Vec3(0.25D, 0.05D, 0.25D));
        pEntity.hurt(ModDamageSources.BARBED_WIRE, 4F);
    }
}