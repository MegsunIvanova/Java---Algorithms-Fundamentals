package theme_05_IntroductionToDynamicProgramming.Exercises;

import java.util.*;

public class P02_LongestZigZagSubsequence_v02 {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        final int[] numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        int[][] dp = new int[numbers.length + 1][2];
        int[][] prev = new int[numbers.length + 1][2];

        //Are Greater
        dp[0][0] = 1;
        //Are lesser
        dp[0][1] = 1;

        for (int i = 0; i < prev.length; i++) {
            Arrays.fill(prev[i], -1);
        }

        int maxLength = 0;
        int[] best = new int[2];

        for (int currentIndex = 0; currentIndex < numbers.length; currentIndex++) {
            int currentNumber = numbers[currentIndex];
            for (int prevIndex = currentIndex - 1; prevIndex >= 0; prevIndex--) {
                int prevNumber = numbers[prevIndex];

                if (currentNumber > prevNumber && dp[currentIndex][0] <= dp[prevIndex][1] + 1) {
                    dp[currentIndex][0] = dp[prevIndex][1] + 1;
                    prev[currentIndex][0] = prevIndex;
                }

                if (currentNumber < prevNumber && dp[currentIndex][1] <= dp[prevIndex][0] + 1) {
                    dp[currentIndex][1] = dp[prevIndex][0] + 1;
                    prev[currentIndex][1] = prevIndex;
                }
            }

            if (maxLength < dp[currentIndex][0]) {
                maxLength = dp[currentIndex][0];
                best[0] = currentIndex;
                best[1] = 0;
            }

            if (maxLength < dp[currentIndex][1]) {
                best[0] = currentIndex;
                best[1] = 1;
            }
        }

        List<String> zigZagSequence = new ArrayList<>();
        int beginRow = best[0];

        while (beginRow != -1) {
            zigZagSequence.add(0, "" + numbers[beginRow]);
            beginRow = prev[beginRow][best[1]];
            best[1] = best[1] == 0 ? 1 : 0;
        }

        System.out.println(String.join(" ", zigZagSequence));

    }
}
