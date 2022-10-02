package hw01;

import java.util.Arrays;
import java.util.Random;

public class SortAlgos {

    public static void main(String[] args) {
        final int SIZE = 1000000;
        int[] arr = new int[SIZE];

        randomize(arr);
        System.out.println("Unsorted Array: " + Arrays.toString(arr));
        System.out.println("Selection Sort Time Complexity: " + selectionSort(arr));
        System.out.println("Sorted Array: " + Arrays.toString(arr));

        System.out.println();

        randomize(arr);
        System.out.println("Unsorted Array: " + Arrays.toString(arr));
        System.out.println("Bubble Sort Time Complexity: " + bubbleSort(arr));
        System.out.println("Sorted Array: " + Arrays.toString(arr));


    }

    public static int selectionSort(int[] arr) {
        int timeComp = 0;

        // J is starting at I to optimize runtime
        for (int i = 0; i < arr.length; i++) {
            int minimumIndex = i;

            for (int j = i; j < arr.length; j++) {
                timeComp++;
                if (arr[j] < arr[minimumIndex]) minimumIndex = j;
            }

            swap(arr, minimumIndex, i);
        }


        return timeComp;
    }

    public static int bubbleSort(int[] arr) {
        int timeComp = 0;
        boolean swapped = false;

        // Added "swapped" flag which optimizes runtime
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - 1; j++) {
                timeComp++;
                if (arr[j + 1] < arr[j]) {
                    swap(arr, j, j + 1);
                    swapped = true;
                }
            }

            if (!swapped) break;
        }

        return timeComp;
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void randomize(int[] arr) {
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(arr.length * 10);
        }
    }
}
