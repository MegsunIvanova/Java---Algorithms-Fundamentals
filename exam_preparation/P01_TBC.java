package exam_preparation;

import java.util.Scanner;

public class P01_TBC {
    private static char[][] matrix;
    private static boolean[][] visited;

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        final int r = Integer.parseInt(scanner.nextLine());

        final int c = Integer.parseInt(scanner.nextLine());

        matrix = new char[r][c];
        visited = new boolean[r][c];

        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = scanner.nextLine().toCharArray();
        }

        int counter = 0;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == 't' && !visited[row][col]) {
                    dfs(row, col);
                    counter++;
                }
            }
        }

        System.out.println(counter);

    }

    private static void dfs(int row, int col) {
        if (isOutOfBounds(row, col) || matrix[row][col] != 't' || visited[row][col]) {
            return;
        }

        visited[row][col] = true;

        dfs(row - 1, col);
        dfs(row - 1, col + 1);
        dfs(row, col + 1);
        dfs(row + 1, col + 1);
        dfs(row + 1, col);
        dfs(row + 1, col - 1);
        dfs(row, col - 1);
        dfs(row - 1, col - 1);

    }

    private static boolean isOutOfBounds(int row, int col) {
        return row < 0 || row >= matrix.length || col < 0 || col >= matrix[row].length;
    }
}
