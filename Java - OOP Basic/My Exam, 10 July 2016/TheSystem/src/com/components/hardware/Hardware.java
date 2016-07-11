package com.components.hardware;

import com.components.SystemComponent;
import com.components.software.Software;

import java.util.LinkedList;
import java.util.List;
import java.util.StringJoiner;

public abstract class Hardware extends SystemComponent {
    private int maximumCapacity;
    private int maximumMemory;
    private List<Software> software;

    protected Hardware(String name, String type, int maximumCapacity, int maximumMemory) {
        super(name, type);
        this.setMaximumCapacity(maximumCapacity);
        this.setMaximumMemory(maximumMemory);
        this.setSoftware(new LinkedList<>());
    }

    public int getMaximumCapacity() {
        return maximumCapacity;
    }

    protected void setMaximumCapacity(int maximumCapacity) {
        this.maximumCapacity = maximumCapacity;
    }

    public int getMaximumMemory() {
        return maximumMemory;
    }

    protected void setMaximumMemory(int maximumMemory) {
        this.maximumMemory = maximumMemory;
    }

    public List<Software> getSoftware() {
        return software;
    }

    private void setSoftware(List<Software> software) {
        this.software = software;
    }

    public int getTotalOperationalMemory(){
        return this.software.stream()
                .mapToInt(Software::getMemoryConsumption)
                .sum();
    }

    public int getTotalCapacityTaken(){
        return this.software.stream()
                .mapToInt(Software::getCapacityConsumption)
                .sum();
    }

    public int getRemainingMemory(){
        return this.getMaximumMemory() - getTotalOperationalMemory();
    }

    public int getRemainingCapacity(){
        return this.getMaximumCapacity() - this.getTotalCapacityTaken();
    }

    public void addSoftware(Software software){
        this.getSoftware().add(software);
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append(String.format("Hardware Component - %s\n", this.getName()));

        int expressSoftwareCount = 0;
        for (Software software : this.getSoftware()) {
            if (software.getType().equals("Express")){
                expressSoftwareCount++;
            }
        }
        result.append(String.format("Express Software Components - %d\n", expressSoftwareCount));

        int lightSoftwareCount = 0;
        for (Software software : this.getSoftware()) {
            if (software.getType().equals("Light")){
                lightSoftwareCount++;
            }
        }
        result.append(String.format("Light Software Components - %d\n", lightSoftwareCount));

        int memoryUsed = this.getTotalOperationalMemory();
        int maximumMemory = this.getMaximumMemory();
        result.append(String.format("Memory Usage: %d / %d\n", memoryUsed, maximumMemory));

        int capacityUsed = this.getTotalCapacityTaken();
        int maximumCapacity = this.getMaximumCapacity();
        result.append(String.format("Capacity Usage: %d / %d\n", capacityUsed, maximumCapacity));

        result.append(String.format("Type: %s\n", this.getType()));

        List<String> softwareComponentsNames = new LinkedList<>();
        for (Software software : this.getSoftware()) {
            softwareComponentsNames.add(software.getName());
        }
        if (softwareComponentsNames.size() != 0){
            result.append(String.format("Software Components: %s\n", String.join(", ", softwareComponentsNames)));
        } else {
            result.append("Software Components: None\n");
        }

        return result.toString();
    }
}
