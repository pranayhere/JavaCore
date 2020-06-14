package com.pranay.interview.graph;

import java.util.ArrayDeque;
import java.util.Queue;

public class FriendCirclesBFS {
    public static void main(String[] args) {
        int[][] M = {
                {1, 1, 0},
                {1, 1, 0},
                {0, 0, 1}
        };

        int count = findCircleNumBfs(M);
        System.out.println("Total friend circles : " + count);
    }

    private static int findCircleNumBfs(int[][] M) {
        int[] visited = new int[M.length];
        int count = 0;
        Queue<Integer> q = new ArrayDeque<>();

        for (int i=0; i < M.length; i++) {
            if (visited[i] == 0) {
                q.offer(i);
                while (!q.isEmpty()) {
                    int s = q.remove();
                    visited[s] = 1;
                    for (int j = 0; j<M.length; j++) {
                        if (M[s][j] == 1 && visited[j] == 0)
                            q.add(j);
                    }
                }
                count++;
            }
        }
        return count;
    }
}
