package com;

import java.io.*;
import java.util.ArrayList;

public class _02_AllCapitals {
    public static void main(String[] args) {
        try{
            BufferedReader br = new BufferedReader(new FileReader("lines2.txt"));
            String inputLine;
            ArrayList<String> fileData = new ArrayList<>();
            while ((inputLine = br.readLine()) != null){
                fileData.add(inputLine.toUpperCase());
            }

            BufferedWriter bw = new BufferedWriter(new FileWriter("lines2.txt"));
            for (String element:fileData) {
                bw.write(element + "\n");
            }

            bw.close();
        }catch (IOException ex) {
            System.err.println("Cannot read the file.");
        }
    }
}
