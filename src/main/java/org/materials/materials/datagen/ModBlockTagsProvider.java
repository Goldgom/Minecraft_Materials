package org.materials.materials.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.materials.materials.EnrollBlocks;
import org.materials.materials.Materials;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagsProvider extends BlockTagsProvider
{

    public ModBlockTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, ExistingFileHelper existingFileHelper)
    {
        super(output, lookupProvider, Materials.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(@javax.annotation.Nonnull HolderLookup.Provider provider)
    {
        // 条件性添加标签
        if (EnrollBlocks.FIREFLY_BUSH != null)
        {
            tag(Materials.MINEABLE_WITH_SHEARS)
                    .add(EnrollBlocks.FIREFLY_BUSH.get());
        }

        // 斧头开采
        tag(BlockTags.MINEABLE_WITH_AXE)
                .add(EnrollBlocks.EXP_BLOCK.get())
                .add(EnrollBlocks.FRAGILE_PLANK_BLOCK.get())
                .add(EnrollBlocks.REINFORCED_PLANK_BLOCK.get());

        // 镐子开采
        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(EnrollBlocks.FRAGILE_SMOOTH_STONE_BLOCK.get())
                .add(EnrollBlocks.REINFORCED_SMOOTH_STONE_BLOCK.get())
                .add(EnrollBlocks.BORDERLESS_GLASS_BLOCK.get())
                .add(EnrollBlocks.HIGH_STRENGTH_GLASS_BLOCK.get())
                .add(EnrollBlocks.SIX_PHASE_ICE_BLOCK.get())
                .add(EnrollBlocks.SYNTHETIC_REINFORCED_DEEPSLATE_BLOCK.get())
                .add(EnrollBlocks.FRAGILE_DEEPSLATE_BLOCK.get())
                .add(EnrollBlocks.REINFORCED_SANDSTONE_BLOCK.get())
                .add(EnrollBlocks.REINFORCED_RED_SANDSTONE_BLOCK.get())
                .add(EnrollBlocks.REINFORCED_TUFF_BLOCK.get())
                .add(EnrollBlocks.REINFORCED_NETHERRACK_BLOCK.get())
                .add(EnrollBlocks.REINFORCED_BASALT_BLOCK.get())
                .add(EnrollBlocks.REINFORCED_BLACKSTONE_BLOCK.get())
                .add(EnrollBlocks.FRAGILE_END_STONE_BLOCK.get())
                .add(EnrollBlocks.REINFORCED_END_STONE_BLOCK.get())
                .add(EnrollBlocks.SYNTHETIC_OBSIDIAN_BLOCK.get())
                .add(EnrollBlocks.REINFORCED_GRANITE_BLOCK.get())
                .add(EnrollBlocks.REINFORCED_DIORITE_BLOCK.get())
                .add(EnrollBlocks.REINFORCED_ANDESITE_BLOCK.get())
                .add(EnrollBlocks.DISSOLVED_STONE_BLOCK.get())
                .add(EnrollBlocks.IMITATION_BEDROCK_BLOCK.get());

        // 需要石质工具
        tag(BlockTags.NEEDS_STONE_TOOL)
                .add(EnrollBlocks.FRAGILE_DEEPSLATE_BLOCK.get())
                .add(EnrollBlocks.REINFORCED_SANDSTONE_BLOCK.get())
                .add(EnrollBlocks.REINFORCED_RED_SANDSTONE_BLOCK.get());

        // 需要铁质工具（按日志）
        tag(BlockTags.NEEDS_IRON_TOOL)
                .add(EnrollBlocks.EXP_BLOCK.get())
                .add(EnrollBlocks.REINFORCED_SMOOTH_STONE_BLOCK.get());

        // 需要金质工具（自定义 TagKey，参照日志）
        tag(org.materials.materials.Materials.NEEDS_GOLDEN_TOOL)
                .add(EnrollBlocks.REINFORCED_PLANK_BLOCK.get())
                .add(EnrollBlocks.BORDERLESS_GLASS_BLOCK.get())
                .add(EnrollBlocks.REINFORCED_TUFF_BLOCK.get())
                .add(EnrollBlocks.REINFORCED_NETHERRACK_BLOCK.get())
                .add(EnrollBlocks.REINFORCED_BASALT_BLOCK.get())
                .add(EnrollBlocks.REINFORCED_BLACKSTONE_BLOCK.get())
                .add(EnrollBlocks.REINFORCED_GRANITE_BLOCK.get())
                .add(EnrollBlocks.REINFORCED_DIORITE_BLOCK.get())
                .add(EnrollBlocks.REINFORCED_ANDESITE_BLOCK.get());

        // 需要钻石工具（按日志）
        tag(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(EnrollBlocks.REINFORCED_END_STONE_BLOCK.get());

        // 需要下界合金工具（自定义 TagKey，参照日志）
        tag(org.materials.materials.Materials.NEEDS_NETHERITE_TOOL)
                .add(EnrollBlocks.HIGH_STRENGTH_GLASS_BLOCK.get())
                .add(EnrollBlocks.SYNTHETIC_REINFORCED_DEEPSLATE_BLOCK.get())
                .add(EnrollBlocks.SYNTHETIC_OBSIDIAN_BLOCK.get())
                .add(EnrollBlocks.IMITATION_BEDROCK_BLOCK.get());

        // 禁止雪层在“六相冰”上生成
        tag(BlockTags.SNOW_LAYER_CANNOT_SURVIVE_ON).add(EnrollBlocks.SIX_PHASE_ICE_BLOCK.get());
    }
}
