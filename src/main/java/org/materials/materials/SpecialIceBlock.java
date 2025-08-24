package org.materials.materials;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.BlockGetter;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nonnull;

public class SpecialIceBlock extends Block
{
    public SpecialIceBlock(Properties properties)
    {
        super(properties);
    }

    @Override
    public void onRemove(@Nonnull BlockState state, @Nonnull Level level, @Nonnull BlockPos pos, @Nonnull BlockState newState, boolean isMoving)
    {
        super.onRemove(state, level, pos, newState, isMoving);
        if (!level.isClientSide && newState.isAir())
        {
            level.setBlock(pos, Blocks.WATER.defaultBlockState(), 3);
        }
    }

    // 让天光向下传播
    @Override
    public boolean propagatesSkylightDown(@NotNull BlockState state, @Nonnull BlockGetter level, @Nonnull BlockPos pos)
    {
        return true;
    }

    // 不阻挡方块光
    @Override
    public int getLightBlock(@Nonnull BlockState state, @Nonnull BlockGetter level, @Nonnull BlockPos pos)
    {
        return 0;
    }

    // 避免环境光AO导致视觉变暗
    @Override
    public float getShadeBrightness(@Nonnull BlockState state, @Nonnull BlockGetter level, @Nonnull BlockPos pos)
    {
        return 1.0F;
    }
}