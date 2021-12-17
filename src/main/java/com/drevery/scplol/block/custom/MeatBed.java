package com.drevery.scplol.block.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.StateContainer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;

import java.util.stream.Stream;

public class MeatBed extends HorizontalBlock
{
    public MeatBed(Properties builder) {super(builder);}

    private static final VoxelShape SHAPE_N = Stream.of(
            Block.makeCuboidShape(0, 0, 15, 16, 11, 16),
            Block.makeCuboidShape(-5, 15, -16, -3, 16, -16),
            Block.makeCuboidShape(0, 2, -16, 16, 6, 15),
            Block.makeCuboidShape(-4, 16, -16, 0, 17, -16),
            Block.makeCuboidShape(-2, 13, -16, 1, 16, -16),
            Block.makeCuboidShape(-1, 10, -16, 1, 13, -16),
            Block.makeCuboidShape(-2, 6, -16, 1, 10, -16),
            Block.makeCuboidShape(2, 17, -9, 2, 18, -6),
            Block.makeCuboidShape(2, 18, -7, 2, 19, -3),
            Block.makeCuboidShape(2, 10, -4, 2, 15, -1),
            Block.makeCuboidShape(2, 15, -5, 2, 18, -2),
            Block.makeCuboidShape(2, 6, -5, 2, 10, -2),
            Block.makeCuboidShape(2, 6, 7, 14, 7, 15),
            Block.makeCuboidShape(15, 0, -16, 16, 2, -15),
            Block.makeCuboidShape(0, 0, -16, 1, 2, -15),
            Block.makeCuboidShape(0, 0, 14, 1, 2, 15),
            Block.makeCuboidShape(15, 0, 14, 16, 2, 15)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR)).get();

    private static final VoxelShape SHAPE_S = Stream.of(
            Block.makeCuboidShape(0.02308376759852493, 0, -0.012184863231544774, 16.023083767598525, 11, 0.9878151367684446),
            Block.makeCuboidShape(-0.30743358690841305, 15, 25.197939479850326, -0.30743358690841305, 16, 27.197939479850326),
            Block.makeCuboidShape(0.02308376759852493, 2, 0.9878151367684446, 16.023083767598525, 6, 31.98781513676844),
            Block.makeCuboidShape(-0.30743358690841305, 16, 22.197939479850326, -0.30743358690841305, 17, 26.197939479850326),
            Block.makeCuboidShape(-0.30743358690841305, 13, 21.197939479850326, -0.30743358690841305, 16, 24.197939479850326),
            Block.makeCuboidShape(-0.30743358690841305, 10, 21.197939479850326, -0.30743358690841305, 13, 23.197939479850326),
            Block.makeCuboidShape(-0.30743358690841305, 6, 21.197939479850326, -0.30743358690841305, 10, 24.197939479850326),
            Block.makeCuboidShape(6.692566413091587, 17, 20.197939479850326, 9.692566413091587, 18, 20.197939479850326),
            Block.makeCuboidShape(8.692566413091589, 18, 20.197939479850326, 12.692566413091589, 19, 20.197939479850326),
            Block.makeCuboidShape(10.692566413091589, 15, 20.197939479850326, 13.692566413091589, 18, 20.197939479850326),
            Block.makeCuboidShape(11.692566413091589, 10, 20.197939479850326, 14.692566413091589, 15, 20.197939479850326),
            Block.makeCuboidShape(10.692566413091589, 6, 20.197939479850326, 13.692566413091589, 10, 20.197939479850326),
            Block.makeCuboidShape(2.0230837675985267, 6, 0.9878151367684446, 14.023083767598527, 7, 8.987815136768445),
            Block.makeCuboidShape(0.02308376759852493, 0, 30.98781513676844, 1.0230837675985267, 2, 31.98781513676844),
            Block.makeCuboidShape(15.023083767598525, 0, 30.98781513676844, 16.023083767598525, 2, 31.98781513676844),
            Block.makeCuboidShape(15.023083767598525, 0, 0.9878151367684446, 16.023083767598525, 2, 1.9878151367684445),
            Block.makeCuboidShape(0.02308376759852493, 0, 0.9878151367684446, 1.0230837675985267, 2, 1.9878151367684445)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR)).get();

    private static final VoxelShape SHAPE_W = Stream.of(
            Block.makeCuboidShape(-0.04455054781650675, 0, 0.03236568458495981, 0.9554494521834791, 11, 16.03236568458496),
            Block.makeCuboidShape(25.165573795265367, 15, 16.362883039091898, 27.165573795265367, 16, 16.362883039091898),
            Block.makeCuboidShape(0.9554494521834791, 2, 0.03236568458495981, 31.95544945218348, 6, 16.03236568458496),
            Block.makeCuboidShape(22.165573795265367, 16, 16.362883039091898, 26.165573795265367, 17, 16.362883039091898),
            Block.makeCuboidShape(21.165573795265367, 13, 16.362883039091898, 24.165573795265367, 16, 16.362883039091898),
            Block.makeCuboidShape(21.165573795265367, 10, 16.362883039091898, 23.165573795265367, 13, 16.362883039091898),
            Block.makeCuboidShape(21.165573795265367, 6, 16.362883039091898, 24.165573795265367, 10, 16.362883039091898),
            Block.makeCuboidShape(20.165573795265367, 17, 6.362883039091898, 20.165573795265367, 18, 9.362883039091898),
            Block.makeCuboidShape(20.165573795265367, 18, 3.362883039091898, 20.165573795265367, 19, 7.362883039091898),
            Block.makeCuboidShape(20.165573795265367, 15, 2.362883039091898, 20.165573795265367, 18, 5.362883039091898),
            Block.makeCuboidShape(20.165573795265367, 10, 1.3628830390918978, 20.165573795265367, 15, 4.362883039091898),
            Block.makeCuboidShape(20.165573795265367, 6, 2.362883039091898, 20.165573795265367, 10, 5.362883039091898),
            Block.makeCuboidShape(0.9554494521834791, 6, 2.03236568458496, 8.955449452183482, 7, 14.03236568458496),
            Block.makeCuboidShape(30.95544945218348, 0, 15.03236568458496, 31.95544945218348, 2, 16.03236568458496),
            Block.makeCuboidShape(30.95544945218348, 0, 0.03236568458495981, 31.95544945218348, 2, 1.0323656845849598),
            Block.makeCuboidShape(0.9554494521834791, 0, 0.03236568458495981, 1.955449452183479, 2, 1.0323656845849598),
            Block.makeCuboidShape(0.9554494521834791, 0, 15.03236568458496, 1.955449452183479, 2, 16.03236568458496)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR)).get();

    private static final VoxelShape SHAPE_E = Stream.of(
            Block.makeCuboidShape(15.06763431541504, 0, -0.044550547816511354, 16.06763431541503, 11, 15.955449452183487),
            Block.makeCuboidShape(-11.14249002766684, 15, -0.3750679023234511, -9.14249002766684, 16, -0.3750679023234511),
            Block.makeCuboidShape(-15.932365684584957, 2, -0.044550547816511354, 15.06763431541504, 6, 15.955449452183487),
            Block.makeCuboidShape(-10.14249002766684, 16, -0.3750679023234511, -6.14249002766684, 17, -0.3750679023234511),
            Block.makeCuboidShape(-8.14249002766684, 13, -0.3750679023234511, -5.14249002766684, 16, -0.3750679023234511),
            Block.makeCuboidShape(-7.14249002766684, 10, -0.3750679023234511, -5.14249002766684, 13, -0.3750679023234511),
            Block.makeCuboidShape(-8.14249002766684, 6, -0.3750679023234511, -5.14249002766684, 10, -0.3750679023234511),
            Block.makeCuboidShape(-4.142490027666842, 17, 6.624932097676549, -4.142490027666842, 18, 9.624932097676549),
            Block.makeCuboidShape(-4.142490027666842, 18, 8.624932097676549, -4.142490027666842, 19, 12.624932097676549),
            Block.makeCuboidShape(-4.142490027666842, 15, 10.624932097676549, -4.142490027666842, 18, 13.624932097676549),
            Block.makeCuboidShape(-4.142490027666842, 10, 11.624932097676549, -4.142490027666842, 15, 14.624932097676549),
            Block.makeCuboidShape(-4.142490027666842, 6, 10.624932097676549, -4.142490027666842, 10, 13.624932097676549),
            Block.makeCuboidShape(7.067634315415042, 6, 1.9554494521834886, 15.06763431541504, 7, 13.955449452183489),
            Block.makeCuboidShape(-15.932365684584957, 0, -0.044550547816511354, -14.932365684584957, 2, 0.9554494521834886),
            Block.makeCuboidShape(-15.932365684584957, 0, 14.955449452183487, -14.932365684584957, 2, 15.955449452183487),
            Block.makeCuboidShape(14.06763431541504, 0, 14.955449452183487, 15.06763431541504, 2, 15.955449452183487),
            Block.makeCuboidShape(14.06763431541504, 0, -0.044550547816511354, 15.06763431541504, 2, 0.9554494521834886)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR)).get();

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        switch (state.get(HORIZONTAL_FACING)) {
            case NORTH:
                return SHAPE_N;
            case SOUTH:
                return SHAPE_S;
            case WEST:
                return SHAPE_E;
            case EAST:
                return SHAPE_W;
            default:
                return SHAPE_N;
        }
    }

        @Override
        protected void fillStateContainer(StateContainer.Builder< Block, BlockState > builder) {
        super.fillStateContainer(builder.add(HORIZONTAL_FACING));
    }

        @Override
        public BlockState getStateForPlacement(BlockItemUseContext context) {
        return this.getDefaultState().with(HORIZONTAL_FACING, context.getPlacementHorizontalFacing().getOpposite());
    }
}
