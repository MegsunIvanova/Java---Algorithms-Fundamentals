package theme_03_SearchingSortingAndGreedyAlgоrithms.Lab;

import java.util.Arrays;
import java.util.Collections;

public class Demo_CountingSort {
    public static int[] counts;

    public static void main(String[] args) {
        int[] arr = {13, 5, 2, 2, 5};

        Integer max = Collections.max(Arrays.asList(13, 5, 2, 2, 5));

        counts = new int[max + 1];

        sort(arr);

        for (int index = 0; index < counts.length; index++) {
            int count = counts[index];
            if (count != 0) {
                for (int i = 0; i < count; i++) {
                    System.out.print(index + " ");
                }
            }
        }
    }

    public static void sort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            counts[arr[i]]++;
        }

    }

    private static void swap(int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}
