package com;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class _03_CountCharacterTypes {
    public static void main(String[] args) {
        try{
            BufferedReader br = new BufferedReader(new FileReader("words.txt"));
            String inputLine;
            int vow = 0;
            int cons = 0;
            int punct = 0;
            ArrayList<Character> vowels = new ArrayList<Character>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
            ArrayList<Character> punctuations = new ArrayList<Character>(Arrays.asList('!', ',', '.', '?'));
            while ((inputLine = br.readLine()) != null){
                inputLine=inputLine.toLowerCase();
                for (int i = 0; i < inputLine.length(); i++) {
                    if (vowels.contains(inputLine.charAt(i))){
                        vow++;
                    }else if(punctuations.contains(inputLine.charAt(i))){
                        punct++;
                    }else if(inputLine.charAt(i) == ' '){
                        continue;
                    }else {
                        cons++;
                    }
                }
            }

            BufferedWriter bw = new BufferedWriter(new FileWriter("count-chars.txt"));
            bw.write("Vowels: " + vow + "\n");
            bw.write("Consonans: " + cons + "\n");
            bw.write("Punctuations: " + punct);

            bw.close();
        }catch (IOException ex) {
            System.err.println("Cannot read the file.");
        }
    }
}
