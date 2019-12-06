package com.pranay.GeeksForGeeks;

public class PerfectSubstring {
	public static void main(String[] args) {
		String s = "1102021222";
		int k = 2;
		int count = perfectSubstring(s, k);
		System.out.println("count is : " + count);
	}

	static int MAX_INT = 10;

	public static boolean check(int[] freq, int k) {
		for (int i = 0; i<MAX_INT; i++)
			if (freq[i] != 0 && freq[i] != k)
				return false;
		return true;
	}

	private static int perfectSubstring(String s, int k) {
		int ans = 0;

		for (int i = 0; i< s.length(); i++) {
			int[] freq = new int[MAX_INT];

			for (int j = i; j<s.length(); j++) {
				try{
					int index = Integer.parseInt(String.valueOf(s.charAt(j)));
					freq[index]++;

					if (freq[index] > k)
						break;

					else if (freq[index] == k && check(freq, k) == true)
						ans++;
				} catch(NumberFormatException e) {

				}

			}
		}
		return ans;
	}
}
