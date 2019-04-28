package com.pranay.GeeksForGeeks;

import java.util.List;
import java.util.Arrays;
import java.util.Collections;

public class MaxSum {
    public static int findMaxSum(List<Integer> list) {
    	int first = 0, second = 0;
    	if (list.get(0) > list.get(1)) {
    		first = list.get(0);
    		second = list.get(1);
    	} else {
    		first = list.get(1);
    		second = list.get(0);
    	}
    	
    	for (int i = 2; i<list.size(); i++) {
    		if (list.get(i) > first) {
    			second = first;
    			first = list.get(i);
    		}
    		else if (list.get(i) > second && list.get(i) != first) {
    			second = list.get(i);
    		}
    	}
    	return first + second;
    }
    
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(5, 9, 7, 11);
        System.out.println(findMaxSum(list));
    }
}