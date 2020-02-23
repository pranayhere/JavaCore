package com.pranay.GeeksForGeeks;

import java.util.ArrayList;

public class ProductOfLastKNumbers {
	ArrayList<Integer> list;

	public ProductOfLastKNumbers() {
		add(0);
	}

	public static void main(String[] args) {
		String[] ops = {"ProductOfNumbers","add","add","add","add","add","getProduct","getProduct","getProduct","add","getProduct"};
		int[][] num = {{},{3},{0},{2},{5},{4},{2},{3},{4},{8},{2}};

		ProductOfLastKNumbers obj;
		obj = new ProductOfLastKNumbers();
		for (int i = 1; i<ops.length; i++) {
			String op = ops[i];
			if (ops[i].equals("add")) {
				obj.add(num[i][0]);
			} else if (ops[i].equals("getProduct")) {
				int product = obj.getProduct(num[i][0]);
				System.out.println(product);
			}
		}
	}

	public void add(int a) {
		if (a > 0) {
			list.add(list.get(list.size() - 1) * a);
		} else {
			list = new ArrayList<>();
			list.add(1);
		}
	}

	public int getProduct(int k) {
		int n = list.size();
		return k < n ? list.get(n - 1) / list.get(n - k - 1) : 0;
	}
}
