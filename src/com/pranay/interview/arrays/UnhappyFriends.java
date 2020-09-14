package com.pranay.interview.arrays;

import java.util.HashSet;
import java.util.Set;

/**
 * 1583. Count Unhappy Friends
 * https://leetcode.com/problems/count-unhappy-friends/
 */
public class UnhappyFriends {
    public static void main(String[] args) {
        int n = 4;
        int[][] preferences = {{1, 2, 3}, {3, 2, 0}, {3, 1, 0}, {1, 2, 0}};
        int[][] pairs = {{0, 1}, {2, 3}};

        int count = unhappyFriends(n, preferences, pairs);
        System.out.println("Count : " + count);
    }

    private static int unhappyFriends(int n, int[][] ps, int[][] pairs) {
        int res = 0;
        int[] pair = new int[n];
        Set<Integer> set = new HashSet<>();

        for (int[] p : pairs) {
            pair[p[0]] = p[1];
            pair[p[1]] = p[0];
        }

        for (int[] p : pairs) {
            for (int x : p) {
                for (int u : ps[x]) {
                    if (u == pair[x]) break; // count before y;
                    for (int x0 : ps[u]) {
                        if (x0 == pair[u]) break; // count before v;
                        if (x0 == x) {   // find x;
                            set.add(x);
                        }
                    }
                }
            }
        }
        return set.size();
    }
}
