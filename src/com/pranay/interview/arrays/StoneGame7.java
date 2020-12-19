package com.pranay.interview.arrays;

import java.util.ArrayList;
import java.util.List;

public class StoneGame7 {
    public static void main(String[] args) {
        int[] stones = {5,3,1,4,2};
        StoneGame7 sg7 = new StoneGame7();
        int scoreDiff = sg7.stoneGameVII(stones);
        System.out.println(scoreDiff);
    }

    int diff = 0;

    private int stoneGameVII(int[] stones) {
        int sum = 0;
        List<Integer> s = new ArrayList<>();

        for (int n: stones) {
            sum += n;
            s.add(n);
        }

        play(s, sum, 0, 0, true);
        return diff;
    }

    private void play(List<Integer> stones, int sum, int alice, int bob, boolean aliceTurn) {
        if (sum == 0) {
            diff = Math.max(alice - bob, diff);
            return;
        }

        if (aliceTurn) {
            if (stones.get(0) <= stones.get(stones.size() - 1)) {
                sum = sum - stones.get(0);
                alice += sum;
                stones.remove(0);
            } else {
                sum = sum - stones.get(stones.size() - 1);
                alice += sum;
                stones.remove(stones.size() - 1);
            }

            play(stones, sum, alice, bob, false);
        } else {
            if (sum - stones.get(0) >= sum - stones.get(stones.size() - 1)) {
                sum -= stones.get(0);
                bob += sum;
                stones.remove(0);
            } else {
                sum -= stones.get(stones.size() - 1);
                bob += sum;
                stones.remove(stones.size() - 1);
            }

            play(stones, sum, alice, bob, true);
        }
    }
}
