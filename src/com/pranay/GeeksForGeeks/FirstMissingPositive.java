package com.pranay.GeeksForGeeks;

import java.util.Arrays;

public class FirstMissingPositive {

	public static void main(String[] args) {
		int[] nums = {9,6,4,2,3,5,7,0,1};
		int num = firstMissingPositive(nums);
		System.out.println(num);
	}

	private static int firstMissingPositive(int[] nums) {
		for(int i=0;i<nums.length;){
            System.out.println(Arrays.toString(nums));
            int cur = nums[i];
//            System.out.println("i : " + i + "cur : " + cur );
            if(cur>=1 && cur<=nums.length && cur!=nums[cur-1]){
                nums[i] = nums[cur-1];
                nums[cur-1] = cur;
                continue;
            }
            i++;
        }
		for(int i=0;i<nums.length;i++){
            if(nums[i]!=i+1)return i+1;
        }
        return nums.length+1;
	}
}

//for(int i=0;i<nums.length;){
//    int cur = nums[i];
//    if(cur>=1&&cur<=nums.length&&cur!=nums[cur-1]){
//        nums[i] = nums[cur-1];
//        nums[cur-1] = cur;
//        continue;
//    }
//    i++;
//}
