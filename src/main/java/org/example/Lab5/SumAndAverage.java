package org.example.Lab5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SumAndAverage {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = 5;
        int[] arr = new int[n];
        int sum = 0;

        System.out.println("Enter 5 numbers:");

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            sum += arr[i];
        }

        double average = (double) sum / n;

        System.out.println("Sum of numbers: " + sum);
        System.out.println("Average of numbers: " + average);
    }
}
