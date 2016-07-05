package bg.softuni.models;

import bg.softuni.exceptions.DuplicateEntryInStructureException;
import bg.softuni.exceptions.InvalidStringException;
import bg.softuni.io.OutputWriter;
import bg.softuni.staticData.ExceptionMessages;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class Course {
    public static final int NUMBER_OF_TASKS_ON_EXAM = 5;
    public static final int MAX_SCORE_ON_EXAM_TASK = 100;

    private String name;
    private LinkedHashMap<String, Student> studentsByName;

    public Course(String name) {
        this.setName(name);
        this.studentsByName = new LinkedHashMap<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.equals("")){
            throw new InvalidStringException();
        }

        this.name = name;
    }

    public Map<String, Student> getStudentsByName() {
        return Collections.unmodifiableMap(this.studentsByName);
    }

    public void enrollStudent(Student student){
        if (this.getStudentsByName().containsKey(student.getUserName())){
            throw new DuplicateEntryInStructureException(student.getUserName(), this.name);
        }

        this.studentsByName.put(student.getUserName(), student);
    }
}
