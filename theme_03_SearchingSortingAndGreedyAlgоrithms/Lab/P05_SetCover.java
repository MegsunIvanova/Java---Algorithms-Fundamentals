package theme_03_SearchingSortingAndGreedyAlgоrithms.Lab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class P05_SetCover {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] elements = reader.readLine().substring(10).split(", ");
        int[] universe = new int[elements.length];
        for (int i = 0; i < elements.length; i++) {
            universe[i] = Integer.parseInt(elements[i]);
        }
        int numberOfSets = Integer.parseInt(reader.readLine().substring(16));
        List<int[]> sets = new ArrayList<>();
        for (int i = 0; i < numberOfSets; i++) {
            String[] setElements = reader.readLine().split(", ");
            int[] set = new int[setElements.length];
            for (int j = 0; j < setElements.length; j++) {
                set[j] = Integer.parseInt(setElements[j]);
            }
            sets.add(set);
        }
        List<int[]> chosenSets = chooseSets(sets, universe);

        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Sets to take (%d):%n", chosenSets.size()));
        for (int[] set : chosenSets) {
            sb.append("{ ");
            sb.append(Arrays.toString(set).replaceAll("\\[|]", ""));
            sb.append(" }").append(System.lineSeparator());
        }
        System.out.println(sb);
    }

    public static List<int[]> chooseSets(List<int[]> sets, int[] universe) {
        Set<Integer> universeSet = new HashSet<>();
        Arrays.stream(universe).forEach(universeSet::add);

        List<int[]> selectedSets = new ArrayList<>();

        while (!universeSet.isEmpty()) {
            int maxCount = 0;
            int[] chosenSet = new int[0];

            for (int[] set : sets) {
                int count = getOccurrences(set, universeSet);
                if (count > maxCount) {
                    maxCount = count;
                    chosenSet = set;
                }
            }

            selectedSets.add(chosenSet);

            Arrays.stream(chosenSet).boxed().forEach(universeSet::remove);
        }

        return selectedSets;
    }

    private static int getOccurrences(int[] set, Set<Integer> universeSet) {
        int count = 0;
        for (int number : set) {
            if (universeSet.contains(number)) {
                count++;
            }
        }
        return count;
    }

}
