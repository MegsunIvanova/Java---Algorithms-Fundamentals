package theme_02_CombinatorialProblems.Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Collectors;

public class P01_ReverseArray {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] elements = reader.readLine().split("\\s+");

        printReverceArray(elements, elements.length - 1);
    }

    private static void printReverceArray(String[] elements, int index) {
        if (index < 0) {
            return;
        }

        System.out.print(elements[index] + " ");

        printReverceArray(elements, index - 1);

    }

}
