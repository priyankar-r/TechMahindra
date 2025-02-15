package week3CollectionAPITask;

import java.util.LinkedList;
import java.util.Scanner;

public class InsertElementInLinkedList {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        // create a linkedlist to store the elements
        LinkedList<String> list = new LinkedList<>();
        // add elements to the linkedlist
        list.add("Apple");
        list.add("Banana");
        list.add("Cherry");
        list.add("Date");
        System.out.println("original list: " + list);
        System.out.print("enter the element to insert: ");
        String elementToInsert = sc.nextLine();
        System.out.print("enter the index to insert the element: ");
        int index = sc.nextInt();
        // check if the position is valid
        if (index < 0 || index > list.size()) {
            System.out.println("invalid position. Please enter a valid index.");
        } else {
            // insert the element at the specified position
            list.add(index, elementToInsert);
            // print the updated list
            System.out.println("updated list after insertion: " + list);
        }
        // close the scanner class
        sc.close();
    }
}
