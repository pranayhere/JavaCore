package com.pranay.Leetcode31DaysOfMay;

public class CheckStraightLine {
    public static void main(String[] args) {
        int[][] coordinates = {{1,2}, {2,3}, {3,4}};
        boolean ans = checkStraightLine(coordinates);
        System.out.println("Ans : " + ans);
    }

    private static boolean checkStraightLine(int[][] coordinates) {
        int[] point1 = coordinates[1];
        int[] point2 = coordinates[0];
        float gSlope = slope(point1, point2);

        for (int i = 1; i < coordinates.length; i++) {
            int[] p1 = coordinates[i];
            int[] p2 = coordinates[0];
            float slop = slope(p1, p2);

            if (gSlope != slop)
                return false;
        }
        return true;
    }

    private static float slope(int[] p1, int[] p2) {
        if ((p1[0] - p2[0]) == 0) return 0;
        return (float)(p2[1] - p1[1]) / (p2[0] - p1[0]);
    }

}
