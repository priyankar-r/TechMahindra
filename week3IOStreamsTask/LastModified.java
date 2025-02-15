package week3IOStreamsTask;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
public class LastModified {
	 public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
	        System.out.print("Enter the file path: ");
	        String filePath = sc.nextLine();

	        // create a file object for the specified path
	        File file = new File(filePath);

	        // check if the file exists
	        if (file.exists() && file.isFile()) {
	            // get the last modified timestamp
	            long lastModifiedTimestamp = file.lastModified();

	            Date lastModifiedDate = new Date(lastModifiedTimestamp);
	            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	            String formattedDate = dateFormat.format(lastModifiedDate);

	            // print the last modified date
	            System.out.println("last modified date of the file: " + formattedDate);
	        } else {
	            System.out.println("the specified file does not exist.");
	        }

	        // close the scanner class
	        sc.close();
	    }
}
