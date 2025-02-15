package week3ExceptionHandlingTask;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
public class EmptyFileChecker {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("enter the file path: ");
		String filePath = sc.nextLine();
		sc.close();
        try {
            // check the file
            checkFileContent(filePath);
            System.out.println("file is not empty.");

        } catch (EmptyFileException e) {
            // catch the custom exception and handle it
            System.err.println("error: " + e.getMessage());
        } catch (IOException e) {
            // catch IO exceptions 
            System.err.println("error: an I/O error occurred - " + e.getMessage());
        } finally {
            // this block will always execute
            System.out.println("finally block executed.");
        }
    }

    // check if the file is empty
    public static void checkFileContent(String filePath) throws IOException, EmptyFileException {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean isEmpty = true;
            while ((line = br.readLine()) != null) {
                // check for non-whitespace characters
                if (!line.trim().isEmpty()) {
                    isEmpty = false;
                    break;
                }
            }

            // If the file is empty, throw a custom exception
            if (isEmpty) {
                throw new EmptyFileException("The file is empty: " + filePath);
            }
        }
    }
}
