//package com.pranay.cses.SortingAndSearching;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.PriorityQueue;

public class RoomAllocation {
    public static void main(String[] args) throws IOException {
        FastScanner fs = new FastScanner(System.in);
        int n = fs.nextInt();

        // arr, dept, original index
        int[][] customers = new int[n][3];
        for (int i = 0; i < n; i++) {
            customers[i][0] = fs.nextInt();
            customers[i][1] = fs.nextInt();
            customers[i][2] = i;
        }

        Arrays.sort(customers, (a, b) -> a[0] - b[0]);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]); // room_id, dept_date

        int[] ans = new int[n];
        int roomId = 0;

        for (int[] cust: customers) {
            int arr = cust[0];
            int dept = cust[1];
            int idx = cust[2];

            if (!pq.isEmpty() && pq.peek()[1] < arr) {
                // reuse the room
                int[] available = pq.poll();
                int room = available[0];
                pq.offer(new int[]{room, dept});
                ans[idx] = room;
            } else {
                roomId++;
                ans[idx] = roomId;
                pq.offer(new int[]{roomId, dept});
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(roomId).append('\n'); // total rooms needed
        for (int i = 0; i < n; i++) {
            sb.append(ans[i]).append(' ');
        }

        System.out.println(sb);
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
