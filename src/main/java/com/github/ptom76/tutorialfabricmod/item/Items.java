package com.github.ptom76.tutorialfabricmod.item;

import com.github.ptom76.tutorialfabricmod.block.Blocks;
import com.github.ptom76.tutorialfabricmod.entity.Entities;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

import static com.github.ptom76.tutorialfabricmod.TutorialFabricMod.id;

public class Items {
    public static Item TUTORIAL_ITEM = new TutorialItem(new Item.Settings().food(new FoodComponent.Builder().hunger(5).snack().build()));

    // ブロック
    public static Item TUTORIAL_BLOCK =  new BlockItem(Blocks.TUTORIAL_BLOCK, new Item.Settings());
    public static Item CLICK_COUNT_BLOCK =  new BlockItem(Blocks.CLICK_COUNT_BLOCK, new Item.Settings());
    public static Item BLUE_APPLE_GENERATOR =  new BlockItem(Blocks.BLUE_APPLE_GENERATOR, new Item.Settings());

    // Material
    public static TutorialToolMaterial TUTORIAL_TOOL_MATERIAL = new TutorialToolMaterial();
    public static TutorialArmorMaterial TUTORIAL_ARMOR_MATERIAL = new TutorialArmorMaterial();

    // ツール
    public static Item TUTORIAL_SWORD = new SwordItem(TUTORIAL_TOOL_MATERIAL, 3, -1.0F, new Item.Settings());
    public static Item TUTORIAL_AXE = new AxeItem(TUTORIAL_TOOL_MATERIAL, 6, -3.0F, new Item.Settings());
    public static Item TUTORIAL_PICKAXE = new PickaxeItem(TUTORIAL_TOOL_MATERIAL, 1, -1.0F, new Item.Settings());
    public static Item TUTORIAL_SHOVEL = new ShovelItem(TUTORIAL_TOOL_MATERIAL, 1, -1.0F, new Item.Settings());
    public static Item TUTORIAL_HOE = new HoeItem(TUTORIAL_TOOL_MATERIAL, -3, -3.0F, new Item.Settings());

    // アーマー
    public static Item TUTORIAL_HELMET = new ArmorItem(TUTORIAL_ARMOR_MATERIAL, EquipmentSlot.HEAD, new Item.Settings());
    public static Item TUTORIAL_CHESTPLATE = new ArmorItem(TUTORIAL_ARMOR_MATERIAL, EquipmentSlot.CHEST, new Item.Settings());
    public static Item TUTORIAL_LEGGINGS = new ArmorItem(TUTORIAL_ARMOR_MATERIAL, EquipmentSlot.LEGS, new Item.Settings());
    public static Item TUTORIAL_BOOTS = new ArmorItem(TUTORIAL_ARMOR_MATERIAL, EquipmentSlot.FEET, new Item.Settings());

    // スポーンエッグ
    public static Item BLUE_APPLE_MOB_SPAWN_EGG = new SpawnEggItem(Entities.BLUE_APPLE_MOB, 0x1276B4, 0xFFC7FF, new Item.Settings());

    public static void init() {
        // アイテムを登録
        Registry.register(Registries.ITEM, id("tutorial_item"), TUTORIAL_ITEM);
        Registry.register(Registries.ITEM, id("tutorial_block"), TUTORIAL_BLOCK);
        Registry.register(Registries.ITEM, id("click_count_block"), CLICK_COUNT_BLOCK);
        Registry.register(Registries.ITEM, id("blue_apple_generator"), BLUE_APPLE_GENERATOR);

        Registry.register(Registries.ITEM, id("tutorial_sword"), TUTORIAL_SWORD);
        Registry.register(Registries.ITEM, id("tutorial_axe"), TUTORIAL_AXE);
        Registry.register(Registries.ITEM, id("tutorial_pickaxe"), TUTORIAL_PICKAXE);
        Registry.register(Registries.ITEM, id("tutorial_shovel"), TUTORIAL_SHOVEL);
        Registry.register(Registries.ITEM, id("tutorial_hoe"), TUTORIAL_HOE);

        Registry.register(Registries.ITEM, id("tutorial_helmet"), TUTORIAL_HELMET);
        Registry.register(Registries.ITEM, id("tutorial_chestplate"), TUTORIAL_CHESTPLATE);
        Registry.register(Registries.ITEM, id("tutorial_leggings"), TUTORIAL_LEGGINGS);
        Registry.register(Registries.ITEM, id("tutorial_boots"), TUTORIAL_BOOTS);

        Registry.register(Registries.ITEM, id("blue_apple_mob_spawn_egg"), BLUE_APPLE_MOB_SPAWN_EGG);
    }
}
