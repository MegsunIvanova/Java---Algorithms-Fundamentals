package theme_02_CombinatorialProblems.Exercises;

import java.util.*;
import java.util.stream.Collectors;

public class P08_WordCruncher {

    private static List<String> words;
    private static List<String> combined = new ArrayList<>();
    private static String target;
    private static Map<Integer, List<String>> table = new HashMap<>();
    private static Map<String, Integer> occurrences = new HashMap<>();
    private static Set<String> out = new TreeSet<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        words = Arrays.stream(scanner.nextLine().split(", "))
                .collect(Collectors.toList());

        target = scanner.nextLine();

        words.removeIf(next -> !target.contains(next));

        for (String substring : words) {
            occurrences.putIfAbsent(substring, 0);
            occurrences.put(substring, occurrences.get(substring) + 1);

            int index = target.indexOf(substring);
            while (index != -1) {
                table.putIfAbsent(index, new ArrayList<>());
                table.get(index).add(substring);
                index = target.indexOf(substring, index + 1);
            }
        }

        permute(0);

        for (String str : out) {
            System.out.println(str);
        }
    }

    private static void permute(int index) {
        if (index == target.length()) {
            printPrepare();
        } else if (table.containsKey(index)) {
            List<String> strings = table.get(index);
            for (String str : strings) {
                if(occurrences.get(str) > 0) {
                    occurrences.put(str, occurrences.get(str) - 1);
                    combined.add(str);
                    permute(index + str.length());
                    combined.remove(combined.size() - 1);
                    occurrences.put(str, occurrences.get(str) + 1);
                }
            }
        }
    }

    private static void printPrepare() {
        String actual = String.join("", combined);
        if (actual.contains(target)) {
           out.add(String.join(" ", combined));
        }
    }
}
