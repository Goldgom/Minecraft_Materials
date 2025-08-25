package org.materials.materials;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import static org.materials.materials.Materials.*;

public class EnrollItems
{
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(MODID);
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MODID);

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> MATERIALS_TAB = CREATIVE_MODE_TABS.register("example_tab", () ->
            CreativeModeTab.builder().title(Component.translatable("creative_tab.materials.example_tab"))
                    .withTabsBefore(CreativeModeTabs.COMBAT)
                    .icon(() -> EnrollBlocks.REINFORCED_SMOOTH_STONE_BLOCK_ITEM.get().getDefaultInstance())
                    .displayItems((parameters, output) ->
                    {
                        output.accept(EnrollBlocks.EXP_BLOCK_ITEM.get());
                        output.accept(EnrollBlocks.FRAGILE_PLANK_BLOCK_ITEM.get());
                        output.accept(EnrollBlocks.REINFORCED_PLANK_BLOCK_ITEM.get());
                        output.accept(EnrollBlocks.REINFORCED_SMOOTH_STONE_BLOCK_ITEM.get());
                        output.accept(EnrollBlocks.FRAGILE_SMOOTH_STONE_BLOCK_ITEM.get());
                        output.accept(EnrollBlocks.BORDERLESS_GLASS_BLOCK_ITEM.get());
                        output.accept(EnrollBlocks.HIGH_STRENGTH_GLASS_BLOCK_ITEM.get());
                        output.accept(EnrollBlocks.SIX_PHASE_ICE_BLOCK_ITEM.get());
                        output.accept(EnrollBlocks.SYNTHETIC_REINFORCED_DEEPSLATE_BLOCK_ITEM.get());
                        output.accept(EnrollBlocks.FRAGILE_DEEPSLATE_BLOCK_ITEM.get());
                        output.accept(EnrollBlocks.REINFORCED_SANDSTONE_BLOCK_ITEM.get());
                        output.accept(EnrollBlocks.REINFORCED_RED_SANDSTONE_BLOCK_ITEM.get());
                        output.accept(EnrollBlocks.REINFORCED_TUFF_BLOCK_ITEM.get());
                        output.accept(EnrollBlocks.REINFORCED_NETHERRACK_BLOCK_ITEM.get());
                        output.accept(EnrollBlocks.REINFORCED_BASALT_BLOCK_ITEM.get());
                        output.accept(EnrollBlocks.REINFORCED_BLACKSTONE_BLOCK_ITEM.get());
                        output.accept(EnrollBlocks.FRAGILE_END_STONE_BLOCK_ITEM.get());
                        output.accept(EnrollBlocks.REINFORCED_END_STONE_BLOCK_ITEM.get());
                        output.accept(EnrollBlocks.SYNTHETIC_OBSIDIAN_BLOCK_ITEM.get());
                        output.accept(EnrollBlocks.REINFORCED_GRANITE_BLOCK_ITEM.get());
                        output.accept(EnrollBlocks.REINFORCED_DIORITE_BLOCK_ITEM.get());
                        output.accept(EnrollBlocks.REINFORCED_ANDESITE_BLOCK_ITEM.get());
                        output.accept(EnrollBlocks.DISSOLVED_STONE_BLOCK_ITEM.get());
                        output.accept(EnrollBlocks.IMITATION_BEDROCK_BLOCK_ITEM.get());
                        // 条件性添加萤火虫灌木
                        if (EnrollBlocks.FIREFLY_BUSH_ITEM != null)
                        {
                            output.accept(EnrollBlocks.FIREFLY_BUSH_ITEM.get());
                        }
                    })
                    .build());
}
