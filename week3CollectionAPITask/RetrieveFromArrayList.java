package week3CollectionAPITask;

import java.util.ArrayList;
import java.util.Scanner;

public class RetrieveFromArrayList {
	public static void main(String[] args) {
        // create an ArrayList to store elements
        ArrayList<String> list = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        System.out.print("how many elements would you like to add? ");
        int numberOfElements = sc.nextInt();
        sc.nextLine();

        // loop to get the elements from the user
        for (int i = 0; i < numberOfElements; i++) {
            System.out.print("Enter element " + (i + 1) + ": ");
            String element = sc.nextLine();
            list.add(element);
        }
        for (String element : list) {
            System.out.println(element);
        }
        System.out.print("\nenter the index of the element you want to retrieve: ");
        int index = sc.nextInt();

        // check if the index is valid
        if (index >= 0 && index < list.size()) {
            // retrieve the element at the specified index
            String element = list.get(index);
            System.out.println("element at index " + index + " is: " + element);
        } else {
            System.out.println("invalid index! please enter an index between 0 and " + (list.size() - 1));
        }

        // close the scanner class
        sc.close();
    }
}
