package theme_01_RecursionAndBackTracking.Lab;

public class Demo_Fibonacci {

    static long fibonacci(int n) {
        if (n <= 1)
            return 1;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static void main(String[] args) {
        System.out.println(fibonacci(10)); // 89
        System.out.println(fibonacci(50)); // This will hang!
    }

}
