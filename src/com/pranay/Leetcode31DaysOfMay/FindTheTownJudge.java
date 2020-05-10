package com.pranay.Leetcode31DaysOfMay;

//https://leetcode.com/problems/find-the-town-judge

public class FindTheTownJudge {
    public static void main(String[] args) {
        int[][] trust = {{1,2}};
        int N = 2;
        int judge = findJudge(N, trust);
        System.out.println("Judge : " + judge);
    }

    private static int findJudge(int n, int[][] trusts) {
        int[] indeg = new int[n + 1];
        int[] outdeg = new int[n + 1];

        for (int[] trust: trusts) {
            indeg[trust[1]]++;
            outdeg[trust[0]]++;
        }

        for (int i = 1; i<=n; i++) {
            if (indeg[i] == n-1 && outdeg[i] == 0) {
                return i;
            }
        }
        return -1;
    }
}
