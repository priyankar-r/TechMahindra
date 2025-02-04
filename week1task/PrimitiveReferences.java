package week1task;

public class PrimitiveReferences {
	    public static void modify(int num, int[] arr) {
	        num += 10;        
	        arr[0] += 50;
	    }

	    public static void main(String[] args) {
	        int x = 5;  
	        int[] numbers = {1, 2, 3};

	        System.out.println("before()call: x = " + x + ",numbers[0] = " + numbers[0]);
	        modify(x, numbers);
	        System.out.println("after()call:  x = " + x + ",numbers[0] = " + numbers[0]);
	    }
}
