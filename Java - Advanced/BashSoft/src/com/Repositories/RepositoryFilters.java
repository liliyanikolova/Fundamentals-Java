package com.Repositories;

import com.ExceptionMessages;
import com.OutputWriter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.function.Predicate;

public class RepositoryFilters {
    public static void printFilteredStudents(
            HashMap<String, ArrayList<Integer>> courseData,
            String filterType,
            Integer numberOfStudents){

        Predicate<Double> filter = createFilter(filterType);
        filterAndTake(filter, courseData, numberOfStudents);
    }

    private static void filterAndTake(Predicate<Double> filter, HashMap<String, ArrayList<Integer>> courseData, int numberOfStudents){
        if (filter == null){
            OutputWriter.displayException(ExceptionMessages.INVALID_FILTER);
            return;
        }

        int studentsCount = 0;
        for (String student : courseData.keySet()) {
            if (studentsCount == numberOfStudents){
                break;
            }
            List<Integer> studentMarks = courseData.get(student);
            double averageMark = studentMarks
                    .stream()
                    .mapToInt(Integer::valueOf)
                    .average()
                    .getAsDouble();
            Double percentageOfFullfillments = averageMark / 100;
            Double mark = percentageOfFullfillments * 4 + 2;
            if (filter.test(mark)){
                OutputWriter.printStudent(student, studentMarks);
                studentsCount++;
            }
        }
    }

    private static Predicate<Double> createFilter(String filterType) {
        switch (filterType){
            case "excellent":
                return mark -> mark >= 5.0;
            case "average":
                return mark -> mark >= 3.5 && mark < 5.0;
            case "poor":
                return mark -> mark < 3.5;
            default:
                return null;
        }
    }
}
