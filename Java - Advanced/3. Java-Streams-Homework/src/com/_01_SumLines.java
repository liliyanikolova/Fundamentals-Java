package com;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class _01_SumLines {

    public static void main(String[] args) {

        try{
            BufferedReader br = new BufferedReader(new FileReader("lines.txt"));
            String inputLine;
            while ((inputLine = br.readLine()) != null){
                int sum = 0;
                for (int i = 0; i < inputLine.length(); i++) {
                    sum += inputLine.charAt(i);
                }
                System.out.println(sum);
            }

        }catch (IOException ex){
            System.err.println("Cannot read the file.");
        }
    }
}
