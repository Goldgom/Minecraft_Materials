// java
package org.materials.materials;

import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.*;

import java.util.List;

public class ModPlacedFeatures
{
    public static void bootstrap(BootstrapContext<PlacedFeature> context)
    {
        HolderGetter<ConfiguredFeature<?, ?>> configured = context.lookup(Registries.CONFIGURED_FEATURE);

        // 溶蚀石头：每区块尝试 32 次，限制 y < 10
        register(context, ModConfiguredFeatures.DISSOLVED_STONE_PLACED_KEY,
                configured.getOrThrow(ModConfiguredFeatures.DISSOLVED_STONE_KEY),
                List.of(
                        CountPlacement.of(32),
                        InSquarePlacement.spread(),
                        HeightRangePlacement.uniform(VerticalAnchor.bottom(), VerticalAnchor.absolute(10)),
                        BiomeFilter.biome()
                ));

        // 萤火虫灌木丛：每区块尝试 32 次（生成概率在 FireflyBushFeature 内部控制），在地表高度放置
        register(context, ModConfiguredFeatures.FIREFLY_BUSH_PLACED_KEY,
                configured.getOrThrow(ModConfiguredFeatures.FIREFLY_BUSH_KEY),
                List.of(
                        CountPlacement.of(32),
                        InSquarePlacement.spread(),
                        PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
                        BiomeFilter.biome()
                ));

        // “六相冰”：地表高度放置，概率与环境限制在特性内控制
        register(context, ModConfiguredFeatures.SIX_PHASE_ICE_PLACED_KEY,
                configured.getOrThrow(ModConfiguredFeatures.SIX_PHASE_ICE_KEY),
                List.of(
                        CountPlacement.of(32),
                        InSquarePlacement.spread(),
                        PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
                        BiomeFilter.biome()
                ));
    }

    private static void register(BootstrapContext<PlacedFeature> context,
                                 net.minecraft.resources.ResourceKey<PlacedFeature> key,
                                 Holder<ConfiguredFeature<?, ?>> cfg,
                                 List<PlacementModifier> modifiers)
    {
        context.register(key, new PlacedFeature(cfg, List.copyOf(modifiers)));
    }
}