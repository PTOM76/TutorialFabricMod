package com.github.ptom76.tutorialfabricmod.sound;

import com.github.ptom76.tutorialfabricmod.TutorialFabricMod;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

public class SoundEvents {
    public static final Identifier JUMP_SOUND_ID = TutorialFabricMod.id("jump_sound");
    public static SoundEvent JUMP_SOUND = SoundEvent.of(JUMP_SOUND_ID);
    //                      1.19.2以前ではnew SoundEvent(...)

    public static void init() {
        // サウンドの登録
        Registry.register(Registries.SOUND_EVENT, JUMP_SOUND_ID, JUMP_SOUND);
    }
}
