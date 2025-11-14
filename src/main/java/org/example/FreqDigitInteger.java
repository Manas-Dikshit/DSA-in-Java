

package org.example;
import java.util.*;
import java.util.Scanner;

public class FreqDigitInteger {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] t = new int[10];
        while(n > 0){
            t[n%10]++;
            n/=10;
        }
        for(int i = 0; i < 10; i++){
            System.out.println(i + "="+t[i]);
        }
    }
}
