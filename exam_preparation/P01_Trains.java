package exam_preparation;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.DoubleStream;

public class P01_Trains {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double[] arrivals = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToDouble(Double::parseDouble)
                .toArray();
        double[] departures = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToDouble(Double::parseDouble)
                .toArray();

        Arrays.sort(arrivals);
        Arrays.sort(departures);

        int maxPlatforms = 0;
        int platforms = 0;
        for (int a = 0, d = 0; a < arrivals.length; ) {
            if (arrivals[a] < departures[d]) {
                platforms++;
                a++;
                maxPlatforms = Math.max(platforms, maxPlatforms);
            } else {
                platforms--;
                d++;
            }
        }

        System.out.println(maxPlatforms);

    }
}
