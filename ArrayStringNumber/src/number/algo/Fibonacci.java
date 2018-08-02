package number.algo;

import java.util.HashMap;
import java.util.Map;

/**
 * Faster Fibonacci
 */
public class Fibonacci {

    public static void main(String[] args) {
        Fibonacci fibonacci = new Fibonacci();
        System.out.println(fibonacci.fibo(1));
        System.out.println(fibonacci.fibo(2));
        System.out.println(fibonacci.fibo(3));
        System.out.println(fibonacci.fibo(4));
        System.out.println(fibonacci.fibo(10));
        System.out.println(fibonacci.fibo(15));
    }

    public int fibo(int n) {
        HashMap<Integer, Integer> calculatedFibo = new HashMap<>();
        int fib = fibo(n, calculatedFibo);

        System.out.println(calculatedFibo);

        return fib;
    }

    private int fibo(int n, Map<Integer, Integer> calculatedFibo) {
        if (n == 0) {
            return 0;
        } else if (n <= 2) {
            return 1;
        } else if (calculatedFibo.containsKey(n)) {
            return calculatedFibo.get(n);
        } else {
            int v = fibo(n - 1, calculatedFibo) + fibo(n - 2, calculatedFibo);
            calculatedFibo.put(n, v);
            return v;
        }
    }
}
