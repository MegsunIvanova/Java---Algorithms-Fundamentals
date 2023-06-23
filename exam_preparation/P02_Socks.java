package exam_preparation;

import java.util.Arrays;
import java.util.Scanner;

public class P02_Socks {
    public static void main(String[] args) {

        final Scanner scanner = new Scanner(System.in);

        final int[] leftSocks = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        final int[] rightSocks = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[][] dp = new int[leftSocks.length + 1][rightSocks.length + 1];

        for (int r = 1; r < dp.length; r++) {
            for (int c = 1; c < dp[r].length; c++) {
                final int leftSock = leftSocks[r - 1];
                final int rightSock = rightSocks[c - 1];

                if (leftSock == rightSock) {
                    dp[r][c] = dp[r - 1][c - 1] + 1;
                } else {
                    dp[r][c] = Math.max(dp[r - 1][c], dp[r][c - 1]);
                }
            }
        }

        final int lastRowIndex = dp.length-1;
        final int lastColIndex = dp[lastRowIndex].length - 1;

        System.out.println(dp[lastRowIndex][lastColIndex]);
    }


}

