package com.pranay.cses.SortingAndSearching;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class Playlist {
    public static void main(String[] args) throws IOException {
        FastScanner fs = new FastScanner(System.in);
        int n = fs.nextInt();

        int[] nums = new int[n];
        Map<Integer, Integer> hm = new HashMap<>();
        int lo = 0;
        int ans = 0;

        for (int hi = 0; hi < n; hi++) {
            int num = fs.nextInt();
            nums[hi] = num;

            hm.put(num, hm.getOrDefault(num, 0) + 1);
            while (hm.get(num) > 1 && lo <= hi) {
                int rm = nums[lo++];
                int cnt = hm.get(rm);
                if (cnt == 1) {
                    hm.remove(rm);
                } else {
                    hm.put(rm, cnt - 1);
                }
            }

            ans = Math.max(ans, hi - lo + 1);
        }

        System.out.println(ans);
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
