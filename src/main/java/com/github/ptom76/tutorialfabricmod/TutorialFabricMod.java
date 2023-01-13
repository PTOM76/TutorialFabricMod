package com.github.ptom76.tutorialfabricmod;

import com.github.ptom76.tutorialfabricmod.block.Blocks;
import com.github.ptom76.tutorialfabricmod.item.ItemGroups;
import com.github.ptom76.tutorialfabricmod.item.Items;
import net.fabricmc.api.ModInitializer;
import net.minecraft.util.Identifier;

public class TutorialFabricMod implements ModInitializer {
    public static String MOD_ID = "tutorialfabricmod";

    @Override
    public void onInitialize() {

        // ブロックの登録
        Blocks.init();

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
