package org.materials.materials;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;

public class IceBlock extends Block
{
    public IceBlock(Properties properties)
    {
        super(properties);
    }

    @Override
    public void onRemove(BlockState state, Level level, BlockPos pos, BlockState newState, boolean isMoving)
    {
        super.onRemove(state, level, pos, newState, isMoving);
        if (!level.isClientSide && newState.isAir())
        {
            level.setBlock(pos, Blocks.WATER.defaultBlockState(), 3);
        }
    }
}