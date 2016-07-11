package com;

import com.components.hardware.Hardware;
import com.components.hardware.HardwareFactory;
import com.components.software.Software;
import com.components.software.SoftwareFactory;

import java.util.List;

public class CommandDispatcher {
    private SoftwareFactory softwareFactory;
    private HardwareFactory hardwareFactory;
    private TheSystem theSystem;

    public CommandDispatcher(TheSystem theSystem, SoftwareFactory softwareFactory, HardwareFactory hardwareFactory) {
        this.softwareFactory = softwareFactory;
        this.hardwareFactory = hardwareFactory;
        this.theSystem = theSystem;
    }

    public void dispatchCommand(String command, String systemComponent, List<String> args){
        switch (command){
            case "Register":
                this.registerSystemComponent(systemComponent, args);
                break;
            case "Release":
                this.releaseSoftwareComponent(args);
                break;
            case "Analyze":
                this.analyzeSystem();
                break;
            default:
                break;
        }
    }

    private void registerSystemComponent(String systemComponent, List<String> args){
        if (args.size() == 4){
            Software newSoftware = this.softwareFactory.createSystemComponent(systemComponent, args);
            for (Hardware hardware : this.theSystem.getHardware()) {
                if (hardware.getName().equals(args.get(0))){
                    if (newSoftware.getMemoryConsumption() <= hardware.getRemainingMemory() &&
                            newSoftware.getCapacityConsumption() <= hardware.getRemainingCapacity()){
                        hardware.addSoftware(newSoftware);
                    }
                }
            }
        }

        if (args.size() == 3){
            Hardware newHardware = this.hardwareFactory.createSystemComponent(systemComponent, args);
            this.theSystem.getHardware().add(newHardware);
        }
    }

    private void releaseSoftwareComponent(List<String> args){
        String hardwareRemoveFrom = args.get(0);
        String softwareToRemove = args.get(1);
        for (Hardware hardware : this.theSystem.getHardware()) {
            if (hardware.getName().equals(hardwareRemoveFrom)){
                for (Software software : hardware.getSoftware()) {
                    if (software.getName().equals(softwareToRemove)){
                        hardware.getSoftware().remove(software);
                    }
                }
            }
        }
    }

    private void analyzeSystem(){
        System.out.println("System Analysis");

        int hardwareComponentsCount = this.theSystem.getHardwareComponentsCount();
        System.out.println(String.format("Hardware Components: %d", hardwareComponentsCount));

        int softwareComponentsCount = this.theSystem.getSoftwareComponentsCount();
        System.out.println(String.format("Software Components: %d", softwareComponentsCount));

        int totalOperationalMemory = this.theSystem.getTotalOperationalMemory();
        int maximumMemory = this.theSystem.getMaximumMemory();
        System.out.println(String.format("Total Operational Memory: %d / %d", totalOperationalMemory, maximumMemory));

        int totalCapacityTaken = this.theSystem.getTotalCapacityTaken();
        int maximumCapacity = this.theSystem.getMaximumCapacity();
        System.out.println(String.format("Total Capacity Taken: %d / %d", totalCapacityTaken, maximumCapacity));

    }
}
