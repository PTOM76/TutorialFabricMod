package com.github.ptom76.tutorialfabricmod.client.screen;

import com.github.ptom76.tutorialfabricmod.TutorialFabricMod;
import com.github.ptom76.tutorialfabricmod.screenhandler.BlueAppleGeneratorScreenHandler;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class BlueAppleGeneratorScreen extends HandledScreen<BlueAppleGeneratorScreenHandler> {
    // assets/tutorialfabricmod/textures/gui/container/blue_apple_generator.png
    private static final Identifier TEXTURE = TutorialFabricMod.id("textures/gui/container/blue_apple_generator.png");

    public BlueAppleGeneratorScreen(BlueAppleGeneratorScreenHandler handler, PlayerInventory inventory, Text title) {
        super(handler, inventory, title);
    }

    @Override
    public void drawBackground(MatrixStack matrices, float delta, int mouseX, int mouseY) {
        //RenderSystem.setShader(GameRenderer::getPositionTexShader); 1.19.2以前
        RenderSystem.setShader(GameRenderer::getPositionTexProgram);
        RenderSystem.setShaderColor(1.0f, 1.0f, 1.0f, 1.0f);
        RenderSystem.setShaderTexture(0, TEXTURE);
        int x = (width - backgroundWidth) / 2;
        int y = (height - backgroundHeight) / 2;
        drawTexture(matrices, x, y, 0, 0, backgroundWidth, backgroundHeight);
    }

    @Override
    public void render(MatrixStack matrices, int mouseX, int mouseY, float delta) {
        renderBackground(matrices);
        super.render(matrices, mouseX, mouseY, delta);
        drawMouseoverTooltip(matrices, mouseX, mouseY);
    }
}
