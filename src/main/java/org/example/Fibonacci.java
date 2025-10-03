package org.example;
import java.util.Scanner;

public class Fibonacci {
    public static void main(String[] args) {
        long ans = fibo(100);
        System.out.println(ans);
    }

    static long fibo(int n) {
        if (n < 2) return n;
        long a = 0, b = 1, c = 0;
        for (int i = 2; i <= n; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return b;
    }
}
