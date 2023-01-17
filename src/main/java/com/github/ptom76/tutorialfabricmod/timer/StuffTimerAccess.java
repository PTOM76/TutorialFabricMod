package com.github.ptom76.tutorialfabricmod.timer;

import java.util.function.Supplier;

public interface StuffTimerAccess {
    void tutorialFabricMod_addTimer(long ticksUntilSomething, Supplier<Boolean> supplier);
}
