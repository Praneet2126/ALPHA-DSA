package Arrays;

import java.util.Arrays;

public class Visualising {
    public static void countingSort(int arr[]) {
        // Finding the largest element
        int largest = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            largest = Math.max(largest, arr[i]);
        }

        // Count array
        int count[] = new int[largest + 1];
        for (int i = 0; i < arr.length; i++) {
            count[arr[i]]++;
        }

        System.out.println("Count array: " + Arrays.toString(count)); // Debug Here 👀

        // Sorting logic
        int j = 0;
        for (int i = 0; i < count.length; i++) {
            while (count[i] > 0) {
                arr[j] = i;
                j++;
                count[i]--;
            }
        }

        System.out.println("Sorted array: " + Arrays.toString(arr)); // Debug Here 👀
    }

    public static void main(String[] args) {
        int arr[] = {4, 2, 2, 8, 3, 3, 1};
        System.out.println("Original array: " + Arrays.toString(arr)); // Debug Here 👀

        countingSort(arr);

        System.out.println("Final sorted array: " + Arrays.toString(arr)); // Debug Here 👀
    }
}

