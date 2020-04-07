package com.pranay.GeeksForGeeks;

public class ReduceBinaryRepToOne {
	public static void main(String[] args) {
		String s = "1101";
		int steps = reduceToOne(s);
		System.out.println("Steps : " + steps);
	}

	private static int reduceToOne(String s) {
		if (s.length() == 1)
			return 0;

		int cnt = 0;
		char[] chars = s.toCharArray();
		for (int i = s.length() - 1; i > 0;) {
			if (chars[i] == '0') {
				cnt++;
				i--;
			}
			else {
				cnt++;
				while (chars[i] == '1' && i > 0) {
					cnt++;
					i--;
				}
				if (i == 0)
					cnt++;

				chars[i] = '1';
			}
		}
		return cnt;
	}
}
