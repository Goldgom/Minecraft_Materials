package org.materials.materials;

import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.GlassBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;

import static org.materials.materials.Materials.*;

public class EnrollBlocks
{
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MODID);
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MODID);

    static final List<Consumer<BuildCreativeModeTabContentsEvent>> externalHandlers = new ArrayList<>();

    // 注册名为 示例方块 的方块，采用石头颜色的默认属性
    public static final RegistryObject<Block> EXP_BLOCK = BLOCKS.register("exp", () ->
            new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.WOOD) // 设置方块的颜色为木头颜色
                    .strength(1.5f, 6.0f) // 设置方块的硬度和爆炸抗性
                    .requiresCorrectToolForDrops() // 需要正确的工具才能掉落物品
                    .sound(SoundType.WOOD) // 设置方块破坏时的音效
                    .lightLevel((state) -> 15) // 设置方块的光照等级
            )
    );

    // 注册名为 萤火虫灌木丛 的方块，采用植物颜色的默认属性
    public static final RegistryObject<Block> FIREFLY_BUSH = BLOCKS.register("firefly_bush", () ->
            new FireflyBushBlock(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.PLANT) // 设置方块的颜色为植物颜色
                    .noCollission() // 设置方块不会阻塞碰撞
                    .instabreak() // 设置方块可以瞬间破坏
                    .sound(SoundType.GRASS) // 设置方块破坏时的音效
                    .lightLevel((state) -> 7) // 设置方块的光照等级
            )
    );

    // 注册名为 脆弱木板 的方块，采用木头颜色的默认属性
    public static final RegistryObject<Block> FRAGILE_PLANK_BLOCK = BLOCKS.register("fragile_plank", () ->
            new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.WOOD) // 设置方块的颜色为木头颜色
                    .strength(0.125f, 0.1f) // 设置方块的硬度和爆炸抗性
                    .sound(SoundType.WOOD) // 设置方块破坏时的音效
                    .lightLevel((state) -> 0) // 设置方块的光照等级
            )
    );
    // 注册名为 强化木板 的方块，采用木头颜色的默认属性
    public static final RegistryObject<Block> REINFORCED_PLANK_BLOCK = BLOCKS.register("reinforced_plank", () ->
            new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.WOOD) // 设置方块的颜色为木头颜色
                    .strength(4.0f, 10.0f) // 设置方块的硬度和爆炸抗性
                    .requiresCorrectToolForDrops() // 需要正确的工具才能掉落物品
                    .sound(SoundType.WOOD) // 设置方块破坏时的音效
                    .lightLevel((state) -> 0) // 设置方块的光照等级
            )
    );
    // 注册名为 脆弱平滑石头 的方块，采用石头颜色的默认属性
    public static final RegistryObject<Block> FRAGILE_SMOOTH_STONE_BLOCK = BLOCKS.register("fragile_smooth_stone", () ->
            new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.STONE) // 设置方块的颜色为石头颜色
                    .strength(1.5f, 6.0f) // 设置方块的硬度和爆炸抗性
                    .requiresCorrectToolForDrops() // 需要正确的工具才能掉落物品
                    .sound(SoundType.STONE) // 设置方块破坏时的音效
                    .lightLevel((state) -> 0) // 设置方块的光照等级
            )
    );
    // 注册名为 强化平滑石头 的方块，采用石头颜色的默认属性
    public static final RegistryObject<Block> REINFORCED_SMOOTH_STONE_BLOCK = BLOCKS.register("reinforced_smooth_stone", () ->
            new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.STONE) // 设置方块的颜色为石头颜色
                    .strength(10.0f, 60.0f) // 设置方块的硬度和爆炸抗性
                    .requiresCorrectToolForDrops() // 需要正确的工具才能掉落物品
                    .sound(SoundType.STONE) // 设置方块破坏时的音效
                    .lightLevel((state) -> 0) // 设置方块的光照等级
            )
    );
    // 注册名为 强化石砖 的方块，采用石头颜色的默认属性
    public static final RegistryObject<Block> REINFORCED_STONE_BRICKS_BLOCK = BLOCKS.register("reinforced_stone_bricks", () ->
            new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.STONE) // 设置方块的颜色为石头颜色
                    .strength(16.0f, 72.0f) // 设置方块的硬度和爆炸抗性
                    .requiresCorrectToolForDrops() // 需要正确的工具才能掉落物品
                    .sound(SoundType.STONE) // 设置方块破坏时的音效
                    .lightLevel((state) -> 0) // 设置方块的光照等级
            )
    );
    // 注册名为 强化雕刻石砖 的方块，采用石头颜色的默认属性
    public static final RegistryObject<Block> REINFORCED_CHISELED_STONE_BRICKS_BLOCK = BLOCKS.register("reinforced_chiseled_stone_bricks", () ->
            new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.STONE) // 设置方块的颜色为石头颜色
                    .strength(16.0f, 72.0f) // 设置方块的硬度和爆炸抗性
                    .requiresCorrectToolForDrops() // 需要正确的工具才能掉落物品
                    .sound(SoundType.STONE) // 设置方块破坏时的音效
                    .lightLevel((state) -> 0) // 设置方块的光照等级
            )
    );
    // 注册名为 无边框玻璃 的方块，采用玻璃颜色的默认属性
    public static final RegistryObject<Block> BORDERLESS_GLASS_BLOCK = BLOCKS.register("borderless_glass", () ->
            new GlassBlock(BlockBehaviour.Properties.copy(Blocks.GLASS) // 复制玻璃的属性
                    .strength(1.125f, 100.0f) // 设置方块的硬度和爆炸抗性
                    .noOcclusion() // 设置方块不会阻塞视线
            )
    );
    // 注册名为 高强度玻璃 的方块，采用玻璃颜色的默认属性
    public static final RegistryObject<Block> HIGH_STRENGTH_GLASS_BLOCK = BLOCKS.register("high_strength_glass", () ->
            new GlassBlock(BlockBehaviour.Properties.copy(Blocks.GLASS)
                    .strength(12.0f, 1000.0f) // 设置方块的硬度和爆炸抗性
                    .noOcclusion() // 设置方块不会阻塞视线
            )
    );
    // 注册名为 “六相冰” 的方块，采用冰颜色的默认属性
    public static final RegistryObject<SpecialIceBlock> SIX_PHASE_ICE_BLOCK = BLOCKS.register("six_phase_ice", () ->
            new SpecialIceBlock(BlockBehaviour.Properties.copy(Blocks.ICE) // 复制冰的属性
                    .strength(32.0f, 256.0f) // 设置方块的硬度和爆炸抗性
                    .friction(0.98f) // 设置方块的摩擦力
                    .noOcclusion() // 设置方块不会阻塞视线
                    .isSuffocating((state, level, pos) -> false) // 设置方块不会阻挡呼吸
                    .isViewBlocking((state, level, pos) -> false) // 设置方块不会阻塞视线
            )
    );
    // 注册名为 合成强化深板岩 的方块，采用石头颜色的默认属性
    public static final RegistryObject<Block> SYNTHETIC_REINFORCED_DEEPSLATE_BLOCK = BLOCKS.register("synthetic_reinforced_deepslate", () ->
            new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.STONE) // 设置方块的颜色为石头颜色
                    .strength(50.0f, 1200.0f) // 设置方块的硬度和爆炸抗性
                    .requiresCorrectToolForDrops() // 需要正确的工具才能掉落物品
                    .sound(SoundType.DEEPSLATE) // 设置方块破坏时的音效
                    .lightLevel((state) -> 0) // 设置方块的光照等级
            )
    );
    // 注册名为 脆弱深板岩 的方块，采用石头颜色的默认属性
    public static final RegistryObject<Block> FRAGILE_DEEPSLATE_BLOCK = BLOCKS.register("fragile_deepslate", () ->
            new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.STONE) // 设置方块的颜色为石头颜色
                    .strength(1.6f, 6.0f) // 设置方块的硬度和爆炸抗性
                    .requiresCorrectToolForDrops() // 需要正确的工具才能掉落物品
                    .sound(SoundType.DEEPSLATE) // 设置方块破坏时的音效
                    .lightLevel((state) -> 0) // 设置方块的光照等级
            )
    );
    // 注册名为 强化砂岩 的方块，采用石头颜色的默认属性
    public static final RegistryObject<Block> REINFORCED_SANDSTONE_BLOCK = BLOCKS.register("reinforced_sandstone", () ->
            new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.SAND) // 设置方块的颜色为沙子颜色
                    .strength(3.0f, 12.0f) // 设置方块的硬度和爆炸抗性
                    .requiresCorrectToolForDrops() // 需要正确的工具才能掉落物品
                    .sound(SoundType.SAND) // 设置方块破坏时的音效
                    .lightLevel((state) -> 0) // 设置方块的光照等级
            )
    );
    // 注册名为 强化红砂岩 的方块，采用石头颜色的默认属性
    public static final RegistryObject<Block> REINFORCED_RED_SANDSTONE_BLOCK = BLOCKS.register("reinforced_red_sandstone", () ->
            new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_ORANGE) // 设置方块的颜色为橙色
                    .strength(3.0f, 12.0f) // 设置方块的硬度和爆炸抗性
                    .requiresCorrectToolForDrops() // 需要正确的工具才能掉落物品
                    .sound(SoundType.SAND) // 设置方块破坏时的音效
                    .lightLevel((state) -> 0) // 设置方块的光照等级
            )
    );
    // 注册名为 强化凝灰岩 的方块，采用石头颜色的默认属性
    public static final RegistryObject<Block> REINFORCED_TUFF_BLOCK = BLOCKS.register("reinforced_tuff", () ->
            new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.STONE) // 设置方块的颜色为石头颜色
                    .strength(6.0f, 20.0f) // 设置方块的硬度和爆炸抗性
                    .sound(SoundType.TUFF) // 设置方块破坏时的音效
                    .lightLevel((state) -> 0) // 设置方块的光照等级
            )
    );
    // 注册名为 强化下界岩 的方块，采用石头颜色的默认属性
    public static final RegistryObject<Block> REINFORCED_NETHERRACK_BLOCK = BLOCKS.register("reinforced_netherrack", () ->
            new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.NETHER) // 设置方块的颜色为下界颜色
                    .strength(4.0f, 12.0f) // 设置方块的硬度和爆炸抗性
                    .sound(SoundType.NETHERRACK) // 设置方块破坏时的音效
                    .lightLevel((state) -> 0) // 设置方块的光照等级
            )
    );
    // 注册名为 强化下界砖块 的方块，采用石头颜色的默认属性
    public static final RegistryObject<Block> REINFORCED_NETHER_BRICKS_BLOCK = BLOCKS.register("reinforced_nether_bricks", () ->
            new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.NETHER) // 设置方块的颜色为下界颜色
                    .strength(10.0f, 72.0f) // 设置方块的硬度和爆炸抗性
                    .requiresCorrectToolForDrops() // 需要正确的工具才能掉落物品
                    .sound(SoundType.NETHER_BRICKS) // 设置方块破坏时的音效
                    .lightLevel((state) -> 0) // 设置方块的光照等级
            )
    );
    // 注册名为 强化雕琢下界砖块 的方块，采用石头颜色的默认属性
    public static final RegistryObject<Block> REINFORCED_CHISELED_NETHER_BRICKS_BLOCK = BLOCKS.register("reinforced_chiseled_nether_bricks", () ->
            new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.NETHER) // 设置方块的颜色为下界颜色
                    .strength(10.0f, 72.0f) // 设置方块的硬度和爆炸抗性
                    .requiresCorrectToolForDrops() // 需要正确的工具才能掉落物品
                    .sound(SoundType.NETHER_BRICKS) // 设置方块破坏时的音效
                    .lightLevel((state) -> 0) // 设置方块的光照等级
            )
    );
    // 注册名为 强化红色下界砖块 的方块，采用石头颜色的默认属性
    public static final RegistryObject<Block> REINFORCED_RED_NETHER_BRICKS_BLOCK = BLOCKS.register("reinforced_red_nether_bricks", () ->
            new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.NETHER) // 设置方块的颜色为下界颜色
                    .strength(10.0f, 72.0f) // 设置方块的硬度和爆炸抗性
                    .requiresCorrectToolForDrops() // 需要正确的工具才能掉落物品
                    .sound(SoundType.NETHER_BRICKS) // 设置方块破坏时的音效
                    .lightLevel((state) -> 0) // 设置方块的光照等级
            )
    );
    // 注册名为 强化玄武岩 的方块，采用石头颜色的默认属性
    public static final RegistryObject<Block> REINFORCED_BASALT_BLOCK = BLOCKS.register("reinforced_basalt", () ->
            new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.STONE) // 设置方块的颜色为石头颜色
                    .strength(5.0f, 20.0f) // 设置方块的硬度和爆炸抗性
                    .sound(SoundType.BASALT) // 设置方块破坏时的音效
                    .lightLevel((state) -> 0) // 设置方块的光照等级
            )
    );
    // 注册名为 强化平滑玄武岩 的方块，采用石头颜色的默认属性
    public static final RegistryObject<Block> REINFORCED_SMOOTH_BASALT_BLOCK = BLOCKS.register("reinforced_smooth_basalt", () ->
            new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.STONE) // 设置方块的颜色为石头颜色
                    .strength(10.0f, 64.0f) // 设置方块的硬度和爆炸抗性
                    .requiresCorrectToolForDrops() // 需要正确的工具才能掉落物品
                    .sound(SoundType.BASALT) // 设置方块破坏时的音效
                    .lightLevel((state) -> 0) // 设置方块的光照等级
            )
    );
    // 注册名为 强化黑石 的方块，采用石头颜色的默认属性
    public static final RegistryObject<Block> REINFORCED_BLACKSTONE_BLOCK = BLOCKS.register("reinforced_blackstone", () ->
            new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.STONE) // 设置方块的颜色为石头颜色
                    .strength(6.0f, 20.0f) // 设置方块的硬度和爆炸抗性
                    .sound(SoundType.STONE) // 设置方块破坏时的音效
                    .lightLevel((state) -> 0) // 设置方块的光照等级
            )
    );
    // 注册名为 强化抛光黑石砖 的方块，采用石头颜色的默认属性
    public static final RegistryObject<Block> REINFORCED_POLISHED_BLACKSTONE_BRICKS_BLOCK = BLOCKS.register("reinforced_polished_blackstone_bricks", () ->
            new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.STONE) // 设置方块的颜色为石头颜色
                    .strength(6.0f, 20.0f) // 设置方块的硬度和爆炸抗性
                    .sound(SoundType.STONE) // 设置方块破坏时的音效
                    .lightLevel((state) -> 0) // 设置方块的光照等级
            )
    );
    // 注册名为 脆弱末地石 的方块，采用末地石颜色的默认属性
    public static final RegistryObject<Block> FRAGILE_END_STONE_BLOCK = BLOCKS.register("fragile_end_stone", () ->
            new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.SAND) // 设置方块的颜色为沙子颜色
                    .strength(0.5f, 2.0f) // 设置方块的硬度和爆炸抗性
                    .sound(SoundType.STONE) // 设置方块破坏时的音效
                    .lightLevel((state) -> 0) // 设置方块的光照等级
            )
    );
    // 注册名为 强化末地石 的方块，采用末地石颜色的默认属性
    public static final RegistryObject<Block> REINFORCED_END_STONE_BLOCK = BLOCKS.register("reinforced_end_stone", () ->
            new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.SAND) // 设置方块的颜色为沙子颜色
                    .strength(45.0f, 64.0f) // 设置方块的硬度和爆炸抗性
                    .requiresCorrectToolForDrops() // 需要正确的工具才能掉落物品
                    .sound(SoundType.STONE) // 设置方块破坏时的音效
                    .lightLevel((state) -> 0) // 设置方块的光照等级
            )
    );
    // 注册名为 强化末地石砖 的方块，采用末地石颜色的默认属性
    public static final RegistryObject<Block> REINFORCED_END_STONE_BRICKS_BLOCK = BLOCKS.register("reinforced_end_stone_bricks", () ->
            new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.SAND) // 设置方块的颜色为沙子颜色
                    .strength(45.0f, 64.0f) // 设置方块的硬度和爆炸抗性
                    .requiresCorrectToolForDrops() // 需要正确的工具才能掉落物品
                    .sound(SoundType.STONE) // 设置方块破坏时的音效
                    .lightLevel((state) -> 0) // 设置方块的光照等级
            )
    );
    // 注册名为 合成黑曜石 的方块，采用黑曜石颜色的默认属性
    public static final RegistryObject<Block> SYNTHETIC_OBSIDIAN_BLOCK = BLOCKS.register("synthetic_obsidian", () ->
            new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.STONE) // 设置方块的颜色为石头颜色
                    .strength(64.0f, 1200.0f) // 设置方块的硬度和爆炸抗性
                    .requiresCorrectToolForDrops() // 需要正确的工具才能掉落物品
                    .sound(SoundType.STONE) // 设置方块破坏时的音效
                    .lightLevel((state) -> 0) // 设置方块的光照等级
            )
    );
    // 注册名为 强化花岗岩 的方块，采用石头颜色的默认属性
    public static final RegistryObject<Block> REINFORCED_GRANITE_BLOCK = BLOCKS.register("reinforced_granite", () ->
            new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.STONE) // 设置方块的颜色为石头颜色
                    .strength(6.0f, 20.0f) // 设置方块的硬度和爆炸抗性
                    .sound(SoundType.STONE) // 设置方块破坏时的音效
                    .lightLevel((state) -> 0) // 设置方块的光照等级
            )
    );
    // 注册名为 强化闪长岩 的方块，采用石头颜色的默认属性
    public static final RegistryObject<Block> REINFORCED_DIORITE_BLOCK = BLOCKS.register("reinforced_diorite", () ->
            new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.STONE) // 设置方块的颜色为石头颜色
                    .strength(6.0f, 20.0f) // 设置方块的硬度和爆炸抗性
                    .sound(SoundType.STONE) // 设置方块破坏时的音效
                    .lightLevel((state) -> 0) // 设置方块的光照等级
            )
    );
    // 注册名为 强化安山岩 的方块，采用石头颜色的默认属性
    public static final RegistryObject<Block> REINFORCED_ANDESITE_BLOCK = BLOCKS.register("reinforced_andesite", () ->
            new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.STONE) // 设置方块的颜色为石头颜色
                    .strength(6.0f, 20.0f) // 设置方块的硬度和爆炸抗性
                    .sound(SoundType.STONE) // 设置方块破坏时的音效
                    .lightLevel((state) -> 0) // 设置方块的光照等级
            )
    );
    // 注册名为 强化方解石 的方块，采用石头颜色的默认属性
    public static final RegistryObject<Block> REINFORCED_CALCITE_BLOCK = BLOCKS.register("reinforced_calcite", () ->
            new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.STONE) // 设置方块的颜色为石头颜色
                    .strength(6.0f, 20.0f) // 设置方块的硬度和爆炸抗性
                    .sound(SoundType.STONE) // 设置方块破坏时的音效
                    .lightLevel((state) -> 0) // 设置方块的光照等级
            )
    );
    // 注册名为 强化红砖块 的方块，采用石头颜色的默认属性
    public static final RegistryObject<Block> REINFORCED_RED_BRICKS_BLOCK = BLOCKS.register("reinforced_red_bricks", () ->
            new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.STONE) // 设置方块的颜色为石头颜色
                    .strength(6.0f, 20.0f) // 设置方块的硬度和爆炸抗性
                    .requiresCorrectToolForDrops() // 需要正确的工具才能掉落物品
                    .sound(SoundType.STONE) // 设置方块破坏时的音效
                    .lightLevel((state) -> 0) // 设置方块的光照等级
            )
    );
    // 注册名为 强化海晶石 的方块，采用石头颜色的默认属性
    public static final RegistryObject<Block> REINFORCED_PRISMARINE_BLOCK = BLOCKS.register("reinforced_prismarine", () ->
            new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.STONE) // 设置方块的颜色为石头颜色
                    .strength(6.0f, 20.0f) // 设置方块的硬度和爆炸抗性
                    .sound(SoundType.STONE) // 设置方块破坏时的音效
                    .lightLevel((state) -> 0) // 设置方块的光照等级
            )
    );
    // 注册名为 强化海晶石砖 的方块，采用石头颜色的默认属性
    public static final RegistryObject<Block> REINFORCED_PRISMARINE_BRICKS_BLOCK = BLOCKS.register("reinforced_prismarine_bricks", () ->
            new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.STONE) // 设置方块的颜色为石头颜色
                    .strength(6.0f, 20.0f) // 设置方块的硬度和爆炸抗性
                    .sound(SoundType.STONE) // 设置方块破坏时的音效
                    .lightLevel((state) -> 0) // 设置方块的光照等级
            )
    );
    // 注册名为 强化暗海晶石 的方块，采用石头颜色的默认属性
    public static final RegistryObject<Block> REINFORCED_DARK_PRISMARINE_BLOCK = BLOCKS.register("reinforced_dark_prismarine", () ->
            new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.STONE) // 设置方块的颜色为石头颜色
                    .strength(6.0f, 99.0f) // 设置方块的硬度和爆炸抗性
                    .sound(SoundType.STONE) // 设置方块破坏时的音效
                    .lightLevel((state) -> 0) // 设置方块的光照等级
            )
    );
    // 注册名为 强化石英块 的方块，采用石头颜色的默认属性
    public static final RegistryObject<Block> REINFORCED_QUARTZ_BLOCK = BLOCKS.register("reinforced_quartz_block", () ->
            new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.STONE) // 设置方块的颜色为石头颜色
                    .strength(6.4f, 24.0f) // 设置方块的硬度和爆炸抗性
                    .requiresCorrectToolForDrops() // 需要正确的工具才能掉落物品
                    .sound(SoundType.STONE) // 设置方块破坏时的音效
                    .lightLevel((state) -> 0) // 设置方块的光照等级
            )
    );
    // 注册名为 强化雕刻石英块 的方块，采用石头颜色的默认属性
    public static final RegistryObject<Block> REINFORCED_CHISELED_QUARTZ_BLOCK = BLOCKS.register("reinforced_chiseled_quartz", () ->
            new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.STONE) // 设置方块的颜色为石头颜色
                    .strength(6.4f, 24.0f) // 设置方块的硬度和爆炸抗性
                    .requiresCorrectToolForDrops() // 需要正确的工具才能掉落物品
                    .sound(SoundType.STONE) // 设置方块破坏时的音效
                    .lightLevel((state) -> 0) // 设置方块的光照等级
            )
    );
    // 注册名为 强化石英砖块 的方块，采用石头颜色的默认属性
    public static final RegistryObject<Block> REINFORCED_QUARTZ_BRICKS_BLOCK = BLOCKS.register("reinforced_quartz_bricks", () ->
            new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.STONE) // 设置方块的颜色为石头颜色
                    .strength(6.4f, 24.0f) // 设置方块的硬度和爆炸抗性
                    .requiresCorrectToolForDrops() // 需要正确的工具才能掉落物品
                    .sound(SoundType.STONE) // 设置方块破坏时的音效
                    .lightLevel((state) -> 0) // 设置方块的光照等级
            )
    );
    // 注册名为 强化石英柱 的方块，采用石头颜色的默认属性
    public static final RegistryObject<Block> REINFORCED_QUARTZ_PILLAR_BLOCK = BLOCKS.register("reinforced_quartz_pillar", () ->
            new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.STONE) // 设置方块的颜色为石头颜色
                    .strength(6.4f, 24.0f) // 设置方块的硬度和爆炸抗性
                    .requiresCorrectToolForDrops() // 需要正确的工具才能掉落物品
                    .sound(SoundType.STONE) // 设置方块破坏时的音效
                    .lightLevel((state) -> 0) // 设置方块的光照等级
            )
    );
    // 注册名为 强化紫水晶块 的方块，采用紫色颜色的默认属性
    public static final RegistryObject<Block> REINFORCED_AMETHYST_BLOCK = BLOCKS.register("reinforced_amethyst_block", () ->
            new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_PURPLE) // 设置方块的颜色为紫色
                    .strength(6.0f, 20.0f) // 设置方块的硬度和爆炸抗性
                    .requiresCorrectToolForDrops() // 需要正确的工具才能掉落物品
                    .sound(SoundType.AMETHYST) // 设置方块破坏时的音效
                    .lightLevel((state) -> 5) // 设置方块的光照等级
            )
    );
    // 注册名为 强化紫珀块 的方块，采用紫色颜色的默认属性
    public static final RegistryObject<Block> REINFORCED_PURPUR_BLOCK = BLOCKS.register("reinforced_purpur_block", () ->
            new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_PURPLE) // 设置方块的颜色为紫色
                    .strength(6.0f, 72.0f) // 设置方块的硬度和爆炸抗性
                    .requiresCorrectToolForDrops() // 需要正确的工具才能掉落物品
                    .sound(SoundType.AMETHYST) // 设置方块破坏时的音效
                    .lightLevel((state) -> 0) // 设置方块的光照等级
            )
    );
    // 注册名为 强化紫珀柱 的方块，采用紫色颜色的默认属性
    public static final RegistryObject<Block> REINFORCED_PURPUR_PILLAR_BLOCK = BLOCKS.register("reinforced_purpur_pillar", () ->
            new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_PURPLE) // 设置方块的颜色为紫色
                    .strength(6.0f, 72.0f) // 设置方块的硬度和爆炸抗性
                    .requiresCorrectToolForDrops() // 需要正确的工具才能掉落物品
                    .sound(SoundType.AMETHYST) // 设置方块破坏时的音效
                    .lightLevel((state) -> 0) // 设置方块的光照等级
            )
    );
    // 注册名为 压缩泥坯 的方块，采用泥土颜色的默认属性
    public static final RegistryObject<Block> COMPRESSED_PACKED_MUD_BLOCK = BLOCKS.register("compressed_packed_mud", () ->
            new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.DIRT) // 设置方块的颜色为泥土颜色
                    .strength(4.0f, 4.0f) // 设置方块的硬度和爆炸抗性
                    .requiresCorrectToolForDrops() // 需要正确的工具才能掉落物品
                    .sound(SoundType.GRAVEL) // 设置方块破坏时的音效
                    .lightLevel((state) -> 0) // 设置方块的光照等级
            )
    );
    // 注册名为 强化泥砖 的方块，采用泥土颜色的默认属性
    public static final RegistryObject<Block> REINFORCED_MUD_BRICKS_BLOCK = BLOCKS.register("reinforced_mud_bricks", () ->
            new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.DIRT) // 设置方块的颜色为泥土颜色
                    .strength(10.0f, 32.0f) // 设置方块的硬度和爆炸抗性
                    .requiresCorrectToolForDrops() // 需要正确的工具才能掉落物品
                    .sound(SoundType.GRAVEL) // 设置方块破坏时的音效
                    .lightLevel((state) -> 0) // 设置方块的光照等级
            )
    );
    // 注册名为 溶蚀石块 的方块，采用石头颜色的默认属性
    public static final RegistryObject<Block> DISSOLVED_STONE_BLOCK = BLOCKS.register("dissolved_stone", () ->
            new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.STONE) // 设置方块的颜色为石头颜色
                    .strength(0.5f, 2.0f) // 设置方块的硬度和爆炸抗性
                    .sound(SoundType.STONE) // 设置方块破坏时的音效
                    .lightLevel((state) -> 0) // 设置方块的光照等级
            )
            {
                @Override
                public void stepOn(net.minecraft.world.level.@NotNull Level level,
                                   net.minecraft.core.@NotNull BlockPos pos,
                                   net.minecraft.world.level.block.state.@NotNull BlockState state,
                                   net.minecraft.world.entity.@NotNull Entity entity)
                {
                    super.stepOn(level, pos, state, entity);
                    if (!level.isClientSide && entity instanceof net.minecraft.world.entity.LivingEntity)
                    {
                        level.destroyBlock(pos, true, entity);
                    }
                }
            }
    );
    // 注册名为 仿制基岩 的方块，采用石头颜色的默认属性
    public static final RegistryObject<Block> IMITATION_BEDROCK_BLOCK = BLOCKS.register("imitation_bedrock", () ->
            new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.STONE) // 设置方块的颜色为石头颜色
                    .strength(65536.0f, 8.0f) // 设置方块的硬度和爆炸抗性
                    .sound(SoundType.STONE) // 设置方块破坏时的音效
                    .lightLevel((state) -> 0) // 设置方块的光照等级
            )
    );

    public static final RegistryObject<Item> EXP_BLOCK_ITEM = ITEMS.register("exp", () ->
            new BlockItem(EXP_BLOCK.get(), new Item.Properties())
    );
    public static final RegistryObject<Item> FIREFLY_BUSH_ITEM = ITEMS.register("firefly_bush", () ->
            new TipsBlockItem(FIREFLY_BUSH.get(), new Item.Properties(), "block.materials.firefly_bush.tooltip")
    );
    public static final RegistryObject<Item> FRAGILE_PLANK_BLOCK_ITEM = ITEMS.register("fragile_plank", () ->
            new TipsBlockItem(FRAGILE_PLANK_BLOCK.get(), new Item.Properties(), "block.materials.fragile_plank.tooltip")
    );
    public static final RegistryObject<Item> REINFORCED_PLANK_BLOCK_ITEM = ITEMS.register("reinforced_plank", () ->
            new BlockItem(REINFORCED_PLANK_BLOCK.get(), new Item.Properties())
    );
    public static final RegistryObject<Item> REINFORCED_SMOOTH_STONE_BLOCK_ITEM = ITEMS.register("reinforced_smooth_stone", () ->
            new BlockItem(REINFORCED_SMOOTH_STONE_BLOCK.get(), new Item.Properties())
    );
    public static final RegistryObject<Item> FRAGILE_SMOOTH_STONE_BLOCK_ITEM = ITEMS.register("fragile_smooth_stone", () ->
            new BlockItem(FRAGILE_SMOOTH_STONE_BLOCK.get(), new Item.Properties())
    );
    public static final RegistryObject<Item> REINFORCED_STONE_BRICKS_BLOCK_ITEM = ITEMS.register("reinforced_stone_bricks", () ->
            new BlockItem(REINFORCED_STONE_BRICKS_BLOCK.get(), new Item.Properties())
    );
    public static final RegistryObject<Item> REINFORCED_CHISELED_STONE_BRICKS_BLOCK_ITEM = ITEMS.register("reinforced_chiseled_stone_bricks", () ->
            new BlockItem(REINFORCED_CHISELED_STONE_BRICKS_BLOCK.get(), new Item.Properties())
    );
    public static final RegistryObject<Item> BORDERLESS_GLASS_BLOCK_ITEM = ITEMS.register("borderless_glass", () ->
            new BlockItem(BORDERLESS_GLASS_BLOCK.get(), new Item.Properties())
    );
    public static final RegistryObject<Item> HIGH_STRENGTH_GLASS_BLOCK_ITEM = ITEMS.register("high_strength_glass", () ->
            new BlockItem(HIGH_STRENGTH_GLASS_BLOCK.get(), new Item.Properties())
    );
    public static final RegistryObject<Item> SIX_PHASE_ICE_BLOCK_ITEM = ITEMS.register("six_phase_ice", () ->
            new TipsBlockItem(SIX_PHASE_ICE_BLOCK.get(), new Item.Properties(), "block.materials.six_phase_ice.tooltip")
    );
    public static final RegistryObject<Item> SYNTHETIC_REINFORCED_DEEPSLATE_BLOCK_ITEM = ITEMS.register("synthetic_reinforced_deepslate", () ->
            new BlockItem(SYNTHETIC_REINFORCED_DEEPSLATE_BLOCK.get(), new Item.Properties())
    );
    public static final RegistryObject<Item> FRAGILE_DEEPSLATE_BLOCK_ITEM = ITEMS.register("fragile_deepslate", () ->
            new BlockItem(FRAGILE_DEEPSLATE_BLOCK.get(), new Item.Properties())
    );
    public static final RegistryObject<Item> REINFORCED_SANDSTONE_BLOCK_ITEM = ITEMS.register("reinforced_sandstone", () ->
            new BlockItem(REINFORCED_SANDSTONE_BLOCK.get(), new Item.Properties())
    );
    public static final RegistryObject<Item> REINFORCED_RED_SANDSTONE_BLOCK_ITEM = ITEMS.register("reinforced_red_sandstone", () ->
            new BlockItem(REINFORCED_RED_SANDSTONE_BLOCK.get(), new Item.Properties())
    );
    public static final RegistryObject<Item> REINFORCED_TUFF_BLOCK_ITEM = ITEMS.register("reinforced_tuff", () ->
            new BlockItem(REINFORCED_TUFF_BLOCK.get(), new Item.Properties())
    );
    public static final RegistryObject<Item> REINFORCED_NETHERRACK_BLOCK_ITEM = ITEMS.register("reinforced_netherrack", () ->
            new BlockItem(REINFORCED_NETHERRACK_BLOCK.get(), new Item.Properties())
    );
    public static final RegistryObject<Item> REINFORCED_NETHER_BRICKS_BLOCK_ITEM = ITEMS.register("reinforced_nether_bricks", () ->
            new BlockItem(REINFORCED_NETHER_BRICKS_BLOCK.get(), new Item.Properties())
    );
    public static final RegistryObject<Item> REINFORCED_CHISELED_NETHER_BRICKS_BLOCK_ITEM = ITEMS.register("reinforced_chiseled_nether_bricks", () ->
            new BlockItem(REINFORCED_CHISELED_NETHER_BRICKS_BLOCK.get(), new Item.Properties())
    );
    public static final RegistryObject<Item> REINFORCED_RED_NETHER_BRICKS_BLOCK_ITEM = ITEMS.register("reinforced_red_nether_bricks", () ->
            new BlockItem(REINFORCED_RED_NETHER_BRICKS_BLOCK.get(), new Item.Properties())
    );
    public static final RegistryObject<Item> REINFORCED_BASALT_BLOCK_ITEM = ITEMS.register("reinforced_basalt", () ->
            new BlockItem(REINFORCED_BASALT_BLOCK.get(), new Item.Properties())
    );
    public static final RegistryObject<Item> REINFORCED_SMOOTH_BASALT_BLOCK_ITEM = ITEMS.register("reinforced_smooth_basalt", () ->
            new BlockItem(REINFORCED_SMOOTH_BASALT_BLOCK.get(), new Item.Properties())
    );
    public static final RegistryObject<Item> REINFORCED_BLACKSTONE_BLOCK_ITEM = ITEMS.register("reinforced_blackstone", () ->
            new BlockItem(REINFORCED_BLACKSTONE_BLOCK.get(), new Item.Properties())
    );
    public static final RegistryObject<Item> REINFORCED_POLISHED_BLACKSTONE_BRICKS_BLOCK_ITEM = ITEMS.register("reinforced_polished_blackstone_bricks", () ->
            new BlockItem(REINFORCED_POLISHED_BLACKSTONE_BRICKS_BLOCK.get(), new Item.Properties())
    );
    public static final RegistryObject<Item> FRAGILE_END_STONE_BLOCK_ITEM = ITEMS.register("fragile_end_stone", () ->
            new BlockItem(FRAGILE_END_STONE_BLOCK.get(), new Item.Properties())
    );
    public static final RegistryObject<Item> REINFORCED_END_STONE_BLOCK_ITEM = ITEMS.register("reinforced_end_stone", () ->
            new BlockItem(REINFORCED_END_STONE_BLOCK.get(), new Item.Properties())
    );
    public static final RegistryObject<Item> REINFORCED_END_STONE_BRICKS_BLOCK_ITEM = ITEMS.register("reinforced_end_stone_bricks", () ->
            new BlockItem(REINFORCED_END_STONE_BRICKS_BLOCK.get(), new Item.Properties())
    );
    public static final RegistryObject<Item> SYNTHETIC_OBSIDIAN_BLOCK_ITEM = ITEMS.register("synthetic_obsidian", () ->
            new TipsBlockItem(SYNTHETIC_OBSIDIAN_BLOCK.get(), new Item.Properties(), "block.materials.synthetic_obsidian.tooltip")
    );
    public static final RegistryObject<Item> REINFORCED_GRANITE_BLOCK_ITEM = ITEMS.register("reinforced_granite", () ->
            new BlockItem(REINFORCED_GRANITE_BLOCK.get(), new Item.Properties())
    );
    public static final RegistryObject<Item> REINFORCED_DIORITE_BLOCK_ITEM = ITEMS.register("reinforced_diorite", () ->
            new BlockItem(REINFORCED_DIORITE_BLOCK.get(), new Item.Properties())
    );
    public static final RegistryObject<Item> REINFORCED_ANDESITE_BLOCK_ITEM = ITEMS.register("reinforced_andesite", () ->
            new BlockItem(REINFORCED_ANDESITE_BLOCK.get(), new Item.Properties())
    );
    public static final RegistryObject<Item> REINFORCED_CALCITE_BLOCK_ITEM = ITEMS.register("reinforced_calcite", () ->
            new BlockItem(REINFORCED_CALCITE_BLOCK.get(), new Item.Properties())
    );
    public static final RegistryObject<Item> REINFORCED_RED_BRICKS_BLOCK_ITEM = ITEMS.register("reinforced_red_bricks", () ->
            new BlockItem(REINFORCED_RED_BRICKS_BLOCK.get(), new Item.Properties())
    );
    public static final RegistryObject<Item> REINFORCED_PRISMARINE_BLOCK_ITEM = ITEMS.register("reinforced_prismarine", () ->
            new BlockItem(REINFORCED_PRISMARINE_BLOCK.get(), new Item.Properties())
    );
    public static final RegistryObject<Item> REINFORCED_PRISMARINE_BRICKS_BLOCK_ITEM = ITEMS.register("reinforced_prismarine_bricks", () ->
            new BlockItem(REINFORCED_PRISMARINE_BRICKS_BLOCK.get(), new Item.Properties())
    );
    public static final RegistryObject<Item> REINFORCED_DARK_PRISMARINE_BLOCK_ITEM = ITEMS.register("reinforced_dark_prismarine", () ->
            new BlockItem(REINFORCED_DARK_PRISMARINE_BLOCK.get(), new Item.Properties())
    );
    public static final RegistryObject<Item> REINFORCED_QUARTZ_BLOCK_ITEM = ITEMS.register("reinforced_quartz_block", () ->
            new BlockItem(REINFORCED_QUARTZ_BLOCK.get(), new Item.Properties())
    );
    public static final RegistryObject<Item> REINFORCED_CHISELED_QUARTZ_BLOCK_ITEM = ITEMS.register("reinforced_chiseled_quartz", () ->
            new BlockItem(REINFORCED_CHISELED_QUARTZ_BLOCK.get(), new Item.Properties())
    );
    public static final RegistryObject<Item> REINFORCED_QUARTZ_BRICKS_BLOCK_ITEM = ITEMS.register("reinforced_quartz_bricks", () ->
            new BlockItem(REINFORCED_QUARTZ_BRICKS_BLOCK.get(), new Item.Properties())
    );
    public static final RegistryObject<Item> REINFORCED_QUARTZ_PILLAR_BLOCK_ITEM = ITEMS.register("reinforced_quartz_pillar", () ->
            new BlockItem(REINFORCED_QUARTZ_PILLAR_BLOCK.get(), new Item.Properties())
    );
    public static final RegistryObject<Item> REINFORCED_AMETHYST_BLOCK_ITEM = ITEMS.register("reinforced_amethyst_block", () ->
            new BlockItem(REINFORCED_AMETHYST_BLOCK.get(), new Item.Properties())
    );
    public static final RegistryObject<Item> REINFORCED_PURPUR_BLOCK_ITEM = ITEMS.register("reinforced_purpur_block", () ->
            new BlockItem(REINFORCED_PURPUR_BLOCK.get(), new Item.Properties())
    );
    public static final RegistryObject<Item> REINFORCED_PURPUR_PILLAR_BLOCK_ITEM = ITEMS.register("reinforced_purpur_pillar", () ->
            new BlockItem(REINFORCED_PURPUR_PILLAR_BLOCK.get(), new Item.Properties())
    );
    public static final RegistryObject<Item> COMPRESSED_PACKED_MUD_BLOCK_ITEM = ITEMS.register("compressed_packed_mud", () ->
            new BlockItem(COMPRESSED_PACKED_MUD_BLOCK.get(), new Item.Properties())
    );
    public static final RegistryObject<Item> REINFORCED_MUD_BRICKS_BLOCK_ITEM = ITEMS.register("reinforced_mud_bricks", () ->
            new BlockItem(REINFORCED_MUD_BRICKS_BLOCK.get(), new Item.Properties())
    );
    public static final RegistryObject<Item> DISSOLVED_STONE_BLOCK_ITEM = ITEMS.register("dissolved_stone", () ->
            new TipsBlockItem(DISSOLVED_STONE_BLOCK.get(), new Item.Properties(), "block.materials.dissolved_stone.tooltip")
    );
    public static final RegistryObject<Item> IMITATION_BEDROCK_BLOCK_ITEM = ITEMS.register("imitation_bedrock", () ->
            new TipsBlockItem(IMITATION_BEDROCK_BLOCK.get(), new Item.Properties(), "block.materials.imitation_bedrock.tooltip")
    );

    static void commonSetup(final FMLCommonSetupEvent event)
    {
        LOGGER.info("HELLO FROM COMMON SETUP");
        LOGGER.info("FMLCommonSetupEvent event: {}", event.toString());

        if (Config.logDirtBlock)
            LOGGER.info("DIRT BLOCK >> {}", ForgeRegistries.BLOCKS.getKey(Blocks.DIRT));
        LOGGER.info("{}{}", Config.magicNumberIntroduction, Config.magicNumber);
        Config.items.forEach((item) -> LOGGER.info("ITEM >> {}", item.toString()));

        LOGGER.info("EXP_BLOCK in mineable/axe: {}", Objects.requireNonNull(ForgeRegistries.BLOCKS.tags()).getTag(BlockTags.MINEABLE_WITH_AXE).contains(EXP_BLOCK.get()));
        LOGGER.info("EXP_BLOCK in needs_iron_tool: {}", Objects.requireNonNull(ForgeRegistries.BLOCKS.tags()).getTag(BlockTags.NEEDS_IRON_TOOL).contains(EXP_BLOCK.get()));
        LOGGER.info("FIREFLY_BUSH in mineable/shears: {}", Objects.requireNonNull(ForgeRegistries.BLOCKS.tags()).getTag(MINEABLE_WITH_SHEARS).contains(FIREFLY_BUSH.get()));
        LOGGER.info("FRAGILE_PLANK_BLOCK in mineable/axe: {}", Objects.requireNonNull(ForgeRegistries.BLOCKS.tags()).getTag(BlockTags.MINEABLE_WITH_AXE).contains(FRAGILE_PLANK_BLOCK.get()));
        LOGGER.info("REINFORCED_PLANK_BLOCK in mineable/axe: {}", Objects.requireNonNull(ForgeRegistries.BLOCKS.tags()).getTag(BlockTags.MINEABLE_WITH_AXE).contains(REINFORCED_PLANK_BLOCK.get()));
        LOGGER.info("REINFORCED_PLANK_BLOCK in needs_golden_tool: {}", Objects.requireNonNull(ForgeRegistries.BLOCKS.tags()).getTag(NEEDS_GOLDEN_TOOL).contains(REINFORCED_PLANK_BLOCK.get()));
        LOGGER.info("REINFORCED_SMOOTH_STONE_BLOCK in mineable/pickaxe: {}", Objects.requireNonNull(ForgeRegistries.BLOCKS.tags()).getTag(BlockTags.MINEABLE_WITH_PICKAXE).contains(REINFORCED_SMOOTH_STONE_BLOCK.get()));
        LOGGER.info("REINFORCED_SMOOTH_STONE_BLOCK in needs_iron_tool: {}", Objects.requireNonNull(ForgeRegistries.BLOCKS.tags()).getTag(BlockTags.NEEDS_IRON_TOOL).contains(REINFORCED_SMOOTH_STONE_BLOCK.get()));
        LOGGER.info("FRAGILE_SMOOTH_STONE_BLOCK in mineable/pickaxe: {}", Objects.requireNonNull(ForgeRegistries.BLOCKS.tags()).getTag(BlockTags.MINEABLE_WITH_PICKAXE).contains(FRAGILE_SMOOTH_STONE_BLOCK.get()));
        LOGGER.info("REINFORCED_STONE_BRICKS_BLOCK in mineable/pickaxe: {}", Objects.requireNonNull(ForgeRegistries.BLOCKS.tags()).getTag(BlockTags.MINEABLE_WITH_PICKAXE).contains(REINFORCED_STONE_BRICKS_BLOCK.get()));
        LOGGER.info("REINFORCED_STONE_BRICKS_BLOCK in needs_diamond_tool: {}", Objects.requireNonNull(ForgeRegistries.BLOCKS.tags()).getTag(BlockTags.NEEDS_DIAMOND_TOOL).contains(REINFORCED_STONE_BRICKS_BLOCK.get()));
        LOGGER.info("REINFORCED_CHISELED_STONE_BRICKS_BLOCK in mineable/pickaxe: {}", Objects.requireNonNull(ForgeRegistries.BLOCKS.tags()).getTag(BlockTags.MINEABLE_WITH_PICKAXE).contains(REINFORCED_CHISELED_STONE_BRICKS_BLOCK.get()));
        LOGGER.info("REINFORCED_CHISELED_STONE_BRICKS_BLOCK in needs_diamond_tool: {}", Objects.requireNonNull(ForgeRegistries.BLOCKS.tags()).getTag(BlockTags.NEEDS_DIAMOND_TOOL).contains(REINFORCED_CHISELED_STONE_BRICKS_BLOCK.get()));
        LOGGER.info("BORDERLESS_GLASS_BLOCK in mineable/pickaxe: {}", Objects.requireNonNull(ForgeRegistries.BLOCKS.tags()).getTag(BlockTags.MINEABLE_WITH_PICKAXE).contains(BORDERLESS_GLASS_BLOCK.get()));
        LOGGER.info("BORDERLESS_GLASS_BLOCK in needs_golden_tool: {}", Objects.requireNonNull(ForgeRegistries.BLOCKS.tags()).getTag(NEEDS_GOLDEN_TOOL).contains(BORDERLESS_GLASS_BLOCK.get()));
        LOGGER.info("HIGH_STRENGTH_GLASS_BLOCK in mineable/pickaxe: {}", Objects.requireNonNull(ForgeRegistries.BLOCKS.tags()).getTag(BlockTags.MINEABLE_WITH_PICKAXE).contains(HIGH_STRENGTH_GLASS_BLOCK.get()));
        LOGGER.info("HIGH_STRENGTH_GLASS_BLOCK in needs_netherite_tool: {}", Objects.requireNonNull(ForgeRegistries.BLOCKS.tags()).getTag(NEEDS_NETHERITE_TOOL).contains(HIGH_STRENGTH_GLASS_BLOCK.get()));
        LOGGER.info("SIX_PHASE_ICE_BLOCK in mineable/pickaxe: {}", Objects.requireNonNull(ForgeRegistries.BLOCKS.tags()).getTag(BlockTags.MINEABLE_WITH_PICKAXE).contains(SIX_PHASE_ICE_BLOCK.get()));
        LOGGER.info("SYNTHETIC_REINFORCED_DEEPSLATE_BLOCK in mineable/pickaxe: {}", Objects.requireNonNull(ForgeRegistries.BLOCKS.tags()).getTag(BlockTags.MINEABLE_WITH_PICKAXE).contains(SYNTHETIC_REINFORCED_DEEPSLATE_BLOCK.get()));
        LOGGER.info("SYNTHETIC_REINFORCED_DEEPSLATE_BLOCK in needs_netherite_tool: {}", Objects.requireNonNull(ForgeRegistries.BLOCKS.tags()).getTag(NEEDS_NETHERITE_TOOL).contains(SYNTHETIC_REINFORCED_DEEPSLATE_BLOCK.get()));
        LOGGER.info("FRAGILE_DEEPSLATE_BLOCK in mineable/pickaxe: {}", Objects.requireNonNull(ForgeRegistries.BLOCKS.tags()).getTag(BlockTags.MINEABLE_WITH_PICKAXE).contains(FRAGILE_DEEPSLATE_BLOCK.get()));
        LOGGER.info("FRAGILE_DEEPSLATE_BLOCK in needs_stone_tool: {}", Objects.requireNonNull(ForgeRegistries.BLOCKS.tags()).getTag(BlockTags.NEEDS_STONE_TOOL).contains(FRAGILE_DEEPSLATE_BLOCK.get()));
        LOGGER.info("REINFORCED_SANDSTONE_BLOCK in mineable/pickaxe: {}", Objects.requireNonNull(ForgeRegistries.BLOCKS.tags()).getTag(BlockTags.MINEABLE_WITH_PICKAXE).contains(REINFORCED_SANDSTONE_BLOCK.get()));
        LOGGER.info("REINFORCED_SANDSTONE_BLOCK in needs_stone_tool: {}", Objects.requireNonNull(ForgeRegistries.BLOCKS.tags()).getTag(BlockTags.NEEDS_STONE_TOOL).contains(REINFORCED_SANDSTONE_BLOCK.get()));
        LOGGER.info("REINFORCED_RED_SANDSTONE_BLOCK in mineable/pickaxe: {}", Objects.requireNonNull(ForgeRegistries.BLOCKS.tags()).getTag(BlockTags.MINEABLE_WITH_PICKAXE).contains(REINFORCED_RED_SANDSTONE_BLOCK.get()));
        LOGGER.info("REINFORCED_RED_SANDSTONE_BLOCK in needs_stone_tool: {}", Objects.requireNonNull(ForgeRegistries.BLOCKS.tags()).getTag(BlockTags.NEEDS_STONE_TOOL).contains(REINFORCED_RED_SANDSTONE_BLOCK.get()));
        LOGGER.info("REINFORCED_TUFF_BLOCK in mineable/pickaxe: {}", Objects.requireNonNull(ForgeRegistries.BLOCKS.tags()).getTag(BlockTags.MINEABLE_WITH_PICKAXE).contains(REINFORCED_TUFF_BLOCK.get()));
        LOGGER.info("REINFORCED_TUFF_BLOCK in needs_golden_tool: {}", Objects.requireNonNull(ForgeRegistries.BLOCKS.tags()).getTag(NEEDS_GOLDEN_TOOL).contains(REINFORCED_TUFF_BLOCK.get()));
        LOGGER.info("REINFORCED_NETHERRACK_BLOCK in mineable/pickaxe: {}", Objects.requireNonNull(ForgeRegistries.BLOCKS.tags()).getTag(BlockTags.MINEABLE_WITH_PICKAXE).contains(REINFORCED_NETHERRACK_BLOCK.get()));
        LOGGER.info("REINFORCED_NETHERRACK_BLOCK in needs_golden_tool: {}", Objects.requireNonNull(ForgeRegistries.BLOCKS.tags()).getTag(NEEDS_GOLDEN_TOOL).contains(REINFORCED_NETHERRACK_BLOCK.get()));
        LOGGER.info("REINFORCED_NETHER_BRICKS_BLOCK in mineable/pickaxe: {}", Objects.requireNonNull(ForgeRegistries.BLOCKS.tags()).getTag(BlockTags.MINEABLE_WITH_PICKAXE).contains(REINFORCED_NETHER_BRICKS_BLOCK.get()));
        LOGGER.info("REINFORCED_NETHER_BRICKS_BLOCK in needs_iron_tool: {}", Objects.requireNonNull(ForgeRegistries.BLOCKS.tags()).getTag(BlockTags.NEEDS_IRON_TOOL).contains(REINFORCED_NETHER_BRICKS_BLOCK.get()));
        LOGGER.info("REINFORCED_CHISELED_NETHER_BRICKS_BLOCK in mineable/pickaxe: {}", Objects.requireNonNull(ForgeRegistries.BLOCKS.tags()).getTag(BlockTags.MINEABLE_WITH_PICKAXE).contains(REINFORCED_CHISELED_NETHER_BRICKS_BLOCK.get()));
        LOGGER.info("REINFORCED_CHISELED_NETHER_BRICKS_BLOCK in needs_iron_tool: {}", Objects.requireNonNull(ForgeRegistries.BLOCKS.tags()).getTag(BlockTags.NEEDS_IRON_TOOL).contains(REINFORCED_CHISELED_NETHER_BRICKS_BLOCK.get()));
        LOGGER.info("REINFORCED_RED_NETHER_BRICKS_BLOCK in mineable/pickaxe: {}", Objects.requireNonNull(ForgeRegistries.BLOCKS.tags()).getTag(BlockTags.MINEABLE_WITH_PICKAXE).contains(REINFORCED_RED_NETHER_BRICKS_BLOCK.get()));
        LOGGER.info("REINFORCED_RED_NETHER_BRICKS_BLOCK in needs_iron_tool: {}", Objects.requireNonNull(ForgeRegistries.BLOCKS.tags()).getTag(BlockTags.NEEDS_IRON_TOOL).contains(REINFORCED_RED_NETHER_BRICKS_BLOCK.get()));
        LOGGER.info("REINFORCED_BASALT_BLOCK in mineable/pickaxe: {}", Objects.requireNonNull(ForgeRegistries.BLOCKS.tags()).getTag(BlockTags.MINEABLE_WITH_PICKAXE).contains(REINFORCED_BASALT_BLOCK.get()));
        LOGGER.info("REINFORCED_BASALT_BLOCK in needs_golden_tool: {}", Objects.requireNonNull(ForgeRegistries.BLOCKS.tags()).getTag(NEEDS_GOLDEN_TOOL).contains(REINFORCED_BASALT_BLOCK.get()));
        LOGGER.info("REINFORCED_SMOOTH_BASALT_BLOCK in mineable/pickaxe: {}", Objects.requireNonNull(ForgeRegistries.BLOCKS.tags()).getTag(BlockTags.MINEABLE_WITH_PICKAXE).contains(REINFORCED_SMOOTH_BASALT_BLOCK.get()));
        LOGGER.info("REINFORCED_SMOOTH_BASALT_BLOCK in needs_iron_tool: {}", Objects.requireNonNull(ForgeRegistries.BLOCKS.tags()).getTag(BlockTags.NEEDS_IRON_TOOL).contains(REINFORCED_SMOOTH_BASALT_BLOCK.get()));
        LOGGER.info("REINFORCED_BLACKSTONE_BLOCK in mineable/pickaxe: {}", Objects.requireNonNull(ForgeRegistries.BLOCKS.tags()).getTag(BlockTags.MINEABLE_WITH_PICKAXE).contains(REINFORCED_BLACKSTONE_BLOCK.get()));
        LOGGER.info("REINFORCED_BLACKSTONE_BLOCK in needs_golden_tool: {}", Objects.requireNonNull(ForgeRegistries.BLOCKS.tags()).getTag(NEEDS_GOLDEN_TOOL).contains(REINFORCED_BLACKSTONE_BLOCK.get()));
        LOGGER.info("REINFORCED_POLISHED_BLACKSTONE_BRICKS_BLOCK in mineable/pickaxe: {}", Objects.requireNonNull(ForgeRegistries.BLOCKS.tags()).getTag(BlockTags.MINEABLE_WITH_PICKAXE).contains(REINFORCED_POLISHED_BLACKSTONE_BRICKS_BLOCK.get()));
        LOGGER.info("REINFORCED_POLISHED_BLACKSTONE_BRICKS_BLOCK in needs_golden_tool: {}", Objects.requireNonNull(ForgeRegistries.BLOCKS.tags()).getTag(NEEDS_GOLDEN_TOOL).contains(REINFORCED_POLISHED_BLACKSTONE_BRICKS_BLOCK.get()));
        LOGGER.info("FRAGILE_END_STONE_BLOCK in mineable/pickaxe: {}", Objects.requireNonNull(ForgeRegistries.BLOCKS.tags()).getTag(BlockTags.MINEABLE_WITH_PICKAXE).contains(FRAGILE_END_STONE_BLOCK.get()));
        LOGGER.info("REINFORCED_END_STONE_BLOCK in mineable/pickaxe: {}", Objects.requireNonNull(ForgeRegistries.BLOCKS.tags()).getTag(BlockTags.MINEABLE_WITH_PICKAXE).contains(REINFORCED_END_STONE_BLOCK.get()));
        LOGGER.info("REINFORCED_END_STONE_BLOCK in needs_diamond_tool: {}", Objects.requireNonNull(ForgeRegistries.BLOCKS.tags()).getTag(BlockTags.NEEDS_DIAMOND_TOOL).contains(REINFORCED_END_STONE_BLOCK.get()));
        LOGGER.info("REINFORCED_END_STONE_BRICKS_BLOCK in mineable/pickaxe: {}", Objects.requireNonNull(ForgeRegistries.BLOCKS.tags()).getTag(BlockTags.MINEABLE_WITH_PICKAXE).contains(REINFORCED_END_STONE_BRICKS_BLOCK.get()));
        LOGGER.info("REINFORCED_END_STONE_BRICKS_BLOCK in needs_diamond_tool: {}", Objects.requireNonNull(ForgeRegistries.BLOCKS.tags()).getTag(BlockTags.NEEDS_DIAMOND_TOOL).contains(REINFORCED_END_STONE_BRICKS_BLOCK.get()));
        LOGGER.info("SYNTHETIC_OBSIDIAN_BLOCK in mineable/pickaxe: {}", Objects.requireNonNull(ForgeRegistries.BLOCKS.tags()).getTag(BlockTags.MINEABLE_WITH_PICKAXE).contains(SYNTHETIC_OBSIDIAN_BLOCK.get()));
        LOGGER.info("SYNTHETIC_OBSIDIAN_BLOCK in needs_netherite_tool: {}", Objects.requireNonNull(ForgeRegistries.BLOCKS.tags()).getTag(NEEDS_NETHERITE_TOOL).contains(SYNTHETIC_OBSIDIAN_BLOCK.get()));
        LOGGER.info("REINFORCED_GRANITE_BLOCK in mineable/pickaxe: {}", Objects.requireNonNull(ForgeRegistries.BLOCKS.tags()).getTag(BlockTags.MINEABLE_WITH_PICKAXE).contains(REINFORCED_GRANITE_BLOCK.get()));
        LOGGER.info("REINFORCED_GRANITE_BLOCK in needs_golden_tool: {}", Objects.requireNonNull(ForgeRegistries.BLOCKS.tags()).getTag(NEEDS_GOLDEN_TOOL).contains(REINFORCED_GRANITE_BLOCK.get()));
        LOGGER.info("REINFORCED_DIORITE_BLOCK in mineable/pickaxe: {}", Objects.requireNonNull(ForgeRegistries.BLOCKS.tags()).getTag(BlockTags.MINEABLE_WITH_PICKAXE).contains(REINFORCED_DIORITE_BLOCK.get()));
        LOGGER.info("REINFORCED_DIORITE_BLOCK in needs_golden_tool: {}", Objects.requireNonNull(ForgeRegistries.BLOCKS.tags()).getTag(NEEDS_GOLDEN_TOOL).contains(REINFORCED_DIORITE_BLOCK.get()));
        LOGGER.info("REINFORCED_ANDESITE_BLOCK in mineable/pickaxe: {}", Objects.requireNonNull(ForgeRegistries.BLOCKS.tags()).getTag(BlockTags.MINEABLE_WITH_PICKAXE).contains(REINFORCED_ANDESITE_BLOCK.get()));
        LOGGER.info("REINFORCED_ANDESITE_BLOCK in needs_golden_tool: {}", Objects.requireNonNull(ForgeRegistries.BLOCKS.tags()).getTag(NEEDS_GOLDEN_TOOL).contains(REINFORCED_ANDESITE_BLOCK.get()));
        LOGGER.info("REINFORCED_CALCITE_BLOCK in mineable/pickaxe: {}", Objects.requireNonNull(ForgeRegistries.BLOCKS.tags()).getTag(BlockTags.MINEABLE_WITH_PICKAXE).contains(REINFORCED_CALCITE_BLOCK.get()));
        LOGGER.info("REINFORCED_CALCITE_BLOCK in needs_golden_tool: {}", Objects.requireNonNull(ForgeRegistries.BLOCKS.tags()).getTag(NEEDS_GOLDEN_TOOL).contains(REINFORCED_CALCITE_BLOCK.get()));
        LOGGER.info("REINFORCED_RED_BRICKS_BLOCK in mineable/pickaxe: {}", Objects.requireNonNull(ForgeRegistries.BLOCKS.tags()).getTag(BlockTags.MINEABLE_WITH_PICKAXE).contains(REINFORCED_RED_BRICKS_BLOCK.get()));
        LOGGER.info("REINFORCED_RED_BRICKS_BLOCK in needs_iron_tool: {}", Objects.requireNonNull(ForgeRegistries.BLOCKS.tags()).getTag(BlockTags.NEEDS_IRON_TOOL).contains(REINFORCED_RED_BRICKS_BLOCK.get()));
        LOGGER.info("REINFORCED_PRISMARINE_BLOCK in mineable/pickaxe: {}", Objects.requireNonNull(ForgeRegistries.BLOCKS.tags()).getTag(BlockTags.MINEABLE_WITH_PICKAXE).contains(REINFORCED_PRISMARINE_BLOCK.get()));
        LOGGER.info("REINFORCED_PRISMARINE_BLOCK in needs_golden_tool: {}", Objects.requireNonNull(ForgeRegistries.BLOCKS.tags()).getTag(NEEDS_GOLDEN_TOOL).contains(REINFORCED_PRISMARINE_BLOCK.get()));
        LOGGER.info("REINFORCED_PRISMARINE_BRICKS_BLOCK in mineable/pickaxe: {}", Objects.requireNonNull(ForgeRegistries.BLOCKS.tags()).getTag(BlockTags.MINEABLE_WITH_PICKAXE).contains(REINFORCED_PRISMARINE_BRICKS_BLOCK.get()));
        LOGGER.info("REINFORCED_PRISMARINE_BRICKS_BLOCK in needs_golden_tool: {}", Objects.requireNonNull(ForgeRegistries.BLOCKS.tags()).getTag(NEEDS_GOLDEN_TOOL).contains(REINFORCED_PRISMARINE_BRICKS_BLOCK.get()));
        LOGGER.info("REINFORCED_DARK_PRISMARINE_BLOCK in mineable/pickaxe: {}", Objects.requireNonNull(ForgeRegistries.BLOCKS.tags()).getTag(BlockTags.MINEABLE_WITH_PICKAXE).contains(REINFORCED_DARK_PRISMARINE_BLOCK.get()));
        LOGGER.info("REINFORCED_DARK_PRISMARINE_BLOCK in needs_iron_tool: {}", Objects.requireNonNull(ForgeRegistries.BLOCKS.tags()).getTag(BlockTags.NEEDS_IRON_TOOL).contains(REINFORCED_DARK_PRISMARINE_BLOCK.get()));
        LOGGER.info("REINFORCED_QUARTZ_BLOCK in mineable/pickaxe: {}", Objects.requireNonNull(ForgeRegistries.BLOCKS.tags()).getTag(BlockTags.MINEABLE_WITH_PICKAXE).contains(REINFORCED_QUARTZ_BLOCK.get()));
        LOGGER.info("REINFORCED_QUARTZ_BLOCK in needs_iron_tool: {}", Objects.requireNonNull(ForgeRegistries.BLOCKS.tags()).getTag(BlockTags.NEEDS_IRON_TOOL).contains(REINFORCED_QUARTZ_BLOCK.get()));
        LOGGER.info("REINFORCED_CHISELED_QUARTZ_BLOCK in mineable/pickaxe: {}", Objects.requireNonNull(ForgeRegistries.BLOCKS.tags()).getTag(BlockTags.MINEABLE_WITH_PICKAXE).contains(REINFORCED_CHISELED_QUARTZ_BLOCK.get()));
        LOGGER.info("REINFORCED_CHISELED_QUARTZ_BLOCK in needs_iron_tool: {}", Objects.requireNonNull(ForgeRegistries.BLOCKS.tags()).getTag(BlockTags.NEEDS_IRON_TOOL).contains(REINFORCED_CHISELED_QUARTZ_BLOCK.get()));
        LOGGER.info("REINFORCED_QUARTZ_BRICKS_BLOCK in mineable/pickaxe: {}", Objects.requireNonNull(ForgeRegistries.BLOCKS.tags()).getTag(BlockTags.MINEABLE_WITH_PICKAXE).contains(REINFORCED_QUARTZ_BRICKS_BLOCK.get()));
        LOGGER.info("REINFORCED_QUARTZ_BRICKS_BLOCK in needs_iron_tool: {}", Objects.requireNonNull(ForgeRegistries.BLOCKS.tags()).getTag(BlockTags.NEEDS_IRON_TOOL).contains(REINFORCED_QUARTZ_BRICKS_BLOCK.get()));
        LOGGER.info("REINFORCED_QUARTZ_PILLAR_BLOCK in mineable/pickaxe: {}", Objects.requireNonNull(ForgeRegistries.BLOCKS.tags()).getTag(BlockTags.MINEABLE_WITH_PICKAXE).contains(REINFORCED_QUARTZ_PILLAR_BLOCK.get()));
        LOGGER.info("REINFORCED_QUARTZ_PILLAR_BLOCK in needs_iron_tool: {}", Objects.requireNonNull(ForgeRegistries.BLOCKS.tags()).getTag(BlockTags.NEEDS_IRON_TOOL).contains(REINFORCED_QUARTZ_PILLAR_BLOCK.get()));
        LOGGER.info("REINFORCED_AMETHYST_BLOCK in mineable/pickaxe: {}", Objects.requireNonNull(ForgeRegistries.BLOCKS.tags()).getTag(BlockTags.MINEABLE_WITH_PICKAXE).contains(REINFORCED_AMETHYST_BLOCK.get()));
        LOGGER.info("REINFORCED_AMETHYST_BLOCK in needs_iron_tool: {}", Objects.requireNonNull(ForgeRegistries.BLOCKS.tags()).getTag(BlockTags.NEEDS_IRON_TOOL).contains(REINFORCED_AMETHYST_BLOCK.get()));
        LOGGER.info("REINFORCED_PURPUR_BLOCK in mineable/pickaxe: {}", Objects.requireNonNull(ForgeRegistries.BLOCKS.tags()).getTag(BlockTags.MINEABLE_WITH_PICKAXE).contains(REINFORCED_PURPUR_BLOCK.get()));
        LOGGER.info("REINFORCED_PURPUR_BLOCK in needs_iron_tool: {}", Objects.requireNonNull(ForgeRegistries.BLOCKS.tags()).getTag(BlockTags.NEEDS_IRON_TOOL).contains(REINFORCED_PURPUR_BLOCK.get()));
        LOGGER.info("REINFORCED_PURPUR_PILLAR_BLOCK in mineable/pickaxe: {}", Objects.requireNonNull(ForgeRegistries.BLOCKS.tags()).getTag(BlockTags.MINEABLE_WITH_PICKAXE).contains(REINFORCED_PURPUR_PILLAR_BLOCK.get()));
        LOGGER.info("REINFORCED_PURPUR_PILLAR_BLOCK in needs_iron_tool: {}", Objects.requireNonNull(ForgeRegistries.BLOCKS.tags()).getTag(BlockTags.NEEDS_IRON_TOOL).contains(REINFORCED_PURPUR_PILLAR_BLOCK.get()));
        LOGGER.info("COMPRESSED_PACKED_MUD_BLOCK in mineable/shovel: {}", Objects.requireNonNull(ForgeRegistries.BLOCKS.tags()).getTag(BlockTags.MINEABLE_WITH_SHOVEL).contains(COMPRESSED_PACKED_MUD_BLOCK.get()));
        LOGGER.info("COMPRESSED_PACKED_MUD_BLOCK in needs_stone_tool: {}", Objects.requireNonNull(ForgeRegistries.BLOCKS.tags()).getTag(BlockTags.NEEDS_STONE_TOOL).contains(COMPRESSED_PACKED_MUD_BLOCK.get()));
        LOGGER.info("REINFORCED_MUD_BRICKS_BLOCK in mineable/shovel: {}", Objects.requireNonNull(ForgeRegistries.BLOCKS.tags()).getTag(BlockTags.MINEABLE_WITH_SHOVEL).contains(REINFORCED_MUD_BRICKS_BLOCK.get()));
        LOGGER.info("REINFORCED_MUD_BRICKS_BLOCK in needs_iron_tool: {}", Objects.requireNonNull(ForgeRegistries.BLOCKS.tags()).getTag(BlockTags.NEEDS_IRON_TOOL).contains(REINFORCED_MUD_BRICKS_BLOCK.get()));
        LOGGER.info("DISSOLVED_STONE_BLOCK in mineable/pickaxe: {}", Objects.requireNonNull(ForgeRegistries.BLOCKS.tags()).getTag(BlockTags.MINEABLE_WITH_PICKAXE).contains(DISSOLVED_STONE_BLOCK.get()));
    }

    // 在 BuildCreativeModeTabContentsEvent 事件中添加物品到对应标签
    // 在 addCreative 方法中添加方块物品到创造模式标签
    static void addCreative(BuildCreativeModeTabContentsEvent event)
    {
        if (event.getTabKey() == EnrollItems.MATERIALS_TAB.getKey())
        {
            // 预留扩展空间
            // 执行所有外部注册的处理器
            externalHandlers.forEach(handler -> handler.accept(event));
        }
    }

    /**
     * 允许外部模组注册物品到创造模式标签
     * 示例用法：
     * EnrollBlocks.registerCreativeTabHandler(event -> {
     *     event.accept(SomeOtherMod.CUSTOM_ITEM.get());
     *     event.accept(SomeOtherMod.ANOTHER_ITEM.get());
     * });
     * @param handler 处理事件的 Consumer
     */
    @Deprecated
    public static void registerCreativeTabHandler(Consumer<BuildCreativeModeTabContentsEvent> handler)
    {
        externalHandlers.add(handler);
    }
}
