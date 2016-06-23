package com;

import com.Repositories.RepositorySorters;
import com.Repositories.StudentsRepository;

import java.awt.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class CommandInterpreter {
        public static void interpretCommand(String input) throws IOException {
            String[] data = input.split("\\s+");
            String command = data[0];
            switch (command){
                case "open":
                    tryOpenFile(input, data);
                    break;

                case "show":
                    tryShowWantedCourse(input, data);
                    break;

                case "mkdir":
                    tryCreateDirectory(input, data);
                    break;

                case "ls":
                    tryTraverseFolders(input, data);
                    break;

                case "cmp":
//                    tryCompareFiles(input, data);
                    break;

                case "changeDirRel":
                    tryChangeRelativePath(input, data);
                    break;

                case "changeDirAbs":
                    tryChangeAbsolutePath(input, data);
                    break;

                case "readDb":
                    tryReadDatabaseFromFile(input, data);
                    break;

                case "filter":
                    tryPrintFilteredStudents(input, data);
                    break;

                case "order":
                    tryPrintOrderedStudents(input, data);
                    break;

                case "download":
//                    downloadFile(input, data);
                    break;

                case "downloadAsynch":
//                    downloadFileAsync(input, data);
                    break;

                case "help":
                    getHelp();
                    break;

                default:
                    displayInvalidCommandMessage(input);
                    break;
            }
        }

    private static void tryPrintFilteredStudents(String input, String[] data){
        if (data.length != 3 && data.length != 4){
            displayInvalidCommandMessage(input);
            return;
        }

        String course = data[1];
        String filter = data[2];

        if (data.length == 3){
            StudentsRepository.printFilteredStudents(course, filter, null);
            return;
        }

        Integer numberOfStudents = Integer.valueOf(data[3]);

        if (data.length == 4){
            StudentsRepository.printFilteredStudents(course, filter, numberOfStudents);
        }
    }

    private static void tryPrintOrderedStudents(String input, String[] data){
        if (data.length != 3 && data.length != 4){
            displayInvalidCommandMessage(input);
            return;
        }

        String course = data[1];
        String comparisonType = data[2];
        Integer numberOfStudents = null;
        if (data.length == 4){
            numberOfStudents = Integer.parseInt(data[3]);
        }

        StudentsRepository.printOrderedStudents(course, comparisonType, numberOfStudents);
    }

    private static void tryShowWantedCourse(String input, String[] data) {
        if (data.length != 2 && data.length != 3){
            displayInvalidCommandMessage(input);
            return;
        }

        if (data.length == 2){
            String courseName = data[1];
            StudentsRepository.getStudentByCourse(courseName);
        }

        if (data.length == 3){
            String courseName = data[1];
            String userName = data[2];
            StudentsRepository.getStudentMarksInCourse(courseName, userName);
        }
    }

    private static void tryOpenFile(String input, String[] data){
        if (data.length != 2){
            displayInvalidCommandMessage(input);
            return;
        }

        String fileName = data[1];
        String filePath = SessionData.currentPath + "\\" + fileName;
        File file = new File(filePath);
        try {
            Desktop.getDesktop().open(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void tryCreateDirectory(String input, String [] data){
        if (data.length != 2){
            displayInvalidCommandMessage(input);
            return;
        }

        String folderName = data[1];
        IOManager.createDirectoryInCurrentFolder(folderName);
    }

    private static void tryTraverseFolders(String input, String [] data){
        if (data.length != 1 && data.length != 2){
            displayInvalidCommandMessage(input);
            return;
        }

        if (data.length == 1){
            IOManager.traverseDirectory(0);
        }

        if (data.length == 2){
            IOManager.traverseDirectory(Integer.parseInt(data[1]));
        }
    }

    private static void tryCompareFile(String input, String[] data) throws IOException{
        if (data.length != 3){
            displayInvalidCommandMessage(input);
            return;
        }

        String firstPath = data[1];
        String secondPath = data[2];
        Tester.compareContent(firstPath, secondPath);
    }

    private static void tryChangeRelativePath(String input, String[] data){
        if (data.length != 2){
            displayInvalidCommandMessage(input);
            return;
        }

        String relativePath = data[1];
        IOManager.changeCurrentDirRelativePath(relativePath);
    }

    private static void tryChangeAbsolutePath(String input, String[] data){
        if (data.length != 2){
            displayInvalidCommandMessage(input);
            return;
        }

        String relativePath = data[1];
        IOManager.changeCurrentDirAbsolutePath(relativePath);
    }

    private static void tryReadDatabaseFromFile(String input, String[] data) throws IOException{
        if (data.length != 2){
            displayInvalidCommandMessage(input);
            return;
        }

        String fileName = data[1];
        StudentsRepository.initializeData(fileName);
    }

    private static void getHelp() {
        try (BufferedReader reader = new BufferedReader(new FileReader("resources\\getHelp.txt"))){
            while (true){
                String line = reader.readLine();
                if (line == null){
                    break;
                }
                OutputWriter.writeMessageOnNewLine(line);
            }
            OutputWriter.writeEmptyLine();

        }  catch (IOException e) {
            OutputWriter.displayException(e.getMessage());
        }
    }

    private static void displayInvalidCommandMessage(String input) {
        String output = String.format("The command %s is invalid.", input);
        OutputWriter.writeMessageOnNewLine(output);
    }
}
