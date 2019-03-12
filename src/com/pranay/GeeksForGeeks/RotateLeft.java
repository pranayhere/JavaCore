package com.pranay.GeeksForGeeks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class RotateLeft {
	public static void main(String[] args) {
		int a[] = {1,2,3,4,5};
		int d = 2;
		int[] arr = rotateLeft(a, 3);
		for(int i : arr)
			System.out.print(i + " ");
	}

	private static int[] rotateLeft(int[] a, int d) {
//		List<Integer> list = new ArrayList<Integer>(a.length);
//        for (int n : a)
//          list.add(n);

        List<Integer> list = Arrays.stream(a).boxed().collect(Collectors.toList());  // primitive array to ArrayList Integer        
        Collections.rotate(list, d * -1); // -1 to left rotate, +1 to right rotate
        return list.stream().mapToInt(Integer::intValue).toArray(); // Integer to primitive int array
	}
}
