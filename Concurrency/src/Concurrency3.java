//Q3: Implement a parallelized version of a recursive algorithm using Java's Fork-Join framework (e.g., merge sort or quicksort)
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.ForkJoinPool;
import java.util.Arrays;
 
public class Concurrency3 {
 
    private static final int THRESHOLD = 500;
 
    public static void main(String[] args) {
        int[] array = {38, 27, 43, 3, 9, 82, 10};
        System.out.println("Original array: " + Arrays.toString(array));
        
        ForkJoinPool pool = new ForkJoinPool();
        pool.invoke(new MergeSortTask(array, 0, array.length - 1));
        
        System.out.println("Sorted array: " + Arrays.toString(array));
    }
 
    static class MergeSortTask extends RecursiveAction {
        private final int[] array;
        private final int left;
        private final int right;
 
        MergeSortTask(int[] array, int left, int right) {
            this.array = array;
            this.left = left;
            this.right = right;
        }
 
        @Override
        protected void compute() {
            if (right - left <= THRESHOLD) {
                Arrays.sort(array, left, right + 1);
            } else {
                int mid = (left + right) / 2;
 
                MergeSortTask leftTask = new MergeSortTask(array, left, mid);
                MergeSortTask rightTask = new MergeSortTask(array, mid + 1, right);
 
                invokeAll(leftTask, rightTask);
 
                merge(left, mid, right);
            }
        }
 
        private void merge(int left, int mid, int right) {
            int[] leftArray = Arrays.copyOfRange(array, left, mid + 1);
            int[] rightArray = Arrays.copyOfRange(array, mid + 1, right + 1);
 
            int i = 0, j = 0, k = left;
 
            while (i < leftArray.length && j < rightArray.length) {
                if (leftArray[i] <= rightArray[j]) {
                    array[k++] = leftArray[i++];
                } else {
                    array[k++] = rightArray[j++];
                }
            }
            while (i < leftArray.length) {
                array[k++] = leftArray[i++];
            }
            while (j < rightArray.length) {
                array[k++] = rightArray[j++];
            }
        }
    }
}
 