package theme_05_IntroductionToDynamicProgramming.Exercises;

import java.util.Scanner;

public class P08_MinimumEditDistance {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int replaceCost = Integer.parseInt(scanner.nextLine());
        int insertCost = Integer.parseInt(scanner.nextLine());
        int deleteCost = Integer.parseInt(scanner.nextLine());

        char[] first = scanner.nextLine().toCharArray();
        char[] second = scanner.nextLine().toCharArray();

        int[][] dp = new int[first.length + 1][second.length + 1];


        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                if (i == 0) {
                    dp[i][j] = j * insertCost;
                } else if (j == 0) {
                    dp[i][j] = i * deleteCost;
                } else if (first[i - 1] == second[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    int toReplace = dp[i - 1][j - 1] + replaceCost;
                    int toInsert = dp[i][j - 1] + insertCost;
                    int toDelete = dp[i - 1][j] + deleteCost;

                    dp[i][j] = Math.min(toReplace, Math.min(toInsert, toDelete));
                }
            }
        }

        int distance = dp[dp.length - 1][dp[dp.length - 1].length - 1];

        System.out.println("Minimum edit distance: " + distance);

    }
}
