package homeworks._06_RawData;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

class Car{
    private String model;
    private Engine engine;
    private Cargo cargo;
    private List<Tire> tires;

    public Car(String model, Engine engine, Cargo cargo, List<Tire> tires) {
        this.setModel(model);
        this.setEngine(engine);
        this.setCargo(cargo);
        this.setTires(tires);
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public List<Tire> getTires() {
        return tires;
    }

    public void setTires(List<Tire> tires) {
        this.tires = tires;
    }
}

class Engine{
    private int engineSpeed;
    private int enginePower;

    public Engine(int engineSpeed, int enginePower) {
        this.engineSpeed = engineSpeed;
        this.enginePower = enginePower;
    }

    public int getEngineSpeed() {
        return engineSpeed;
    }

    public void setEngineSpeed(int engineSpeed) {
        this.engineSpeed = engineSpeed;
    }

    public int getEnginePower() {
        return enginePower;
    }

    public void setEnginePower(int enginePower) {
        this.enginePower = enginePower;
    }
}

class Cargo{
    private int cargoWeight;
    private String CargoType;

    public Cargo(int cargoWeight, String cargoType) {
        this.cargoWeight = cargoWeight;
        CargoType = cargoType;
    }

    public int getCargoWeight() {
        return cargoWeight;
    }

    public void setCargoWeight(int cargoWeight) {
        this.cargoWeight = cargoWeight;
    }

    public String getCargoType() {
        return CargoType;
    }

    public void setCargoType(String cargoType) {
        CargoType = cargoType;
    }
}

class Tire{
    private double tirePressure;
    private int tireAge;

    public Tire(double tirePressure, int tireAge) {
        this.tirePressure = tirePressure;
        this.tireAge = tireAge;
    }

    public double getTirePressure() {
        return tirePressure;
    }

    public void setTirePressure(double tirePressure) {
        this.tirePressure = tirePressure;
    }

    public int getTireAge() {
        return tireAge;
    }

    public void setTireAge(int tireAge) {
        this.tireAge = tireAge;
    }
}

public class Pr06RawData {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int carsAmount = Integer.parseInt(reader.readLine());
        LinkedList<Car> cars = new LinkedList<>();
        for (int i = 0; i < carsAmount; i++) {
            String[] input = reader.readLine().split("\\s+");
            Car currentCar = createCar(input);

            cars.add(currentCar);
        }

        String filterCriteria = reader.readLine();

        for (Car car : cars) {
            if (filterCriteria.equals("fragile")){
                if (car.getCargo().getCargoType().equals("fragile")){
                    for (Tire tire : car.getTires()) {
                        if (tire.getTirePressure() < 1){
                            System.out.println(car.getModel());
                            break;
                        }
                    }
                }
            } else {
                if (car.getCargo().getCargoType().equals("flamable") &&
                        car.getEngine().getEnginePower() > 250){
                            System.out.println(car.getModel());
                }
            }
        }
    }

    private static Car createCar(String[] input){
        String model = input[0];
        int engineSpeed = Integer.parseInt(input[1]);
        int enginePower = Integer.parseInt(input[2]);
        int cargoWeight = Integer.parseInt(input[3]);
        String cargoType = input[4];
        double tire1Pressure = Double.parseDouble(input[5]);
        int tire1Age = Integer.parseInt(input[6]);
        double tire2Pressure = Double.parseDouble(input[7]);
        int tire2Age = Integer.parseInt(input[8]);
        double tire3Pressure = Double.parseDouble(input[9]);
        int tire3Age = Integer.parseInt(input[10]);
        double tire4Pressure = Double.parseDouble(input[11]);
        int tire4Age = Integer.parseInt(input[12]);

        Engine engine = new Engine(engineSpeed, enginePower);
        Cargo cargo = new Cargo(cargoWeight, cargoType);
        Tire tire1 = new Tire(tire1Pressure, tire1Age);
        Tire tire2 = new Tire(tire2Pressure, tire2Age);
        Tire tire3 = new Tire(tire3Pressure, tire3Age);
        Tire tire4 = new Tire(tire4Pressure, tire4Age);
        LinkedList<Tire> tires = new LinkedList<>();
        tires.add(tire1);
        tires.add(tire2);
        tires.add(tire3);
        tires.add(tire4);

        return new Car(model, engine, cargo, tires);
    }
}
