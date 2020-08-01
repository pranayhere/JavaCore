package com.pranay.interview.greedy;

/**
 * 134. Gas Station
 * https://leetcode.com/problems/gas-station/
 */
public class GasStation {
    public static void main(String[] args) {
        int[] gas  = {1,2,3,4,5};
        int[] cost = {3,4,5,1,2};

        int startIndex = canCompleteCircuit(gas, cost);
        System.out.println("Start Index : " + startIndex);
    }

    private static int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int totalTank = 0;
        int currTank = 0;
        int startIdx = 0;

        for (int i = 0; i < n; i++) {
            totalTank += gas[i] - cost[i];
            currTank += gas[i] - cost[i];

            if (currTank < 0) {
                startIdx = i + 1;
                currTank = 0;
            }
        }
        return totalTank >= 0 ? startIdx : -1;
    }
}
