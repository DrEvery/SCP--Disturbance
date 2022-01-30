package com.drevery.scpdisturbance;

import net.minecraft.util.Direction;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;

public class Utils {
    /**
     * Provide the North Shape first in order for array to work correctly <br>
     * Currently only works with Horizontal Blocks
     */
    public static VoxelShape[] makeHorizontalShapes(VoxelShape northShape) {
        return new VoxelShape[]{rotateShape(Direction.SOUTH, northShape), rotateShape(Direction.WEST, northShape), northShape, rotateShape(Direction.EAST, northShape)};
    }

    private static VoxelShape rotateShape(Direction to, VoxelShape shape) {
        VoxelShape[] buffer = new VoxelShape[]{ shape, VoxelShapes.empty() };
        int times = (to.getHorizontalIndex() - Direction.NORTH.getHorizontalIndex() + 4) % 4;
        for (int i = 0; i < times; i++) {
            buffer[0].forEachBox((minX, minY, minZ, maxX, maxY, maxZ) -> buffer[1] =
                    VoxelShapes.or(buffer[1], VoxelShapes.create(1-maxZ, minY, minX, 1-minZ, maxY, maxX)));
            buffer[0] = buffer[1];
            buffer[1] = VoxelShapes.empty();
        }

        return buffer[0];
    }
}
