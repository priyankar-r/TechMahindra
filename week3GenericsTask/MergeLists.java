package week3GenericsTask;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MergeLists {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// create two lists to store elements
		List<String> list1 = new ArrayList<>();
		List<String> list2 = new ArrayList<>();

		// get the no of elements for the first list
		System.out.print("enter the no of elements of 1st list: ");
		int n1 = sc.nextInt();
		sc.nextLine();

		// get the elements for the 1st list
		System.out.println("enter the elements of 1st list:");
		for (int i = 0; i < n1; i++) {
			System.out.print("element " + (i + 1) + ": ");
			list1.add(sc.nextLine());
		}

		// get the number of elements of 2nd list
		System.out.print("enter the no of elements of 2nd list: ");
		int n2 = sc.nextInt();
		sc.nextLine();

		// get the elements of 2nd list
		System.out.println("enter the elements of 2nd list:");
		for (int i = 0; i < n2; i++) {
			System.out.print("element " + (i + 1) + ": ");
			list2.add(sc.nextLine());
		}
		List<String> mergedList = mergeListsAlternately(list1, list2);

		// print the merged list
		System.out.println("Merged List:");
		for (String element : mergedList) {
			System.out.print(element + " ");
		}

		sc.close();
	}

	// generic method to merge two lists alternately
	public static <T> List<T> mergeListsAlternately(List<T> list1, List<T> list2) {
		List<T> mergedList = new ArrayList<>();
		int size1 = list1.size();
		int size2 = list2.size();
		int maxSize = Math.max(size1, size2);

		for (int i = 0; i < maxSize; i++) {
			if (i < size1) {
				mergedList.add(list1.get(i));
			}
			if (i < size2) {
				mergedList.add(list2.get(i));
			}
		}
		return mergedList;
	}
}
