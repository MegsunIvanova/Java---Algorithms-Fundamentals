package exam_preparation;

import java.util.*;
import java.util.stream.Collectors;

public class P03_PathFinder {
    private static Map<Integer, Set<Integer>> graph = new HashMap<>();

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        final int length = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < length; i++) {
            final String line = scanner.nextLine();

            if (line.trim().length() > 0) {
                final Set<Integer> children = Arrays.stream(line.split("\\s+"))
                        .map(Integer::parseInt)
                        .collect(Collectors.toSet());

                graph.put(i, children);

            } else {
                graph.put(i, new HashSet<>());
            }
        }

        final int patsNumber = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < patsNumber; i++) {

            int[] path = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            String result = dfs(path, 0);

            System.out.println(result);

        }


    }

    private static String dfs(int[] path, int index) {
        int currentNode = path[index];
        int nextNode = path[index + 1];

        Set<Integer> children = graph.get(currentNode);

        if (!children.contains(nextNode))  {
            return "no";
        }

        if (index + 1 < path.length - 1) {
           return dfs(path, index + 1);
        } else {
            return "yes";
        }


    }
}
