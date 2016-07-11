package com.components.software;

public class ExpressSoftware extends Software{
    private static final String COMPONENT_TYPE = "Express";
    private static final double CAPACITY_FACTOR = 1;
    private static final double MEMORY_FACTOR = 2;

    public ExpressSoftware(String name, int capacityConsumption, int memoryConsumption) {
        super(name, COMPONENT_TYPE, capacityConsumption, memoryConsumption);
        this.setMemoryConsumption(this.getChangedMemory());
        this.setCapacityConsumption(this.getChangedCapacity());
    }

    @Override
    protected int getChangedMemory() {
        return this.getMemoryConsumption() * (int)MEMORY_FACTOR;
    }

    @Override
    protected int getChangedCapacity() {
        return this.getCapacityConsumption() * (int)CAPACITY_FACTOR;
    }
}
