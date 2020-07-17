package com.pranay.interview.strings;

public class ReverseWordInString {
    public static void main(String[] args) {
        String str = "the    blue  ";
        String ans = reverseWords(str);
        System.out.println("Ans : " + ans);
    }

    private static String reverseWords(String s) {
        s = ' ' + s;
        String ns = "";
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) != ' ') {
                continue;
            }

            for (int j = i + 1; j < s.length(); j++) {
                if (s.charAt(j) == ' ')
                    continue;
                ns += s.charAt(j);

                if (j == s.length() - 1)
                    ns += ' ';
            }

            s = s.substring(0, i);
        }
        return ns.trim();
    }
}
