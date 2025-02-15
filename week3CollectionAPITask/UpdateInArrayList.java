package week3CollectionAPITask;

import java.util.ArrayList;
import java.util.Scanner;

public class UpdateInArrayList {
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
        System.out.print("\nenter the index to update: ");
        int index = sc.nextInt();
        sc.nextLine();
        // check if the index is valid
        if (index >= 0 && index < list.size()) {
            System.out.print("enter the new element: ");
            String newElement = sc.nextLine();
            // update the element at the specified index
            list.set(index, newElement);
            System.out.println("\nthe ArrayList after update is:");
            for (String element : list) {
                System.out.println(element);
            }
        } else {
            System.out.println("invalid index! please enter an index between 0 and " + (list.size() - 1));
        }
        // close the scanner class
        sc.close();
    }
}
