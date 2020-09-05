package com.pranay.codeforces;

import java.util.Scanner;

public class TheaterSquare {
    public static void main(String[] args) {
        Scanner sr = new Scanner(System.in);
        double n = sr.nextInt();
        double m = sr.nextInt();
        double a = sr.nextInt();

        System.out.println((long)(Math.ceil(n/a) * Math.ceil(m/a)));
    }
}
