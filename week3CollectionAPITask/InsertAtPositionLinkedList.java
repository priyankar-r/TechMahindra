package week3CollectionAPITask;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.Arrays;

public class InsertAtPositionLinkedList {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        // create a linkedlist to store the elements
        LinkedList<String> list = new LinkedList<>();
        // add initial elements to the linkedlist
        list.add("Apple");
        list.add("Banana");
        list.add("Cherry");
        System.out.println("original list: " + list);
        System.out.print("enter the position to insert elements: ");
        int position = sc.nextInt();
        sc.nextLine();
        System.out.print("enter the elements to insert: ");
        String elementsInput = sc.nextLine();
        // split the input into an array of elements
        String[] elementsToInsert = elementsInput.split(",");
        // check if the position is valid
        if (position < 0 || position > list.size()) {
            System.out.println("invalid position. Please enter a valid index.");
        } else {
            // insert the elements at the specified position
            list.addAll(position, Arrays.asList(elementsToInsert));
            System.out.println("updated list after inserting elements: " + list);
        }
        // close the scanner class
        sc.close();
    }
}