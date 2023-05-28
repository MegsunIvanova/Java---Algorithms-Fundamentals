package theme_02_CombinatorialProblems.Lab;

import java.util.Scanner;

public class P05_CombinationsWithoutRepetition {
    private static String[] elements;
    private static String[] combinationsArr;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        elements = scanner.nextLine().split("\\s+");

        int k = Integer.parseInt(scanner.nextLine());

        combinationsArr = new String[k];

        combinations(0, 0);

    }

    private static void combinations(int index, int start) {
        if (index == combinationsArr.length) {
            print(combinationsArr);
            return;
        }

        for (int i = start; i < elements.length; i++) {
            combinationsArr[index] = elements[i];
            combinations(index + 1, i + 1);
        }

    }

    private static void print(String[] arr) {
        System.out.println(String.join(" ", arr));
    }
}
