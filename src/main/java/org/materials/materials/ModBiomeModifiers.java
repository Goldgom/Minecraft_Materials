// java
package org.materials.materials;

import net.minecraft.core.HolderGetter;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.common.world.ForgeBiomeModifiers;

public class ModBiomeModifiers
{
    public static final ResourceKey<BiomeModifier> ADD_FIREFLY_BUSH =
            ResourceKey.create(net.minecraftforge.registries.ForgeRegistries.Keys.BIOME_MODIFIERS,
                    ResourceLocation.fromNamespaceAndPath(Materials.MODID, "add_firefly_bush"));

    public static final ResourceKey<BiomeModifier> ADD_DISSOLVED_STONE =
            ResourceKey.create(net.minecraftforge.registries.ForgeRegistries.Keys.BIOME_MODIFIERS,
                    ResourceLocation.fromNamespaceAndPath(Materials.MODID, "add_dissolved_stone"));

    public static final ResourceKey<BiomeModifier> ADD_SIX_PHASE_ICE =
            ResourceKey.create(net.minecraftforge.registries.ForgeRegistries.Keys.BIOME_MODIFIERS,
                    ResourceLocation.fromNamespaceAndPath(Materials.MODID, "add_six_phase_ice"));

    public static void bootstrap(BootstapContext<BiomeModifier> ctx)
    {
        HolderGetter<PlacedFeature> placed = ctx.lookup(Registries.PLACED_FEATURE);
        HolderGetter<Biome> biomes = ctx.lookup(Registries.BIOME);

        var overworld = biomes.getOrThrow(BiomeTags.IS_OVERWORLD);

        var fireflyPlaced = placed.getOrThrow(ModConfiguredFeatures.FIREFLY_BUSH_PLACED_KEY);
        var dissolvedPlaced = placed.getOrThrow(ModConfiguredFeatures.DISSOLVED_STONE_PLACED_KEY);
        var sixPhaseIcePlaced = placed.getOrThrow(ModConfiguredFeatures.SIX_PHASE_ICE_PLACED_KEY);

        ctx.register(ADD_FIREFLY_BUSH, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                overworld,
                HolderSet.direct(fireflyPlaced),
                GenerationStep.Decoration.VEGETAL_DECORATION));

        ctx.register(ADD_DISSOLVED_STONE, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                overworld,
                HolderSet.direct(dissolvedPlaced),
                GenerationStep.Decoration.UNDERGROUND_DECORATION));

        ctx.register(ADD_SIX_PHASE_ICE, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                overworld,
                HolderSet.direct(sixPhaseIcePlaced),
                GenerationStep.Decoration.VEGETAL_DECORATION));
    }
}