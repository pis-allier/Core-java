package com.jagat.File;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.DeflaterOutputStream;

public class CompressData {

    public static void main(String[] args) {
        try (FileInputStream fis = new FileInputStream("mytext.txt");
             FileOutputStream fos = new FileOutputStream("file2");
             DeflaterOutputStream dos = new DeflaterOutputStream(fos)) {

            int data;
            while ((data = fis.read()) != -1) {
                dos.write(data);
            }

            System.out.println("Data compressed successfully.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
