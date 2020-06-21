package com.pranay.interview.strings;

public class RobinKarpSubstringSearch {
    private int prime = 3;

    public static void main(String[] args) {
        char[] text = "abedabcd".toCharArray();
        char[] pattern = "abc".toCharArray();

        RobinKarpSubstringSearch rc = new RobinKarpSubstringSearch();
        int idx = rc.robinKarp(text, pattern);
        System.out.println("Index : " + idx);
    }

    private int robinKarp(char[] text, char[] pattern) {
        int m = pattern.length;
        int n = text.length;

        long patternHash = createHash(pattern, m - 1);
        long textHash = createHash(text, m - 1);

        for (int i = 1; i <= n - m + 1; i++) {
            if (patternHash == textHash && checkEquals(text, i-1, i+m-2, pattern, 0, m -1)) {
                return i - 1;
            }

            if (i < n - m + 1) {
                textHash = recalculateHash(text, i - 1, i + m - 1, textHash, m);
            }
        }

        return -1;
    }

    private long recalculateHash(char[] str, int oldIdx, int newIdx, long oldHash, int patternLen) {
        long newHash = oldHash - str[oldIdx];
        newHash = newHash / prime;
        newHash += str[newIdx] * Math.pow(prime, patternLen - 1);
        return newHash;
    }

    private boolean checkEquals(char[] str1, int start1, int end1, char[] str2, int start2, int end2) {
        if (end1 - start1 != end2 - start2) {
            return false;
        }

        while (start1 <= end1 && start2 <= end2) {
            if (str1[start1] != str2[start2]) {
                return false;
            }
            start1++;
            start2++;
        }
        return true;
    }

    private long createHash(char[] str, int end) {
        long hash = 0;

        for (int i = 0; i<=end; i++) {
            hash += str[i] * Math.pow(prime, i);
        }
        return hash;
    }
}
