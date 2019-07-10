package com.pranay.GeeksForGeeks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CountingBits {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 5;
		
		List<String> list = Arrays.asList("a","c","b","d");
		System.out.println(list);
		
		List mylist = new ArrayList();
		mylist.add(1);
		mylist.add("abc");
		mylist.add(new CountingBits());
		
		System.out.println(mylist);
		
		System.out.println(Collections.binarySearch(list, "c"));
		
		Integer a = 1000;
		int b = 1000;
		if (a.equals(b))
			System.out.println("Inside");
		
		int[] arr = countBits(n);
		System.out.println(Arrays.toString(arr));
	}

	private static int[] countBits(int n) {
		int diff = 2;
		int val = diff * 2;
		int[] arr = new int[n+1];
		arr[0] = 0;
		arr[1] = 1;
		for (int i = 2; i<= n; i++) {
			if (i >= val) {
				diff = val;
				val = diff * 2;
			} 
//			System.out.println("i:" + i + "diff : " + diff);
			arr[i] = 1 + arr[i - diff];
		}
		return arr;
	}

}
