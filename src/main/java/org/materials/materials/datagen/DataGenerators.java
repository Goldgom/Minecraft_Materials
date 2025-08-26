package org.materials.materials.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.materials.materials.Materials;

import java.util.concurrent.CompletableFuture;

@Mod.EventBusSubscriber(modid = Materials.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGenerators 
{
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) 
    {
        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();

        // 添加战利品表提供器
        generator.addProvider(event.includeServer(), new ModLootTableProvider(packOutput, lookupProvider));

        // 方块标签
        generator.addProvider(event.includeServer(), new ModBlockTagsProvider(packOutput, lookupProvider, existingFileHelper));

        // 世界生成与配方
        generator.addProvider(event.includeServer(), new ModWorldGenProvider(packOutput, lookupProvider));
        generator.addProvider(event.includeServer(), new ModRecipeProvider(packOutput));
    }
}
