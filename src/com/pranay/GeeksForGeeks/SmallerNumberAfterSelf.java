package com.pranay.GeeksForGeeks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 315. Count of Smaller Numbers After Self
 * https://leetcode.com/problems/count-of-smaller-numbers-after-self/
 */
public class SmallerNumberAfterSelf {
	public static void main(String[] args) {
		int[] nums = {5, 3, 6, 1};

        SmallerNumberAfterSelf snas = new SmallerNumberAfterSelf();
		List<Integer> ans2 = snas.countSmallerBinary(nums);
		System.out.println(ans2);
	}

	Integer[] res;
	List<Integer> list = new ArrayList<>();

	private List<Integer> countSmallerBinary(int[] nums) {
        res = new Integer[nums.length];

        for (int i = nums.length - 1; i >= 0; i--) {
            addNum(nums[i], i);
            System.out.println(list);
        }

        return Arrays.asList(res);
	}

    private void addNum(int num, int i) {
        int lo = 0;
        int hi = list.size() - 1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int M = list.get(mid);

            if (num >= M)
                lo = mid + 1;
            else
                hi = mid - 1;
        }
        list.add(lo, num);
        res[i] = lo;
    }
}
