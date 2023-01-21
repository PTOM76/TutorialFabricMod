package com.github.ptom76.tutorialfabricmod;

import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;

public class ServerNetworks {
    public static void init() {
        // tutorialfabricmod:press_end_keyの通信を受け取ったら処理される
        ServerPlayNetworking.registerGlobalReceiver(TutorialFabricMod.id("press_end_key"), ((server, player, handler, buf, responseSender) -> {
            // プレイヤーを殺す関数
            player.kill();
        }));
    }
}
