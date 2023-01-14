package com.github.ptom76.tutorialfabricmod.entity;

import com.github.ptom76.tutorialfabricmod.item.Items;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ExperienceOrbEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.World;

public class BlueAppleEntity extends PathAwareEntity {
    public BlueAppleEntity(EntityType<? extends PathAwareEntity> entityType, World world) {
        super(entityType, world);
    }

    // 死亡時呼び出される関数
    @Override
    public void onDeath(DamageSource damageSource) {
        super.onDeath(damageSource);

        // クライアントではないとき
        if (!world.isClient) {
            // ドロップ品 (数: 1～3個)
            dropStack(new ItemStack(Items.TUTORIAL_ITEM, world.random.nextBetween(1, 3)));

            // 経験値ドロップ (量:5～20)
            ExperienceOrbEntity.spawn((ServerWorld) world, getPos(), world.random.nextBetween(5, 20));
        }
    }
}
