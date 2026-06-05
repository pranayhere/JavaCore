package com.pranay.interview.queue;

import java.util.ArrayDeque;
import java.util.Deque;

// Count Subarrays With Cost Less Than or Equal to K
public class SubarrayCostK {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, 2};
        int k = 4;

        SubarrayCostK s = new SubarrayCostK();
        long ans = s.countSubarrays(nums, k);

        System.out.println(ans);
    }

    public long countSubarrays(int[] nums, int k) {
        Deque<Integer> minD = new ArrayDeque<>();
        Deque<Integer> maxD = new ArrayDeque<>();

        int l = 0;
        int ans = 0;

        for (int r = 0; r < nums.length; r++) {
            if (!minD.isEmpty() && nums[minD.peekLast()] >= nums[r]) {
                minD.pollLast();
            }
            minD.addLast(r);

            if (!maxD.isEmpty() && nums[maxD.peekLast()] <= nums[r]) {
                maxD.pollLast();
            }
            maxD.addLast(r);

            System.out.println("l = " + l + " r = " + r + " minD = " + minD + " maxD = " + maxD);

            // shrink the window if cost > k
            while (!minD.isEmpty() && !maxD.isEmpty()) {
                long minVal = nums[minD.peekFirst()];
                long maxVal = nums[maxD.peekFirst()];
                long len = r - l + 1;

                if (maxVal - minVal + len <= k)
                    break;

                System.out.println("shrinking... l = " + l + " r = " + r + " minD = " + minD + " maxD = " + maxD);
                if (minD.peekFirst() == l)
                    minD.pollFirst();

                if (maxD.peekFirst() == l)
                    maxD.pollFirst();

                l++;
            }

            ans += r - l + 1;
        }

        System.out.println("minD" + minD);
        System.out.println("maxD" + maxD);
        return ans;
    }
}
