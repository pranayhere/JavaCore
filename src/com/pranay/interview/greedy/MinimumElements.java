package com.pranay.interview.greedy;

import java.util.stream.IntStream;

public class MinimumElements {
    public static void main(String[] args) {
        int[] nums = {1,-1,1};
        int limit = 3, goal = 4;
        int ans = minElements(nums, limit, goal);
        System.out.println("Minimum elements : " + ans);
    }

    private static int minElements(int[] nums, int limit, int goal) {
        int sum = IntStream.of(nums).sum();
        int count = 0;

        if (sum > goal) { // +ve
            int diff = Math.abs(goal - sum);
            count += diff / limit;

            sum -= (limit * count);
            if (sum > goal)
                count++;
        } else if (sum == goal) {
            return 0;
        } else { // sum > goal (-ve)
            int diff = Math.abs(goal - sum);
            count += diff / limit;

            sum += (limit * count);
            if (sum < goal)
                count++;
        }

        return count;
    }
}
