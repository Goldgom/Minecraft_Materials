package org.materials.materials;

import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModFeatures
{
    public static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(ForgeRegistries.FEATURES, Materials.MODID);

    public static final RegistryObject<DissolvedStoneFeature> DISSOLVED_STONE_FEATURE = FEATURES.register("dissolved_stone",
            () -> new DissolvedStoneFeature(NoneFeatureConfiguration.CODEC));

    public static final RegistryObject<FireflyBushFeature> FIREFLY_BUSH_FEATURE = FEATURES.register("firefly_bush",
            () -> new FireflyBushFeature(NoneFeatureConfiguration.CODEC));

    public static final RegistryObject<Feature<NoneFeatureConfiguration>> SIX_PHASE_ICE_FEATURE = FEATURES.register("six_phase_ice",
            () -> new SixPhaseIceFeature(NoneFeatureConfiguration.CODEC));
}
