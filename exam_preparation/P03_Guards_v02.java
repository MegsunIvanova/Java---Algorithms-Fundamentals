package exam_preparation;

import java.util.*;

public class P03_Guards_v02 {

    private static Map<Integer, Set<Integer>> graph = new HashMap<>();
    private static Set<Integer> notVisitedNodes = new HashSet<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int nodes = Integer.parseInt(scanner.nextLine());
        int edgeCount = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= nodes; i++) {
            notVisitedNodes.add(i);
            graph.put(i, new HashSet<>());
        }

        for (int i = 0; i < edgeCount; i++) {
            String[] edge = scanner.nextLine().split("\\s+");
            int from = Integer.parseInt(edge[0]);
            int to = Integer.parseInt(edge[1]);

            graph.get(from).add(to);
        }

        int startNode = Integer.parseInt(scanner.nextLine());

        dfs(startNode);

        notVisitedNodes.stream().sorted().forEach(node -> System.out.print(node + " "));

    }

    private static void dfs(int currentNode) {
        if (!notVisitedNodes.contains(currentNode)) {
            return;
        }

        notVisitedNodes.remove(currentNode);

        Set<Integer> connectedNodes = graph.get(currentNode);

        for (Integer connectedNode : connectedNodes) {
            dfs(connectedNode);
        }
    }

}
