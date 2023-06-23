package exam_preparation;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class P02_Stairs_v02 {

    private static long memory[];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int stairs = Integer.parseInt(scanner.nextLine());

        if (stairs < 4) {
            System.out.println(stairs);
            return;
        }

        memory = new long[stairs + 1];
        memory[1] = 1;
        memory[2] = 2;

        System.out.println(climbStairs(stairs));

    }

    private static long climbStairs(int stairs) {
        if (memory[stairs] != 0) {
            return memory[stairs];
        }

        return memory[stairs] = climbStairs(stairs - 1)
                + climbStairs(stairs - 2);

    }
}
