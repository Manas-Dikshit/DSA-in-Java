package org.example.Codeforces;

import java.util.*;
import java.io.*;


public class Piggy {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        StringBuilder out = new StringBuilder();

        int t = Integer.parseInt(br.readLine().trim());

        while(t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            int[] a = new int[n];
            String[] parts = br.readLine().split(" ");
            if (parts.length != n) {
                System.out.println("Error: Expected " + n + " numbers but got " + parts.length);
                return;
            }
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(parts[i]);
            }
            int[] b = a.clone();

            Arrays.sort(b);

            // If already sorted, output -1
            if (Arrays.equals(a, b)) {
                out.append("-1\n");
                continue;
            }
            int maxDiff = 0;
            for (int i = 0; i < n; i++) {
                maxDiff = Math.max(maxDiff, Math.abs(a[i] - b[i]));
            }
            out.append(maxDiff).append("\n");
        }
        System.out.print(out);

    }
}
