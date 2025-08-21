// java
package org.materials.materials.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;
import org.materials.materials.EnrollBlocks;
import org.materials.materials.Materials;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagsProvider extends BlockTagsProvider
{
    public ModBlockTagsProvider(PackOutput output,
                                CompletableFuture<HolderLookup.Provider> lookupProvider,
                                ExistingFileHelper existingFileHelper)
    {
        super(output, lookupProvider, Materials.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.@NotNull Provider provider)
    {
        // 禁止雪层在“六相冰”上生成
        tag(BlockTags.SNOW_LAYER_CANNOT_SURVIVE_ON).add(EnrollBlocks.SIX_PHASE_ICE_BLOCK.get());
    }
}