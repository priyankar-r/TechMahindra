package week3CollectionAPITask;

import java.util.LinkedList;
import java.util.Scanner;

public class IterateLinkedListFromPosition {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// create a linkedlist to store the elements
		LinkedList<String> list = new LinkedList<>();
		// add elements to the linkedlist
		list.add("Apple");
		list.add("Banana");
		list.add("Cherry");
		list.add("Orange");
		list.add("Blueberry");
		System.out.println("original list: " + list);
		System.out.print("enter the starting position to iterate from: ");
		int startPosition = sc.nextInt();
		// close the scanner class
		sc.close();
		// check if the starting position is valid
		if (startPosition < 0 || startPosition >= list.size()) {
			System.out.println("invalid starting position. Please enter a valid index.");
			return;
		}
		System.out.println("\niterating using for loop starting from position " + startPosition + ":");
		for (int i = startPosition; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}
}
