package com.pranay.interview.hashing;

import java.util.Arrays;
import java.util.TreeMap;

public class HandOfStraights {
    public static void main(String[] args) {
        int[] hand = {1,2,3,6,2,3,4,7,8};
        int W = 3;
        boolean ans = isNStraightHand(hand, W);
        System.out.println("Ans : " + ans);
    }

    public static boolean isNStraightHand(int[] hand, int W) {
        TreeMap<Integer, Integer> count = new TreeMap<>();
        for (int card: hand)
            count.put(card, count.getOrDefault(card, 0) + 1);

        while (count.size() > 0) {
            int first = count.firstKey();
            for (int card = first; card < first + W; card++) {
                if (!count.containsKey(card)) {
                    return false;
                }

                int c = count.get(card);
                if (c == 1)
                    count.remove(card);
                else
                    count.put(card, c - 1);
            }
        }
        return true;
    }
}
