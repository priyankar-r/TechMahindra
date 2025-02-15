package week3task1;
import java.util.*;
public class EqualsVsDeepEquals {
	public static void main(String[] args) {
        // example with single-dimensional arrays
        int[] arr1 = {1, 2, 3};
        int[] arr2 = {1, 2, 3};
        int[] arr3 = {1, 2, 4};

        System.out.println("Comparing arr1 and arr2 using equals(): " + arr1.equals(arr2));
        System.out.println("Comparing arr1 and arr2 using Arrays.equals(): " + Arrays.equals(arr1, arr2)); 
        System.out.println("Comparing arr1 and arr3 using Arrays.equals(): " + Arrays.equals(arr1, arr3));

        // example with multidimensional arrays
        int[][] deepArr1 = {{1, 2}, {3, 4}};
        int[][] deepArr2 = {{1, 2}, {3, 4}};
        int[][] deepArr3 = {{1, 2}, {3, 5}};

        System.out.println("\nComparing deepArr1 and deepArr2 using equals(): " + deepArr1.equals(deepArr2)); 
        System.out.println("Comparing deepArr1 and deepArr2 using Arrays.equals(): " + Arrays.equals(deepArr1, deepArr2)); 
        System.out.println("Comparing deepArr1 and deepArr2 using Arrays.deepEquals(): " + Arrays.deepEquals(deepArr1, deepArr2)); 
        System.out.println("Comparing deepArr1 and deepArr3 using Arrays.deepEquals(): " + Arrays.deepEquals(deepArr1, deepArr3));
    }
}
