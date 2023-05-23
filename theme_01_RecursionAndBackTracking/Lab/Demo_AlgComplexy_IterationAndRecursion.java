package theme_01_RecursionAndBackTracking.Lab;

public class Demo_AlgComplexy_IterationAndRecursion {
    public static void main(String[] args) {

        //BRUTE-FORCE

//        for (int i = 0; i <= 9; i++) {
//            for (int j = 0; j <= 9; j++) {
//                for (int k = 0; k <= 9; k++) {
//                    for (int l = 0; l <= 9; l++) {
//                        for (int m = 0; m <= 9; m++) {
//                            System.out.printf("%d%d%d%d%d%n", i, j, k, l, m);
//                        }
//                    }
//                }
//            }
//        }

//        System.out.println(Math.pow(10,5));

        //RECURSION

        System.out.print("(main");
        a();
        System.out.println(")");

    }

    private static void a() {
        System.out.print("(a");
        b();
        System.out.print(")");
    }

    private static void b() {
        System.out.print("(b");
        c();
        System.out.print(")");
    }

    private static void c() {
        System.out.print("(c");
        d();
        System.out.print(")");
    }

    private static void d() {
        System.out.print("(d)");
    }

}
