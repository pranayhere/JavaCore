package com.pranay.GeeksForGeeks;

import java.util.Arrays;

public class NumSmallerByFrequency {
    public static void main(String[] args) {
        String[] queries = {"bbb","cc"};
        String[] words = {"a","aa","aaa","aaaa"};
        int[] arr = numSmallerByFrequency(queries, words);
        System.out.println(Arrays.toString(arr));
    }

    private static int[] numSmallerByFrequency(String[] queries, String[] words) {
        int qcnt[] = new int[queries.length];
        int wcnt[] = new int[words.length];
        int ans[] = new int[queries.length];
        for (int i = 0; i< queries.length; i++) {
            int chars[] = new int[26];
            for (char c: queries[i].toCharArray()) {
                chars[c - 'a']++;
            }
            for (int val: chars) {
                if (val > 0) {
                    qcnt[i] = val;
                    break;
                }
            }
        }
        System.out.println(Arrays.toString(qcnt));

        for (int i = 0; i< words.length; i++) {
            int chars[] = new int[26];
            for (char c: words[i].toCharArray()) {
                chars[c - 'a']++;
            }
            for (int val: chars) {
                if (val > 0) {
                    wcnt[i] = val;
                    break;
                }
            }
        }
        System.out.println(Arrays.toString(wcnt));


        for(int i = 0; i<qcnt.length; i++) {
            int count = 0;
            for (int j = 0; j<wcnt.length; j++) {
                if (qcnt[i] < wcnt[j]) {
                    count++;
                }
            }
            ans[i] = count;
        }
        return ans;
    }
}
