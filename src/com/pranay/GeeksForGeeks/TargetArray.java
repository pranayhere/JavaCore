package com.pranay.GeeksForGeeks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class TargetArray {
	public static void main(String[] args) {
		int[] nums = {1,2,3,4,0};
		int[] index = {0,1,2,3,0};
		int[] res = createTargetArray(nums, index);
		System.out.println(Arrays.toString(res));
	}

	private static int[] createTargetArray(int[] nums, int[] index) {
		List<Integer> list = new LinkedList<>();
		int[] res = new int[nums.length];

		for (int i = 0; i<nums.length; i++) {
			list.add(index[i], nums[i]);
		}

		for (int i=0; i<list.size(); i++) {
			res[i] = list.get(i);
		}
		return res;
	}
}
