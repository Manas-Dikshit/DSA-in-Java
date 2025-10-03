package org.example;
import java.util.*;
import java.io.*;

public class Codeforces_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder out = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            long n = Long.parseLong(br.readLine());
            List<Long> answers = new ArrayList<>();

            // Try different k values (10^k grows fast, up to ~1e18)
            for (int k = 1; k <= 18; k++) {
                long divisor = pow10(k) + 1;
                if (n % divisor == 0) {
                    long x = n / divisor;
                    answers.add(x);
                }
            }

            if (answers.isEmpty()) {
                out.append("0\n");
            } else {
                Collections.sort(answers);
                out.append(answers.size()).append("\n");
                for (int i = 0; i < answers.size(); i++) {
                    if (i > 0) out.append(" ");
                    out.append(answers.get(i));
                }
                out.append("\n");
            }
        }

        System.out.print(out.toString());
    }

    private static long pow10(int exp) {
        long res = 1;
        for (int i = 0; i < exp; i++) res *= 10;
        return res;
    }
}

