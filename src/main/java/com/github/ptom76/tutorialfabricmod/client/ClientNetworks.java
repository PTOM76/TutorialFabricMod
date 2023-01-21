package com.github.ptom76.tutorialfabricmod.client;

import com.github.ptom76.tutorialfabricmod.TutorialFabricMod;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;

public class ClientNetworks {
    public static void init() {
    }

    public static void sendPressEndKey() {
        ClientPlayNetworking.send(TutorialFabricMod.id("press_end_key"), PacketByteBufs.empty());
    }
}
