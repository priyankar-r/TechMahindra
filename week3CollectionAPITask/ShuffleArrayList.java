package week3CollectionAPITask;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ShuffleArrayList {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// create an ArrayList to store the elements
		ArrayList<String> list = new ArrayList<>();
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
		// shuffle the list
		Collections.shuffle(list);
		System.out.println("shuffled list: " + list);
		// close the scanner class
		sc.close();
	}
}
