package com.github.ptom76.tutorialfabricmod.client;

import com.github.ptom76.tutorialfabricmod.client.render.entity.EntityRenderers;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

@Environment(EnvType.CLIENT)
public class TutorialFabricClientMod implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        // EntityのRenderer関係の登録
        EntityRenderers.init();
    }
}
