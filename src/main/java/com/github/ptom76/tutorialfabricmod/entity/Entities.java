package com.github.ptom76.tutorialfabricmod.entity;

import com.github.ptom76.tutorialfabricmod.TutorialFabricMod;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

public class Entities {
    public static EntityType<BlueAppleEntity> BLUE_APPLE_MOB = FabricEntityTypeBuilder.create()
            // スポーングループ
            .spawnGroup(SpawnGroup.CREATURE)
            .entityFactory(BlueAppleEntity::new)

            // 当たり判定のサイズ
            .dimensions(EntityDimensions.fixed(0.5f, 1.25f))
            .build();

    public static void init() {
        // エンティティの登録
        Registry.register(Registries.ENTITY_TYPE, TutorialFabricMod.id("blue_apple_mob"), BLUE_APPLE_MOB);

        attributeRegister();
    }

    public static void attributeRegister() {
        // 属性の登録
        FabricDefaultAttributeRegistry.register(BLUE_APPLE_MOB, BlueAppleEntity.createMobAttributes()
                // 体力
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 5.0)

                // 防護力
                .add(EntityAttributes.GENERIC_ARMOR, 3.0));
    }
}
