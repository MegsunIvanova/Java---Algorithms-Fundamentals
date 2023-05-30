package theme_02_CombinatorialProblems.Exercises;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P09_SchoolTeams {
    private static String[] girls;
    private static String[] boys;
    private static String[] girlsCombinations = new String[3];
    private static String[] boysCombinations = new String[2];
    private static List<String> girlsOut = new ArrayList<>();
    private static List<String> boysOut = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        girls = scanner.nextLine().split(", ");
        boys = scanner.nextLine().split(", ");

        combine(0, 0, true);
        combine(0, 0, false);

        for (String girlsGroup : girlsOut) {
            for (String boysGroup : boysOut) {
                System.out.println(girlsGroup + ", " + boysGroup);
            }
        }
    }

    private static void combine(int index, int start, boolean isGirls) {
        String[] groupCombinations = isGirls ? girlsCombinations : boysCombinations;
        String[] group = isGirls ? girls : boys;
        List<String> out = isGirls ? girlsOut : boysOut;

        if (index >= groupCombinations.length) {
            out.add(String.join(", ", groupCombinations));
        } else {
            for (int i = start; i < group.length; i++) {
                groupCombinations[index] = group[i];
                combine(index + 1, i + 1, isGirls);
            }
        }
    }


}
