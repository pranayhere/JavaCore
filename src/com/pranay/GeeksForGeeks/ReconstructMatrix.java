package com.pranay.GeeksForGeeks;

import java.util.ArrayList;
import java.util.List;

public class ReconstructMatrix {
	public static void main(String[] args) {
		int upper = 9;
		int lower = 2;
		int[] colsum = {0,1,2,0,0,0,0,0,2,1,2,1,2};
		List<List<Integer>> ans = reconstructMatrix(upper, lower, colsum);
		for (List<Integer> list : ans) {
			System.out.println(list);
		}
	}

	private static List<List<Integer>> reconstructMatrix(int upper, int lower, int[] colsum) {
		List<List<Integer>> res = new ArrayList<>();
		int common = 0;
		int one = 0;
		int colsumsum = 0;
		for (int i = 0; i < colsum.length; i++) {
			if (colsum[i] == 2) {
				common++;
			}
			if (colsum[i] == 1)
				one++;
			colsumsum += colsum[i];
		}

		if (colsumsum != upper + lower) {
			return res;
		}

		if (upper < common || lower < common) {
			return res;
		}

		int urem = upper - common;
		List<Integer> up = new ArrayList<>();
		List<Integer> low = new ArrayList<>();
		for (int i = 0; i < colsum.length; i++) {
			if (colsum[i] != 1) {
				up.add(colsum[i] / 2);
				low.add(colsum[i] / 2);
			} else if (urem > 0) {
				up.add(1);
				low.add(0);
				urem--;
			} else {
				up.add(0);
				low.add(1);
			}
		}
		res.add(up);
		res.add(low);
		return res;
	}
}
