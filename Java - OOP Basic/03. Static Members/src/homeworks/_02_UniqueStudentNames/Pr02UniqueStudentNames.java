package homeworks._02_UniqueStudentNames;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

class Student{
    private String name;

    public Student(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

class StudentGroup{
    private HashSet<Student> students;
    private static int uniqueStudentsCount;

    public StudentGroup() {
        this.students = new HashSet<>();
    }

    public static int getUniqueStudentsCount() {
        return uniqueStudentsCount;
    }

    public void addStudent(Student student){
        for (Student existingStudent : students) {
            if(existingStudent.getName().equals(student.getName())){
                return;
            }
        }

        this.students.add(student);
        uniqueStudentsCount = this.students.size();
    }
}

public class Pr02UniqueStudentNames {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();
        StudentGroup studentGroup = new StudentGroup();
        while (!input.equals("End")){
            Student student = new Student(input);
            studentGroup.addStudent(student);

            input = reader.readLine();
        }

        System.out.println(StudentGroup.getUniqueStudentsCount());
    }
}
