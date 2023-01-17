package com.github.ptom76.tutorialfabricmod.enchantment;

import com.github.ptom76.tutorialfabricmod.TutorialFabricMod;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

public class Enchantments {
    public static Enchantment FREEZE = new FreezeEnchantment();

    public static void init() {
        // エンチャント登録
        Registry.register(Registries.ENCHANTMENT, TutorialFabricMod.id("freeze"), FREEZE);
    }
}
