package com.pranay.interview.searching;

public class KthMissingElement {
    public static void main(String[] args) {
        int[] A = {4, 7, 9, 10};
        int K = 3;

        KthMissingElement me = new KthMissingElement();
        int element = me.missingElement(A, K);
        System.out.println("Missing element : " + element);
    }

    public int missing(int idx, int[] nums) {
        return nums[idx] - nums[0] - idx;
    }

    private int missingElement(int[] A, int K) {
        int n = A.length;

        if (K > missing(n - 1, A))
            return A[n - 1] + K - missing(n - 1, A);

        int lo = 0;
        int hi = n - 1;

        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;

            if (missing(mid, A) < K)
                lo = mid + 1;
            else
                hi = mid;
        }

        return A[lo - 1] + K - missing(lo - 1, A);
    }
}
