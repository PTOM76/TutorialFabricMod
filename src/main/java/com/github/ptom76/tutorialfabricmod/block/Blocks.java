package com.github.ptom76.tutorialfabricmod.block;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.MapColor;
import net.minecraft.block.Material;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

import static com.github.ptom76.tutorialfabricmod.TutorialFabricMod.id;

public class Blocks {
    public static Block TUTORIAL_BLOCK = new TutorialBlock(FabricBlockSettings.of(Material.STONE).strength(1.5f, 3.0f).mapColor(MapColor.CYAN));

    public static void init() {
        // ブロックを登録
        Registry.register(Registries.BLOCK, id("tutorial_block"), TUTORIAL_BLOCK);
    }
}
