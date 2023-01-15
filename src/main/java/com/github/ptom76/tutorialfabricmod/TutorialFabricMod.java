package com.github.ptom76.tutorialfabricmod;

import com.github.ptom76.tutorialfabricmod.block.Blocks;
import com.github.ptom76.tutorialfabricmod.entity.Entities;
import com.github.ptom76.tutorialfabricmod.item.ItemGroups;
import com.github.ptom76.tutorialfabricmod.item.Items;
import com.github.ptom76.tutorialfabricmod.screenhandler.ScreenHandlers;
import com.github.ptom76.tutorialfabricmod.tile.Tiles;
import net.fabricmc.api.ModInitializer;
import net.minecraft.util.Identifier;

public class TutorialFabricMod implements ModInitializer {
    public static String MOD_ID = "tutorialfabricmod";

    @Override
    public void onInitialize() {

        // エンティティの登録
        Entities.init();

        // コンテナの登録
        ScreenHandlers.init();

        // ブロックの登録
        Blocks.init();

        // タイルの登録
        Tiles.init();

        // アイテムの登録
        Items.init();

        // クリエイティブタブの登録
        ItemGroups.addItems();
    }
    
    // Identifierを生成する
    public static Identifier id(String path) {
        return new Identifier(MOD_ID, path);
    }
}
