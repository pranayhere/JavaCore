package com.pranay.interview.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * 465. Optimal Account Balancing
 * https://leetcode.com/problems/optimal-account-balancing/
 */
public class OptimalAccountBalancing {
    public static void main(String[] args) {
//        int[][] txns = {{0, 1, 10}, {1, 0, 1}, {1, 2, 5}, {2, 0, 5}};

        int[][] txns = {{0, 1, 10}, {2, 0, 5}};
        OptimalAccountBalancing oab = new OptimalAccountBalancing();
        int minTxn = oab.minTransfer(txns);
        System.out.println("Minimum txn to sattle debt : " + minTxn);
    }

    public int minTransfer(int[][] txns) {
        Map<Integer, Integer> hm = new HashMap<>();
        for (int[] t : txns) {
            hm.put(t[0], hm.getOrDefault(t[0], 0) - t[2]);
            hm.put(t[1], hm.getOrDefault(t[1], 0) + t[2]);
        }

        return settle(0, new ArrayList<>(hm.values()));
    }

    private int settle(int start, ArrayList<Integer> debt) {
        while (start < debt.size() && debt.get(start) == 0)
            start++;

        if (start == debt.size()) return 0;

        int txn = Integer.MAX_VALUE;
        for (int i = start + 1; i < debt.size(); i++) {
            if (debt.get(i) * debt.get(start) < 0) {
                debt.set(i, debt.get(i) + debt.get(start));
                txn = Math.min(txn, 1 + settle(start + 1, debt));
                debt.set(i, debt.get(i) - debt.get(start));
            }
        }
        return txn;
    }
}
