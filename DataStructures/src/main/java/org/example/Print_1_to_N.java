package org.example;
import java.util.Scanner;

public class Print_1_to_N {
    public static void main(String[] args) {
        print(10);
    }
    static void print(int n){
        if(n == 0){
            return;
        }
        print(n-1);
        System.out.print(n + " ");
    }
}
