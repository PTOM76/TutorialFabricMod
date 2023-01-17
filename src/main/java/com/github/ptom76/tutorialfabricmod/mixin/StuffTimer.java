package com.github.ptom76.tutorialfabricmod.mixin;

import com.github.ptom76.tutorialfabricmod.timer.StuffTimerAccess;
import com.github.ptom76.tutorialfabricmod.timer.TickTimer;
import net.minecraft.server.MinecraftServer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

@Mixin(MinecraftServer.class)
public class StuffTimer implements StuffTimerAccess {
    @Unique
    private final List<TickTimer> tickTimers = new ArrayList<>();

    @Inject(method = "tick", at = @At("TAIL"))
    private void onTick(CallbackInfo ci) {
        if (tickTimers.isEmpty()) return;

        for (TickTimer tickTimer : tickTimers) {
            if (--tickTimer.ticksUntilSomething == 0) {
                tickTimer.supplier.get();
            }
        }

    }

    @Override
    public void tutorialFabricMod_addTimer(long ticksUntilSomething, Supplier<Boolean> supplier) {
        tickTimers.add(new TickTimer(ticksUntilSomething, supplier));
    }
}
