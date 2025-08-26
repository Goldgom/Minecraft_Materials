// java
package org.materials.materials;

import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import javax.annotation.Nonnull;

public class FireflyBushFeature extends Feature<NoneFeatureConfiguration>
{
    public FireflyBushFeature(Codec<NoneFeatureConfiguration> codec)
    {
        super(codec);
    }

    @Override
    public boolean place(@Nonnull FeaturePlaceContext<NoneFeatureConfiguration> ctx)
    {
        BlockPos pos = ctx.origin();
        WorldGenLevel level = ctx.level();
        RandomSource random = ctx.random();

        // 位置必须是空气
        if (!level.getBlockState(pos).isAir())
            return false;

        // 用方块自身的生存规则校验地面（复用 mayPlaceOn）
        if (!EnrollBlocks.FIREFLY_BUSH.get().defaultBlockState().canSurvive(level, pos))
            return false;

        // 1.5% 概率生成
        if (random.nextFloat() < 0.015f)
        {
            level.setBlock(pos, EnrollBlocks.FIREFLY_BUSH.get().defaultBlockState(), 3);
            return true;
        }
        return false;
    }
}