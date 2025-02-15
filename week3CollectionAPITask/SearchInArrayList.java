package week3CollectionAPITask;

import java.util.ArrayList;
import java.util.Scanner;

public class SearchInArrayList {
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
        System.out.print("\nenter the element to search for: ");
        String searchElement = sc.nextLine();
        // search for the element in the ArrayList
        int index = list.indexOf(searchElement);
        // check if the element was found
        if (index != -1) {
            System.out.println("element '" + searchElement + "' found at index: " + index);
        } else {
            System.out.println("element '" + searchElement + "' not found in the ArrayList.");
        }
        // close the scanner class
        sc.close();
    }
}
