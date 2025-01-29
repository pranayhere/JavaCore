package com.pranay.interview.arrays;

import java.util.*;

public class SmallestRange {
    public static void main(String[] args) {
        List<List<Integer>> nums = new ArrayList<>();
        nums.add(Arrays.asList(4,10,15,24,26));
        nums.add(Arrays.asList(0,9,12,20));
        nums.add(Arrays.asList(5,18,22,30));

        SmallestRange sr = new SmallestRange();
        int[] range = sr.smallestRange(nums);
        System.out.println("res: " + Arrays.toString(range));
    }

    public int[] smallestRange(List<List<Integer>> nums) {
        int k = nums.size();
        List<int[]> N = new ArrayList<>();
        for (int i = 0; i < nums.size(); i++) {
            List<Integer> curr = nums.get(i);

            for (Integer n: curr) {
                N.add(new int[]{i, n});
            }
        }

        Collections.sort(N, (a, b) -> a[1] - b[1]);
        for (int[] num: N) {
            System.out.println(Arrays.toString(num));
        }

        int lo = 0;
        int hi = 0;
        Map<Integer, Integer> hm = new HashMap<>();
        int[] res = new int[2];
        int minSize = Integer.MAX_VALUE;

        while (lo <= hi && hi < N.size()) {
            int arr = N.get(hi)[0];
            hm.put(arr, hm.getOrDefault(arr, 0) + 1);

            while (hm.size() == k) {
                int rm = N.get(lo)[0];
                int cnt = hm.get(rm);
                if (cnt == 1)
                    hm.remove(rm);
                else
                    hm.put(rm, cnt - 1);

                int start = N.get(lo)[1];
                int end = N.get(hi)[1];
                if (end - start < minSize) {
                    minSize = end - start;
                    res[0] = start;
                    res[1] = end;
                }

                lo++;
            }

            hi++;
        }

        return res;
    }
}
