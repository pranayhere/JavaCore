package com.pranay.interview.arrays;

public class StrongPasswordChecker {
    public static void main(String[] args) {
        String s = "pranaysankpal";
        int changes = strongPasswordChecker(s);
        System.out.println("Changes : " + changes);
    }

    private static int strongPasswordChecker(String s) {

        char[] str = s.toCharArray();
        int missingType = 3;
        boolean isUpper = false, isLower = false, isDigit = false;

        for (char c: str) {
            if (!isUpper && Character.isUpperCase(c)) {isUpper = true; --missingType;}
            if (!isLower && Character.isLowerCase(c)) {isLower = true; --missingType;}
            if (!isDigit && Character.isDigit(c)) {isDigit = true; --missingType;}
        }

        int totalChangeCnt = 0, oneChangeCnt = 0, twoChangeCnt = 0, pos = 2;
        while (pos < s.length()) {
            if (str[pos] == str[pos - 1] && str[pos - 1] == str[pos - 2]) {
                int len = 2;
                while (pos < s.length() && str[pos] == str[pos - 1]) {
                    len += 1;
                    pos += 1;
                }

                totalChangeCnt += len / 3;
                if (len % 3 == 0) oneChangeCnt += 1;
                else if (len % 3 == 1) twoChangeCnt += 1;
            } else
                pos++;
        }

        if (s.length() < 6)
            return Math.max(missingType, 6 - s.length());

        else if (s.length() <= 20)
            return Math.max(missingType, totalChangeCnt);

        else {
            int deleteCount = s.length() - 20;
            totalChangeCnt -= Math.min(deleteCount, oneChangeCnt);
            totalChangeCnt -= Math.min(Math.max(deleteCount - oneChangeCnt, 0), twoChangeCnt * 2) / 2;
            totalChangeCnt -= Math.max(deleteCount - oneChangeCnt - 2 * twoChangeCnt, 0) / 3;

            return deleteCount + Math.max(missingType, totalChangeCnt);
        }
    }
}
