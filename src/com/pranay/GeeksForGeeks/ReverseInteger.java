package com.pranay.GeeksForGeeks;

public class ReverseInteger {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x = -123;
		System.out.println(reverse(x));
	}

	private static int reverse(int x) {
		int num = 0;
		while (x != 0) {
			int mod = x % 10;
			x = x / 10;
			if (num > Integer.MAX_VALUE/10 || (num == Integer.MAX_VALUE/10 && mod > 7))
				return 0;
			if (num < Integer.MIN_VALUE/10 || (num == Integer.MIN_VALUE / 10 && mod < -8)) 
				return 0;
			num = num * 10 + mod;
			System.out.println(num);
		}

		return num;
	}
}
