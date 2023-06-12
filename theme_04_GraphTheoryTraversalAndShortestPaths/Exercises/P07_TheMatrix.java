package theme_04_GraphTheoryTraversalAndShortestPaths.Exercises;

import java.util.Arrays;
import java.util.Scanner;

public class P07_TheMatrix {
    private static char[][] matrix;
    private static char fillSymbol;
    private static char oldSymbol;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int rows = dimensions[0];
        int cols = dimensions[1];

        matrix = new char[rows][cols];

        for (int row = 0; row < rows; row++) {
            matrix[row] = scanner.nextLine().replaceAll("\\s+", "").toCharArray();
        }

        fillSymbol = scanner.nextLine().charAt(0);

        int[] coordinates = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int startRow = coordinates[0];
        int startCol = coordinates[1];

        oldSymbol = matrix[startRow][startCol];

        fillMatrix(startRow, startCol);

        printMatrix();
    }

    private static void printMatrix() {
        StringBuilder out = new StringBuilder();
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                out.append(matrix[row][col]);
            }
            out.append(System.lineSeparator());
        }

        System.out.print(out.toString());
    }

    private static void fillMatrix(int r, int c) {
        if (isOutOfBands(r, c) || matrix[r][c] != oldSymbol) {
            return;
        }

        matrix[r][c] = fillSymbol;

        fillMatrix(r + 1, c);
        fillMatrix(r - 1, c);
        fillMatrix(r, c + 1);
        fillMatrix(r, c - 1);
    }

    private static boolean isOutOfBands(int r, int c) {
        return r < 0 || r >= matrix.length || c < 0 || c >= matrix[r].length;
    }
}
