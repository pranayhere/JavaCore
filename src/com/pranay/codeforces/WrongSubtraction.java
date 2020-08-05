package com.pranay.codeforces;

import java.util.Scanner;

public class WrongSubtraction {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

//        int n = 512;
//        int k = 4;

        int ans = subtraction(n, k);
        System.out.println(ans);
    }

    private static int subtraction(int n, int k) {
        for (int i = 0; i < k; i++) {
            if (n % 10 == 0)
                n /= 10;
            else
                n--;
        }
        return n;
    }
}
