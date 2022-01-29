package com.pranay.interview.dp;

public class SolvingQuestionWithBrainPower {
    public static void main(String[] args) {
        int[][] questions = {{3,2},{4,3},{4,4},{2,5}};
        SolvingQuestionWithBrainPower sqb = new SolvingQuestionWithBrainPower();
        long ans = sqb.maxPoints(questions);
        System.out.println("Ans : " + ans);
    }

    public long maxPoints(int[][] questions) {
        long[] memo = new long[questions.length];
        return dfs(questions, 0, memo);
    }

    private long dfs(int[][] questions, int idx, long[] memo) {
        if (idx >= questions.length)
            return 0;

        if (memo[idx] > 0)
            return memo[idx];

        long res = Math.max(dfs(questions, idx + 1, memo), dfs(questions, idx + 1 + questions[idx][1], memo) + questions[idx][0]);
        return memo[idx] = res;
    }
}
