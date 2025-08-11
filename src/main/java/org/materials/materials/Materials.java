package org.materials.materials;

import com.mojang.logging.LogUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

@Mod(Materials.MODID)
public class Materials
{
    public static final String MODID = "materials";
    static final Logger LOGGER = LogUtils.getLogger();

    // 注册方块的注册表
    public static final TagKey<Block> NEEDS_GOLDEN_TOOL = BlockTags.create(ResourceLocation.fromNamespaceAndPath("minecraft", "needs_golden_tool"));
    public static final TagKey<Block> NEEDS_NETHERITE_TOOL = BlockTags.create(ResourceLocation.fromNamespaceAndPath("minecraft", "needs_netherite_tool"));

    public Materials(FMLJavaModLoadingContext context)
    {
        IEventBus modEventBus = context.getModEventBus();

        // 注册自己的注册表
        EnrollBlocks.BLOCKS.register(modEventBus);
        EnrollBlocks.ITEMS.register(modEventBus);
        EnrollBlocks.CREATIVE_MODE_TABS.register(modEventBus);
        ModFeatures.FEATURES.register(modEventBus);

        modEventBus.addListener(EnrollBlocks::commonSetup);
        modEventBus.addListener(EnrollBlocks::addCreative);
        MinecraftForge.EVENT_BUS.register(this);
        context.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {
        LOGGER.info("HELLO from server starting");
    }

    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {
            LOGGER.info("HELLO FROM CLIENT SETUP");
            LOGGER.info("MINECRAFT NAME >> {}", Minecraft.getInstance().getUser().getName());

            if (net.minecraftforge.fml.ModList.get().isLoaded("extendedblocks"))
            {
                // 执行联动代码
                LOGGER.info("Mod extendedblocks is loaded.");
            }

            event.enqueueWork(() ->
            {
                ItemBlockRenderTypes.setRenderLayer(EnrollBlocks.BORDERLESS_GLASS_BLOCK.get(), RenderType.translucent());
                ItemBlockRenderTypes.setRenderLayer(EnrollBlocks.HIGH_STRENGTH_GLASS_BLOCK.get(), RenderType.translucent());
                ItemBlockRenderTypes.setRenderLayer(EnrollBlocks.SIX_PHASE_ICE_BLOCK.get(), RenderType.translucent());
            });
        }
    }
}