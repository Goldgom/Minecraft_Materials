package org.materials.materials;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.network.chat.Component;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class TipsBlockItem extends BlockItem
{
    public String toolTipInfo = "";

    public TipsBlockItem(Block block, Properties properties)
    {
        super(block, properties);
    }

    public TipsBlockItem(Block block, Properties properties, String toolTipInfo)
    {
        super(block, properties);
        this.toolTipInfo = toolTipInfo;
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level world, List<Component> tooltip, TooltipFlag flag)
    {
        if (Screen.hasAltDown())
        {
            tooltip.add(Component.translatable(this.toolTipInfo).withStyle(ChatFormatting.GRAY));
        }
        else
        {
            tooltip.add(Component.translatable("More_information").withStyle(ChatFormatting.YELLOW));
        }
    }
}