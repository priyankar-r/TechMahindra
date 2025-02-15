package week3CollectionAPITask
;
import java.util.LinkedList;
import java.util.Scanner;

public class InsertAtEndLinkedList {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        // create a linkedlist to store the elements
        LinkedList<String> list = new LinkedList<>();
        // add initial elements to the linkedlist
        list.add("Apple");
        list.add("Banana");
        list.add("Cherry");
        System.out.println("original list: " + list);
        System.out.print("enter the element to insert at the end of the list: ");
        String elementToInsert = sc.nextLine();
        // insert the element at the end of the list
        list.addLast(elementToInsert);
        System.out.println("updated list after inserting at the end: " + list);
        // close the scanner class
        sc.close();
    }
}
