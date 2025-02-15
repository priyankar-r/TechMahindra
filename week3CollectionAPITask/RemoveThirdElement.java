package week3CollectionAPITask;

import java.util.ArrayList;
import java.util.Scanner;

public class RemoveThirdElement {
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
        // check if the ArrayList has at least 3 elements
        if (list.size() >= 3) {
            // remove the third element
            list.remove(2);
            for (String element : list) {
                System.out.println(element);
            }
        } 
        else {
            System.out.println("\nArrayList does not have at least 3 elements. Cannot remove the third element.");
        }
        // close the scanner class
        sc.close();
    }
}
