package com.pranay.interview.dp;

public class NumberOfWaysToEarnPoints {
    public static void main(String[] args) {
        int target = 6;
        int[][] types = {{6,1},{3,2},{2,3}};

        NumberOfWaysToEarnPoints nep = new NumberOfWaysToEarnPoints();
        int ans = nep.waysToReachTarget(target, types);
        System.out.println("Ans : " + ans);
    }

    public int waysToReachTarget(int target, int[][] types) {
        int n = types.length;
        return dfs(target, types, 0, 0);
    }

    private int dfs(int target, int[][] types, int idx, int currSum) {
        if (currSum == target)
            return 1;

        if (currSum > target)
            return 0;

        if (idx == types.length)
            return 0;

        int count = 0;
        for (int i = 1; i <= types[idx][0]; i++) {
            count += dfs(target, types, idx + 1, currSum + types[idx][1] * i);
        }

        count += dfs(target, types, idx + 1, currSum);

        return count % (int)(1e9 + 7);
    }
}
