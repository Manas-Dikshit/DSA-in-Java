package org.example;
import java.util.Scanner;

public class Rec1 {
    public static void main(String[] args) {
        Print1(1);
    }
    static void Print1(int n){
        if(n == 10){
            System.out.println(10);
            return;
        }
        System.out.println(n);
        Print1(n+1);
    }
}
