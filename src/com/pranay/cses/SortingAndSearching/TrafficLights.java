package com.pranay.cses.SortingAndSearching;

import java.io.IOException;
import java.io.InputStream;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * There is a street of length x whose positions are numbered 0,1,\ldots,x. Initially there are no traffic lights, but n sets of traffic lights are added to the street one after another.
 * Your task is to calculate the length of the longest passage without traffic lights after each addition.
 * Input
 * The first input line contains two integers x and n: the length of the street and the number of sets of traffic lights.
 * Then, the next line contains n integers p_1,p_2,\ldots,p_n: the position of each set of traffic lights. Each position is distinct.
 * Output
 * Print the length of the longest passage without traffic lights after each addition.
 * Constraints
 *
 * 1 \le x \le 10^9
 * 1 \le n \le 2 \cdot 10^5
 * 0 < p_i < x
 *
 * Example
 * Input:
 * 8 3
 * 3 6 2
 *
 * Output:
 * 5 3 3
 */

/**
 * Problem: Traffic Lights (CSES)
 *
 * We are given a street of length x (0 to x).
 * Initially there are no traffic lights.
 *
 * We insert n traffic lights one by one.
 * After each insertion, we must output the length of the longest segment
 * (without any traffic light inside it).
 *
 * ------------------------------------------------------------
 *
 * KEY IDEA:
 *
 * The street is always divided into segments between consecutive lights.
 *
 * Each new traffic light splits exactly one existing segment into two.
 *
 * We must maintain:
 * 1. All light positions in sorted order
 * 2. All segment lengths dynamically to get the maximum quickly
 *
 * ------------------------------------------------------------
 *
 * DATA STRUCTURES USED:
 *
 * 1. TreeSet<Integer> lights
 *    - Stores all traffic light positions in sorted order
 *    - Initially: {0, x}
 *    - Allows:
 *        lower(p)  -> previous light before p
 *        higher(p) -> next light after p
 *
 * 2. TreeMap<Integer, Integer> segments
 *    - Acts like a multiset of segment lengths
 *    - key   = segment length
 *    - value = frequency of that length
 *    - Supports:
 *        insert/remove in O(log n)
 *        get maximum segment using lastKey()
 *
 * ------------------------------------------------------------
 *
 * INITIAL STATE:
 *
 * lights = {0, x}
 * segments = { x : 1 }   // whole street is one segment
 *
 * ------------------------------------------------------------
 *
 * FOR EACH INSERTION p:
 *
 * 1. Find neighbors of p:
 *        left  = lights.lower(p)
 *        right = lights.higher(p)
 *
 *    So p lies inside segment:
 *        (left, right)
 *
 * 2. Remove old segment:
 *        oldLen = right - left
 *        decrease frequency of oldLen in segments
 *        if frequency becomes 0, remove it
 *
 * 3. Add new segments:
 *        len1 = p - left
 *        len2 = right - p
 *
 *        insert len1 into segments
 *        insert len2 into segments
 *
 * 4. Insert new light:
 *        lights.add(p)
 *
 * 5. Answer:
 *        maximum segment length = segments.lastKey()
 *
 * ------------------------------------------------------------
 *
 * TIME COMPLEXITY:
 *
 * Each insertion:
 *     O(log n)
 *
 * Total:
 *     O(n log n)
 * */
public class TrafficLights {
    public static void main(String[] args) throws IOException {
        FastScanner fs = new FastScanner(System.in);
        int x = fs.nextInt();
        int n = fs.nextInt();

        TreeSet<Integer> lights = new TreeSet<>();
        TreeMap<Integer, Integer> seg = new TreeMap<>();

        lights.add(0);
        lights.add(x);

        seg.put(x, 1);

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            int p = fs.nextInt();

            Integer left = lights.floor(p);
            Integer right = lights.ceiling(p);

            int oldLen = right - left;

            seg.put(oldLen, seg.get(oldLen) - 1);
            if (seg.get(oldLen) == 0) {
                seg.remove(oldLen);
            }

            int len1 = p - left;
            int len2 = right - p;

            seg.put(len1, seg.getOrDefault(len1, 0) + 1);
            seg.put(len2, seg.getOrDefault(len2, 0) + 1);

            lights.add(p);

            sb.append(seg.lastKey()).append(" ");
        }

        System.out.println(sb.toString().trim());
    }

    static class FastScanner {
        private final InputStream in;
        private final byte[] buffer = new byte[1 << 16];

        private int ptr = 0, len = 0;

        FastScanner(InputStream is) {
            in = is;
        }

        private int read() throws IOException {
            if (ptr >= len) {
                len = in.read(buffer);
                ptr = 0;

                if (len <= 0) return -1;
            }

            return buffer[ptr++];
        }

        int nextInt() throws IOException {
            return (int) nextLong();
        }

        long nextLong() throws IOException {
            int c;

            while ((c = read()) <= ' ') {
                if (c == -1) return -1;
            }

            int sign = 1;

            if (c == '-') {
                sign = -1;
                c = read();
            }

            long val = 0;

            while (c > ' ') {
                val = val * 10 + (c - '0');
                c = read();
            }

            return val * sign;
        }
    }
}
