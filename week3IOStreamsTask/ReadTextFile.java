package week3IOStreamsTask;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class ReadTextFile {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the path to the text file: ");
		String filePath = sc.nextLine();

		// use a StringBuilder to store the file content
		StringBuilder content = new StringBuilder();

		// use try-with-resources to ensure the reader is closed automatically
		try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
			String line;
			// read each line of the file until the end
			while ((line = br.readLine()) != null) {
				content.append(line).append("\n");
			}
			// print the file content
			System.out.println("\nfile content:\n" + content.toString());

		} catch (IOException e) {
			// handle any IO exceptions
			System.err.println("error reading the file: " + e.getMessage());
		} finally {
			// close the scanner class
			sc.close();
		}
	}
}
