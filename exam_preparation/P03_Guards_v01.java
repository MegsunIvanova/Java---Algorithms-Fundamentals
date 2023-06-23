package exam_preparation;

import java.util.*;

public class P03_Guards_v01 {
    private static boolean[] visited;
    private static Map<Integer, List<Integer>> graph;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int nodes = Integer.parseInt(scanner.nextLine());
        int edges = Integer.parseInt(scanner.nextLine());

        visited = new boolean[nodes + 1];
        visited[0] = true;

        graph = new HashMap<>();

        for (int i = 0; i < edges; i++) {
            int[] line = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            graph.putIfAbsent(line[0], new ArrayList<>());
            graph.get(line[0]).add(line[1]);
        }

        int startNode = Integer.parseInt(scanner.nextLine());

        Deque<Integer> queue = new ArrayDeque<>();
        queue.offer(startNode);
        visited[startNode] = true;

        while (!queue.isEmpty()) {
            int node = queue.poll();

            if (!graph.containsKey(node)) {
                continue;
            }

            List<Integer> children = graph.get(node);

            if (children.isEmpty()) {
                continue;
            }

            for (int child : children) {
                if (!visited[child]) {
                    queue.offer(child);
                    visited[child] = true;

                }
            }
        }

        List<String> out = new ArrayList<>();
        for (int i = 1; i < visited.length; i++) {
            if (!visited[i]) {
                out.add("" + i);
            }
        }

        System.out.println(String.join(" ", out));

    }

}
