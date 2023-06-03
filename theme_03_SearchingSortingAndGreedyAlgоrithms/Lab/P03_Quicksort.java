package theme_03_SearchingSortingAndGreedyAlgоrithms.Lab;

import java.util.Arrays;
import java.util.Scanner;

public class P03_Quicksort {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] arr = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        quickSort(arr, 0, arr.length - 1);

        StringBuilder builder = new StringBuilder();

        for (int element : arr) {
            builder.append(element).append(" ");
        }

        System.out.println(builder.toString().trim());

    }

    private static void quickSort(int[] arr, int start, int end) {
        if (start < end) {
            //We choose an element from the arr, called the pivot.
            // We'll use it to divide the list into two sub-lists.
            int pIndex = partition(arr, start, end);

            quickSort(arr, start, pIndex - 1);
            quickSort(arr, pIndex, end);
        }
    }

    private static int partition(int[] arr, int start, int end) {
        int pivot = arr[end];
        int pIndex = (start);

        //checks each element and swaps it before the pivot if its value is smaller.
        for (int i = start; i < end; i++) {
            if (arr[i] <= pivot) {

                int temp = arr[pIndex];
                arr[pIndex] = arr[i];
                arr[i] = temp;

                pIndex++;
            }
        }

        int temp = arr[pIndex];
        arr[pIndex] = arr[end];
        arr[end] = temp;

        return pIndex;
    }
}
