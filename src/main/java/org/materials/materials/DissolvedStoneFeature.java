package org.materials.materials;

import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

public class DissolvedStoneFeature extends Feature<NoneFeatureConfiguration>
{
    public DissolvedStoneFeature(Codec<NoneFeatureConfiguration> codec)
    {
        super(codec);
    }

    @Override
    public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> context)
    {
        BlockPos pos = context.origin();
        var level = context.level();
        RandomSource random = context.random();

        // 仅在主世界生成
        if (level instanceof net.minecraft.world.level.WorldGenLevel)
        {
            net.minecraft.world.level.WorldGenLevel worldGenLevel = (net.minecraft.world.level.WorldGenLevel) level;
            if (!worldGenLevel.getLevel().dimension().equals(Level.OVERWORLD))
            {
                return false;
            }
        }

        // 只在y<10生成
        if (pos.getY() >= 10) return false;

        // 检查周围5x5x5是否有滴水石
        boolean nearDripstone = false;
        BlockPos.MutableBlockPos checkPos = new BlockPos.MutableBlockPos();
        for (int dx = -2; dx <= 2; dx++)
        {
            for (int dy = -2; dy <= 2; dy++)
            {
                for (int dz = -2; dz <= 2; dz++)
                {
                    checkPos.set(pos.getX() + dx, pos.getY() + dy, pos.getZ() + dz);
                    BlockState state = level.getBlockState(checkPos);
                    if (state.is(Blocks.POINTED_DRIPSTONE) || state.is(Blocks.DRIPSTONE_BLOCK))
                    {
                        nearDripstone = true;
                        break;
                    }
                }
                if (nearDripstone) break;
            }
            if (nearDripstone) break;
        }

        // 10%概率生成
        if (nearDripstone && random.nextFloat() < 0.1f)
        {
            level.setBlock(pos, EnrollBlocks.DISSOLVED_STONE_BLOCK.get().defaultBlockState(), 2);
            return true;
        }
        return false;
    }
}