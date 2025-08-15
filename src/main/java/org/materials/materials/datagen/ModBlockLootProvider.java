package org.materials.materials.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import org.materials.materials.EnrollBlocks;

import java.util.Set;
import java.util.stream.Collectors;

public class ModBlockLootProvider extends BlockLootSubProvider
{
    public ModBlockLootProvider(HolderLookup.Provider registries)
    {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), registries);
    }

    @Override
    protected void generate()
    {
        // 所有简单方块默认掉落自身
        dropSelf(EnrollBlocks.EXP_BLOCK.get());
        dropSelf(EnrollBlocks.FRAGILE_PLANK_BLOCK.get());
        dropSelf(EnrollBlocks.REINFORCED_PLANK_BLOCK.get());
        dropSelf(EnrollBlocks.FRAGILE_SMOOTH_STONE_BLOCK.get());
        dropSelf(EnrollBlocks.REINFORCED_SMOOTH_STONE_BLOCK.get());
        dropSelf(EnrollBlocks.BORDERLESS_GLASS_BLOCK.get());
        dropSelf(EnrollBlocks.HIGH_STRENGTH_GLASS_BLOCK.get());
        dropSelf(EnrollBlocks.SIX_PHASE_ICE_BLOCK.get());
        dropSelf(EnrollBlocks.SYNTHETIC_REINFORCED_DEEPSLATE_BLOCK.get());
        dropSelf(EnrollBlocks.FRAGILE_DEEPSLATE_BLOCK.get());
        dropSelf(EnrollBlocks.REINFORCED_SANDSTONE_BLOCK.get());
        dropSelf(EnrollBlocks.REINFORCED_RED_SANDSTONE_BLOCK.get());
        dropSelf(EnrollBlocks.REINFORCED_TUFF_BLOCK.get());
        dropSelf(EnrollBlocks.REINFORCED_NETHERRACK_BLOCK.get());
        dropSelf(EnrollBlocks.REINFORCED_BASALT_BLOCK.get());
        dropSelf(EnrollBlocks.REINFORCED_BLACKSTONE_BLOCK.get());
        dropSelf(EnrollBlocks.FRAGILE_END_STONE_BLOCK.get());
        dropSelf(EnrollBlocks.REINFORCED_END_STONE_BLOCK.get());
        dropSelf(EnrollBlocks.SYNTHETIC_OBSIDIAN_BLOCK.get());
        dropSelf(EnrollBlocks.REINFORCED_GRANITE_BLOCK.get());
        dropSelf(EnrollBlocks.REINFORCED_DIORITE_BLOCK.get());
        dropSelf(EnrollBlocks.REINFORCED_ANDESITE_BLOCK.get());
        dropSelf(EnrollBlocks.DISSOLVED_STONE_BLOCK.get());
        dropSelf(EnrollBlocks.IMITATION_BEDROCK_BLOCK.get());
        // 条件性添加萤火虫灌木掉落表
        if (EnrollBlocks.FIREFLY_BUSH != null)
        {
            add(EnrollBlocks.FIREFLY_BUSH.get(),
                    createShearsOnlyDrop(EnrollBlocks.FIREFLY_BUSH.get()));
        }
    }

    @Override
    protected Iterable<Block> getKnownBlocks()
    {
        return EnrollBlocks.BLOCKS.getEntries().stream()
                .map(h -> (Block) h.get())
                .collect(Collectors.toSet());
    }
}
