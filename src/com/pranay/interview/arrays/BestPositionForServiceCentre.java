package com.pranay.interview.arrays;

/**
 * Constraints:
 *
 * 1 <= positions.length <= 50
 * positions[i].length == 2
 * 0 <= positions[i][0], positions[i][1] <= 100
 */

public class BestPositionForServiceCentre {
    public static void main(String[] args) {
        int[][] positions = {{0,1},{1,0},{1,2},{2,1}};
        double minDistance = getMinDistSum(positions);
        System.out.println("Min Distance : " + minDistance);
    }

    private static double getMinDistSum(int[][] positions) {
        double x = 0;
        double y = 0;

        double res = distanceSum(x, y, positions);
        double steps = 50;

        int[][] dirs = {{1, 0},{-1, 0},{0, 1},{0, -1}};

        OUT: while (steps > 0.000001) {
            for (int[] dir: dirs) {
                double nx = x + steps * dir[0];
                double ny = y + steps * dir[1];

                double distance = distanceSum(nx, ny, positions);

                if (distance < res) {
                    res = distance;
                    x = nx;
                    y = ny;
                    continue OUT;
                }
            }
            steps /= 2;
        }
        return res;
    }

    private static double distanceSum(double x, double y, int[][] positions) {
        double res = 0;
        for (int[] p : positions) {
            res += Math.sqrt((p[0] - x) * (p[0] - x) + (p[1] - y) * (p[1] - y));
        }
        return res;
    }
}
