package org.example.Codeforces;

import java.io.*;
import java.util.*;

public class ArrayColoring {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder out = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] a = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int[] pos = new int[n + 1];
            for (int i = 0; i < n; i++) pos[a[i]] = i;

            List<List<Integer>> g = new ArrayList<>();
            for (int i = 0; i < n; i++) g.add(new ArrayList<>());
            for (int i = 0; i < n - 1; i++) { // edges in original order
                g.get(i).add(i + 1);
                g.get(i + 1).add(i);
            }
            for (int i = 1; i < n; i++) { // edges in sorted order
                int u = pos[i], v = pos[i + 1];
                g.get(u).add(v);
                g.get(v).add(u);
            }

            int[] color = new int[n];
            boolean ok = true;
            for (int i = 0; i < n && ok; i++) if (color[i] == 0) {
                Queue<Integer> q = new ArrayDeque<>();
                q.add(i); color[i] = 1;
                while (!q.isEmpty() && ok) {
                    int u = q.poll();
                    for (int v : g.get(u)) {
                        if (color[v] == 0) { color[v] = -color[u]; q.add(v); }
                        else if (color[v] == color[u]) { ok = false; break; }
                    }
                }
            }
            out.append(ok ? "YES\n" : "NO\n");
        }
        System.out.print(out);
    }
}
