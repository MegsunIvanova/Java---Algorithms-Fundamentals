package theme_05_IntroductionToDynamicProgramming.Exercises;

import java.util.Arrays;
import java.util.Scanner;

public class P04_SumWithUnlimitedAmountOfCoins {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        final int[] coins = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        final int targetSum = Integer.parseInt(scanner.nextLine());

        int[] dp = new int[targetSum + 1];

        dp[0] = 1;

        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j <= targetSum; j++) {
                dp[j] += dp[j - coins[i]];
            }

        }

        System.out.println(dp[targetSum]);

    }
}
