package com.pranay.GeeksForGeeks;

public class ConsecutiveCharacters {
    public static void main(String[] args) {
        String s = "cc";
        int count = maxPower(s);
        System.out.println("Count : "+count);
    }

    private static int maxPower(String s) {
        int max = 1;
        int curr = 1;
        for (int i = 1; i < s.length(); i++) {
            char now = s.charAt(i);
            char prev = s.charAt(i-1);
            if (now == prev) {
                curr++;
            } else {
                curr = 1;
            }
            max = Math.max(curr, max);
        }
        return max;
    }
}
