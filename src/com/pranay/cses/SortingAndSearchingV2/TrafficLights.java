package com.pranay.cses.SortingAndSearchingV2;

import java.io.IOException;
import java.io.InputStream;
import java.util.TreeMap;
import java.util.TreeSet;

public class TrafficLights {
    public static void main(String[] args) throws IOException {
        FastScanner fs = new FastScanner(System.in);
        StringBuilder sb = new StringBuilder();

        int x = fs.nextInt();
        int n = fs.nextInt();

        TreeSet<Integer> lights = new TreeSet<>();
        TreeMap<Integer, Integer> segments = new TreeMap<>();
        lights.add(0);
        lights.add(x);

        segments.put(x, 1);

        while (n-- > 0) {
            int pos = fs.nextInt();
            Integer prevLight = lights.floor(pos);
            Integer nextLight = lights.ceiling(pos);

            int prevSeg = nextLight - prevLight;
            int cnt = segments.get(prevSeg);
            if (cnt == 1) {
                segments.remove(prevSeg);
            } else {
                segments.put(prevSeg, cnt - 1);
            }

            lights.add(pos);
            segments.put(pos - prevLight, segments.getOrDefault(pos - prevLight, 0) + 1);
            segments.put(nextLight - pos, segments.getOrDefault(nextLight - pos, 0) + 1);

            sb.append(segments.lastKey()).append(" ");
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
