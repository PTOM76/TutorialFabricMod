package com.github.ptom76.tutorialfabricmod.client;

import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import net.minecraft.text.Text;
import org.lwjgl.glfw.GLFW;

public class KeyBindings {
    public static KeyBinding TUTORIAL_KEY_BINDING_P =
            new KeyBinding("key.tutorialfabricmod.p",
                    InputUtil.Type.KEYSYM, // キーボード=KEYSYM, マウス=MOUSE
                    GLFW.GLFW_KEY_P, // Pキー
                    "category.tutorialfabricmod.tutorial"
            );

    public static KeyBinding TUTORIAL_KEY_BINDING_END =
            new KeyBinding("key.tutorialfabricmod.end",
                    InputUtil.Type.KEYSYM, // キーボード=KEYSYM, マウス=MOUSE
                    GLFW.GLFW_KEY_END, // endキー
                    "category.tutorialfabricmod.tutorial"
            );

    public static void init() {
        // キーバインドの登録
        KeyBindingHelper.registerKeyBinding(TUTORIAL_KEY_BINDING_P);
        KeyBindingHelper.registerKeyBinding(TUTORIAL_KEY_BINDING_END);

        // イベントの登録
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            while (TUTORIAL_KEY_BINDING_P.wasPressed()) {
                if (client.player != null)
                    client.player.sendMessage(Text.literal("Pが押されました。"), false);
            }

            while (TUTORIAL_KEY_BINDING_END.wasPressed()) {
                ClientNetworks.sendPressEndKey();
            }
        });

    }
}
