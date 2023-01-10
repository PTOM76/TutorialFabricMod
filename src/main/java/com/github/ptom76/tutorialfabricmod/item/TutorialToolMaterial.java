package com.github.ptom76.tutorialfabricmod.item;

import com.github.ptom76.tutorialfabricmod.TutorialFabricMod;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class TutorialToolMaterial implements ToolMaterial {
    // 耐久値
    @Override
    public int getDurability() {
        return 2000;
    }

    // 採掘速度
    @Override
    public float getMiningSpeedMultiplier() {
        return 10.0F;
    }

    // 攻撃力
    @Override
    public float getAttackDamage() {
        return 5.0F;
    }

    // 採掘レベル
    @Override
    public int getMiningLevel() {
        return 3;
    }

    // エンチャント適性
    @Override
    public int getEnchantability() {
        return 15;
    }

    // 修理の材料
    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(Items.TUTORIAL_ITEM);
    }
}
