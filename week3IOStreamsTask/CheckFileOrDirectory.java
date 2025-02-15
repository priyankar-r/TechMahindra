package week3IOStreamsTask;
import java.util.*;
import java.io.*;
public class CheckFileOrDirectory {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("enter the file or directory path: ");
        String pathname = sc.nextLine();

        // create a file object for the specified path
        File fileOrDir = new File(pathname);

        // check if the path exists
        if (fileOrDir.exists()) {
            // check if it is a directory
            if (fileOrDir.isDirectory()) {
                System.out.println("the path is a directory.");
            }
            // check if it is a file
            else if (fileOrDir.isFile()) {
                System.out.println("the path is a file.");
            }
        } else {
            System.out.println("the specified path does not exist.");
        }

        // close the scanner class
        sc.close();
    }
}
