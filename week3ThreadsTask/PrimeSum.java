package week3ThreadsTask;

import java.util.*;
import java.util.concurrent.*;

public class PrimeSum {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// get limit
		int limit = sc.nextInt();
		sc.close();

		int numThreads = Runtime.getRuntime().availableProcessors();

		// divide the range into subranges for each thread
		int rangeSize = limit / numThreads;
		ExecutorService executor = Executors.newFixedThreadPool(numThreads);
		List<Future<Long>> futures = new ArrayList<>();

		// submit tasks to the executor
		for (int i = 0; i < numThreads; i++) {
			int start = i * rangeSize + 1;
			int end = (i == numThreads - 1) ? limit : (i + 1) * rangeSize;
			futures.add(executor.submit(new PrimeSumTask(start, end)));
		}
		long totalSum = 0;
		for (Future<Long> future : futures) {
			try {
				totalSum += future.get();
			} catch (InterruptedException | ExecutionException e) {
				e.printStackTrace();
			}
		}
		executor.shutdown();

		// print the result
		System.out.println("sum of all prime numbers up to " + limit + " is: " + totalSum);
	}

	private static class PrimeSumTask implements Callable<Long> {
		private final int start;
		private final int end;

		public PrimeSumTask(int start, int end) {
			this.start = start;
			this.end = end;
		}

		@Override
		public Long call() {
			long sum = 0;
			for (int i = start; i <= end; i++) {
				if (isPrime(i)) {
					sum += i;
				}
			}
			return sum;
		}

		// check if it is a prime
		private boolean isPrime(int number) {
			if (number < 2) {
				return false;
			}
			for (int i = 2; i * i <= number; i++) {
				if (number % i == 0) {
					return false;
				}
			}
			return true;
		}
	}
}
