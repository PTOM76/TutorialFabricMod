package com.github.ptom76.tutorialfabricmod.enchantment;

import com.github.ptom76.tutorialfabricmod.timer.StuffTimerAccess;
import net.minecraft.block.Blocks;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class FreezeEnchantment extends Enchantment {
    public FreezeEnchantment() {
        super(Rarity.UNCOMMON, EnchantmentTarget.WEAPON, new EquipmentSlot[]{EquipmentSlot.MAINHAND});
    }

    @Override
    public int getMaxPower(int level) {
        return super.getMinPower(level) + 50;
    }

    @Override
    public int getMinPower(int level) {
        return level * 10;
    }

    @Override
    public int getMaxLevel() {
        return 3;
    }

    @Override
    public void onTargetDamaged(LivingEntity user, Entity target, int level) {
        if (target instanceof LivingEntity) {
            LivingEntity entity = (LivingEntity) target;
            BlockPos pos = entity.getBlockPos();
            World world = entity.getWorld();
            // ブロックが空気のとき
            if (world.getBlockState(pos).isAir()) {
                // 音の再生
                target.playSound(SoundEvents.BLOCK_GLASS_BREAK, 1f, 1f);

                // 薄氷の設置
                world.setBlockState(pos, Blocks.ICE.getDefaultState());
            }
            if (world.getBlockState(pos.up()).isAir()) {
                world.setBlockState(pos.up(), Blocks.ICE.getDefaultState());
            }

            // 移動速度低下の追加
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 500, 255, false, false, false));

            StuffTimerAccess stuffTimerAccess = (StuffTimerAccess) world.getServer();

            stuffTimerAccess.tutorialFabricMod_addTimer(5, () -> {
                // エンティティの場所を設定
                entity.teleport(pos.getX() + 0.5, pos.getY(), pos.getZ() + 0.5);
                return true;
            });

            stuffTimerAccess.tutorialFabricMod_addTimer(45, () -> {
                // ブロックが薄氷のとき、
                if (world.getBlockState(pos).getBlock() == Blocks.ICE) {

                    // ブロック破壊
                    world.breakBlock(pos, false);

                    // 攻撃
                    entity.damage(DamageSource.FREEZE, level * 2);
                }
                return true;
            });
            stuffTimerAccess.tutorialFabricMod_addTimer(50, () -> {
                // pos.up()はY座標に+1
                if (world.getBlockState(pos.up()).getBlock() == Blocks.ICE) {
                    world.breakBlock(pos.up(), false);
                    entity.damage(DamageSource.FREEZE, level * 3);
                }

                // 移動速度低下の除去
                entity.removeStatusEffect(StatusEffects.SLOWNESS);

                return true;
            });


        }
        super.onTargetDamaged(user, target, level);
    }
}
