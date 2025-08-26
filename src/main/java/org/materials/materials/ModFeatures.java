package org.materials.materials;

import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.jetbrains.annotations.NotNull;

import static org.materials.materials.Materials.MODID;

public class ModFeatures
{
    public static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(Registries.FEATURE, MODID);

    // 仅在萤火虫灌木存在时注册特性
    public static final DeferredHolder<Feature<?>, FireflyBushFeature> FIREFLY_BUSH_FEATURE  =
            EnrollBlocks.FIREFLY_BUSH != null
                    ? FEATURES.register("firefly_bush", () -> new FireflyBushFeature(NoneFeatureConfiguration.CODEC))
                    : null;

    public static final DeferredHolder<Feature<?>, DissolvedStoneFeature> DISSOLVED_STONE_FEATURE = FEATURES.register("dissolved_stone",
            () -> new DissolvedStoneFeature(NoneFeatureConfiguration.CODEC));

    public static final DeferredHolder<Feature<?>, SixPhaseIceFeature> SIX_PHASE_ICE_FEATURE = FEATURES.register("six_phase_ice",
            () -> new SixPhaseIceFeature(NoneFeatureConfiguration.CODEC));
}
