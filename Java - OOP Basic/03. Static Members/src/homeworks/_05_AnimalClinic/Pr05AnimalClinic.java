package homeworks._05_AnimalClinic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashSet;
import java.util.Set;

class Animal{
    private String name;
    private String breed;

    public Animal(String name, String breed) {
        this.name = name;
        this.breed = breed;
    }

    public String getName() {
        return name;
    }

    public String getBreed() {
        return breed;
    }
}

class AnimalClinic{
    private static int patientId;
    private static int healedAnimalsCount;
    private static int rehabilitatedAnimalsCount;

    public static int getPatientId() {
        return patientId;
    }

    public static int getHealedAnimalsCount() {
        return healedAnimalsCount;
    }

    public static int getRehabilitatedAnimalsCount() {
        return rehabilitatedAnimalsCount;
    }

    public static void increaseHealedAnimalsCount(){
        healedAnimalsCount++;
        patientId++;
    }

    public static void increaseRehabilitatedAnimalsCount(){
        rehabilitatedAnimalsCount++;
        patientId++;
    }
}

public class Pr05AnimalClinic {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Set<Animal> healedAnimals = new LinkedHashSet<>();
        Set<Animal> rehabilitatedAnimals = new LinkedHashSet<>();
        while (true){
            String input = reader.readLine();
            if (input.equals("End")){
                break;
            }

            String[] patientInfo = input.split("\\s+");
            Animal animal = new Animal(patientInfo[0], patientInfo[1]);

            switch (patientInfo[2]){
                case "heal":
                    AnimalClinic.increaseHealedAnimalsCount();
                    System.out.println(String.format("Patient %d: [%s (%s)] has been healed!",
                            AnimalClinic.getPatientId(),
                            animal.getName(),
                            animal.getBreed()));
                    healedAnimals.add(animal);
                    break;
                case "rehabilitate":
                    AnimalClinic.increaseRehabilitatedAnimalsCount();
                    System.out.println(String.format("Patient %d: [%s (%s)] has been rehabilitated!",
                            AnimalClinic.getPatientId(),
                            animal.getName(),
                            animal.getBreed()));
                    rehabilitatedAnimals.add(animal);
                    break;
            }
        }

        System.out.println(String.format("Total healed animals: %d", AnimalClinic.getHealedAnimalsCount()));
        System.out.println(String.format("Total rehabilitated animals: %d", AnimalClinic.getRehabilitatedAnimalsCount()));

        String input = reader.readLine();
        switch (input){
            case "heal":
                for (Animal animal : healedAnimals) {
                    System.out.println(String.format("%s %s", animal.getName(), animal.getBreed()));
                }
                break;
            case "rehabilitate":
                for (Animal animal : rehabilitatedAnimals) {
                    System.out.println(String.format("%s %s", animal.getName(), animal.getBreed()));
                }
                break;
        }
    }
}
