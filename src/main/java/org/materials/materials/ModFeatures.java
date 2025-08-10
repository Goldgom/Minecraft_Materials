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
}
