package com;

import com.components.hardware.HardwareFactory;
import com.components.software.SoftwareFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) throws IOException {
	    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        TheSystem theSystem = new TheSystem();
        SoftwareFactory softwareFactory = new SoftwareFactory();
        HardwareFactory hardwareFactory = new HardwareFactory();
        CommandDispatcher commandDispatcher = new CommandDispatcher(theSystem, softwareFactory, hardwareFactory);

        while (true){
            String input = reader.readLine();
            if (input.equals("System Split")){
                System.out.println(theSystem);
                break;
            }

            String[] splitInput = input.split("\\(");
            Pattern pattern = Pattern.compile("([A-Z][a-z]+)");
            Matcher matcher = pattern.matcher(splitInput[0]);
            String command = "";
            if (matcher.find()){
                command = matcher.group(1);
            }

            String systemComponent = splitInput[0].replace(command, "");
            List<String> arguments = Arrays.asList(splitInput[1].replace(")", "").split(", "));
            commandDispatcher.dispatchCommand(command, systemComponent, arguments);
        }
    }
}
