package com.pranay.interview.graph;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 679. 24 Game
 * https://leetcode.com/problems/24-game/discuss/179363/Thinking-Process-Backtracking
 *
 * Explanation:
 * Let's say, we pick any two numbers, a and b, and apply any operator +, -, *, /, assuming that the expression is surrounded
 * with parenthesis, e.g. (a + b). Then, the result of (a + b) instead of a and b would participate in the following calculations.
 * Take nums = [4, 3, 2, 1] for example, assuming that we pick 4, 3 and apply +, nums would become [7, 2, 1].
 *
 * We keep enumerating until there is only one element left in nums, and return true only if the last element equals to 24.
 *
 * DIFF_TOLERANT is established because division between Double data type may cause loss of precision.
 */

public class The24Game {
    public static void main(String[] args) {
        int[] nums = {4, 3, 2, 1};
        // int[] nums = {3, 3, 8, 8};

        The24Game g = new The24Game();
        boolean ans = g.judgePoint24(nums);
        System.out.println("Ans : " + ans);
    }

    public boolean judgePoint24(int[] nums) {
        List<Double> list = new ArrayList<>();
        for (int i: nums) {
            list.add((double) i);
        }

        return dfs(list);
    }

    public boolean dfs(List<Double> nums) {
        double DIFF_TOLERANCE = 0.1;

        if (nums.size() == 1)
            return Math.abs(nums.get(0) - 24) <= DIFF_TOLERANCE;

        for (int i = 1; i < nums.size(); i++) {
            for (int j = 0; j < i; j++) {
                double a = nums.get(i);
                double b = nums.get(j);

                List<Double> eval = List.of(a + b, a - b, b - a, a * b, a / b, b / a);
                List<Double> copy = new ArrayList<>(nums);

                copy.remove(i);
                copy.remove(j);

                for (double val: eval) {
                    copy.add(val);

                    if (dfs(copy))
                        return true;

                    copy.remove(copy.size() - 1);
                }
            }
        }
        
        return false;
    }
}
