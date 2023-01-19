package com.github.ptom76.tutorialfabricmod.mixin;

import com.github.ptom76.tutorialfabricmod.sound.SoundEvents;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PlayerEntity.class)
public abstract class PlayerEntityMixin {
    //@Shadow public abstract void playSound(SoundEvent sound, float volume, float pitch);

    @Shadow public abstract void playSound(SoundEvent event, SoundCategory category, float volume, float pitch);

    // ジャンプの関数
    @Inject(method = "jump", at = @At("TAIL"))
    private void jump(CallbackInfo ci) {
        //playSound(SoundEvents.JUMP_SOUND, 1f, 1f);
        // サウンド再生
        playSound(SoundEvents.JUMP_SOUND, SoundCategory.PLAYERS, 1f, 1f);
    }
}
