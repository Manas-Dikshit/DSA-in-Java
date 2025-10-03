package org.example;

import java.util.Scanner;
import java.util.Arrays;

public class bsrc {
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of array you want to create");
        int size = sc.nextInt();
        int[] arr = new int[size];
        System.out.println("Enter the elements:");
        for(int i = 0; i< arr.length; i++){
            int index = sc.nextInt();
            arr[i] = index;
        }
        Arrays.sort(arr);
        System.out.println("Your sorted array is "+ Arrays.toString(arr));

        System.out.println("Enter the target you want to find");
        int target = sc.nextInt();
        int ans = search(arr, target, 0, arr.length-1);
        if(ans == -1){
            System.out.println("Target Not Found");
        }
        else{
            System.out.println("Target Found At Index "+ ans);
        }
    }
    static int search(int[] arr, int target, int s, int e){
        Arrays.sort(arr);
        if(s>e){
            return -1;
        }
        int m = s+(e-s) / 2;

        if(arr[m] == target){
            return m;
        }
        if(target < arr[m]){
           return search(arr, target, s, m-1);
        }

            return search(arr, target, m+1, e);

    }
}
