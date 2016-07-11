package homeworks._01_Students;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Student{
    private String name;
    private static int studentsCount = 0;

    public Student(String name) {
        this.name = name;
        studentsCount++;
    }

    public static int getStudentsCount() {
        return studentsCount;
    }
}

public class Pr01Students {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();
        while (!input.equals("End")){
            Student student = new Student(input);

            input = reader.readLine();
        }

        System.out.println(Student.getStudentsCount());
    }
}
