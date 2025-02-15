package week3task1;
import java.util.*;
public class ArrayCopyRangeExample {
	public static void main(String[] args) {
        // original array
        int[] originalArray = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100};

        // copy a range of elements from the original array
        int[] copiedArray = Arrays.copyOfRange(originalArray, 2, 7);

        // print the original array
        System.out.println("original array: " + Arrays.toString(originalArray));

        // print the copied array
        System.out.println("copied array (from index 2 to 6): " + Arrays.toString(copiedArray));
    }
}
