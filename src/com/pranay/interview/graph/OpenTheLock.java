package com.pranay.interview.graph;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

/**
 * 752. Open the Lock
 * https://leetcode.com/problems/open-the-lock/
 */
public class OpenTheLock {
    public static void main(String[] args) {
        String[] deadends = {"0201", "0101", "0102", "1212", "2002"};
        String target = "0202";

//        String[] deadends = {"8888"};[]\poui[[]=
//        String target = "0009";

        int steps = openLock(deadends, target);
        System.out.println("Steps : " + steps);
    }

    private static int openLock(String[] dead, String target) {
        Set<String> deadends = new HashSet<>(Arrays.asList(dead));

        if (deadends.contains("0000"))
            return -1;

        Queue<String> q = new ArrayDeque<>();
        q.offer("0000");

        int steps = 0;
        Set<String> visited = new HashSet<>();

        while (!q.isEmpty()) {
            int size = q.size();

            for (int n = 0; n < size; n++) {
                String cur = q.poll();

                if (cur.equals(target)) {
                    return steps;
                }

                for (int i = 0; i < 4; i++) {
                    for (int d = -1; d <= 1; d = d + 2) {
                        int num = ((cur.charAt(i) - '0') + d + 10) % 10;
                        String next = cur.substring(0, i) + ("" + num) + cur.substring(i + 1);

                        if (!deadends.contains(next) && !visited.contains(next))
                            q.offer(next);

                        visited.add(next);
                    }
                }
            }
            steps++;
        }
        return -1;
    }
}
