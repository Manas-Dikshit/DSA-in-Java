package org.example.Lab5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Prg1 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Enter number of elements: ");
        int n = Integer.parseInt(br.readLine());

        if (n < 2) {
            System.out.println("Array must contain at least two numbers.");
            return;
        }

        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        System.out.println("Enter the array elements:");
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());

            if (num > largest) {
                secondLargest = largest;
                largest = num;
            } else if (num > secondLargest && num != largest) {
                secondLargest = num;
            }
        }

        System.out.println("Largest number: " + largest);

        if (secondLargest == Integer.MIN_VALUE) {
            System.out.println("Second largest number does not exist (all elements may be equal).");
        } else {
            System.out.println("Second largest number: " + secondLargest);
        }
    }
}
