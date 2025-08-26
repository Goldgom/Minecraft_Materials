package org.materials.materials;

import com.mojang.logging.LogUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.TieredItem;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.level.block.Block;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
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
    public static final TagKey<Block> MINEABLE_WITH_SHEARS = BlockTags.create(ResourceLocation.fromNamespaceAndPath("minecraft", "mineable/shears"));

    public Materials(FMLJavaModLoadingContext context)
    {
        IEventBus modEventBus = context.getModEventBus();

        // 注册自己的注册表
        EnrollBlocks.BLOCKS.register(modEventBus);
        EnrollBlocks.ITEMS.register(modEventBus);
        EnrollItems.CREATIVE_MODE_TABS.register(modEventBus);
        EnrollItems.ITEMS.register(modEventBus);

        ModFeatures.FEATURES.register(modEventBus);

        modEventBus.addListener(EnrollBlocks::commonSetup);
        modEventBus.addListener(EnrollBlocks::addCreative);

        // 添加酿造配方监听器
        modEventBus.addListener(EnrollItems::commonSetup);

        MinecraftForge.EVENT_BUS.register(this);
        context.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {
        LOGGER.info("HELLO from server starting");

        if (net.minecraftforge.fml.ModList.get().isLoaded("extended_blocks"))
        {
            // 执行联动代码
            LOGGER.info("Mod extended_blocks in server is loaded.");
        }
    }

    // 自定义开采层级校验：金及以上、下界合金及以上
    @SubscribeEvent
    public void onHarvestCheck(PlayerEvent.HarvestCheck event)
    {
        BlockState state = event.getTargetBlock();
        if (state == null)
            return;

        // 仅当方块被标记到自定义标签时介入
        Tier required = null;
        if (state.is(NEEDS_NETHERITE_TOOL))
        {
            required = Tiers.NETHERITE;
        }
        else if (state.is(NEEDS_GOLDEN_TOOL))
        {
            required = Tiers.GOLD;
        }
        else
        {
            return; // 未标记则不干预默认判定
        }

        if (event.getEntity() != null && event.getEntity().isCreative())
            return; // 创造模式不拦截

        ItemStack stack = event.getEntity() != null ? event.getEntity().getMainHandItem() : ItemStack.EMPTY;
        boolean allowed = (required == Tiers.NETHERITE) ? isAllowedForNetherite(stack) : isAllowedForGolden(stack);
        if (!allowed)
        {
            event.setCanHarvest(false);
        }
    }

    // 金及以上：允许 金/铁/钻石/下界合金
    private static boolean isAllowedForGolden(ItemStack stack)
    {
        if (!(stack.getItem() instanceof TieredItem tiered))
            return false; // 非分层工具不允许

        Tier actual = tiered.getTier();
        return actual == Tiers.GOLD || actual == Tiers.IRON || actual == Tiers.DIAMOND || actual == Tiers.NETHERITE;
    }

    // 下界合金及以上：仅允许 下界合金
    private static boolean isAllowedForNetherite(ItemStack stack)
    {
        if (!(stack.getItem() instanceof TieredItem tiered))
            return false;

        Tier actual = tiered.getTier();
        return actual == Tiers.NETHERITE;
    }

    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        @SuppressWarnings({"removal"}) // ItemBlockRenderTypes.setRenderLayer 将在 1.21.4 版本弃用移除，这里抑制警告
        public static void onClientSetup(FMLClientSetupEvent event)
        {
            LOGGER.info("HELLO FROM CLIENT SETUP");
            LOGGER.info("MINECRAFT NAME >> {}", Minecraft.getInstance().getUser().getName());

            if (net.minecraftforge.fml.ModList.get().isLoaded("extended_blocks"))
            {
                // 执行联动代码
                LOGGER.info("Mod extended_blocks is loaded.");
            }

            event.enqueueWork(() ->
            {
                ItemBlockRenderTypes.setRenderLayer(EnrollBlocks.BORDERLESS_GLASS_BLOCK.get(), RenderType.translucent());
                ItemBlockRenderTypes.setRenderLayer(EnrollBlocks.HIGH_STRENGTH_GLASS_BLOCK.get(), RenderType.translucent());
                ItemBlockRenderTypes.setRenderLayer(EnrollBlocks.SIX_PHASE_ICE_BLOCK.get(), RenderType.translucent());
                ItemBlockRenderTypes.setRenderLayer(EnrollBlocks.FIREFLY_BUSH.get(), RenderType.cutout());
            });
        }
    }
}