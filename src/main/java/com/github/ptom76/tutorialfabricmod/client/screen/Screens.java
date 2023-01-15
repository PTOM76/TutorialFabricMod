package com.github.ptom76.tutorialfabricmod.client.screen;

import com.github.ptom76.tutorialfabricmod.screenhandler.ScreenHandlers;
import net.minecraft.client.gui.screen.ingame.HandledScreens;

public class Screens {

    public static void init() {
        // スクリーンの登録
        HandledScreens.register(ScreenHandlers.BLUE_APPLE_GENERATOR_SCREEN_HANDLER, BlueAppleGeneratorScreen::new);
    }
}
