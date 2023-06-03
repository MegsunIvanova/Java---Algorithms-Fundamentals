package theme_03_SearchingSortingAndGreedyAlgоrithms.Lab;

import java.util.Arrays;
import java.util.Scanner;

public class Demo_SearchingAlgorithms {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] arr = {13, 2, 34, 73, 27, 86};

        System.out.println(indexOfLs(arr, 73));

        Arrays.sort(arr); //2, 13, 27, 34, 34, 86
        System.out.println(indexOfBs(arr, 73));

    }

    //Linear Search
    private static int indexOfLs(int[] arr, int key) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == key) {
                return i;
            }
        }
        return -1;
    }

    //Binary Search
    private static int indexOfBs(int[] arr, int key) {
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = (start + end) / 2;
            int current = arr[mid];
            if (key < current) {
                end = mid - 1;
            } else if (key > current) {
                start = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
