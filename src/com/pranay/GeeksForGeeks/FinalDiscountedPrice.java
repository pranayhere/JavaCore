package com.pranay.GeeksForGeeks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FinalDiscountedPrice {

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(new Integer[] {1,3,3,2,5});
		finalPrice(list);
	}

	public static void finalPrice(List<Integer> list) {
		int[] arr = new int[list.size()];
		int[] left = new int[arr.length];
		List<Integer> idx = new ArrayList<Integer>();
		
		for (int i = 0; i< list.size(); i++) {
			arr[i] = list.get(i);
		}
		
		int min = arr[arr.length - 1];
		left[arr.length - 1] = min;
		
		for (int i = arr.length - 2; i >=0; i--) {
			if (arr[i] == arr[i+1]) {
				left[i] = arr[i];
				continue;
			}
			
			left[i] = Math.min(min, arr[i]);
			min = Math.min(min, left[i]);
		}
		
		int sum = 0;
		for (int i = 0; i<arr.length; i++) {
			
			if (left[i] == arr[i]) {
				if (i+1 <arr.length && arr[i] == arr[i+1]) {
					sum = sum + (arr[i] - left[i]);
				} else {
					sum += arr[i];	
					idx.add(i);
				}
			} else {
				sum = sum + (arr[i] - left[i]);
			}
		}
		
		System.out.println(list);
		System.out.println(Arrays.toString(left));
		
		System.out.println(sum);
		for (Integer i : idx) {
			System.out.print(i + " ");
		}

	}

}
