package week3ExceptionHandlingTask;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
public class PositiveNumberChecker {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("enter the file path: ");
		String filePath = sc.nextLine();
		sc.close();
        try {
            // check the number is positive or not
            checkNumbersInFile(filePath);
            System.out.println("all numbers are non-positive.");

        } catch (PositiveNumberException e) {
            // catch the custom exception and handle it
            System.err.println("error: " + e.getMessage());
        } catch (IOException e) {
            // catch IO exceptions
            System.err.println("error: An I/O error occurred - " + e.getMessage());
        } finally {
            // this block will always execute
            System.out.println("finally block executed.");
        }
    }

    // check the number is positive number
    public static void checkNumbersInFile(String filePath) throws IOException, PositiveNumberException {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            int lineNumber = 0;
            while ((line = br.readLine()) != null) {
                lineNumber++;
                try {
                    int number = Integer.parseInt(line.trim());

                    // check if the number is positive
                    if (number > 0) {
                        // Throw a custom exception if the number is positive
                        throw new PositiveNumberException("positive number found at line " + lineNumber + ": " + number);
                    }
                } catch (NumberFormatException e) {
                    // Handle invalid number format
                    System.err.println("warning: invalid number format at line " + lineNumber + " - " + line);
                }
            }
        }
    }
}
