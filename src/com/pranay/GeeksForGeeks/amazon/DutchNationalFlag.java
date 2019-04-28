package com.pranay.GeeksForGeeks.amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;


public class DutchNationalFlag {
	public static void main(String[] args) {
		int[] arr = {1,2,0,1,2,0,0};
		sort(arr);
	}

	private static int[] sort(int[] arr) {
		List<Integer> list = Arrays.stream(arr)
	      .boxed()
	      .collect(Collectors.toList());
		
		System.out.println(list);
		
		List<Integer> groupedList = (List<Integer>) list.stream().collect(Collectors.groupingBy(w -> w));
		System.out.println(groupedList);
		return null;
	}
}
