package week3CollectionAPITask;

import java.util.LinkedList;
import java.util.Scanner;

public class AppendToLinkedList {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// create a linkedlist to store the elements
		LinkedList<String> list = new LinkedList<>();
		System.out.print("enter the no of elements: ");
		int n = sc.nextInt();
		sc.nextLine();
		System.out.println("enter the elements:");
		for (int i = 0; i < n; i++) {
			System.out.print("element " + (i + 1) + ": ");
			String element = sc.nextLine();
			list.add(element);
		}
		System.out.println("original list: " + list);
		System.out.print("enter the element to append to the end of the list: ");
		String elementToAppend = sc.nextLine();
		// append the element to the end of the list
		list.addLast(elementToAppend);
		System.out.println("updated list after appending: " + list);
		// close the scanner class
		sc.close();
	}
}
