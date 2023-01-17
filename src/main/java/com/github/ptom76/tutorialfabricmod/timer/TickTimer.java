package com.github.ptom76.tutorialfabricmod.timer;

import java.util.function.Supplier;

public class TickTimer {
    public long ticksUntilSomething;
    public Supplier<Boolean> supplier;

    public TickTimer(long ticksUntilSomething, Supplier<Boolean> supplier) {
        this.ticksUntilSomething = ticksUntilSomething;
        this.supplier = supplier;
    }
}
