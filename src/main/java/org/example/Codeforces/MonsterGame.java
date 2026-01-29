package org.example.Codeforces;

import java.util.*;
import java.io.*;

public class MonsterGame {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder out = new StringBuilder();
        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            long[] a = new long[n];
            long[] b = new long[n];

            String[] sa = br.readLine().split(" ");
            String[] sb = br.readLine().split(" ");

            for (int i = 0; i < n; i++) a[i] = Long.parseLong(sa[i]);
            for (int i = 0; i < n; i++) b[i] = Long.parseLong(sb[i]);

            Arrays.sort(a);

            // prefix sums of b
            long[] prefix = new long[n];
            prefix[0] = b[0];
            for (int i = 1; i < n; i++) prefix[i] = prefix[i - 1] + b[i];

            long ans = 0;

            for (int i = 0; i < n; i++) {
                long x = a[i];
                int idx = lowerBound(a, x); // first index >= x
                long usableSwords = n - idx;

                // Find how many levels can be cleared
                int levels = upperBound(prefix, usableSwords);
                ans = Math.max(ans, x * levels);
            }

            out.append(ans).append("\n");
        }
        System.out.print(out);
    }

    // first index >= value
    static int lowerBound(long[] arr, long val) {
        int l = 0, r = arr.length;
        while (l < r) {
            int mid = (l + r) / 2;
            if (arr[mid] >= val) r = mid;
            else l = mid + 1;
        }
        return l;
    }

    // first index with prefix[i] > usableSwords
    static int upperBound(long[] arr, long val) {
        int l = 0, r = arr.length;
        while (l < r) {
            int mid = (l + r) / 2;
            if (arr[mid] <= val) l = mid + 1;
            else r = mid;
        }
        return l; // number of levels possible
    }
}
