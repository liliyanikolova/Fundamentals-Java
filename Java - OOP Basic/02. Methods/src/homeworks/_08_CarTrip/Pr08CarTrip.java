package homeworks._08_CarTrip;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Car{
    private double speed;
    private double fuel;
    private double fuelEconomy;
    private double totalDistance;
    private double totalTime;

    public Car(double speed, double fuel, double fuelEconomy) {
        this.speed = speed;
        this.fuel = fuel;
        this.fuelEconomy = fuelEconomy;
        this.totalDistance = 0;
        this.totalTime = 0;
    }

    public double getSpeed() {
        return speed;
    }

    public double getFuel() {
        return fuel;
    }

    public double getFuelEconomy() {
        return fuelEconomy;
    }

    public double getTotalDistance() {
        return totalDistance;
    }

    public double getTotalTime() {
        return totalTime;
    }

    public void travelDistance(double distance){
        if ((100 * this.fuel) / this.fuelEconomy < distance){
            distance = (100 * this.fuel) / this.fuelEconomy;
        }

        this.totalDistance += distance;
        this.fuel -= distance * (this.fuelEconomy / 100);
        this.totalTime +=(distance / this.speed) * 60;
    }

    public void refuel(double liters){
        this.fuel += liters;
    }
}

public class Pr08CarTrip {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = reader.readLine().split("\\s+");

        double speed = Double.parseDouble(input[0]);
        double fuel = Double.parseDouble(input[1]);
        double fuelEconomy = Double.parseDouble(input[2]);

        Car car = new Car(speed, fuel,fuelEconomy);

        String command = reader.readLine();
        while (!command.equals("END")){
            String[] splitCommand = command.split("\\s+");
            switch (splitCommand[0]){
                case "Travel":
                    Double distance = Double.parseDouble(splitCommand[1]);
                    car.travelDistance(distance);
                    break;
                case "Refuel":
                    Double liters = Double.parseDouble(splitCommand[1]);
                    car.refuel(liters);
                    break;
                case "Distance":
                    System.out.println(String.format("Total distance: %s kilometers", car.getTotalDistance()));
                    break;
                case "Time":
                    int hours = (int)car.getTotalTime() / 60;
                    int minutes = (int)car.getTotalTime() % 60;
                    System.out.println(String.format("Total time: %d hours and %d minutes", hours, minutes));
                    break;
                case "Fuel":
                    System.out.println(String.format("Fuel left: %s liters", car.getFuel()));
                    break;
            }

            command = reader.readLine();
        }
    }
}
