package com.components.software;

public class LightSoftware extends Software {
    private static final String COMPONENT_TYPE = "Light";
    private static final double CAPACITY_FACTOR = 0.5;
    private static final double MEMORY_FACTOR = 0.5;

    public LightSoftware(String name, int capacityConsumption, int memoryConsumption) {
        super(name, COMPONENT_TYPE, capacityConsumption, memoryConsumption);
        this.setMemoryConsumption(this.getChangedMemory());
        this.setCapacityConsumption(this.getChangedCapacity());
    }

    @Override
    protected int getChangedMemory() {
        return this.getMemoryConsumption() - (int)(this.getMemoryConsumption() * MEMORY_FACTOR);
    }

    @Override
    protected int getChangedCapacity() {
        return this.getCapacityConsumption() + (int)(this.getCapacityConsumption() * CAPACITY_FACTOR);
    }
}
