package week3CollectionAPITask;

import java.util.ArrayList;
import java.util.Scanner;

public class InsertAtFirstPosition {
	public static void main(String[] args) {
        // create an ArrayList to store elements
        ArrayList<String> list = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        System.out.print("how many elements would you like to add? ");
        int numberOfElements = sc.nextInt();
        sc.nextLine();

        // loop to get the elements from the user
        for (int i = 0; i < numberOfElements; i++) {
            System.out.print("enter element " + (i + 1) + ": ");
            String element = sc.nextLine();
            list.add(element);
        }
        for (String element : list) {
            System.out.println(element);
        }
        System.out.print("\nenter the element: ");
        String newElement = sc.nextLine();

        // insert the new element at the 1st position
        list.add(0, newElement);
        for (String element : list) {
            System.out.println(element);
        }
        // close the scanner class
        sc.close();
    }
}
