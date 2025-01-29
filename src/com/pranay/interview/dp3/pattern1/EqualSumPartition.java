package com.pranay.interview.dp3.pattern1;

public class EqualSumPartition {
    public static void main(String[] args) {
        int[] nums = {1, 4, 5};
        boolean ans = equalSumPartition(nums);
        System.out.println("Ans : " + ans);
    }

    private static boolean equalSumPartition(int[] nums) {
        int sum = 0;
        for (int n: nums)
            sum += n;

        if (sum % 2 != 0)
            return false;

        boolean ansRec = espRec(nums, sum / 2, nums.length);
        System.out.println("Ans rec : " + ansRec);

        boolean ansMemo = espMemo(nums, sum / 2, nums.length);
        System.out.println("Ans memo : " + ansMemo);

        boolean ansTD = espTab(nums, sum / 2, nums.length);
        System.out.println("Ans TD : " + ansTD);

        return ansMemo;
    }

    public static boolean espRec(int[] nums, int sum, int n) {
        if (sum == 0)
            return true;

        if (n == 0)
            return false;

        if (nums[n - 1] <= sum) {
            return espRec(nums, sum - nums[n - 1], n - 1) || espRec(nums, sum, n - 1);
        } else {
            return espRec(nums, sum, n - 1);
        }
    }

    // --------------------- memo --------------------------
    static boolean[][] dp = new boolean[4][9];
    public static boolean espMemo(int[] nums, int sum, int n) {
        if (sum == 0)
            return true;

        if (n == 0)
            return false;

        if (dp[n][sum])
            return dp[n][sum];

        if (nums[n - 1] <= sum)
            return dp[n][sum] = espMemo(nums, sum - nums[n - 1], n - 1) || espMemo(nums, sum, n - 1);
        else
            return dp[n][sum] = espMemo(nums, sum, n - 1);
    }

    // ----------------------- Tabulation -----------------------
    public static boolean espTab(int[] nums, int sum, int n) {
        boolean[][] dp = new boolean[nums.length + 1][sum + 1];
        for (int i = 0; i < dp.length; i++)
            dp[i][0] = true;

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (j < nums[i - 1])
                    dp[i][j] = dp[i - 1][j];
                else
                    dp[i][j] = dp[i - 1][j - nums[i - 1]] || dp[i - 1][j];
            }
        }
        return dp[dp.length - 1][dp[0].length - 1];
    }
}
