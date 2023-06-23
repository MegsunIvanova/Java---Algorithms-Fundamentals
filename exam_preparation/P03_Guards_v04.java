package exam_preparation;

import java.util.*;

public class P03_Guards_v04 {

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

        Deque<Integer> deque = new ArrayDeque<>();

        deque.offer(startNode);

        while (!deque.isEmpty()) {
            Integer currentNode = deque.poll();

            if (!notVisitedNodes.contains(currentNode)) {
                continue;
            }

            notVisitedNodes.remove(currentNode);

            Set<Integer> toTraverse = graph.get(currentNode);
            deque.addAll(toTraverse);

        }

        notVisitedNodes.stream().sorted().forEach(node -> System.out.print(node + " "));

    }

}
