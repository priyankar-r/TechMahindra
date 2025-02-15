package week3IOStreamsTask;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class ReadFileLineByLine {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("enter the file path: ");
		String filePath = sc.nextLine();
		sc.close();
		// use try-with-resources to ensure the reader is closed automatically
		try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
			String line;
			// read each line of the file until the end
			while ((line = br.readLine()) != null) {
				// process the line
				System.out.println(line);
			}
		} catch (IOException e) {
			// handle any IO exceptions
			e.printStackTrace();
		}
	}
}
