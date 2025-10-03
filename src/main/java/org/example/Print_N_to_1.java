package org.example;
import java.util.Scanner;

public class Print_N_to_1{
    public static void main(String[] args) {
        print(12);
    }
    static void print(int n){
        if(n == 0){
            return;
        }
        System.out.print(n + " ");
        print(n-1);
    }
}