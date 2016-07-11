package homeworks._01_Vehicles;

import homeworks._01_Vehicles.Models.Bus;
import homeworks._01_Vehicles.Models.Car;
import homeworks._01_Vehicles.Models.Truck;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;

public class Main {
    private static Car car;
    private static Bus bus;
    private static Truck truck;
    private static DecimalFormat df = new DecimalFormat("0.######");

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] carInfo = reader.readLine().split("\\s+");
        double fuelQuantityCar = Double.valueOf(carInfo[1]);
        double fuelConsumptionInLitersPerKmCar = Double.valueOf(carInfo[2]);
        double tankCapacityCar = Double.valueOf(carInfo[3]);
        car = new Car(fuelQuantityCar, fuelConsumptionInLitersPerKmCar, tankCapacityCar);

        String[] truckInfo = reader.readLine().split("\\s+");
        double fuelQuantityTruck = Double.valueOf(truckInfo[1]);
        double fuelConsumptionInLitersPerKmTruck = Double.valueOf(truckInfo[2]);
        double tankCapacityTrunk = Double.valueOf(truckInfo[3]);
        truck = new Truck(fuelQuantityTruck, fuelConsumptionInLitersPerKmTruck, tankCapacityTrunk);

        String[] busInfo = reader.readLine().split("\\s+");
        double fuelQuantityBus = Double.valueOf(busInfo[1]);
        double fuelConsumptionInLitersPerKmBus = Double.valueOf(busInfo[2]);
        double tankCapacityBus = Double.valueOf(busInfo[3]);
        bus = new Bus(fuelQuantityBus, fuelConsumptionInLitersPerKmBus, tankCapacityBus);

        int commandsCount = Integer.valueOf(reader.readLine());
        for (int i = 0; i < commandsCount; i++) {
            String[] commandInfo = reader.readLine().split("\\s+");
            String command = commandInfo[0];
            String vehicle = commandInfo[1];
            double value = Double.valueOf(commandInfo[2]);
            switch (command) {
                case "Drive":
                    executeDriveCommand(vehicle, value);
                    break;
                case "Refuel":
                    executeRefuelCommand(vehicle, value);
                    break;
                case "DriveEmpty":
                    executeDriveEmptyCommand(vehicle, value);
                    break;
            }
        }

        System.out.println(String.format("Car: %.2f", car.getFuelQuantity()));
        System.out.println(String.format("Truck: %.2f", truck.getFuelQuantity()));
        System.out.println(String.format("Bus: %.2f", bus.getFuelQuantity()));
    }

    private static void executeDriveCommand(String vehicle, double distance){
       try {
           switch (vehicle) {
               case "Car": {
                   if (car.canDriveDistance(distance)) {
                       System.out.println(String.format("Car travelled %s km", df.format(distance)));
                   } else {
                       System.out.println("Car needs refueling");
                   }
                   break;
               }
               case "Truck": {
                   if (truck.canDriveDistance(distance)) {
                       System.out.println(String.format("Truck travelled %s km", df.format(distance)));
                   } else {
                       System.out.println("Truck needs refueling");
                   }
                   break;
               }
               case "Bus": {
                   if (bus.canDriveDistance(distance)) {
                       System.out.println(String.format("Bus travelled %s km", df.format(distance)));
                   } else {
                       System.out.println("Bus needs refueling");
                   }
                   break;
               }
           }

       } catch (IllegalArgumentException iae){
           System.out.println(iae.getMessage());
       }
    }

    private static void executeDriveEmptyCommand(String vehicle, double distance){
        try {
            if (bus.canDriveDistanceEmpty(distance)) {
                System.out.println(String.format("Bus travelled %s km", df.format(distance)));
            } else {
                System.out.println("Bus needs refueling");
            }
        } catch (IllegalArgumentException iae){
            System.out.println(iae.getMessage());
        }
    }

    private static void executeRefuelCommand(String vehicle, double liters){
        try {
            switch (vehicle) {
                case "Car":
                    car.refuelLiters(liters);
                    break;
                case "Truck":
                    truck.refuelLiters(liters);
                    break;
                case "Bus":
                    bus.refuelLiters(liters);
                    break;
            }
        } catch (IllegalArgumentException iae){
            System.out.println(iae.getMessage());
        }
    }
}
