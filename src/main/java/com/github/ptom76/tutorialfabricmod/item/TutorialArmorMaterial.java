package com.github.ptom76.tutorialfabricmod.item;

import com.github.ptom76.tutorialfabricmod.TutorialFabricMod;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;

public class TutorialArmorMaterial implements ArmorMaterial {

    int[] protectionAmounts = new int[]{3, 6, 8, 3};

    // 耐久値
    @Override
    public int getDurability(EquipmentSlot slot) {
        return 35;
    }

    // 防護力
    @Override
    public int getProtectionAmount(EquipmentSlot slot) {
        return protectionAmounts[slot.getEntitySlotId()];
    }

    // エンチャント適性
    @Override
    public int getEnchantability() {
        return 15;
    }

    // 装備音
    @Override
    public SoundEvent getEquipSound() {
        return SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND;
    }

    // 修理の材料
    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(Items.TUTORIAL_ITEM);
    }

    // 名前
    @Override
    public String getName() {
        return "tutorial";
    }

    // 防具強度
    @Override
    public float getToughness() {
        return 3.0F;
    }

    // ノックバック耐久
    @Override
    public float getKnockbackResistance() {
        return 0.1F;
    }
}
