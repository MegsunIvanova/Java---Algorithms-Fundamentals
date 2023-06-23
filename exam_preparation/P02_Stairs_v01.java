package exam_preparation;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class P02_Stairs_v01 {

    private static Map<Integer, Long> memoization = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int stairs = Integer.parseInt(scanner.nextLine());

        long steps = getSteps(stairs, 0);

        System.out.println(steps);

    }

    private static long getSteps(int stairs, int currentStep) {

        if (stairs == 2) {
            return 2;
        }

        if (stairs == 1) {
            return 1;
        }

        if (memoization.containsKey(stairs)) {
            return memoization.get(stairs);
        }

        long result = getSteps(stairs - 1, currentStep + 1)
                + getSteps(stairs - 2, currentStep + 1);
        memoization.put(stairs, result);

        return result;

    }
}
