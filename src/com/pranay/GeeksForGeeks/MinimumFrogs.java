package com.pranay.GeeksForGeeks;

public class MinimumFrogs {
	public static void main(String[] args) {
		String croakOfFrogs = "croakcroak";
		int num = minNumberOfFrogs(croakOfFrogs);
		System.out.println("Minimum frogs : " + num);
	}

	private static int minNumberOfFrogs(String croakOfFrogs) {
		int c = 0, r = 0, o = 0, a = 0, k = 0;
		int max = 0;
		for (char ch : croakOfFrogs.toCharArray()) {
			if (ch == 'c') c++;
			else if (ch == 'r') {
				if (c == 0) return -1;
				c--;
				r++;
			} else if (ch == 'o') {
				if (r == 0) return -1;
				r--;
				o++;
			} else if (ch == 'a') {
				if (o == 0) return -1;
				o--;
				a++;
			} else if (ch == 'k') {
				if (a == 0) return -1;
				a--;
				k++;
			}
			max = Math.max(max, c + r + o + a + k);
			k = 0;
		}
		if (a > 0 || r > 0 || o > 0 || c > 0) return -1;
		return max;
	}
}
