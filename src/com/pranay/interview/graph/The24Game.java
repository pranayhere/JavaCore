package com.pranay.interview.graph;

import java.util.ArrayList;
import java.util.List;

public class The24Game {
    public static void main(String[] args) {
        int[] nums = {4, 1, 8, 7};
        boolean ans = judgePoint24(nums);
        System.out.println("Ans : " + ans);
    }

    private static boolean judgePoint24(int[] nums) {
        List<Double> list = new ArrayList<>();
        for (int i : nums) {
            list.add((double) i);
        }
        return dfs(list);
    }

    private static boolean dfs(List<Double> list) {
        if (list.size() == 1) {
            if (Math.abs(list.get(0) - 24.0) < 0.001) {
                return true;
            }
            return false;
        }

        for (int i = 0; i< list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                for (double c : generatePossibleResults(list.get(i), list.get(j))) {
                    List<Double> nextRound = new ArrayList<>();
                    nextRound.add(c);
                    for (int k = 0; k < list.size(); k++) {
                        if (k == j || k == i)
                            continue;
                        nextRound.add(list.get(k));
                    }
                    if (dfs(nextRound))
                        return true;
                }
            }
        }

        return false;
    }

    private static List<Double> generatePossibleResults(Double a, Double b) {
        List<Double> res = new ArrayList<>();
        res.add(a + b);
        res.add(a - b);
        res.add(b - a);
        res.add(a * b);
        res.add(a / b);
        res.add(b / a);
        return res;
    }
}
