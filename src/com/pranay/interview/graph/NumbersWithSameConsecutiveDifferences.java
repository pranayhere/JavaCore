package com.pranay.interview.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NumbersWithSameConsecutiveDifferences {
    public static void main(String[] args) {
        int N = 3, K = 7;
        NumbersWithSameConsecutiveDifferences nsc = new NumbersWithSameConsecutiveDifferences();
        int[] ans = nsc.numsSameConsecDiff(N, K);
        System.out.println(ans);
    }

    List<Integer> res = new ArrayList<>();
    private int[] numsSameConsecDiff(int N, int k) {
        for (int num = 0; num < 10; num++)
            dfs(N - 1, k, num);
        return res.stream().mapToInt(i -> i).toArray(); // list to array
    }

    private void dfs(int N, int k, int num) {
        if (N == 0) {
            res.add(num);
            return;
        }

        List<Integer> nextDigits = new ArrayList<>();
        int tailDigit = num % 10;
        nextDigits.add(tailDigit + k);

        if (k != 0)
            nextDigits.add(tailDigit - k);

        for (Integer nextDigit: nextDigits) {
            if (0 <= nextDigit && nextDigit < 10) {
                int newNum = num * 10 + nextDigit;
                dfs(N - 1, k, newNum);
            }
        }
    }
}
