package org.example;

public class PassingNumber {
    public static void main(String[] args) {
        num(45);
    }
    static void num(int n){
        if( n == 0 ){
            return;
        }
        System.out.print(n + " ");
        num(--n);
    }
}
