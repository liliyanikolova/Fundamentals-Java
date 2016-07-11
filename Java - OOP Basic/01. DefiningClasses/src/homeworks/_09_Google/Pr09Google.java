package homeworks._09_Google;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Pokemon{
    private String name;
    private String type;

    public Pokemon(String name, String type) {
        this.setName(name);
        this.setType(type);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        String result = String.format("%s %s\n", this.getName(), this.getType());

        return result;
    }
}

abstract class Human{
    private String name;
    private String birthday;

    public Human(String name, String birthday) {
        this.setName(name);
        this.setBirthday(birthday);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        String result = String.format("%s %s\n",this.getName(), this.getBirthday());

        return result.toString();
    }
}

class Parent extends Human{
    public Parent(String name, String birthday) {
        super(name, birthday);
    }
}

class Child extends Human{
    public Child(String name, String birthday) {
        super(name, birthday);
    }
}

class Car{
    private String model;
    private int speed;

    public Car(String model, int speed) {
        this.setModel(model);
        this.setSpeed(speed);
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    @Override
    public String toString() {
        String result = String.format("%s %d\n", this.getModel(), this.getSpeed());

        return result;
    }
}

class Company {
    private String name;
    private String department;
    private double salary;

    public Company(String name, String department, double salary) {
        this.setName(name);
        this.setDepartment(department);
        this.setSalary(salary);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {

        StringBuilder result = new StringBuilder(this.getName() + " ");
        result.append(this.getDepartment() + " ");
        result.append(String.format("%.2f\n", this.getSalary()));

        return result.toString();
    }
}

class Person {
    private String name;
    private Company company;
    private LinkedList<Pokemon> pokemons;
    private LinkedList<Parent> parents;
    private LinkedList<Child> children;
    private Car car;

    public Person(String name) {
        this.setName(name);
        this.pokemons = new LinkedList<>();
        this.parents = new LinkedList<>();
        this.children = new LinkedList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public LinkedList<Pokemon> getPokemons() {
        return pokemons;
    }

    public void setPokemons(LinkedList<Pokemon> pokemons) {
        this.pokemons = pokemons;
    }

    public LinkedList<Parent> getParents() {
        return parents;
    }

    public void setParents(LinkedList<Parent> parents) {
        this.parents = parents;
    }

    public LinkedList<Child> getChildren() {
        return children;
    }

    public void setChildren(LinkedList<Child> children) {
        this.children = children;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append(String.format("%s\n", this.getName()));
        result.append(String.format("Company:\n"));
        if (this.getCompany() != null){
            result.append(this.getCompany());
        }

        result.append(String.format("Car:\n"));
        if (this.getCar() != null){
            result.append(this.getCar());
        }

        result.append(String.format("Pokemon:\n"));
        for (int i = 0; i < this.getPokemons().size(); i++) {
            result.append(this.getPokemons().get(i));
        }

        result.append(String.format("Parents:\n"));
        for (int i = 0; i < this.getParents().size(); i++) {
            result.append(this.getParents().get(i));
        }

        result.append(String.format("Children:\n"));
        for (int i = 0; i < this.getChildren().size(); i++) {
            result.append(this.getChildren().get(i));
        }

        return result.toString();
    }
}

public class Pr09Google {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();
        HashMap<String, Person> personByName = new HashMap<>();
        while (!input.equals("End")) {
            String[] personInfo = input.split("\\s+");
            String personName = personInfo[0];
            Person person;
            if (!personByName.containsKey(personName)) {
                person = new Person(personName);
                personByName.put(personName, person);
            } else {
                person = personByName.get(personName);
            }

            setPersonInfo(person, personInfo);

            input = reader.readLine();
        }

        String targetPersonName = reader.readLine();
        Person targetPerson = personByName.get(targetPersonName);
        System.out.println(targetPerson);
    }

    private static void setPersonInfo(Person person, String[] personInfo) {
        switch (personInfo[1]) {
            case "company":
                person.setCompany(new Company(personInfo[2], personInfo[3], Double.parseDouble(personInfo[4])));
                break;
            case "pokemon":
                person.getPokemons().add(new Pokemon(personInfo[2], personInfo[3]));
                break;
            case "parents":
                person.getParents().add(new Parent(personInfo[2], personInfo[3]));
                break;
            case "children":
                person.getChildren().add(new Child(personInfo[2], personInfo[3]));
                break;
            case "car":
                person.setCar(new Car(personInfo[2], Integer.parseInt(personInfo[3])));
                break;
        }
    }
}
