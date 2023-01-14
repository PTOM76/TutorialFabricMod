package com.github.ptom76.tutorialfabricmod.item;

import com.github.ptom76.tutorialfabricmod.TutorialFabricMod;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

import static com.github.ptom76.tutorialfabricmod.item.Items.*;

public class ItemGroups {
    
    // クリエイティブタブ
    public static ItemGroup TUTORIAL = FabricItemGroup.builder(TutorialFabricMod.id("tutorial"))
            // タブのアイコン
            .icon(() -> new ItemStack(TUTORIAL_ITEM))
            .build();
    
    public static void addItems() {
        // クリエイティブタブへ追加
        ItemGroupEvents.modifyEntriesEvent(TUTORIAL).register((entries -> entries.add(TUTORIAL_ITEM)));
        ItemGroupEvents.modifyEntriesEvent(TUTORIAL).register((entries -> entries.add(TUTORIAL_BLOCK)));
        ItemGroupEvents.modifyEntriesEvent(TUTORIAL).register((entries -> entries.add(TUTORIAL_SWORD)));
        ItemGroupEvents.modifyEntriesEvent(TUTORIAL).register((entries -> entries.add(TUTORIAL_AXE)));
        ItemGroupEvents.modifyEntriesEvent(TUTORIAL).register((entries -> entries.add(TUTORIAL_PICKAXE)));
        ItemGroupEvents.modifyEntriesEvent(TUTORIAL).register((entries -> entries.add(TUTORIAL_SHOVEL)));
        ItemGroupEvents.modifyEntriesEvent(TUTORIAL).register((entries -> entries.add(TUTORIAL_HOE)));
        ItemGroupEvents.modifyEntriesEvent(TUTORIAL).register((entries -> entries.add(TUTORIAL_HELMET)));
        ItemGroupEvents.modifyEntriesEvent(TUTORIAL).register((entries -> entries.add(TUTORIAL_CHESTPLATE)));
        ItemGroupEvents.modifyEntriesEvent(TUTORIAL).register((entries -> entries.add(TUTORIAL_LEGGINGS)));
        ItemGroupEvents.modifyEntriesEvent(TUTORIAL).register((entries -> entries.add(TUTORIAL_BOOTS)));
        ItemGroupEvents.modifyEntriesEvent(TUTORIAL).register((entries -> entries.add(BLUE_APPLE_MOB_SPAWN_EGG)));
    }
}
