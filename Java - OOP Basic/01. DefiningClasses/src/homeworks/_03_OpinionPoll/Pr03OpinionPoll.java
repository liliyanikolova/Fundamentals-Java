package homeworks._03_OpinionPoll;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

class Person{
    String name;
    int age;

    public Person() {
        this("No name", 1);
    }

    public Person(int age) {
        this("No name", age);
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

public class Pr03OpinionPoll {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        LinkedList<String> people = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            people.add(reader.readLine());
        }

        LinkedList<String> greaterThan30 = new LinkedList<>();
        for (String person : people) {
            String[] input = person.split("\\s+");
            String name = input[0];
            int age = Integer.parseInt(input[1]);

            if (age > 30){
                greaterThan30.add(person);
            }
        }

        greaterThan30.sort((firstPerson, secondPerson) -> firstPerson.compareTo(secondPerson));

        for (String person : greaterThan30) {
            String[] data = person.split("\\s+");
            String name = data[0];
            int age = Integer.parseInt(data[1]);
            System.out.println(name + " - " + age);
        }
    }
}
