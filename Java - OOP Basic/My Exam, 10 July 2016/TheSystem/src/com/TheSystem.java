package com;

import com.components.hardware.Hardware;

import java.util.LinkedList;
import java.util.List;

public class TheSystem {
    private List<Hardware> hardware;

    public TheSystem() {
        this.setHardware(new LinkedList<>());
    }

    public List<Hardware> getHardware() {
        return hardware;
    }

    private void setHardware(List<Hardware> hardware) {
        this.hardware = hardware;
    }

    public void addHardware(Hardware hardware){
        this.getHardware().add(hardware);
    }

    public int getTotalOperationalMemory(){
        return (int)this.hardware.stream()
                .mapToDouble(Hardware::getTotalOperationalMemory)
                .sum();
    }

    public int getTotalCapacityTaken(){
        return (int)this.hardware.stream()
                .mapToDouble(Hardware::getTotalCapacityTaken)
                .sum();
    }

    public int getHardwareComponentsCount(){
        return this.getHardware().size();
    }

    public int getSoftwareComponentsCount(){
        int result = 0;
        for (Hardware hardware : this.getHardware()) {
            result += hardware.getSoftware().size();
        }

        return result;
    }
    
    public int getMaximumMemory(){
        int result = 0;
        for (Hardware hardware : this.getHardware()) {
            result += hardware.getMaximumMemory();
        }

        return result;
    }

    public int getMaximumCapacity(){
        int result = 0;
        for (Hardware hardware : this.getHardware()) {
            result += hardware.getMaximumCapacity();
        }

        return result;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (Hardware hardware : this.getHardware()) {
            result.append(hardware);
        }

        return result.toString();
    }
}
