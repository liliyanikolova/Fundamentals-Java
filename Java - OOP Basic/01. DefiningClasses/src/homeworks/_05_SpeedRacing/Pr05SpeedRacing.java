package homeworks._05_SpeedRacing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashSet;
import java.util.Set;

class Car{
    private String model;
    private double fuelAmount;
    private double fuelCostPerKilometer;
    private double distanceTraveled;

    public Car(String model, double fuelAmount, double fuelCostPerKilometer) {
        this.model = model;
        this.fuelAmount = fuelAmount;
        this.fuelCostPerKilometer = fuelCostPerKilometer;
        this.distanceTraveled = 0;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getFuelAmount() {
        return fuelAmount;
    }

    public void setFuelAmount(double fuelAmount) {
        this.fuelAmount = fuelAmount;
    }

    public double getFuelCostPerKilometer() {
        return fuelCostPerKilometer;
    }

    public void setFuelCostPerKilometer(double fuelCostPerKilometer) {
        this.fuelCostPerKilometer = fuelCostPerKilometer;
    }

    public double getDistanceTraveled() {
        return distanceTraveled;
    }

    public void setDistanceTraveled(double distanceTraveled) {
        this.distanceTraveled = distanceTraveled;
    }

    public void moveCar(double distance){
        if (canCarMove(distance)){
            this.setFuelAmount(this.getFuelAmount() - distance * this.getFuelCostPerKilometer());
            this.setDistanceTraveled(this.getDistanceTraveled() + distance);

        } else {
            System.out.println("Insufficient fuel for the drive");
        }
    }

    @Override
    public String toString() {
        String result = String.format("%s %.2f %.0f", this.getModel(), this.getFuelAmount(), this.getDistanceTraveled());

        return result;
    }

    private boolean canCarMove(double distance){
        return this.fuelAmount >= distance * this.getFuelCostPerKilometer();
    }
}

public class Pr05SpeedRacing {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int carsNumber = Integer.parseInt(reader.readLine());
        Set<Car> cars = new LinkedHashSet<>();
        for (int i = 0; i < carsNumber; i++) {
            String[] input = reader.readLine().split("\\s+");
            String model = input[0];
            double fuelAmount = Double.parseDouble(input[1]);
            double fuelCostFor1km = Double.parseDouble(input[2]);
            Car newCar = new Car(model, fuelAmount, fuelCostFor1km);
            cars.add(newCar);
        }

        String command = reader.readLine();
        while (!command.equals("End")){
            String[] splitCommand = command.split("\\s+");
            String carModel = splitCommand[1];
            double distance = Double.parseDouble(splitCommand[2]);

            for (Car car : cars) {
                if (car.getModel().equals(carModel)){
                    car.moveCar(distance);
                    continue;
                }
            }

            command = reader.readLine();
        }

        for (Car car : cars) {
            System.out.println(car);
        }
    }
}
