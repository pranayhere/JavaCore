package com.pranay.interview.searching;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a list of integers nums, return a new list where each element in the new list is the number of smaller elements to the right of that element in the original input list.
 * <p>
 * Constraints
 * <p>
 * n ≤ 100,000 where n is the length of nums
 * Example 1
 * Input
 * lst = [3, 4, 9, 6, 1]
 * Output
 * [1, 1, 2, 1, 0]
 * Explanation
 * There is 1 smaller element to the right of 3
 * There is 1 smaller element to the right of 4
 * There are 2 smaller elements to the right of 9
 * There is 1 smaller element to the right of 6
 * There are no smaller elements to the right of 1
 */
public class LongDistance {
    public static void main(String[] args) {
        int[] lst = {3, 4, 9, 6, 1};
        LongDistance ld = new LongDistance();
        int[] ans = ld.solve(lst);
        System.out.println("Ans : " + Arrays.toString(ans));
    }

    List<Integer> sorted = new ArrayList<>();

    public int[] solve(int[] lst) {
        int n = lst.length;
        int[] ans = new int[n];

        for (int i = n - 1; i >= 0; i--) {
            int idx = binarySearch(lst[i]);
            sorted.add(idx, lst[i]);
            ans[i] = idx;
        }

        return ans;
    }

    public int binarySearch(int num) {
        int lo = 0;
        int hi = sorted.size();

        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;

            if (sorted.get(mid) < num)
                lo = mid + 1;
            else
                hi = mid;
        }

        // System.out.println(sorted + "---" + num + " --- " + lo);
        return lo;
    }

}
