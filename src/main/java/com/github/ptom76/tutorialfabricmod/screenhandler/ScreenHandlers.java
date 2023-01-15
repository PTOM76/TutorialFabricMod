package com.github.ptom76.tutorialfabricmod.screenhandler;

import com.github.ptom76.tutorialfabricmod.TutorialFabricMod;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.screen.ScreenHandlerType;

public class ScreenHandlers {
    public static ScreenHandlerType<BlueAppleGeneratorScreenHandler> BLUE_APPLE_GENERATOR_SCREEN_HANDLER
            = new ScreenHandlerType<>(BlueAppleGeneratorScreenHandler::new);

    public static void init() {
        // ScreenHandlerTypeの登録
        Registry.register(Registries.SCREEN_HANDLER, TutorialFabricMod.id("blue_apple_generator_screen_handler")
                , BLUE_APPLE_GENERATOR_SCREEN_HANDLER);
    }
}
