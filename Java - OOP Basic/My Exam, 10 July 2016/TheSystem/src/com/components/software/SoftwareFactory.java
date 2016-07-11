package com.components.software;

import java.util.List;

public class SoftwareFactory {
    public Software createSystemComponent(String componentType, List<String> args){
        Software softwareComponent = null;
        switch (componentType){
            case "LightSoftware":
                softwareComponent = new LightSoftware(args.get(1),
                        Integer.valueOf((args.get(2)).trim()),
                        Integer.valueOf((args.get(3)).trim()));
                break;
            case "ExpressSoftware":
                softwareComponent = new ExpressSoftware(args.get(1),
                        Integer.valueOf((args.get(2)).trim()),
                        Integer.valueOf((args.get(3)).trim()));
                break;
            default:
                break;
        }

        return softwareComponent;
    }

}
