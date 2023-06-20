package theme_05_IntroductionToDynamicProgramming.Exercises;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class P03_DividingPresents {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final int[] presents = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        final int totalPresents = Arrays.stream(presents).sum();
        final int half = totalPresents / 2;

        int[] dp = new int[half + 1];
        Arrays.fill(dp, -1);
        dp[0] = 0;

        int alanTotalPresents = 0;

        for (int i = 0; i < presents.length; i++) {
            int currentPresent = presents[i];

            for (int prevValue = half - currentPresent; prevValue >= 0; prevValue--) {
                if (dp[prevValue] != -1 && dp[prevValue + currentPresent] == -1) {
                    int sumIndex = prevValue + currentPresent;
                    dp[sumIndex] = i;

                    alanTotalPresents = Math.max(sumIndex, alanTotalPresents);
                }
            }
        }

        final int bobTotalPresents = totalPresents - alanTotalPresents;
        final int difference = bobTotalPresents - alanTotalPresents;
        List<String> alanPresentsList = new ArrayList<>();

        int sumOfPresents = alanTotalPresents;
        while (sumOfPresents > 0) {
            int index = dp[sumOfPresents];
            int present = presents[index];
            alanPresentsList.add("" + present);
            sumOfPresents -= present;
        }

        StringBuilder out = new StringBuilder();
        out.append(String.format("Difference: %d", difference)).append(System.lineSeparator());
        out.append(String.format("Alan:%d Bob:%d", alanTotalPresents, bobTotalPresents)).append(System.lineSeparator());
        out.append(String.format("Alan takes: %s", String.join(" ",alanPresentsList))).append(System.lineSeparator());
        out.append("Bob takes the rest.");


        System.out.println(out);
    }
}
