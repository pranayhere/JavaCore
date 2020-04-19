package com.pranay.GeeksForGeeks;

public class ReformatString {
	public static void main(String[] args) {
		String s = "ab123";
		String formatted = reformat(s);
		System.out.println("formatted : " + formatted);
	}

	private static String reformat(String s) {
		String letters = "";
		String nums = "";
		for (int i = 0; i< s.length(); i++) {
			if (Character.isDigit(s.charAt(i))) {
				nums += s.charAt(i);
			} else {
				letters += s.charAt(i);
			}
		}
//		System.out.println("letters : " + letters);
//		System.out.println("Digits : " + nums);

		String ans = "";
		String first = null;
		String second = null;
		if (Math.abs(letters.length() - nums.length()) <= 1) {
			if (letters.length() > nums.length()) {
				first = letters;
				second = nums;
			} else if (letters.length() < nums.length()) {
				first = nums;
				second = letters;
			}
			else if (Character.isDigit(s.charAt(0))) {
				first = letters;
				second = nums;
			} else {
				first = nums;
				second = letters;
			}

			int count = 0;
			int i = 0;
			int j = 0;
			while (count < s.length()) {
				if (count % 2 == 0) {
					ans += first.charAt(i);
					i++;
					count++;
				} else {
					ans += second.charAt(j);
					j++;
					count++;
				}
			}
		}
		return ans;
	}
}
