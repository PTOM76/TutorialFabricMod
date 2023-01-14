package com.github.ptom76.tutorialfabricmod.client.render.entity;

import com.github.ptom76.tutorialfabricmod.TutorialFabricMod;
import com.github.ptom76.tutorialfabricmod.entity.BlueAppleEntity;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

public class BlueAppleEntityRenderer extends MobEntityRenderer<BlueAppleEntity, BlueAppleEntityModel> {
    public BlueAppleEntityRenderer(EntityRendererFactory.Context context) {
        super(context, new BlueAppleEntityModel(context.getPart(EntityRenderers.MODEL_BLUE_APPLE_LAYER)), 0.5f);
    }

    @Override
    public Identifier getTexture(BlueAppleEntity entity) {
        return TutorialFabricMod.id("textures/entity/blue_apple_mob/blue_apple_mob.png");
    }
}
