package week3IOStreamsTask;
import java.io.File;
import java.util.Scanner;
public class GetFileSize {
	public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.print("enter the file path: ");
    String filePath = sc.nextLine();

    // create a file object for the specified path
    File file = new File(filePath);

    // check if the file exists
    if (file.exists() && file.isFile()) {
        // get the file size in bytes
        long fileSizeInBytes = file.length();

        // convert the file size to KB and MB
        double fileSizeInKB = fileSizeInBytes / 1024.0;
        double fileSizeInMB = fileSizeInKB / 1024.0;

        //print the file size in bytes, KB, and MB
        System.out.println("file size in bytes: " + fileSizeInBytes + " B");
        System.out.println("file size in KB: " + fileSizeInKB + " KB");
        System.out.println("file size in MB: " + fileSizeInMB + " MB");
    } else {
        System.out.println("the specified file does not exist.");
    }

    // close the scanner class
    sc.close();
}
}
