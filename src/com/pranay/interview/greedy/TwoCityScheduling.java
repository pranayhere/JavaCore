package com.pranay.interview.greedy;

import java.util.Arrays;
import java.util.Comparator;

// https://leetcode.com/problems/two-city-scheduling/solution/
public class TwoCityScheduling {
    public static void main(String[] args) {
        int[][] costs = {{10,20},{30,200},{400,50},{30,20}};
        int minCost = twoCitySchedCost2(costs);
        System.out.println("Min cost : " +minCost);
    }

    private static int twoCitySchedCost(int[][] costs) {

        Arrays.sort(costs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return (o1[0] - o1[1]) - (o2[0] - o2[1]);
            }
        });
        for (int[] cost: costs) {
            System.out.println(Arrays.toString(cost));
        }

        int total = 0;
        int n = costs.length / 2;

        for (int i = 0; i < n; i++) {
            total += costs[i][0] + costs[i+n][1];
        }
        return total;
    }

    /**
     * EXPLANATION:-
     * The problem is to send n persons to city A
     * and n persons to city B with minimum cost.
     *
     * The idea is to send each person to city A.
     * costs = [[10,20],[30,200],[400,50],[30,20]]
     *
     * So, totalCost = 10 + 30 + 400 + 30 = 470
     *
     * Now, we need to send n persons to city B.
     * Which persons do we need to send city B?
     *
     * Here, we need to minimize the cost.
     * We have already paid money to go to city A.
     * So, Send the persons to city B who get more refund
     * so that our cost will be minimized.
     *
     * So, maintain refunds of each person
     * refund[i] = cost[i][1] - cost[i][0]
     *
     * So, refunds of each person
     *     refund = [10, 170, -350, -10]
     *
     * Here, refund +ve means we need to pay
     *              -ve means we will get refund.
     *
     * So, sort the refund array.
     *
     * refund = [-350, -10, 10, 170]
     *
     * Now, get refund for N persons,
     * totalCost += 470 + -350 + -10 = 110
     *
     * So, minimum cost is 110
     */
    private static int twoCitySchedCost2(int[][] costs) {
        int totalCost = 0;
        int[] refund = new int[costs.length];
        for (int i = 0; i<costs.length; i++) {
            totalCost += costs[i][0];
        }

        for (int i = 0; i<costs.length; i++) {
            refund[i] = costs[i][1] - costs[i][0];
        }

        Arrays.sort(refund);
        int n = costs.length / 2;
        for (int i = 0; i<n; i++) {
            totalCost += refund[i];
        }
        return totalCost;
    }
}
