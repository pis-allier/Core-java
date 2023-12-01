package com.jagat.File;

import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class BufferedOutputStreamExample {

    public static void main(String[] args) {

        try (DataInputStream dis = new DataInputStream(System.in);
             FileOutputStream fout = new FileOutputStream("m1.txt", true);
             BufferedOutputStream bout = new BufferedOutputStream(fout, 512)) {

            System.out.println("Enter '@' at the end");
            char ch;
            while ((ch = (char) dis.read()) != '@') {
                bout.write(ch);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Current Working Directory: " + System.getProperty("user.dir"));
    }
}