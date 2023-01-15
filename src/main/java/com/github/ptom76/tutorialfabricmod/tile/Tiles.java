package com.github.ptom76.tutorialfabricmod.tile;

import com.github.ptom76.tutorialfabricmod.TutorialFabricMod;
import com.github.ptom76.tutorialfabricmod.block.Blocks;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

public class Tiles {
    public static BlockEntityType<ClickCountBlockTile> CLICK_COUNT_BLOCK_TILE = FabricBlockEntityTypeBuilder
            .create(ClickCountBlockTile::new, Blocks.CLICK_COUNT_BLOCK).build();

    public static BlockEntityType<BlueAppleGeneratorTile> BLUE_APPLE_GENERATOR_TILE = FabricBlockEntityTypeBuilder
            .create(BlueAppleGeneratorTile::new, Blocks.BLUE_APPLE_GENERATOR).build();

    public static void init() {
        // タイル(ブロックエンティティ)のタイプの登録
        Registry.register(Registries.BLOCK_ENTITY_TYPE, TutorialFabricMod.id("click_count_block"), CLICK_COUNT_BLOCK_TILE);
        Registry.register(Registries.BLOCK_ENTITY_TYPE, TutorialFabricMod.id("blue_apple_generator"), BLUE_APPLE_GENERATOR_TILE);
    }
}
