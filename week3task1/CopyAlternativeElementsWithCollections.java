package week3task1;

import java.util.*;

public class CopyAlternativeElementsWithCollections {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// original list to store user input
		List<Integer> originalList = new ArrayList<>();

		// prompt the user to enter the number of elements
		System.out.print("enter the number of elements: ");
		int n = sc.nextInt();

		// prompt the user to enter the elements
		System.out.println("enter the elements:");
		for (int i = 0; i < n; i++) {
			System.out.print("element " + (i + 1) + ": ");
			originalList.add(sc.nextInt());
		}

		// new list to store alternative elements
		List<Integer> newList = new ArrayList<>();

		// copy alternative elements
		for (int i = 0; i < originalList.size(); i += 2) {
			newList.add(originalList.get(i));
		}

		// print the original list
		System.out.println("original list:");
		printList(originalList);

		// print the new list with alternative elements
		System.out.println("new list with alternative elements:");
		printList(newList);

		// close the scanner class
		sc.close();
	}

	// helper method to print a list
	public static void printList(List<Integer> list) {
		for (Integer element : list) {
			System.out.print(element + " ");
		}
		System.out.println();
	}
}
