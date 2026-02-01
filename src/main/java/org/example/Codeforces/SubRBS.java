package org.example.Codeforces;

import java.io.*;
import java.util.*;

public class SubRBS {
    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);
        int T = fs.nextInt();
        StringBuilder out = new StringBuilder();
        while (T-- > 0) {
            int n = fs.nextInt();
            String s = fs.next();
            char[] a = s.toCharArray();

            // prefix counts of '(' and ')'
            int[] prefOpen = new int[n + 1];
            int[] prefClose = new int[n + 1];
            for (int i = 0; i < n; i++) {
                prefOpen[i + 1] = prefOpen[i] + (a[i] == '(' ? 1 : 0);
                prefClose[i + 1] = prefClose[i] + (a[i] == ')' ? 1 : 0);
            }
            int totalOpen = prefOpen[n];
            int totalClose = prefClose[n];

            // nextOpen[i] = smallest index > i that has '(' (1-based indices in pref arrays)
            int[] nextOpen = new int[n + 2];
            Arrays.fill(nextOpen, -1);
            int next = -1;
            for (int i = n - 1; i >= 0; i--) {
                if (a[i] == '(') next = i; // 0-based
                nextOpen[i] = next; // next index >= i, but we will query nextOpen[k-1]
            }
            nextOpen[n] = -1; // beyond end

            int best = -1;

            // iterate over possible k where s[k] == ')'
            // k is 1-based in explanation, here use 0-based index for s[k]
            for (int k = 0; k < n; k++) {
                if (a[k] != ')') continue;

                // prefix is s[0..k-1], its balance B:
                int opensPrefix = prefOpen[k];
                int closesPrefix = prefClose[k];
                int B = opensPrefix - closesPrefix;

                // we need a '(' from some position j > k-1, i.e. j >= k
                int jIndex = nextOpen[k]; // returns 0-based index of next '(' at or after k
                if (jIndex == -1) continue; // no '(' after that prefix

                // suffix counts strictly after jIndex -> positions > jIndex
                int opensSuf = prefOpen[n] - prefOpen[jIndex + 1];
                int closesSuf = prefClose[n] - prefClose[jIndex + 1];

                // we need closesSuf >= B + 1
                if (closesSuf < B + 1) continue;

                int extraPairs = Math.min(opensSuf, closesSuf - (B + 1));
                int usedFromSuffix = (B + 1) + 2 * extraPairs;
                int totalLength = (k) + 1 + usedFromSuffix; // (k) = number of prefix chars (0..k-1)
                // Simplify: prefix count = k, + chosen '(' =1, + usedFromSuffix
                if (totalLength > best) best = totalLength;
            }

            out.append(best).append('\n');
        }
        System.out.print(out.toString());
    }

    // Fast scanner (simple)
    static class FastScanner {
        private final InputStream in;
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0, len = 0;

        FastScanner(InputStream is) { in = is; }

        private int read() throws IOException {
            if (ptr >= len) {
                len = in.read(buffer);
                ptr = 0;
                if (len <= 0) return -1;
            }
            return buffer[ptr++];
        }

        int nextInt() throws IOException {
            int c;
            while ((c = read()) <= ' ') if (c == -1) return Integer.MIN_VALUE;
            int sign = 1;
            if (c == '-') { sign = -1; c = read(); }
            int val = 0;
            while (c > ' ') {
                val = val * 10 + (c - '0');
                c = read();
            }
            return val * sign;
        }

        String next() throws IOException {
            int c;
            while ((c = read()) <= ' ') if (c == -1) return null;
            StringBuilder sb = new StringBuilder();
            while (c > ' ') {
                sb.append((char) c);
                c = read();
            }
            return sb.toString();
        }
    }
}
