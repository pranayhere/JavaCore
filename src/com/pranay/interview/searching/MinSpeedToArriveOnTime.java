package com.pranay.interview.searching;

public class MinSpeedToArriveOnTime {
    public static void main(String[] args) {
//        int[] dist = {1,3,2};
//        double hour = 2.7;

        int[] dist = {1,1,100000};
        double hour = 2.01;

        int minTime = minSpeedOnTime(dist, hour);
        System.out.println("Min time : " + minTime);
    }

    private static int minSpeedOnTime(int[] dist, double hour) {
        int lo = 1;
        int hi = 10_000_001;

        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (canReach(dist, hour, mid)) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }

        return lo == 10_000_001 ? -1 : lo;
    }

    public static boolean canReach(int[] dist, double hour, int mid) {
        double currTime = 0;
        for (int i = 0; i < dist.length - 1; i++) {
            currTime += Math.ceil((double) dist[i] / mid);
        }

        currTime += (double) dist[dist.length - 1] / mid;
        if (currTime > hour)
            return false;

        return true;
    }
}
