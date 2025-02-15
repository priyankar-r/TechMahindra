package week3CollectionAPITask;

import java.util.LinkedList;

public class IterateLinkedListReverse {
	public static void main(String[] args) {
        // create a linkedlist to store the elements
        LinkedList<String> list = new LinkedList<>();
        // add elements to the linkedlist
        list.add("Apple");
        list.add("Banana");
        list.add("Cherry");
        list.add("Date");
        // print the original list
        System.out.println("original list: " + list);
        System.out.println("\niterating in reverse using for loop:");
        for (int i = list.size() - 1; i >= 0; i--) {
            System.out.println(list.get(i));
        }
    }
}
