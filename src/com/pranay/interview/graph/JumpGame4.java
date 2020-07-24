package com.pranay.interview.graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * 1345. Jump Game IV
 * https://leetcode.com/problems/jump-game-iv/
 *
 * In one step you can jump from index i to index
 * i + 1 where: i + 1 < arr.length.
 * i - 1 where: i - 1 >= 0.
 * j where: arr[i] == arr[j] and i != j.
 * Return the minimum number of steps to reach the last index of the array.
 * 
 * Explanation: 
 * Explore all possibilities, ie. i + 1, i - 1 and index of similar number
 */
public class JumpGame4 {
    public static void main(String[] args) {
        int[] arr = {100,-23,-23,404,100,23,23,23,3,404};
        int jumps = minJumps(arr);
        System.out.println("Jumps : " + jumps);
    }

    private static int minJumps(int[] arr) {
        int N = arr.length;
        Map<Integer, List<Integer>> hm  = new HashMap<>();
        for (int i = 0; i < N; i++)
            hm.computeIfAbsent(arr[i], k -> new ArrayList<>()).add(i);

        System.out.println(hm);
        Queue<Integer> q = new ArrayDeque<>();
        q.add(0);

        boolean[] visited = new boolean[N];
        visited[0] = true;

        int steps = 0;
        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                int idx = q.poll();

                if (idx == N - 1)
                    return steps;

                List<Integer> next = hm.get(arr[idx]);
                next.add(idx - 1);
                next.add(idx + 1);

                for (int j : next) {
                    if (j < 0 || j >= N || visited[j])
                        continue;
                    q.offer(j);
                    visited[j] = true;
                }

                next.clear();
            }
            steps++;
        }
        return 0;
    }
}
