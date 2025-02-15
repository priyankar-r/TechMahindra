package week3StreamsTask;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalInt;
import java.util.Scanner;

public class MaxMinUsingStreams {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // create a list to store the integers
        List<Integer> numbers = new ArrayList<>();
        System.out.print("enter the number of elements: ");
        int n = sc.nextInt();
        System.out.println("enter the elements:");
        for (int i = 0; i < n; i++) {
            System.out.print("element " + (i + 1) + ": ");
            numbers.add(sc.nextInt());
        }
        // find the maximum value
        OptionalInt max = numbers.stream().mapToInt(Integer::intValue).max();
        // find the minimum value
        OptionalInt min = numbers.stream().mapToInt(Integer::intValue).min();
        // print the results
        if (max.isPresent()) {
            System.out.println("maximum value: " + max.getAsInt());
        } else {
            System.out.println("the list is empty, cannot find maximum value.");
        }
        if (min.isPresent()) {
            System.out.println("minimum value: " + min.getAsInt());
        } else {
            System.out.println("the list is empty, cannot find minimum value.");
        }
        // close the scanner class
        sc.close();
    }
}
