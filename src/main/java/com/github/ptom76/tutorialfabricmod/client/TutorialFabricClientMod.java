package com.github.ptom76.tutorialfabricmod.client;

import com.github.ptom76.tutorialfabricmod.client.render.entity.EntityRenderers;
import com.github.ptom76.tutorialfabricmod.client.screen.Screens;
import com.github.ptom76.tutorialfabricmod.mixin.GridWidgetAccessor;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.screen.v1.ScreenEvents;
import net.minecraft.client.gui.screen.GameMenuScreen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.gui.widget.ClickableWidget;
import net.minecraft.client.gui.widget.GridWidget;
import net.minecraft.text.Text;

import java.util.List;

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


        ScreenEvents.AFTER_INIT.register((client, screen, scaledWidth, scaledHeight) -> {
            if (!(screen instanceof GameMenuScreen)) return;
            ClickableWidget gridWidget = net.fabricmc.fabric.api.client.screen.v1.Screens.getButtons(screen).get(0);
            if (gridWidget instanceof GridWidget) {
                List<ClickableWidget> widgets = ((GridWidgetAccessor)gridWidget).getChildren();

                ButtonWidget helloWorldBtn = ButtonWidget.builder(Text.of("Hello, World!"), (widget) -> {
                    if (client.player != null)
                        client.player.sendMessage(Text.of("Hello, World!"));
                }).dimensions(screen.width / 2 - 102, screen.height / 4 + 128, 204, 20).build();
                widgets.add(helloWorldBtn);
            }
        });
    }
}
