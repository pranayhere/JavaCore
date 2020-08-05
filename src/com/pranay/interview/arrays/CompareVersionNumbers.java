package com.pranay.interview.arrays;

/**
 * 165. Compare Version Numbers
 * https://leetcode.com/problems/compare-version-numbers/
 */
public class CompareVersionNumbers {
    public static void main(String[] args) {
        String version1 = "7.5.3.4", version2 = "7.5.3";
        int ans = compareVersion(version1, version2);
        System.out.println("Ans : " +ans);
    }

    private static int compareVersion(String ver1, String ver2) {
        String[] v1 = ver1.split("\\.");
        String[] v2 = ver2.split("\\.");
        for (int i = 0; i < Math.max(v1.length, v2.length); i++) {
            int n1 = i >= v1.length ? 0 : Integer.parseInt(v1[i]);
            int n2 = i >= v2.length ? 0 : Integer.parseInt(v2[i]);

            if (n1 != n2)
                return n1 > n2 ? 1 : -1;
        }
        return 0;
    }
}
