package week3ThreadsTask;
import java.util.concurrent.*;
public class SortArrayIntegerThread {
	public static void main(String[] args) {
        int[] array = { 38, 27, 43, 3, 9, 82, 10 };
        System.out.println("original array:");
        printArray(array);

        ForkJoinPool pool = new ForkJoinPool();
        pool.invoke(new MergeSortTask(array, 0, array.length - 1));

        System.out.println("sorted array:");
        printArray(array);
    }

    private static void printArray(int[] array) {
        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println();
  }

    private static class MergeSortTask extends RecursiveAction {
        private final int[] array;
        private final int low;
        private final int high;

        public MergeSortTask(int[] array, int low, int high) {
            this.array = array;
            this.low = low;
            this.high = high;
        }

        @Override
        protected void compute() {
            if (low < high) {
                int mid = (low + high) / 2;

                // divide the task into two subtasks
                MergeSortTask leftTask = new MergeSortTask(array, low, mid);
                MergeSortTask rightTask = new MergeSortTask(array, mid + 1, high);

                // fork the subtasks
                invokeAll(leftTask, rightTask);

                // merge the results
                merge(array, low, mid, high);
            }
        }

        private void merge(int[] array, int low, int mid, int high) {
            int[] temp = new int[high - low + 1];
            int i = low, j = mid + 1, k = 0;

            while (i <= mid && j <= high) {
                if (array[i] <= array[j]) {
                    temp[k++] = array[i++];
                } else {
                    temp[k++] = array[j++];
                }
            }

            while (i <= mid) {
                temp[k++] = array[i++];
            }

            while (j <= high) {
                temp[k++] = array[j++];
            }

            System.arraycopy(temp, 0, array, low, temp.length);
        }
    }
}
