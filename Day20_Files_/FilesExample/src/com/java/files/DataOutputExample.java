package com.java.files;

import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataOutputExample {

	public static void main(String[] args) {
		try {
			FileOutputStream fout = new FileOutputStream("d:/dataout.txt");
			DataOutputStream dout = new DataOutputStream(fout);
			dout.writeInt(12);
			dout.writeUTF("Mphasis");
			dout.writeDouble(98523.44);
			dout.writeBoolean(true);
			dout.close();
			fout.close();
			System.out.println("Data Stored...");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
