package com.pranay.interview.graph;

import java.util.ArrayDeque;
import java.util.Queue;

public class ReachNumber {
    public static void main(String[] args) {
        int target = 2;
        int steps = reachNumber(target);
        System.out.println("Steps : " + steps);
    }

    private static int reachNumber(int target) {
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(0);
        int steps = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            steps++;

            for (int i = 0; i < size; i++) {
                int curr = q.poll();

                if (curr == target) {
                    return steps - 1;
                }

                q.offer(curr + steps);
                q.offer(curr - steps);
            }
        }
        return -1;
    }
}
