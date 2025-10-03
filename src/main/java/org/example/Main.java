package org.example;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of array you want to create:");
        int n = sc.nextInt();
    }
    static int[] descending(int[] arr, int s, int e){
        Arrays.sort(arr);
      while(s<e){
          swap(arr[s], arr[e]);
          s++;
          e--;
      }
       return arr;
    }
    static void swap(int x, int y){
        int temp = x;
        x = y;
        y = temp;
    }
}