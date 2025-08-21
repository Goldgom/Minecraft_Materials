// java
package org.materials.materials;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.BushBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;

public class FireflyBushBlock extends BushBlock implements BonemealableBlock
{
    private static final VoxelShape SHAPE = box(2.0, 0.0, 2.0, 14.0, 12.0, 14.0);

    public FireflyBushBlock()
    {
        super(Properties.of()
                .mapColor(MapColor.PLANT)
                .noCollission()
                .instabreak()
                .sound(SoundType.GRASS)
                .lightLevel(s -> 7));
    }

    public FireflyBushBlock(Properties properties)
    {
        super(properties);
    }

    @Override
    public @NotNull VoxelShape getShape(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull CollisionContext ctx)
    {
        return SHAPE;
    }

    @Override
    protected boolean mayPlaceOn(BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos)
    {
        return state.is(Blocks.GRASS_BLOCK) || state.is(Blocks.DIRT) || state.is(Blocks.COARSE_DIRT)
                || state.is(Blocks.ROOTED_DIRT) || state.is(Blocks.PODZOL) || state.is(Blocks.MOSS_BLOCK)
                || state.is(Blocks.FARMLAND) || state.is(Blocks.MUD) || super.mayPlaceOn(state, level, pos);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext ctx)
    {
        return canSurvive(defaultBlockState(), ctx.getLevel(), ctx.getClickedPos()) ? defaultBlockState() : null;
    }

    @Override
    public void animateTick(@NotNull BlockState state, @NotNull Level level, @NotNull BlockPos pos, @NotNull RandomSource random)
    {
        super.animateTick(state, level, pos, random);
        if (random.nextFloat() < 0.25f)
        {
            double x = pos.getX() + 0.2 + random.nextDouble() * 0.6;
            double y = pos.getY() + 0.5 + random.nextDouble() * 0.5;
            double z = pos.getZ() + 0.2 + random.nextDouble() * 0.6;
            double vx = (random.nextDouble() - 0.5) * 0.01;
            double vy = 0.01 + random.nextDouble() * 0.02;
            double vz = (random.nextDouble() - 0.5) * 0.01;
            level.addParticle(ParticleTypes.WAX_OFF, x, y, z, vx, vy, vz);
        }
    }

    // 骨粉：少量在周围草地扩散
    @Override
    public boolean isValidBonemealTarget(@NotNull LevelReader level, @NotNull BlockPos pos, @NotNull BlockState state, boolean isClient)
    {
        return true;
    }

    @Override
    public boolean isBonemealSuccess(@NotNull Level level, RandomSource random, @NotNull BlockPos pos, @NotNull BlockState state)
    {
        return random.nextFloat() < 0.9f;
    }

    @Override
    public void performBonemeal(@NotNull ServerLevel level, @NotNull RandomSource random, @NotNull BlockPos pos, @NotNull BlockState state)
    {
        for (int i = 0; i < 8; i++)
        {
            BlockPos target = pos.offset(random.nextInt(5) - 2, random.nextInt(2) - 1, random.nextInt(5) - 2);
            if (!level.isEmptyBlock(target)) continue;
            BlockPos below = target.below();
            if (mayPlaceOn(level.getBlockState(below), level, below) && defaultBlockState().canSurvive(level, target))
            {
                level.setBlock(target, defaultBlockState(), 3);
            }
        }
    }

    @Override
    public boolean canSurvive(@NotNull BlockState state, @NotNull LevelReader level, BlockPos pos)
    {
        BlockPos below = pos.below();
        return mayPlaceOn(level.getBlockState(below), level, below);
    }

    @Override
    public boolean isFlammable(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull Direction face)
    {
        return true;
    }

    @Override
    public int getFlammability(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull Direction face)
    {
        return 60;
    }

    @Override
    public int getFireSpreadSpeed(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull Direction face)
    {
        return 30;
    }
}