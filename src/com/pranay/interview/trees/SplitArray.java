package com.pranay.interview.trees;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class SplitArray {
    public static void main(String[] args) {
        int[] nums = {1,2,3,3,4,4,5,5};
        SplitArray sa = new SplitArray();

        boolean res =  sa.isPossible(nums);
        System.out.println("Res : " + res);
    }

    public boolean isPossible(int[] nums) {
        TreeMap<Integer, Integer> tm = new TreeMap<>();
        for (int n: nums)
            tm.put(n, tm.getOrDefault(n, 0) + 1);

        while (!tm.isEmpty()) {
            List<Integer> curr = new ArrayList<>();

            int next = tm.firstKey();

            while (tm.containsKey(next)) {
                curr.add(next);

                int cnt = tm.get(next);
                if (cnt == 1)
                    tm.remove(next);
                else
                    tm.put(next, cnt - 1);

                next += 1;
            }

            System.out.println(curr);

            if (curr.size() < 3)
                return false;
        }

        return true;
    }
}
