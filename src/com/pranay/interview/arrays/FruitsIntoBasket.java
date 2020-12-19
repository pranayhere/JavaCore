package com.pranay.interview.arrays;

import java.util.HashMap;
import java.util.Map;

public class FruitsIntoBasket {
    public static void main(String[] args) {
        int[] tree = {1,2,3,2,2};
        int totalFruits = totalFruit(tree);
        System.out.println("Ans : " + totalFruits);
    }

    private static int totalFruit(int[] tree) {
        Map<Integer, Integer> hm = new HashMap<>();
        int lo = 0;
        int count = 0;

        for (int hi = 0; hi < tree.length; hi++) {
            hm.put(tree[hi], hm.getOrDefault(tree[hi], 0) + 1);

            if (hm.size() == 2) {
                count = Math.max(hi - lo + 1, count);
            }

            while (hm.size() > 2) {
                int fruit = tree[lo++];
                int cnt = hm.get(fruit);

                if (cnt == 1) {
                    hm.remove(fruit);
                } else {
                    hm.put(fruit, cnt - 1);
                }
            }
        }
        return count;
    }
}
