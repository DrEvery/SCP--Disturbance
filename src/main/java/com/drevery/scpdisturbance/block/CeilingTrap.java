package com.drevery.scpdisturbance.block;

import com.drevery.scpdisturbance.ModDamageSources;
import com.drevery.scpdisturbance.block.base.BaseHorizontalBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

public class CeilingTrap extends BaseHorizontalBlock {

    private static final VoxelShape SHAPE = Block.box(6, 15.75, 6, 10, 16, 10);

    public CeilingTrap(Properties builder) {
        super(builder);
    }

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        return SHAPE;
    }

    @Override
    public void entityInside(BlockState state, World worldIn, BlockPos pos, Entity entityIn) {
        entityIn.makeStuckInBlock(state, new Vector3d(0.25D, 0.05D, 0.25D));
        entityIn.hurt(ModDamageSources.SCP_002_TRAP, 4F);
    }
}


