package week3ExceptionHandlingTask;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class FileReaderExample {
	public static void main(String[] args) {
		try {
			Scanner sc = new Scanner(System.in);
			System.out.print("enter the file path: ");
			String filePath = sc.nextLine();
			sc.close();
			readFile(filePath); 

			// this line will execute only if no exception is thrown
			System.out.println("file is read.");

		} catch (FileNotFoundException e) {
			// catch the FileNotFoundException and handle it
			System.err.println("error: file not found - " + e.getMessage());
		} catch (IOException e) {
			// catch other IO exceptions
			System.err.println("error: an I/O error occurred - " + e.getMessage());
		} finally {
			// this block will always execute
			System.out.println("finally block executed.");
		}
	}

	// to read a file
	public static void readFile(String filePath) throws FileNotFoundException, IOException {
		// use try-with-resources to ensure the BufferedReader is closed automatically
		try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
			String line;
			// read each line of the file
			while ((line = br.readLine()) != null) {
				System.out.println(line);
			}
		}
	}
}
