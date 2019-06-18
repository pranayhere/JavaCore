package com.pranay.GeeksForGeeks;

import java.util.BitSet;

public class BitSetFindDuplicates {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1,2,3,4,5,4,6,6,7,8,8,9};
		findDuplicates(arr);
	}

	private static void findDuplicates(int[] arr) {
		BitSet bs = new BitSet(arr.length);
		for (int i=0; i<arr.length; i++) {
			int num = arr[i];
			if (bs.get(num)) {
				System.out.println(num);
			} else {
				bs.set(num);
			}
		}
		System.out.println(bs);
	}
}
