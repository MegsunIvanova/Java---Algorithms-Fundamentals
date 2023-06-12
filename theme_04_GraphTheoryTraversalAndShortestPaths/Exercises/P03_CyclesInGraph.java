package theme_04_GraphTheoryTraversalAndShortestPaths.Exercises;

import java.util.*;

public class P03_CyclesInGraph {

    private static Map<String, List<String>> graph = new HashMap<>();
    private static Set<String> visited = new HashSet<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String source = null;

        String line = scanner.nextLine();

        while (!line.equals("End")) {
            String[] tokens = line.split("-");

            if (source == null) {
                source = tokens[0];
            }

            graph.putIfAbsent(tokens[0], new ArrayList<>());
            graph.putIfAbsent(tokens[1], new ArrayList<>());
            graph.get(tokens[0]).add(tokens[1]);

            line = scanner.nextLine();
        }

        Set<String> cycles = new HashSet<>();

        try {
            dfs(source, cycles);
            if (visited.size() < graph.size()) {
                System.out.println("Acyclic: No");
            } else {
                System.out.println("Acyclic: Yes");
            }
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void dfs(String source, Set<String> cycles) {
        if (cycles.contains(source)) {
            throw new IllegalStateException("Acyclic: No");
        }

        if (visited.contains(source)) {
            return;
        }

        cycles.add(source);
        visited.add(source);

        List<String> children = graph.get(source);
        for (String child : children) {
            dfs(child, cycles);
        }

        cycles.remove(source);
    }
}
