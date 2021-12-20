package com.java.files;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class DataInputExample {

	public static void main(String[] args) {
		try {
			FileInputStream fin = new FileInputStream("d:/dataout.txt"); 
			DataInputStream din = new DataInputStream(fin);
			int x = din.readInt();
			String str = din.readUTF();
			double bas = din.readDouble();
			boolean flag = din.readBoolean();
			System.out.println("X value is  " +x);
			System.out.println("Name is  " +str);
			System.out.println("Basic is  " +bas);
			System.out.println("Boolean Value is  "+flag);
			din.close();
			fin.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
