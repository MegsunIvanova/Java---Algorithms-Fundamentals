package theme_04_GraphTheoryTraversalAndShortestPaths.Exercises;

import java.util.*;

public class P02_AreasInMatrix {

    private static char[][] matrix;
    private static boolean[][] visited;
    private static boolean[] visitedNode;

    private static List<Edge> graph = new ArrayList<>();

    private static class Edge {
        int[] source;
        int[] dest;

        public Edge(int sRow, int sCol) {
            this.source = new int[]{sRow, sCol};
        }

        public void setDest(int dRow, int dCol) {
            this.dest = new int[]{dRow, dCol};
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine());

        matrix = new char[rows][];
        visited = new boolean[rows][];

        for (int i = 0; i < rows; i++) {
            matrix[i] = scanner.nextLine().toCharArray();
            visited[i] = new boolean[matrix[i].length];
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (!visited[i][j]) {
                    dfs(i, j, matrix[i][j]);
                }
            }
        }

        visitedNode = new boolean[graph.size() + 1];

        Map<Character, Integer> areas = new TreeMap<>();

        for (int i = 0; i < graph.size(); i++) {
            if (!visitedNode[i]) {
                Edge edge = graph.get(i);
                char key = matrix[edge.source[0]][edge.source[1]];
                areas.putIfAbsent(key, 0);
                areas.put(key, areas.get(key) + 1);
                bfs(i);
            }
        }

        System.out.println("Areas: " + areas.values().stream().mapToInt(e -> e).sum());

        for (Map.Entry<Character, Integer> entry : areas.entrySet()) {
            System.out.printf("Letter '%c' -> %d%n", entry.getKey(), entry.getValue());
        }

    }

    private static void bfs(int source) {
        Deque<Integer> queue = new ArrayDeque<>();
        queue.offer(source);

        visitedNode[source] = true;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            Edge edge = graph.get(node);

            if (edge.dest != null) {
                visitedNode[node + 1] = true;
                queue.offer(node + 1);
            }
        }
    }

    private static void dfs(int row, int col, char areaSymbol) {
        visited[row][col] = true;

        Edge edge = new Edge(row, col);
        graph.add(edge);

        assignDestination(row, col + 1, areaSymbol);
        assignDestination(row, col - 1, areaSymbol);
        assignDestination(row + 1, col, areaSymbol);
        assignDestination(row - 1, col, areaSymbol);
    }

    private static void assignDestination(int r, int c, char areaSymbol) {
        if (isInBounds(r, c) && !visited[r][c] && matrix[r][c] == areaSymbol) {
            graph.get(graph.size() - 1).setDest(r, c);
            dfs(r, c, areaSymbol);
        }
    }

    private static boolean isInBounds(int row, int col) {
        return !isOutOfBounds(row, col);
    }

    private static boolean isOutOfBounds(int row, int col) {
        return row < 0 || row >= matrix.length || col < 0 || col >= matrix[row].length;
    }
}
