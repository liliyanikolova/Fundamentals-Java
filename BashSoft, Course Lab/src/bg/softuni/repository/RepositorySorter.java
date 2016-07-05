package bg.softuni.repository;

import bg.softuni.io.OutputWriter;
import bg.softuni.models.Course;
import bg.softuni.models.Student;
import bg.softuni.staticData.ExceptionMessages;

import java.util.*;
import java.util.stream.Collectors;

public class RepositorySorter {
    public void printSortedStudents(
            HashMap<String, Double> courseData,
            String comparisonType,
            int numberOfStudents) {
        comparisonType = comparisonType.toLowerCase();

        if (!comparisonType.equals("ascending") && !comparisonType.equals("descending")) {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_COMPARISON_QUERY);
        }

        Comparator<Map.Entry<String, Double>> comparator = (x, y) ->
                Double.compare(x.getValue(), y.getValue());

        List<String> sortedStudents = courseData.entrySet()
                .stream()
                .sorted(comparator)
                .limit(numberOfStudents)
                .map(x -> x.getKey())
                .collect(Collectors.toList());

        if (comparisonType.equals("descending")) {
            Collections.reverse(sortedStudents);
        }


        printStudents(courseData, sortedStudents);
    }

    private void printStudents(HashMap<String, Double> courseData, List<String> sortedStudents) {
        for (String student : sortedStudents) {
            OutputWriter.printStudent(student, courseData.get(student));
        }
    }
}

