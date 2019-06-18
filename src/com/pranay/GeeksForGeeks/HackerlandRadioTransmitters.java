package com.pranay.GeeksForGeeks;

import java.util.Arrays;

public class HackerlandRadioTransmitters {

	public static void main(String[] args) {
		 int[] x = {7, 2, 4, 6, 5, 9, 12, 11};
		 int k = 2;
//		int[] x = { 1, 2, 3, 4, 5 };
//		int k = 1;
		int count = hackerlandRadioTransmitters(x, k);
		System.out.println("Final transmitters : " + count);
	}

	private static int hackerlandRadioTransmitters(int[] x, int k) {
		int count_trans = 0;
		int i = 0;
		Arrays.sort(x);
		System.out.println(Arrays.toString(x)); // [2, 4, 5, 6, 7, 9, 11, 12]
		while(i < x.length) {
			System.out.println("init : "+i);
			count_trans = count_trans + 1;
			int next_point = x[i] + k;
			while(i < x.length && x[i] <= next_point)
				i = i + 1;
			System.out.println("first : "+i);
			next_point = x[i-1] + k;
			while(i < x.length && x[i] <= next_point)
				i = i + 1;
			System.out.println("sec : "+i);
		}
		return count_trans;
	}

}
