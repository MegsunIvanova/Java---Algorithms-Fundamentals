package theme_05_IntroductionToDynamicProgramming.Exercises;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class P02_LongestZigZagSubsequence {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        final int[] numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        int[] len = new int[numbers.length];
        Arrays.fill(len, 1);

        int[] prevIndex = new int[numbers.length];
        Arrays.fill(prevIndex, -1);

        boolean[] largerNextElement = new boolean[numbers.length];

        int maxLen = 0;
        int maxIndex = -1;


        for (int index = 0; index < numbers.length; index++) {
            int element = numbers[index];

            for (int i = index - 1; i >= 0; i--) {
                int prevElement = numbers[i];

                if (i == 0) {
                    largerNextElement[0] = prevElement < element;
                }

                if (prevElement < element && largerNextElement[i] && len[i] + 1 >= len[index]) {
                    len[index] = len[i] + 1;
                    prevIndex[index] = i;
                    largerNextElement[index] = false;
                }

                if (prevElement > element && !largerNextElement[i] && len[i] + 1 >= len[index]) {
                    len[index] = len[i] + 1;
                    prevIndex[index] = i;
                    largerNextElement[index] = true;
                }

            }

            if (len[index] > maxLen) {
                maxLen = len[index];
                maxIndex = index;
            }
        }

        List<String> result = new ArrayList<>();
        int index = maxIndex;

        while (index != -1) {
            result.add(0, "" + numbers[index]);
            index = prevIndex[index];
        }

        System.out.println(String.join(" ", result));

    }
}
