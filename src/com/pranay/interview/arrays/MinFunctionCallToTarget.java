package com.pranay.interview.arrays;

/**
 * 1558. Minimum Numbers of Function Calls to Make Target Array
 * https://leetcode.com/problems/minimum-numbers-of-function-calls-to-make-target-array/
 *
 * https://leetcode.com/problems/minimum-numbers-of-function-calls-to-make-target-array/discuss/805884/Java-Explanation-with-VIDEO-and-comments-Count-number-of-divides-O(n*log(m))
 * Work backwards, if any number is odd, subtract 1. If even, divide by 2.
 * EXAMPLE:
 * [4,2,5]
 *
 * [4,2,4] + 1 operation, previous had odd, so subtract 1
 * [2,1,2] + 1 op, previous had all even, divide by 2
 * [2,0,2] + 1 op, previous had odd, so subtract 1
 * [1,0,1] + 1 op , previous had all even, divide by 2
 * [0,0,1] + 1 op , previous had odd, so subtract 1
 * [0,0,0] + 1 op , previous had odd, so subtract 1
 * That is 6 operations.
 *
 * But we can't really iterate like that in code, so instead, we iterate through the numbers individually and for each one, we divide by 2 and subtract by 1 each time.
 *
 * -> If we divide, we ONLY increase the count if it's greater than how many divides we previously had. That's because the divide operation happens across every number unlike the subtract operation. So if we divided previously, that means this number had been divided already, so we shouldn't increment count.
 *
 * -> If we subtract, we increase count each time.
 *
 * Once the number hits 0, we can stop.
 */
public class MinFunctionCallToTarget {
    public static void main(String[] args) {
        int[] nums = {4,2,5};
        int ops = minOperations(nums);
        System.out.println("Number of operations : " + ops);
    }

    private static int minOperations(int[] nums) {
        // WORK BACKWARDS
        int count = 0;
        int currDivides = 0; // how many times have we currently divided by 2

        // The most a number has been divided by 2
        int maxDivides = Integer.MIN_VALUE;//(basically dependant on the largest number)

        for (int i = 0; i < nums.length; i++) {
            currDivides = 0; // reset to 0
            int n = nums[i];
            while (n > 0) { // while the number hasn't hit zero

                if (n % 2 == 0) { // if its even, divide by 2
                    n = n / 2;
                    currDivides++;

                    // if our current number of divides is greater than the max, we can increase our count
                    if (currDivides > maxDivides) {
                        count++;
                        maxDivides = currDivides;
                    }
                } else { // if its odd, subtract 11
                    n--;
                    count++;
                }
            }
        }
        return count;
    }
}
