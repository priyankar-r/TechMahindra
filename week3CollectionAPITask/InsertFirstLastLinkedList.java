package week3CollectionAPITask;

import java.util.LinkedList;
import java.util.Scanner;

public class InsertFirstLastLinkedList {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        // create a linkedlist to store the elements
        LinkedList<String> list = new LinkedList<>();
        // add initial elements to the linkedlist
        list.add("Banana");
        list.add("Cherry");
        list.add("Date");
        System.out.println("original list: " + list);
        System.out.print("enter the element to insert at the 1st position: ");
        String elementToInsertFirst = sc.nextLine();
        // insert the element at the first position
        list.addFirst(elementToInsertFirst);
        System.out.println("list after inserting at 1st position: " + list);
        System.out.print("enter the element to insert at the last position: ");
        String elementToInsertLast = sc.nextLine();
        // insert the element at the last position
        list.addLast(elementToInsertLast);
        System.out.println("list after inserting at the last position: " + list);
        // close the scanner class
        sc.close();
    }
}
