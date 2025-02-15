package week3CollectionAPITask;

import java.util.LinkedList;

public class IterateLinkedList {
	public static void main(String[] args) {
        // create a LinkedList to store the elements
        LinkedList<String> list = new LinkedList<>();
        // add elements to the LinkedList
        list.add("Apple");
        list.add("Banana");
        list.add("Cherry");
        list.add("Date");
        System.out.println("\niterating through all the elements in linkedlist:");
        list.forEach(System.out::println);
    }
}
