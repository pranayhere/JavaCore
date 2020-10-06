package com.pranay.codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Team231A {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        String[][] arr = new String[tc][3];
        for (int i = 1; i <= tc; i++) {
            arr[i - 1] = br.readLine().split(" ");
        }

        int ans = solve(arr);
        System.out.println("Ans : " + ans);
    }

    private static int solve(String[][] arr) {
        int res = 0;
        for (String[] A: arr) {
            int count = 0;

            for (String n: A) {
                count += Integer.parseInt(n);
            }

            if (count >= 2)
                res++;
        }
        return res;
    }
}
