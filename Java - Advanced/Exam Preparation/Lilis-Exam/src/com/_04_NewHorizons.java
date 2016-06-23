package com;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class _04_NewHorizons {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        LinkedHashMap<String, LinkedHashMap<String, LinkedHashMap<String, Integer>>> database = new LinkedHashMap<>();
        while (!input.equals("Expand your horizons")){
            String[] courseData = input.split("/");
            String course = courseData[0];
            String lecturer = courseData[1];
            String lecture = courseData[2];
            Integer peopleCount = Integer.parseInt(courseData[3]);

            if (!database.containsKey(course)){
                database.put(course, new LinkedHashMap<>());
            }

            if (!database.get(course).containsKey(lecturer)){
                LinkedHashMap<String ,Integer> lectures = new LinkedHashMap<>();
                database.get(course).put(lecturer, lectures);
            }

            if (!database.get(course).get(lecturer).containsKey(lecture)){
                database.get(course).get(lecturer).put(lecture, 0);
            }

            database.get(course).get(lecturer).put(lecture, database.get(course).get(lecturer).get(lecture).intValue() + peopleCount);

            input = scanner.nextLine();
        }

        LinkedHashMap<String, LinkedHashMap<String, LinkedHashMap<String, Integer>>> sortedCourses =
                database.entrySet()
                        .stream()
                        .sorted((firstCourse, secondCourse) -> {
                            Integer firstCoursePeopleCount = 0;
                            Integer secondCoursePeopleCount = 0;
                            for (Map.Entry<String,LinkedHashMap<String,Integer>> lecturerEntry : firstCourse.getValue().entrySet()) {
                                for (Map.Entry<String,Integer> lectureEntry : lecturerEntry.getValue().entrySet()) {
                                    firstCoursePeopleCount += lectureEntry.getValue();
                                }
                            }

                            for (Map.Entry<String,LinkedHashMap<String,Integer>> lecturerEntry : secondCourse.getValue().entrySet()) {
                                for (Map.Entry<String,Integer> lectureEntry : lecturerEntry.getValue().entrySet()) {
                                    secondCoursePeopleCount += lectureEntry.getValue();
                                }
                            }

                            return secondCoursePeopleCount.compareTo(firstCoursePeopleCount);
                        })
                        .sorted((firstCourse, secondCourse) -> {
                            Integer firstCurseLectureCount = 0;
                            Integer secondCurseLectureCount = 0;
                            for (Map.Entry<String,LinkedHashMap<String,Integer>> lecturersEntry : firstCourse.getValue().entrySet()) {
                                firstCurseLectureCount = lecturersEntry.getValue().size();
                            }

                            for (Map.Entry<String,LinkedHashMap<String,Integer>> lecturersEntry : secondCourse.getValue().entrySet()) {
                                secondCurseLectureCount = lecturersEntry.getValue().size();
                            }

                            return firstCurseLectureCount.compareTo(secondCurseLectureCount);
                        })
                        .collect(Collectors.toMap(
                                Map.Entry::getKey,
                                Map.Entry::getValue,
                                (x,y)-> {throw new AssertionError();},
                                LinkedHashMap::new
                        ));

        for (Map.Entry<String, LinkedHashMap<String, LinkedHashMap<String, Integer>>> courseEntry : sortedCourses.entrySet()) {
            System.out.printf("Course - %s\n", courseEntry.getKey());
            LinkedHashMap<String, LinkedHashMap<String, Integer>> sortedLecturers =
                    courseEntry.getValue()
                    .entrySet()
                    .stream()
                    .sorted((firstLecturer, secondLecturer) -> {
                        Integer firstLecturerLecturesCount = firstLecturer.getValue().size();
                        Integer secondLecturerLecturesCount = secondLecturer.getValue().size();

                        return secondLecturerLecturesCount.compareTo(firstLecturerLecturesCount);
                    })
                    .sorted((firstLecturer, secondLecturer) -> {
                        return firstLecturer.getKey().compareTo(secondLecturer.getKey());
                    })
                    .collect(Collectors.toMap(
                            Map.Entry::getKey,
                            Map.Entry::getValue,
                            (x,y)-> {throw new AssertionError();},
                            LinkedHashMap::new
                    ));

            for (Map.Entry<String,LinkedHashMap<String,Integer>> lecturerEntry : sortedLecturers.entrySet()) {
                System.out.printf("Lecturer - %s\n", lecturerEntry.getKey());
                LinkedHashMap<String, Integer> sortedLectures =
                        lecturerEntry.getValue()
                        .entrySet()
                        .stream()
                        .sorted((firstLecture, secondLecture) -> {
                            Integer firstLecturePeopleCount = firstLecture.getValue();
                            Integer secondLecturePeopleCount = secondLecture.getValue();

                            return secondLecturePeopleCount.compareTo(firstLecturePeopleCount);
                        })
                        .collect(Collectors.toMap(
                                Map.Entry::getKey,
                                Map.Entry::getValue,
                                (x,y)-> {throw new AssertionError();},
                                LinkedHashMap::new
                        ));

                for (Map.Entry<String,Integer> lectureEntry : sortedLectures.entrySet()) {
                    System.out.printf("Lecture - %s, People - %d\n", lectureEntry.getKey(), lectureEntry.getValue());
                }
            }
        }
    }
}
