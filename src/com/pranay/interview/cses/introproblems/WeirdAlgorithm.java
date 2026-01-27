package com.pranay.interview.cses.introproblems;

public class WeirdAlgorithm {
    public static void main(String[] args) {
        int n = 3;

        while (n != 1) {
            if (n % 2 == 1) {
                n = n * 3 + 1;
            } else {
                n = n / 2;
            }

            System.out.println(n);
        }
    }
}
