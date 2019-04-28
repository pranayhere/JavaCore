package com.pranay.testdome;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class TwoSum {
    public static int[] findTwoSum(int[] list, int sum) {
    	Set<Integer> hs = new HashSet<Integer>();
    	for (int i=0; i<list.length; i++) {
    		int temp = sum - list[i];
    		if (temp > 0 && hs.contains(temp)) {
    			return new int[] {temp, list[i]};
    		}
    		hs.add(list[i]);
    	}
    	return null;
    }

    public static void main(String[] args) {
        int[] indices = findTwoSum(new int[] { 3, 1, 5, 7, 5, 9 }, 10);
        if(indices != null) {
            System.out.println(indices[0] + " " + indices[1]);
        }
    }
}