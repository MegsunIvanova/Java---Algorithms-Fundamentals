package theme_05_IntroductionToDynamicProgramming.Exercises;

import java.util.*;

public class P05_SumWithLimitedCoins {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        final int[] coins = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        final int targetSum = Integer.parseInt(scanner.nextLine());

        Set<Integer> dp = new HashSet<>();

        int result = 0;

        dp.add(0);

        for (int coin : coins) {
            for (Integer sum : new ArrayList<>(dp)) {
                int currentSum = coin + sum;
                if (currentSum == targetSum) {
                    result++;
                }

                if (currentSum <= targetSum) {
                    dp.add(currentSum);
                }
            }
        }

        System.out.println(result);

    }
}
