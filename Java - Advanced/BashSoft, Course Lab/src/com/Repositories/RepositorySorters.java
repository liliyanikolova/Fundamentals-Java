package com.Repositories;

import com.OutputWriter;

import java.util.*;

public class RepositorySorters {
    public static void printSortedStudents(
            HashMap<String, ArrayList<Integer>> courseData,
            String comparisonType,
            int numberOfStudents){
        Comparator<Map.Entry<String, ArrayList<Integer>>> comperator = createComperator(comparisonType);

        ArrayList<Map.Entry<String, ArrayList<Integer>>> sortedStudents = new ArrayList<>();

        Collections.sort(sortedStudents, comperator);
        for (Map.Entry<String, ArrayList<Integer>> student : sortedStudents) {
            OutputWriter.printStudent(student.getKey(), student.getValue());
        }
    }

    private static Comparator<Map.Entry<String, ArrayList<Integer>>> createComperator(String comparisonType){
        switch (comparisonType){
            case "ascending":
                return new Comparator<Map.Entry<String, ArrayList<Integer>>>() {
                    @Override
                    public int compare(
                            Map.Entry<String, ArrayList<Integer>> fisrtSudent,
                            Map.Entry<String, ArrayList<Integer>> secondSudent) {
                        Double firstStudentTotal = getTotalScore(fisrtSudent.getValue());
                        Double secondStudentTotal = getTotalScore(fisrtSudent.getValue());

                        return firstStudentTotal.compareTo(secondStudentTotal);
                    }
                };
            case "descending":
                return new Comparator<Map.Entry<String, ArrayList<Integer>>>() {
                    @Override
                    public int compare(
                            Map.Entry<String, ArrayList<Integer>> fisrtSudent,
                            Map.Entry<String, ArrayList<Integer>> secondSudent) {
                        Double firstStudentTotal = getTotalScore(fisrtSudent.getValue());
                        Double secondStudentTotal = getTotalScore(fisrtSudent.getValue());

                        return secondStudentTotal.compareTo(firstStudentTotal);
                    }
                };
            default:
                return null;
        }
    }

    private static Double getTotalScore(ArrayList<Integer> grades) {
        Double total = 0d;
        for (Integer grade : grades) {
            total += grade;
        }

        return total / grades.size();
    }
}
