package com.github.ptom76.tutorialfabricmod.item;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Rarity;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class TutorialItem extends Item {
    public TutorialItem(Settings settings) {
        super(settings);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        super.appendTooltip(stack, world, tooltip, context);
        // ツールチップ追加
        // 1.18以前では↓new TranslatableText(key);
        tooltip.add(Text.translatable("item.tutorialfabricmod.tutorial_item.tooltip").formatted(Formatting.RED));

        // 1.18以前では↓new LiteralText(string);
        tooltip.add(Text.literal("§dHello, §bWorld!!"));
    }

    @Override
    public Rarity getRarity(ItemStack stack) {
        // レア度
        return Rarity.UNCOMMON;
    }
}
