package org.example;
import java.util.Scanner;
public class Product_of_n_to_1 {
    public static void main(String[] args) {
        int ans = factorial(10);
        System.out.println(ans);
    }
    static int factorial(int n){
        if(n == 1){
            return 1;
        }
        return n * factorial(n-1);
    }
}
