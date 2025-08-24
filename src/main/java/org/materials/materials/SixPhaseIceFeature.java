// java
package org.materials.materials;

import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

public class SixPhaseIceFeature extends Feature<NoneFeatureConfiguration>
{
    static int radius = 8;     // 水平半径
    static int vRadius = 4;    // 垂直半径
    static float triggerChance = 0.08f; // 8%

    public SixPhaseIceFeature(Codec<NoneFeatureConfiguration> codec)
    {
        super(codec);
    }

    @Override
    public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> ctx)
    {
        BlockPos origin = ctx.origin();
        WorldGenLevel level = ctx.level();
        RandomSource random = ctx.random();

        // 寒冷检查
        if (!level.getBiome(origin).value().coldEnoughToSnow(origin))
            return false;

        int placed = 0;

        int x = origin.getX() + random.nextInt(radius * 2 + 1) - radius;
        int y = origin.getY() + random.nextInt(vRadius * 2 + 1) - vRadius;
        int z = origin.getZ() + random.nextInt(radius * 2 + 1) - radius;
        BlockPos pos = new BlockPos(x, y, z);

        if (isWithoutWorldBounds(level, pos))
            return false;

        // 候选点：水面上/水中/冰块(冰山及其内部)
        if (isInvalidTarget(level, pos))
            return false;

        // 概率触发生成，并从触发点开始扩散成簇
        if (random.nextFloat() < triggerChance)
        {
            placed += placeCluster(level, pos, random);
        }

        return placed > 0;
    }

    // 检查位置是否在世界边界外
    static boolean isWithoutWorldBounds(WorldGenLevel level, BlockPos pos)
    {
        return pos.getY() < level.getMinBuildHeight() || pos.getY() >= level.getMaxBuildHeight();
    }

    // 不允许替换: 除水体(含水面顶层水方块) 或各类冰方块之外的其他方块
    static boolean isInvalidTarget(WorldGenLevel level, BlockPos pos)
    {
        var state = level.getBlockState(pos);
        if (state.is(Blocks.ICE) || state.is(Blocks.PACKED_ICE) || state.is(Blocks.BLUE_ICE) || state.is(Blocks.FROSTED_ICE))
            return false;

        // 水体，包括水面
        return !level.getFluidState(pos).is(FluidTags.WATER);
    }

    private static boolean placeOne(WorldGenLevel level, BlockPos pos)
    {
        var current = level.getBlockState(pos);
        if (isInvalidTarget(level, pos))
            return false;
        if (current.is(EnrollBlocks.SIX_PHASE_ICE_BLOCK.get()))
            return false;
        return level.setBlock(pos, EnrollBlocks.SIX_PHASE_ICE_BLOCK.get().defaultBlockState(), 3);
    }

    // 从起点向周围随机扩散，形成小簇
    private static int placeCluster(WorldGenLevel level, BlockPos start, RandomSource random)
    {
        int placed = 0;

        if (placeOne(level, start)) placed++;

        // 簇大小 3~8
        int clusterSize = 3 + random.nextInt(6);

        BlockPos current = start;
        // 通过多次邻近随机尝试扩散，优先在近邻处扎堆
        for (int tries = 0; tries < clusterSize * 4 && placed < clusterSize; tries++)
        {
            BlockPos next = current.offset(random.nextInt(3) - 1, random.nextInt(3) - 1, random.nextInt(3) - 1);

            if (isWithoutWorldBounds(level, next))
                continue;
            if (!level.getBiome(next).value().coldEnoughToSnow(next))
                continue;
            if (isInvalidTarget(level, next))
                continue;

            if (placeOne(level, next))
            {
                placed++;
                // 让扩散中心逐步移动，促使形成“团簇”
                current = next;
            }
        }
        return placed;
    }
}