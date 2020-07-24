package com.pranay.interview.bitwise;

import java.util.Arrays;

public class SingleNumber3 {
    public static void main(String[] args) {
        int[] nums = {1,2,3,16,2,1};
        int[] res = singleNumber(nums);
        System.out.println(Arrays.toString(res));
    }

    public static int[] singleNumber(int[] nums) {
        int diff = 0;
        for(int num: nums){
            diff^=num;
        }
        diff = Integer.highestOneBit(diff);
        System.out.println(diff);

        int[] result = new int[2];
        Arrays.fill(result,0);
        for(int num: nums){
            if((diff & num) == 0){
                result[0] ^= num;
            }
            else{
                result[1] ^= num;
            }
        }
        return result;
    }
}
