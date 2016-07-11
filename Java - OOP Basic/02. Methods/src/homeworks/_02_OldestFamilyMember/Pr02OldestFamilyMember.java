package homeworks._02_OldestFamilyMember;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;

class Person{
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

class Family{
    private LinkedList<Person> members;

    public Family() {
        this.members = new LinkedList<>();
    }

    public void addMember(Person member){
        this.members.add(member);
    }

    public Person getOldestMember(){
        Person oldestMember = this.members.get(0);
        for (Person member : this.members) {
            if (member.getAge() > oldestMember.getAge()){
                oldestMember = member;
            }
        }
        
        return oldestMember;
    }
}

public class Pr02OldestFamilyMember {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int membersCount = Integer.parseInt(reader.readLine());
        Family family = new Family();
        for (int i = 0; i < membersCount; i++) {
            String[] input = reader.readLine().split("\\s+");
            String name = input[0];
            int age = Integer.parseInt(input[1]);
            Person newMember = new Person(name, age);
            family.addMember(newMember);
        }

        Person oldestMember = family.getOldestMember();
        System.out.println(String.format("%s %d", oldestMember.getName(), oldestMember.getAge()));
    }
}
