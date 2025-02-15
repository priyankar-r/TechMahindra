package week3IOStreamsTask;
import java.util.*;
import java.io.*;
public class AccessByExtension {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // prompt the user to enter the directory path
        System.out.print("enter the directory path: ");
        String directoryPath = sc.nextLine();

        System.out.print("enter the file extension to filter (like txt, java, pdf): ");
        String extension = sc.nextLine();

        // create a file object for the directory
        File directory = new File(directoryPath);

        // check if the path exists and is a directory
        if (directory.exists() && directory.isDirectory()) {
            // get the list of files in the directory
            File[] files = directory.listFiles();

            // check if the directory is not empty
            if (files != null) {
                System.out.println("files with extension '" + extension + "' in '" + directoryPath + "':");
                for (File file : files) {
                    // check if the file has the specified extension
                    if (file.isFile() && file.getName().endsWith("." + extension)) {
                        System.out.println(file.getName());
                    }
                }
            } else {
                System.out.println("the directory is empty.");
            }
        } else {
            System.out.println("the specified path does not exist or is not a directory.");
        }

        // close the scanner class
        sc.close();
    }
}
