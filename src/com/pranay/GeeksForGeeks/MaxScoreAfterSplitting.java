package com.pranay.GeeksForGeeks;

public class MaxScoreAfterSplitting {
    public static void main(String[] args) {
        String s = "011101";
        int score =  maxScore(s);
        System.out.println("Ans : "+score);
    }

    private static int maxScore(String s) {
        int ones = 0;
        int zeros = 0;
        int sum = 0;
        for (int i = 0; i<s.length(); i++) {
            if (s.charAt(i) == '1') {
                ones++;
            }
        }

        for (int i = 0; i<s.length() - 1; i++) {
            if (s.charAt(i) == '0') {
                zeros ++;
            } else {
                ones --;
            }
            System.out.println(zeros + " - " + ones);
            sum = Math.max(sum, zeros + ones);
        }
        return sum;
    }
}
