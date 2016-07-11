package homeworks._01_MethodSaysHello;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

class Person{
    private String name;

    public Person(String name) {
        this.name = name;
    }

    public String greet(){
        return String.format("%s says \"Hello\"!", this.name);
    }
}

public class Pr01MethodSaysHello {
    public static void main(String[] args) throws ClassNotFoundException, IOException {
        Field[] fields = Person.class.getDeclaredFields();
        Method[] methods = Person.class.getDeclaredMethods();
        if (fields.length != 1 || methods.length != 1) {
            throw new ClassFormatError();
        }

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name = reader.readLine();
        Person peter = new Person(name);
        System.out.println(peter.greet());
    }
}
