package com.pranay.interview.graph;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

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

        Set<String> seen = new HashSet<>();
        int depth = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int n = 0; n < size; n++) {
                String node = q.poll();

                if (node.equals(target)) {
                    return depth;
                }

                for (int i = 0; i < 4; i++) {
                    for (int d = -1; d <= 1; d += 2) {
                        int y = ((node.charAt(i) - '0') + d + 10) % 10;
                        String neighbour = node.substring(0, i) + ("" + y) + node.substring(i + 1);
                        System.out.println("Neighbour : " + neighbour);

                        if (!seen.contains(neighbour) && !deadends.contains(neighbour)) {
                            q.add(neighbour);
                        }
                        seen.add(neighbour);
                    }
                }
            }
            depth++;
        }
        return -1;
    }
}
