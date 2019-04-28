package com.pranay.GeeksForGeeks;

public class SpecialPalindromeAgain {

	public static void main(String[] args) {
		int n = 5;
		String str = "aabaa";
		long count = substrPaliCount(n,str);
		System.out.println(count);
	}

	private static long substrPaliCount(int n, String s) {
		long retVal = s.length();

        for (int i = 0; i < s.length(); i++)
        {
            char startChar = s.charAt(i);
            int diffCharIdx = -1;
            for (int j = i + 1; j < s.length(); j++)
            {
                char currChar = s.charAt(j);
                System.out.print(startChar +" "+ currChar);
                if (startChar == currChar)
                {
                	System.out.print(" if ");
                    if ((diffCharIdx == -1) || (j - diffCharIdx) == (diffCharIdx - i))
                        retVal++;
                }
                else
                {
                	System.out.print(" else ");
                    if (diffCharIdx == -1)
                        diffCharIdx = j;
                    else {
                    	System.out.println();
                        break;                    	
                    }
                }
                System.out.println();
            }
        }
        return retVal;
	}

	private static boolean isPalindrom(String str) {
		String rev = new StringBuffer(str).reverse().toString();
		System.out.print(str + " " +rev);
		if (str.equals(rev))
			return true;
		return false;
	}

}
