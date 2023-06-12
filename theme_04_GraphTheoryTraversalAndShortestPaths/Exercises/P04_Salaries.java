package theme_04_GraphTheoryTraversalAndShortestPaths.Exercises;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class P04_Salaries {

    private static List<List<Integer>> graph = new ArrayList<>();

    private static long[] salaries;
    private static boolean[] visited;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int employees = Integer.parseInt(scanner.nextLine());

        int[] managersCount = new int[employees];

        for (int i = 0; i < employees; i++) {
            graph.add(new ArrayList<>());
            String line = scanner.nextLine();

            for (int emp = 0; emp < line.length(); emp++) {
                char letter = line.charAt(emp);

                if (letter == 'Y') {
                    managersCount[emp]++;
                    graph.get(i).add(emp);
                }
            }
        }

        salaries = new long[employees];
        visited = new boolean[employees];

        for (int node = 0; node < managersCount.length; node++) {
            if (managersCount[node] == 0) {
                dfs(node);
            }
        }

        System.out.println(Arrays.stream(salaries).sum());
    }

    private static void dfs(int node) {
        List<Integer> children = graph.get(node);
        if (children.isEmpty()) {
            salaries[node] = 1;
            return;
        }

        if (visited[node]) {
            return;
        }

        visited[node] = true;

        for (Integer child : children) {
            if (!visited[child]) {
                dfs(child);
            }
        }

        salaries[node] = children.stream().mapToLong(c -> salaries[c]).sum();
    }
}

