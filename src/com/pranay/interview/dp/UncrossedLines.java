package com.pranay.interview.dp;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

public class UncrossedLines {
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd'T'Hmmss'Z'");
    public static void main(String[] args) {
        int[] A = {1, 4, 2};
        int[] B = {1, 2, 4};
        int max = maxUncrossedLines(A, B);

        LocalDateTime currentDateTime = LocalDateTime.of(2020, 5, 5, 9, 15, 20);
        String formattedDateTime = currentDateTime.format(formatter);
        System.out.println(formattedDateTime);
        System.out.println("Max : " + max);
    }

    private static int maxUncrossedLines(int[] A, int[] B) {
        int[][] dp = new int[A.length + 1][B.length + 1];

        for (int i = 1; i<=A.length; i++) {
            for (int j = 1; j<=B.length; j++) {
                if (A[i-1] == B[j-1]) {
                    dp[i][j] = 1 + dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
//        for (int[] arr: dp) {
//            System.out.println(Arrays.toString(arr));
//        }
        return dp[dp.length - 1][dp[0].length - 1];
    }

}
