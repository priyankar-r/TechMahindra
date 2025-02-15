package week3CollectionAPITask;

import java.util.LinkedList;
import java.util.Scanner;

public class InsertAtFrontLinkedList {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// create a linkedlist to store the elements
		LinkedList<String> list = new LinkedList<>();
		// add initial elements to the linkedlist
		list.add("Banana");
		list.add("Cherry");
		list.add("Date");
		System.out.println("original list: " + list);
		System.out.print("enter the element to insert at the front of the list: ");
		String elementToInsert = sc.nextLine();
		// insert the element at the front of the list
		list.addFirst(elementToInsert);
		System.out.println("updated list after inserting at the front: " + list);
		// close the scanner class
		sc.close();
	}

}
