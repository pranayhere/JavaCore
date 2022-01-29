package com.pranay.interview.implementation;

import java.util.Scanner;

public class WayTooLongWords {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            String word = sc.next();
            if (word.length() > 10) {
                String w = word.charAt(0) + String.valueOf(word.length() - 2) + word.charAt(word.length() - 1);
                System.out.println(w);
            } else {
                System.out.println(word);
            }
        }
    }
}
