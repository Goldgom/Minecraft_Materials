package org.materials.materials;

import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

public class ModConfiguredFeatures 
{
    public static final ResourceKey<ConfiguredFeature<?, ?>> DISSOLVED_STONE_KEY = registerKey("dissolved_stone");
    public static final ResourceKey<PlacedFeature> DISSOLVED_STONE_PLACED_KEY = registerPlacedKey("dissolved_stone");
    public static final ResourceKey<ConfiguredFeature<?, ?>> FIREFLY_BUSH_KEY = registerKey("firefly_bush");
    public static final ResourceKey<PlacedFeature> FIREFLY_BUSH_PLACED_KEY = registerPlacedKey("firefly_bush");
    public static final ResourceKey<ConfiguredFeature<?, ?>> SIX_PHASE_ICE_KEY = registerKey("six_phase_ice");
    public static final ResourceKey<PlacedFeature> SIX_PHASE_ICE_PLACED_KEY = registerPlacedKey("six_phase_ice");

    public static void bootstrap(BootstrapContext<ConfiguredFeature<?, ?>> context)
    {
        // 添加溶蚀石头特征
        register(context, DISSOLVED_STONE_KEY, ModFeatures.DISSOLVED_STONE_FEATURE.get(),
                new NoneFeatureConfiguration());

        // 添加萤火虫灌木特征（如果存在）
        if (ModFeatures.FIREFLY_BUSH_FEATURE != null) 
        {
            register(context, FIREFLY_BUSH_KEY, ModFeatures.FIREFLY_BUSH_FEATURE.get(), new NoneFeatureConfiguration());
        }

        // 添加六相冰特征
        register(context, SIX_PHASE_ICE_KEY, ModFeatures.SIX_PHASE_ICE_FEATURE.get(), new NoneFeatureConfiguration());
    }

    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) 
    {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, ResourceLocation.fromNamespaceAndPath(Materials.MODID, name));
    }

    public static ResourceKey<PlacedFeature> registerPlacedKey(String name) 
    {
        return ResourceKey.create(Registries.PLACED_FEATURE, ResourceLocation.fromNamespaceAndPath(Materials.MODID, name));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstrapContext<ConfiguredFeature<?, ?>> context,
                                                                                          ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) 
    {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
