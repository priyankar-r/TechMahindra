package week3IOStreamsTask;

import java.util.*;
import java.io.*;

public class CheckFileOrDirectoryExists {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("enter the file or directory path: ");
		String pathname = sc.nextLine();

		// create a file object for the specified path
		File fileOrDir = new File(pathname);

		// check if the file or directory exists
		if (fileOrDir.exists()) {

			System.out.println("The path exists");

		} else {
			System.out.println("The specified path does not exist.");
		}

		// close the scanner class
		sc.close();
	}
}
