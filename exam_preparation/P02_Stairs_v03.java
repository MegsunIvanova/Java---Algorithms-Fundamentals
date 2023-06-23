package exam_preparation;

import java.util.Scanner;

public class P02_Stairs_v03 {

    private static long memory[];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int stairs = Integer.parseInt(scanner.nextLine());

        if (stairs < 3) {
            System.out.println(stairs);
            return;
        }

        memory = new long[stairs + 1];
        memory[1] = 1;
        memory[2] = 2;

        for (int i = 3; i <= stairs; i++) {
            memory[i] = memory[i - 1] + memory[i - 2];
        }

        System.out.println(memory[stairs]);

    }

}
