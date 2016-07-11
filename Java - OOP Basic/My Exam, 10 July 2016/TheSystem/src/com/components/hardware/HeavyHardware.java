package com.components.hardware;

import java.util.ArrayList;

public class HeavyHardware extends Hardware{
    private static final String COMPONENT_TYPE = "Heavy";
    private static final double CAPACITY_FACTOR = 2;
    private static final double MEMORY_FACTOR = 0.25;

    public HeavyHardware(String name, int maximumCapacity, int maximumMemory) {
        super(name, COMPONENT_TYPE, maximumCapacity, maximumMemory);
        this.setMaximumCapacity(this.getChangedCapacity());
        this.setMaximumMemory(this.getChangedMemory());
    }

    @Override
    protected int getChangedMemory() {
        return this.getMaximumMemory() - (int)(this.getMaximumMemory() * MEMORY_FACTOR);
    }

    @Override
    protected int getChangedCapacity() {
        return this.getMaximumCapacity() * (int)CAPACITY_FACTOR;
    }
}
