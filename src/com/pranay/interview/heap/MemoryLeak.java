package com.pranay.interview.heap;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MemoryLeak {
    public static void main(String[] args) {
        int memory1 = 9;
        int memory2 = 6;

        int[] ans = memLeak(memory1, memory2);
        System.out.println(Arrays.toString(ans));
    }

    private static int[] memLeak(int memory1, int memory2) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] == a[1] ? a[0] - b[0] : b[1] - a[1]);
        pq.add(new int[]{1, memory1});
        pq.add(new int[]{2, memory2});

        int time = 1;
        while (pq.peek()[1] >= time) {
            int[] curr = pq.poll();

            if (curr[1] - time >= 0) {
                curr[1] = curr[1] - time;
                pq.add(curr);
            }

            time++;
        }

        int[] m1 = pq.poll();
        int[] m2 = pq.poll();

        int[] ans = new int[3];
        ans[0] = time;
        ans[m1[0]] = m1[1];
        ans[m2[0]] = m2[1];

        return ans;
    }


}
