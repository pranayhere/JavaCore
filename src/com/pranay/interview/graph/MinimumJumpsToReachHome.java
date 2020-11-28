package com.pranay.interview.graph;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

/**
 * 1654. Minimum Jumps to Reach Home
 * https://leetcode.com/problems/minimum-jumps-to-reach-home/
 */
public class MinimumJumpsToReachHome {
    public static void main(String[] args) {
        int forbidden[] = {14,4,18,1,15}, a = 3, b = 15, x = 9;

        int minJumps = minimumJumps(forbidden, a, b, x);
        System.out.println("Min Jumps : " + minJumps);
    }

    private static int minimumJumps(int[] forbidden, int a, int b, int x) {
        Set<Integer> hs = new HashSet<>();
        for (int n: forbidden)
            hs.add(n);

        Queue<int[]> q = new ArrayDeque<>(); // int[] {idxToJump, isBackward}
        q.offer(new int[]{0, 0}); // {currIdx, isBackward = 0} initially

        while (!q.isEmpty()) {
            
        }
        return 0;
    }
}
