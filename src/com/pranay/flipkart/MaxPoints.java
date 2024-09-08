package com.pranay.flipkart;

public class MaxPoints {
    public static void main(String str[]) {
        int[] points;
        points = new int[]{10, 10, 10, 10, 10, 10, 10, 10, 10, 10};
        assertEqual(calculateMaxScore(points, 5, 1), 50);
        points = new int[]{10, 100, 10, 10, 10, 100, 10, 10, 10, 100};
        assertEqual(calculateMaxScore(points, 3, 1), 300);
        points = new int[]{10, 100, 500, 10, 10, 100, 500, 10, 10, 100};
        assertEqual(calculateMaxScore(points, 3, 1), 1100);
        points = new int[]{10, 5, 11, 8, 7, 5, 2, 9, 13, 1, 12, 8, 4, 8, 9, 4, 12, 11, 8, 7, 5, 12, 8,
                5, 9, 4, 7, 3, 11, 10, 5, 3, 7, 10, 9, 8, 4, 7, 10, 9, 12, 4, 6, 3, 8, 6, 9, 6, 2, 9};
        assertEqual(calculateMaxScore(points, 10, 2), 108);
    }

    public static void assertEqual(Object o1, Object o2) {
        if (o1.equals(o2))
            System.out.println("Pass");
        else
            System.out.println("Fail");
    }

    //Please complete below
    public static int calculateMaxScore(int[] points, int bullets, int reloadingGap) {
        int[][] memo = new int[points.length][bullets + 1];
        int score = dfs(points, bullets, reloadingGap, 0, memo);
        System.out.println("Ans: " + score);
        return score;
    }

    public static int dfs(int[] points, int bullets, int reloadingGap, int idx, int[][] memo) {
        if (idx >= points.length)
            return 0;

        if (bullets == 0)
            return 0;

        if (memo[idx][bullets] > 0)
            return memo[idx][bullets];

        int score = 0;
        score = Math.max(score, Math.max(points[idx] + dfs(points, bullets - 1, reloadingGap, idx + reloadingGap + 1, memo), dfs(points, bullets, reloadingGap, idx + 1, memo)));

        return memo[idx][bullets] = score;
    }
}
