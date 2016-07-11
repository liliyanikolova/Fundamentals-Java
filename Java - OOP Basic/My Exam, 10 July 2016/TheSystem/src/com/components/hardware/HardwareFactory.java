package com.components.hardware;

import java.util.List;

public class HardwareFactory {
    public Hardware createSystemComponent(String componentType, List<String> args){
        Hardware hardwareComponent = null;
        switch (componentType){
            case "HeavyHardware":
                hardwareComponent = new HeavyHardware(args.get(0),
                        Integer.valueOf((args.get(1)).trim()),
                        Integer.valueOf((args.get(2)).trim()));
                break;
            case "PowerHardware":
                hardwareComponent = new PowerHardware(args.get(0),
                        Integer.valueOf((args.get(1)).trim()),
                        Integer.valueOf((args.get(2)).trim()));
                break;
            default:
                break;
        }

        return hardwareComponent;
    }
}
