package week3IOStreamsTask;
import java.io.*;
import java.util.*;
public class ListOfFilesAndDirectories {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // get directory path from user
        System.out.print("Enter the directory path: ");
        String directoryPath = sc.nextLine();

        // create a file object for the directory
        File directory = new File(directoryPath);

        // check if the path exists and is a directory
        if (directory.exists() && directory.isDirectory()) {
            // get the list of files and directories
            File[] filesAndDirs = directory.listFiles();

            // check if the directory is not empty
            if (filesAndDirs != null) {
                System.out.println("Files and directories in '" + directoryPath + "':");
                for (File fileOrDir : filesAndDirs) {
                    // print the name of the file or directory
                    System.out.println(fileOrDir.getName());
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
