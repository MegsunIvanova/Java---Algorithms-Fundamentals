package exam_preparation;

import java.util.*;

public class P03_Guards_v03 {
    private static boolean[][] graph;
    private static Set<Integer> visitedNodes = new HashSet<>();

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        final int nodes = Integer.parseInt(scanner.nextLine());

        graph = new boolean[nodes + 1][nodes + 1];

        final int edgeCount = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < edgeCount; i++) {
            final String[] edge = scanner.nextLine().split("\\s+");
            final int from = Integer.parseInt(edge[0]);
            final int to = Integer.parseInt(edge[1]);

            graph[from][to] = true;
        }

        final int startNode = Integer.parseInt(scanner.nextLine());

        dfs(startNode);

        for (int i = 1; i <= nodes ; i++) {
            if (!visitedNodes.contains(i)) {
                System.out.print(i + " ");
            }
        }

    }

    private static void dfs(int currentNode) {
        if (visitedNodes.contains(currentNode)) {
            return;
        }

        visitedNodes.add(currentNode);

        for (int i = 1; i < graph[currentNode].length; i++) {
            if (graph[currentNode][i]) {
                dfs(i);
            }
        }

    }

}
