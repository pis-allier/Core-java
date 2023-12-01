package com.jagat.File;

import java.io.DataInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileStream {

	public static void main(String[] args) {

		System.out.println("Enter something");
		try (DataInputStream dis = new DataInputStream(System.in);
				FileOutputStream fout = new FileOutputStream("mytext.txt", true)) {

			System.out.println("Enter '@' at the end");
			char ch;
			while ((ch = (char) dis.read()) != '@') {
				fout.write(ch);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Current Working Directory: " + System.getProperty("user.dir"));
	}
}