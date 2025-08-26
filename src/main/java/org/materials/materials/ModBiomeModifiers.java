package org.materials.materials;

import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.biome.Biome;
import net.neoforged.neoforge.common.world.BiomeModifier;
import net.neoforged.neoforge.common.world.BiomeModifiers;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

public class ModBiomeModifiers 
{
    public static final ResourceKey<BiomeModifier> ADD_DISSOLVED_STONE = registerKey("add_dissolved_stone");
    public static final ResourceKey<BiomeModifier> ADD_FIREFLY_BUSH = registerKey("add_firefly_bush");
    public static final ResourceKey<BiomeModifier> ADD_SIX_PHASE_ICE = registerKey("add_six_phase_ice");
    public static void bootstrap(BootstrapContext<BiomeModifier> context)
    {
        var placedFeatures = context.lookup(Registries.PLACED_FEATURE);
        var biomes = context.lookup(Registries.BIOME);

        context.register(ADD_DISSOLVED_STONE, new BiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                HolderSet.direct(placedFeatures.getOrThrow(ModConfiguredFeatures.DISSOLVED_STONE_PLACED_KEY)),
                net.minecraft.world.level.levelgen.GenerationStep.Decoration.UNDERGROUND_ORES));

        if (ModFeatures.FIREFLY_BUSH_FEATURE != null) 
        {
            context.register(ADD_FIREFLY_BUSH, new BiomeModifiers.AddFeaturesBiomeModifier(
                    biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                    HolderSet.direct(placedFeatures.getOrThrow(ModConfiguredFeatures.FIREFLY_BUSH_PLACED_KEY)),
                    net.minecraft.world.level.levelgen.GenerationStep.Decoration.VEGETAL_DECORATION));
        }

        context.register(ADD_SIX_PHASE_ICE, new BiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                HolderSet.direct(placedFeatures.getOrThrow(ModConfiguredFeatures.SIX_PHASE_ICE_PLACED_KEY)),
                net.minecraft.world.level.levelgen.GenerationStep.Decoration.VEGETAL_DECORATION));
    }

    private static ResourceKey<BiomeModifier> registerKey(String name) 
    {
        return ResourceKey.create(NeoForgeRegistries.Keys.BIOME_MODIFIERS, ResourceLocation.fromNamespaceAndPath(Materials.MODID, name));
    }
}
