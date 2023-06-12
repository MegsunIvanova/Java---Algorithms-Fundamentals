package theme_04_GraphTheoryTraversalAndShortestPaths.Exercises;

import java.util.*;
import java.util.stream.Collectors;

public class P05_BreakCycles {

    private static Map<Character, List<Character>> graph = new HashMap<>();
    private static List<String> removedEdges = new ArrayList<>();
//    private static Set<Character> visitedNodes = new HashSet<>();
//    private static Set<Character> cycleNodes = new LinkedHashSet<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.trim().isEmpty()) {
                break;
            }

            String[] tokens = line.split("\\s+");

            char node = tokens[0].charAt(0);
            graph.putIfAbsent(node, new ArrayList<>());

            for (int i = 2; i < tokens.length; i++) {
                char child = tokens[i].charAt(0);
                graph.putIfAbsent(child, new ArrayList<>());
                graph.get(node).add(child);
//                graph.get(child).add(node);
            }
        }

        List<Character> nodesSorted = new ArrayList<>(graph.keySet());
        Collections.sort(nodesSorted);

        for (Character source : nodesSorted) {
            List<Character> destinations = new ArrayList<>(graph.get(source));
            Collections.sort(destinations);

            for (Character dest : destinations) {
                graph.get(source).remove(dest);
                graph.get(dest).remove(source);
                boolean isCycled = hasPath(source, dest, new HashSet<Character>(), new ArrayDeque<>());
                if (isCycled) {
                    removedEdges.add(String.format("%s - %s", source, dest));
                } else {
                    graph.get(source).add(dest);
                    graph.get(dest).add(source);
                }
            }


        }

        System.out.println("Edges to remove: " + removedEdges.size());
        System.out.println(removedEdges.stream().collect(Collectors.joining(System.lineSeparator())));

    }

    private static boolean hasPath(Character source, Character destination,
                                   Set<Character> visited, Deque<Character> queue) {
        queue.offer(source);
        visited.add(source);

        while (!queue.isEmpty()) {
            Character node = queue.poll();
            if (destination.equals(node)) {
                return true;
            }

            List<Character> children = graph.get(node);
            if (children.size() > 0) {
                for (Character child : children) {
                    if (!visited.contains(child)) {
                        queue.offer(child);
                        visited.add(child);
                    }

                }

            }
        }

        return false;
    }


}
