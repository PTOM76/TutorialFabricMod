package com.github.ptom76.tutorialfabricmod.client;

import com.github.ptom76.tutorialfabricmod.client.render.entity.EntityRenderers;
import com.github.ptom76.tutorialfabricmod.client.screen.Screens;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

@Environment(EnvType.CLIENT)
public class TutorialFabricClientMod implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        // EntityのRenderer関係の登録
        EntityRenderers.init();

        // スクリーン(クライアント側のGUI)の登録
        Screens.init();

        // キーバインドの登録
        KeyBindings.init();
    }
}
