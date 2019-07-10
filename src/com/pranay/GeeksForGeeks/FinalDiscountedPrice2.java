package com.pranay.GeeksForGeeks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FinalDiscountedPrice2 {

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(new Integer[] {2,3,1,2,4,2});
		finalPrice(list);
	}

	public static void finalPrice(List<Integer> list) {
		
		int[] minArr = new int[list.size()];
		List<Integer> idx = new ArrayList<>();
		
		for (int i =0; i< list.size(); i++) {
			int current = list.get(i); 
			for (int j = i+1; j<list.size(); j++) {
				if (current >= list.get(j)) {
					minArr[i] = list.get(j);
					break;
				}
			}
		}
		
		long sum = 0;
		for (int i = 0; i<list.size(); i++) {
			sum += list.get(i) - minArr[i];
			if (minArr[i] == 0) {
				idx.add(i);
			}
		}
		
//		System.out.println(Arrays.toString(minArr));
		System.out.println(sum);
		for (Integer i : idx) {
			System.out.print(i + " ");
		}
		
	}

}
