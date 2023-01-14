package com.github.ptom76.tutorialfabricmod.client.render.entity;

import com.github.ptom76.tutorialfabricmod.TutorialFabricMod;
import com.github.ptom76.tutorialfabricmod.entity.Entities;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.entity.model.EntityModelLayer;

public class EntityRenderers {

    // EntityのModelレイヤー
    public static EntityModelLayer MODEL_BLUE_APPLE_LAYER = new EntityModelLayer(TutorialFabricMod.id("blue_apple_mob"), "main");

    public static void init() {
        // EntityのRenderer(描画システム)の登録
        EntityRendererRegistry.register(Entities.BLUE_APPLE_MOB, BlueAppleEntityRenderer::new);

        // Entityのモデル登録
        EntityModelLayerRegistry.registerModelLayer(MODEL_BLUE_APPLE_LAYER, BlueAppleEntityModel::getTexturedModelData);
    }
}
