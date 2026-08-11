package org.example.Codeforces;

import java.io.*;


import java.util.*;

public class BuildATree {

    static class FastScanner {
        private final InputStream in = System.in;
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0, len = 0;

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
            do {
                c = read();
            } while (c <= ' ');

            int res = 0;
            while (c > ' ') {
                res = res * 10 + c - '0';
                c = read();
            }
            return res;
        }

        long nextLong() throws IOException {
            int c;
            do {
                c = read();
            } while (c <= ' ');

            long res = 0;
            while (c > ' ') {
                res = res * 10 + c - '0';
                c = read();
            }
            return res;
        }
    }

    static class Edge {
        int u, v;

        Edge(int u, int v) {
            this.u = u;
            this.v = v;
        }
    }

    static class Group {
        int size;
        int id;

        Group(int size, int id) {
            this.size = size;
            this.id = id;
        }
    }

    static void solve(FastScanner fs, StringBuilder out) throws Exception {

        int n = fs.nextInt();
        long k = fs.nextLong();

        // Calculate maximum possible k
        long maxK = 0;

        for (int x = 1; x <= n / 2; x++) {
            maxK += x;

            if (2L * x <= n - 1) {
                maxK += x;
            }
        }

        maxK *= 2;

        // Impossible
        if ((k & 1L) != 0 ||
                k < 2L * (n - 1) ||
                k > maxK) {

            out.append("-1\n");
            return;
        }

        // n = 2
        if (n == 2) {
            out.append("1 2\n");
            return;
        }

        /*
         * Vertex 1 is the centroid.
         *
         * Initially create two chains with balanced sizes.
         */
        ArrayList<Integer> cnt = new ArrayList<>();

        int first = (n - 1) / 2;
        int second = (n - 1) - first;

        cnt.add(first);
        cnt.add(second);

        /*
         * We work with k/2.
         */
        long target = k / 2;
        long current = maxK / 2;

        /*
         * Split chains until we can construct
         * the exact required value.
         */
        int iteration = 0;

        while (true) {

            int id = iteration & 1;
            int size = cnt.get(id);

            if (size > 1 &&
                    current - (size - 1) >= target) {

                current -= size - 1;

                cnt.set(id, size - 1);
                cnt.add(1);

                iteration++;
                continue;
            }

            break;
        }

        /*
         * Now construct the tree.
         *
         * The current value is >= target.
         * The remaining difference is handled
         * by changing the last vertex of one chain.
         */
        int special = iteration & 1;

        // If the selected chain cannot handle it,
        // use the other one.
        if (cnt.get(special) - 1 < current - target) {
            special ^= 1;
        }

        int groups = cnt.size();

        ArrayList<Edge> edges = new ArrayList<>(n - 1);

        int[] start = new int[groups];

        int vertex = 2;

        /*
         * Build all groups.
         */
        for (int g = 0; g < groups; g++) {

            start[g] = vertex;

            int size = cnt.get(g);

            if (g != special) {

                // Normal chain
                int previous = 1;

                for (int j = 0; j < size; j++) {

                    edges.add(
                            new Edge(previous, vertex)
                    );

                    previous = vertex;
                    vertex++;
                }

            } else {

                /*
                 * Special chain.
                 *
                 * Its final vertex is attached
                 * at a different depth.
                 */
                int previous = 1;

                int chainStart = vertex;

                for (int j = 0; j < size - 1; j++) {

                    edges.add(
                            new Edge(previous, vertex)
                    );

                    previous = vertex;
                    vertex++;
                }

                long reduction = current - target;

                int newHeight =
                        size - (int) reduction;

                if (newHeight <= 1) {

                    edges.add(
                            new Edge(1, vertex)
                    );

                } else {

                    edges.add(
                            new Edge(
                                    chainStart + newHeight - 2,
                                    vertex
                            )
                    );
                }

                vertex++;
            }
        }

        /*
         * Assign labels.
         *
         * We need consecutive labels to be
         * in different centroid subtrees.
         */
        PriorityQueue<Group> pq = new PriorityQueue<>(
                (a, b) -> {
                    if (a.size != b.size) {
                        return Integer.compare(b.size, a.size);
                    }

                    return Integer.compare(a.id, b.id);
                }
        );

        for (int g = 0; g < groups; g++) {
            if (cnt.get(g) > 0) {
                pq.add(new Group(cnt.get(g), g));
            }
        }

        int[] nextVertex = start.clone();

        /*
         * label[old vertex] = final label
         */
        int[] label = new int[n + 1];

        label[1] = 1;

        int previousGroup = -1;

        for (int number = 2; number <= n; number++) {

            Group firstGroup = pq.poll();

            /*
             * There should always be another group
             * if the largest one is the previous group.
             */
            if (firstGroup.id == previousGroup) {

                Group secondGroup = pq.poll();

                label[nextVertex[secondGroup.id]] = number;

                nextVertex[secondGroup.id]++;

                secondGroup.size--;

                if (firstGroup.size > 0) {
                    pq.add(firstGroup);
                }

                if (secondGroup.size > 0) {
                    pq.add(secondGroup);
                }

                previousGroup = secondGroup.id;

            } else {

                label[nextVertex[firstGroup.id]] = number;

                nextVertex[firstGroup.id]++;

                firstGroup.size--;

                if (firstGroup.size > 0) {
                    pq.add(firstGroup);
                }

                previousGroup = firstGroup.id;
            }
        }

        /*
         * Convert internal vertices into final labels.
         */
        for (Edge e : edges) {

            out.append(label[e.u])
                    .append(' ')
                    .append(label[e.v])
                    .append('\n');
        }
    }

    public static void main(String[] args) throws Exception {

        FastScanner fs = new FastScanner();

        StringBuilder out = new StringBuilder();

        int t = fs.nextInt();

        while (t-- > 0) {
            solve(fs, out);
        }

        System.out.print(out);
    }
}