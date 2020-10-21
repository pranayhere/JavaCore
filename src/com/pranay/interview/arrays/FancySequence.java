package com.pranay.interview.arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FancySequence {
    public static void main(String[] args) {
        FancySequence fancy = new FancySequence();
        fancy.append(2);   // fancy sequence: [2]
        fancy.addAll(3);   // fancy sequence: [2+3] -> [5]
        fancy.append(7);   // fancy sequence: [5, 7]
        fancy.multAll(2);  // fancy sequence: [5*2, 7*2] -> [10, 14]
        System.out.println(fancy.getIndex(0)); // return 10
        fancy.addAll(3);   // fancy sequence: [10+3, 14+3] -> [13, 17]
        fancy.append(10);  // fancy sequence: [13, 17, 10]
        fancy.multAll(2);  // fancy sequence: [13*2, 17*2, 10*2] -> [26, 34, 20]
        System.out.println(fancy.getIndex(0)); // return 26
        System.out.println(fancy.getIndex(1)); // return 34
        System.out.println(fancy.getIndex(2)); // return 20
    }

    List<int[]> q;
    Map<Integer, int[]> valuesAndlastUpdated = null;
    private int counter = -1;

    public FancySequence() {
        q = new ArrayList<>();
        valuesAndlastUpdated = new HashMap<>();
    }

    public int getIndex(int idx) {
        int mod = 1000000007;
        if (!valuesAndlastUpdated.containsKey(idx))
            return -1;

        long val = valuesAndlastUpdated.get(idx)[0];
        int start = valuesAndlastUpdated.get(idx)[1];

        for (int i = start; i < q.size(); i++) {
            int[] p = q.get(i);

            if (p[0] == 0) {
                val *= p[1];
            } else {
                val += p[1];
            }

            if (val > mod)
                val %= mod;
        }

        valuesAndlastUpdated.put(idx, new int[]{(int) val, q.size()});
        return (int) val;
    }

    public void multAll(int m) {
        q.add(new int[]{0, m});
    }

    public void addAll(int inc) {
        q.add(new int[]{1, inc});
    }

    public void append(int val) {
        valuesAndlastUpdated.put(++counter, new int[]{val, q.size()});
    }
}
