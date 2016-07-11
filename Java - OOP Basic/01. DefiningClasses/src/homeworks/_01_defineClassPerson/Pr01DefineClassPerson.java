package homeworks._01_defineClassPerson;

import java.lang.reflect.Field;

class Person {
    String name;
    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Person() {
    }
}

public class Pr01DefineClassPerson {

    public static void main(String[] args) throws Exception {
        Class person = Person.class;
        Field[] fields = person.getDeclaredFields();
        System.out.println(fields.length);

        Person pesho = new Person("Pesho", 20);
        Person gosho = new Person();

        gosho.name = "Gosho";
        gosho.age = 18;
    }

}
