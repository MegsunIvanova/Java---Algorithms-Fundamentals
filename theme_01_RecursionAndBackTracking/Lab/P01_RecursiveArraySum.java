package theme_01_RecursionAndBackTracking.Lab;

import java.util.Arrays;
import java.util.Scanner;

public class P01_RecursiveArraySum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] arr = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        //iterative approach

//        int sum = 0;
//
//        for (int i = 0; i < arr.length; i++) {
//            sum += arr[i];
//        }
//
//        System.out.println("Iteration sum: " + sum);

            int sumTwo = sumNumbers(arr, 0);

//        System.out.println("Recursion sum: " + sumTwo);
        System.out.println(sumTwo);
    }

    public static int sumNumbers (int [] numbers, int index) {
        if (index >= numbers.length) {
            return 0;
        }

        return numbers[index] + sumNumbers(numbers, index + 1);
    }
}
