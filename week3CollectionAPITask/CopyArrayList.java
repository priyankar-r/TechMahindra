package week3CollectionAPITask;

import java.util.ArrayList;
import java.util.Scanner;

public class CopyArrayList {
	public static void main(String[] args) {
        // create the 1st ArrayList to store elements
        ArrayList<String> list1 = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        System.out.print("how many elements would you like to add? ");
        int numberOfElements = sc.nextInt();
        sc.nextLine();
        // loop to get the elements from the user
        for (int i = 0; i < numberOfElements; i++) {
            System.out.print("enter element " + (i + 1) + ": ");
            String element = sc.nextLine();
            list1.add(element);
        }
        for (String element : list1) {
            System.out.println(element);
        }
        // create the 2nd ArrayList and copy all elements from the 1st ArrayList
        ArrayList<String> list2 = new ArrayList<>(list1);
        for (String element : list2) {
            System.out.println(element);
        }
        // close the scanner class
        sc.close();
    }
}