package com.jagat.File;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileInputStreamExample {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("Enter the file name:");
            String fileName = br.readLine();

            try (FileInputStream fin = new FileInputStream(fileName);
                 BufferedInputStream bin = new BufferedInputStream(fin)) {

                System.out.println("File contents:");

                int ch;
                while ((ch = bin.read()) != -1) {
                    System.out.print((char) ch);
                }
            } catch (FileNotFoundException e) {
                System.out.println("File not found");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
