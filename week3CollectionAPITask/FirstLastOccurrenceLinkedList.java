package week3CollectionAPITask;

import java.util.LinkedList;
import java.util.Scanner;

public class FirstLastOccurrenceLinkedList {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// create a linkedlist to store the elements
		LinkedList<String> list = new LinkedList<>();
		// add elements to the linkedlist
		list.add("Apple");
		list.add("Banana");
		list.add("Cherry");
		list.add("Banana");
		list.add("Date");
		list.add("Banana");
		System.out.println("original list: " + list);
		System.out.print("enter the element to find the first and last occurrence of: ");
		String elementToFind = sc.nextLine();
		// find the first occurrence of the specified element
		int firstOccurrence = list.indexOf(elementToFind);
		// find the last occurrence of the specified element
		int lastOccurrence = list.lastIndexOf(elementToFind);
		if (firstOccurrence != -1) {
			System.out.println("first occurrence of '" + elementToFind + "' is at index: " + firstOccurrence);
			System.out.println("last occurrence of '" + elementToFind + "' is at index: " + lastOccurrence);
		} else {
			System.out.println("the element '" + elementToFind + "' is not found in the list.");
		}
		// close the scanner class
		sc.close();
	}
}
