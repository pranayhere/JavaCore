package com.pranay.GeeksForGeeks;

public class PalindromNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		if (isPalindrome(121)) {
			System.out.println("Plaindrom");
		} else {
			System.out.println("Not Palindrom");
		}
	}

	public static boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int rev = reverse(x);
        if (x == rev)
            return true;
        return false;
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
		}

		return num;
	}
}
