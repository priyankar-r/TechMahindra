package week3GenericsTask;
import java.util.*;
public class ArrayEqualityChecker {
	 public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
	        System.out.print("enter the no of elements in the 1st array: ");
	        int n1 = sc.nextInt();
	        Integer[] array1 = new Integer[n1];
	        System.out.println("enter the elements of the 1st array:");
	        for (int i = 0; i < n1; i++) {
	            array1[i] = sc.nextInt();
	        }
	        System.out.print("enter the no of elements in the 2nd array: ");
	        int n2 = sc.nextInt();
	        Integer[] array2 = new Integer[n2];
	        System.out.println("enter the elements of the 2nd array:");
	        for (int i = 0; i < n2; i++) {
	            array2[i] = sc.nextInt();
	        }

	        // check if the arrays are equal
	        boolean areEqual = areArraysEqual(array1, array2);
	        System.out.println("the two arrays are equal: " + areEqual);

	        sc.close();
	    }

	    // generic method to check if two arrays have the same elements in the same order
	    public static <T> boolean areArraysEqual(T[] array1, T[] array2) {
	        // if both arrays are null, they are considered equal
	        if (array1 == null && array2 == null) {
	            return true;
	        }

	        // if one of the arrays is null, they are not equal
	        if (array1 == null || array2 == null) {
	            return false;
	        }

	        // If the lengths of the arrays are different, they are not equal
	        if (array1.length != array2.length) {
	            return false;
	        }

	        // Compare each element of the arrays
	        for (int i = 0; i < array1.length; i++) {
	            if (!array1[i].equals(array2[i])) {
	                return false;
	            }
	        }

	        // If all elements are equal, return true
	        return true;
	    }
}
