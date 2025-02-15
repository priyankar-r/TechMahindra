package week3ThreadsTask;
import java.util.concurrent.*;
public class MatrixMultiplication {
	public static void main(String[] args) {
        int[][] matrixA = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        int[][] matrixB = {
            {9, 8, 7},
            {6, 5, 4},
            {3, 2, 1}
        };

        int rowsA = matrixA.length;
        int colsA = matrixA[0].length;
        int colsB = matrixB[0].length;

        // resultant matrix
        int[][] result = new int[rowsA][colsB];

        // create a thread pool with the number of available processors
        int numThreads = Runtime.getRuntime().availableProcessors();
        ExecutorService executor = Executors.newFixedThreadPool(numThreads);

        // divide the work among threads
        for (int i = 0; i < rowsA; i++) {
            for (int j = 0; j < colsB; j++) {
                executor.submit(new MultiplicationTask(matrixA, matrixB, result, i, j));
            }
        }
        executor.shutdown();
        try {
            executor.awaitTermination(1, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // print the result matrix
        System.out.println("resultant Matrix:");
        printMatrix(result);
    }
    private static class MultiplicationTask implements Runnable {
        private final int[][] matrixA;
        private final int[][] matrixB;
        private final int[][] result;
        private final int row;
        private final int col;

        public MultiplicationTask(int[][] matrixA, int[][] matrixB, int[][] result, int row, int col) {
            this.matrixA = matrixA;
            this.matrixB = matrixB;
            this.result = result;
            this.row = row;
            this.col = col;
        }

        @Override
        public void run() {
            int sum = 0;
            for (int k = 0; k < matrixA[0].length; k++) {
                sum += matrixA[row][k] * matrixB[k][col];
            }
            result[row][col] = sum;
        }
    }
    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }
}
