package com.pranay.interview.arrays;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BestTeamWithNoConflicts {
    public static void main(String[] args) {
        int scores[] = {4,5,6,5}, ages[] = {2,1,2,1};

        BestTeamWithNoConflicts bt = new BestTeamWithNoConflicts();
        int maxScore = bt.bestTeamScore(scores, ages);
        System.out.println("Max Score : " + maxScore);
    }

    private int bestTeamScore(int[] scores, int[] ages) {
        int n = scores.length;
        int[][] team = new int[n][2];

        for (int i = 0; i < n; i++) {
            team[i][0] = ages[i];
            team[i][1] = scores[i];
        }

        Arrays.sort(team, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);

        int[] dp = new int[n];
        // dp is the max sum for all sequences (not necessarily consecutive) ending in current idx
        dp[0] = team[0][1];

        for (int i = 1; i < n; i++) {
            int max = team[i][1];

            for (int j = 0; j < i; j++) {
                if (team[i][1] >= team[j][1])
                    max = Math.max(max, dp[j] + team[i][1]);
            }
            dp[i] = max;
        }

        int res = 0;
        for (int num: dp) {
            res = Math.max(res, num);
        }

        return res;
    }
}
