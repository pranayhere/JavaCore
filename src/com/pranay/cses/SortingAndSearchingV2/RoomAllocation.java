//package com.pranay.cses.SortingAndSearchingV2;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * https://cses.fi/problemset/task/1164
 *
 * Room Allocation
 *
 * There is a large hotel, and n customers will arrive soon. Each customer
 * wants to have a single room.
 *
 * You know each customer's arrival and departure day. Two customers can stay
 * in the same room if the departure day of the first customer is earlier than
 * the arrival day of the second customer.
 *
 * What is the minimum number of rooms that are needed to accommodate all
 * customers? And how can the rooms be allocated?
 *
 * Input
 * The first input line contains an integer n: the number of customers.
 * Then there are n lines, each of which describes one customer. Each line has
 * two integers a and b: the arrival and departure day.
 *
 * Output
 * Print first an integer k: the minimum number of rooms required.
 * After that, print a line that contains the room number of each customer in
 * the same order as in the input. The rooms are numbered 1, 2, ..., k. You can
 * print any valid solution.
 *
 * Constraints
 * - 1 <= n <= 2 * 10^5
 * - 1 <= a <= b <= 10^9
 *
 * Example
 * Input:
 * 3
 * 1 2
 * 2 4
 * 4 4
 *
 * Output:
 * 2
 * 1 2 1
 */


public class RoomAllocation {
    public static void main(String[] args) throws IOException {
        FastScanner fs = new FastScanner(System.in);
        int n = fs.nextInt();

        int[][] customers = new int[n][3];
        for (int i = 0; i < n; i++) {
            customers[i][0] = fs.nextInt();
            customers[i][1] = fs.nextInt();
            customers[i][2] = i;
        }

        Arrays.sort(customers, (a, b) -> a[0] - b[0]); // sort by arrival time.

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]); // [end, roomId]
        Queue<Integer> available = new ArrayDeque<>();

        int[] ans = new int[n];
        int roomId = 0;

        for (int i = 0; i < n; i++) {
            int start = customers[i][0];
            int end = customers[i][1];
            int idx = customers[i][2];

            while (!pq.isEmpty() && pq.peek()[0] < start) {
                available.add(pq.poll()[1]);
            }

            if (available.isEmpty()) {
                roomId++;
                pq.offer(new int[]{end, roomId});
                ans[idx] = roomId;
            } else {
                int freeRoom = available.poll();
                pq.offer(new int[]{end, freeRoom});
                ans[idx] = freeRoom;
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
