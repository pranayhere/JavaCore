package com.pranay.interview.graph;

public class CanPartitionToKSubsetSum {
    public static void main(String[] args) {
        int[] nums = {4, 3, 2, 3, 5, 2, 1};
        int k = 4;

        CanPartitionToKSubsetSum cpk = new CanPartitionToKSubsetSum();
        boolean ans = cpk.canPartition(nums, k);
        System.out.println("Ans : " + ans);
    }

    private boolean canPartition(int[] A, int k) {
        if (k > A.length)
            return false;

        int sum = 0;
        for (int n : A)
            sum += n;

        if (sum % k != 0)
            return false;

        boolean[] seen = new boolean[A.length];
        dfs(A, 0, A.length - 1, seen, sum / k, k);
        return false;
    }

    public boolean dfs(int[] A, int sum, int st, boolean[] seen, int target, int round) {
        if (round == 0)
            return true;

        if (sum == target && dfs(A, 0, A.length - 1, seen, target, round - 1)) {
            return true;
        }

        for (int i = st; i >= 0; i--) {
            if (!seen[i] && sum + A[i] <= target) {
                seen[i] = true;
                if (dfs(A, sum + A[i], i - 1, seen, target, round))
                    return true;
                seen[i] = false;
            }
        }

        return false;
    }
}
