package com;

import java.io.*;

public class _04_CopyJpgFile {
    public static void main(String[] args) {
        try{
            byte[] image;
            File file = new File("image.jpg");
            image = new byte[(int)file.length()];

            FileInputStream fileInputStream = new FileInputStream(file);
            fileInputStream.read(image);

            FileOutputStream fileOutputStream = new FileOutputStream("my-copied-picture.jpg");
            fileOutputStream.write(image);
        }catch (IOException ex){
            System.err.println("Cannot read the file.");
        }
    }
}
