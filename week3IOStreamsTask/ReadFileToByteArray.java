package week3IOStreamsTask;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;
public class ReadFileToByteArray {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("enter the file path: ");
	    String filePath = sc.nextLine();
	    File file = new File(filePath);
	    sc.close();
        // check if the file exists
        if (!file.exists() || !file.isFile()) {
            System.out.println("The specified file does not exist.");
            return;
        }

        // create a FileInputStream to read the file
        try (FileInputStream fis = new FileInputStream(file)) {
            // Get the file size in bytes
            long fileSize = file.length();

            // check if the file size is too large to fit in an array
            if (fileSize > Integer.MAX_VALUE) {
                System.out.println("The file is too large to read into a byte array.");
                return;
            }

            // create a byte array to hold the file contents
            byte[] byteArray = new byte[(int) fileSize];

            // read the file contents into the byte array
            int bytesRead = fis.read(byteArray);

            // check if the entire file was read
            if (bytesRead != fileSize) {
                System.out.println("could not read the entire file.");
                return;
            }

            // print the byte array
            System.out.println("file contents as byte array:");
            for (byte b : byteArray) {
                System.out.print(b + " ");
            }
        } catch (IOException e) {
            System.out.println("an error occurred while reading the file: " + e.getMessage());
        }
    }
}
