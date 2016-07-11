package homeworks._07_CarSalesman;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

class Engine{
    private String model;
    private  int power;
    private int displacement;
    private String efficiency;

    public Engine(String model, int power, int displacement, String efficiency) {
        this.setModel(model);
        this.setPower(power);
        this.setDisplacement(displacement);
        this.setEfficiency(efficiency);
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public int getDisplacement() {
        return displacement;
    }

    public void setDisplacement(int displacement) {
        this.displacement = displacement;
    }

    public String getEfficiency() {
        return efficiency;
    }

    public void setEfficiency(String efficiency) {
        this.efficiency = efficiency;
    }

    @Override
    public String toString() {
        String result = null;
        if(this.getDisplacement() == -1){
            result = this.getModel() + ":" + "\n" +
                    "    " + "Power: " + this.getPower() + "\n" +
                    "    " + "Displacement: n/a" + "\n" +
                    "    " + "Efficiency: " + this.getEfficiency();
        } else {
            result = this.getModel() + ":" + "\n" +
                    "    " + "Power: " + this.getPower() + "\n" +
                    "    " + "Displacement: " + this.getDisplacement() + "\n" +
                    "    " + "Efficiency: " + this.getEfficiency();
        }

        return result;
    }
}

class Car{
    private String model;
    private Engine engine;
    private int weight;
    private String color;

    public Car(String model, Engine engine, int weight, String color) {
        this.setModel(model);
        this.setEngine(engine);
        this.setWeight(weight);
        this.setColor(color);
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

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        String result = null;
        if (this.getWeight() == -1){
            result = this.getModel() + ":" + "\n" +
                    "  " + this.getEngine() + "\n" +
                    "  " + "Weight: n/a" + "\n" +
                    "  " + "Color: " + this.getColor();
        } else {
            result = this.getModel() + ":" + "\n" +
                    "  " + this.getEngine() + "\n" +
                    "  " + "Weight: " + this.getWeight() + "\n" +
                    "  " + "Color: " + this.getColor();
        }

        return result;
    }
}

public class Pr07CarSalesman {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int enginesCount = Integer.parseInt(reader.readLine());
        LinkedList<Engine> engines = new LinkedList<>();
        for (int i = 0; i < enginesCount; i++) {
            String[] input = reader.readLine().split("\\s+");
            Engine engine = createEngine(input);

            engines.add(engine);
        }

        int carsCount = Integer.parseInt(reader.readLine());
        LinkedList<Car> cars = new LinkedList<>();
        for (int i = 0; i < carsCount; i++) {
            String[] input = reader.readLine().split("\\s+");
            Car car = createCar(input, engines);

            cars.add(car);
        }

        for (Car car : cars) {
            System.out.println(car);
        }
    }

    private static boolean isNumber(String input){
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException ex){
            return false;
        }
    }

    private static Engine createEngine(String[] input){
        String model = input[0];
        int power = Integer.parseInt(input[1]);
        int displacement = -1;
        String efficiency = "n/a";

        if (input.length == 3){
            if (isNumber(input[2])){
                displacement = Integer.parseInt(input[2]);
            } else {
                efficiency = input[2];
            }
        }

        if (input.length == 4){
            displacement = Integer.parseInt(input[2]);
            efficiency = input[3];
        }

        return new Engine(model, power, displacement, efficiency);
    }

    private static Car createCar(String[] input, LinkedList<Engine> engines){
        String model = input[0];
        Engine currentEngine = getEngine(input[1], engines);
        int weight = -1;
        String color = "n/a";

        if (input.length == 3){
            if (isNumber(input[2])){
                weight = Integer.parseInt(input[2]);
            } else {
                color = input[2];
            }
        }

        if (input.length == 4){
            weight = Integer.parseInt(input[2]);
            color = input[3];
        }

        return new Car(model, currentEngine, weight, color);
    }

    private static Engine getEngine(String criteriaEngine, LinkedList<Engine> engines){
        for (Engine engine : engines) {
            if (engine.getModel().equals(criteriaEngine)){
                return engine;
            }
        }

        return null;
    }
}
