package week3IOStreamsTask;
import java.util.*;
import java.io.*;
public class CheckFilePermissions {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("enter the file or directory path: ");
        String pathname = sc.nextLine();

        // create a file object for the specified path
        File fileOrDir = new File(pathname);

        // check if the file or directory exists
        if (fileOrDir.exists()) {
            if (fileOrDir.canRead()) {
                System.out.println("read permission: granted");
            } else {
                System.out.println("read permission: denied");
            }
            if (fileOrDir.canWrite()) {
                System.out.println("write permission: granted");
            } else {
                System.out.println("write permission: denied");
            }
        } else {
            System.out.println("the specified path does not exist.");
        }

        // close the scanner class
        sc.close();
    }
}
