package com.pranay.GeeksForGeeks;

// https://leetcode.com/problems/number-of-dice-rolls-with-target-sum/
// Close to CombinationSum approach
// In this problem we don't need start index because we are going to allow duplicates i.e. [1, 2] and [2, 1] are valid

import java.util.ArrayList;
import java.util.List;

public class DiceRollsToTarget {
    public static void main(String[] args) {
        int d = 2, f = 6, target = 7;
        int rolls = numRollsToTarget(d, f, target);
        
        int rolls2 = numRollsToTargetDP(d, f, target);
        System.out.println("rolls : " + rolls);
        System.out.println("rolls2 : " + rolls2);
    }

    private static int numRollsToTargetDP(int d, int f, int target) {
        long[][] table = new long[d+1][target+1];
        int modulo = 1000000007;

        /* Table entries for only one dice */
        for(int j = 1; j <= f && j <= target; j++)
            table[1][j] = 1;

        /* Fill rest of the entries in table using recursive relation
        i: number of dice, j: sum */
        for(int i = 2; i <= d;i ++){
            for(int j = 1; j <= target; j++){
                for(int k = 1; k < j && k <= f; k++)
                    table[i][j] = (table[i][j] % modulo + table[i-1][j-k]);
            }
        }

        return (int) (table[d][target] % modulo);
    }

    private static int numRollsToTarget(int d, int f, int target) {
        if (d == 1 && target > f) {
            return 0;
        }

        List<Integer> combinations = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();

        result = getCombinations(combinations, result, d, f, target);

        System.out.println(result);
        return result.size();
    }

    private static List<List<Integer>> getCombinations(List<Integer> combinations, List<List<Integer>> result, int d, int f, int target) {
        System.out.println(combinations);
        if (target == 0) {
            result.add(new ArrayList<>(combinations));
        }

        if (target < 0) {
            return result;
        }

        if (d == 0) {
            return result;
        }

        for(int i = 1; i<=f; i++) {
            combinations.add(i);
            result = getCombinations(combinations, result, d-1, f, target - i);
            combinations.remove(combinations.size() - 1);
        }
        return result;
    }
    
    
    
}