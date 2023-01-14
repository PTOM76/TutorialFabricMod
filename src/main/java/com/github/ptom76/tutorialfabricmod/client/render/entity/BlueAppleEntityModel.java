package com.github.ptom76.tutorialfabricmod.client.render.entity;

import com.github.ptom76.tutorialfabricmod.entity.BlueAppleEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.model.EntityModelPartNames;
import net.minecraft.client.util.math.MatrixStack;

public class BlueAppleEntityModel extends EntityModel<BlueAppleEntity> {

    private final ModelPart base;

    public BlueAppleEntityModel(ModelPart base) {
        this.base = base;
    }

    @Override
    public void setAngles(BlueAppleEntity entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {

    }

    @Override
    public void render(MatrixStack matrices, VertexConsumer vertices, int light, int overlay, float red, float green, float blue, float alpha) {
        base.render(matrices, vertices, light, overlay, red, green, blue, alpha);
    }

    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData rootPart = modelData.getRoot();

        // 頭と体のパーツを追加
        rootPart.addChild(EntityModelPartNames.HEAD, ModelPartBuilder.create()
                .uv(0, 0)
                .cuboid(-4.0f, 4.0f, -4.0f, 8.0f, 8.0f, 8.0f), ModelTransform.NONE);

        rootPart.addChild(EntityModelPartNames.BODY, ModelPartBuilder.create()
                .uv(0, 20)
                .cuboid(-4.0f, 12.0f, -3.0f, 8.0f, 12.0f, 6.0f), ModelTransform.NONE);

        return TexturedModelData.of(modelData, 32, 48);
    }
}
