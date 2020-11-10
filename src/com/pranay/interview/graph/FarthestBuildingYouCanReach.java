package com.pranay.interview.graph;

import java.util.PriorityQueue;

/**
 * 1642. Furthest Building You Can Reach
 * https://leetcode.com/problems/furthest-building-you-can-reach/
 *
 * Greedy soluton may be wrong.
 * LeetCode messed up the test cases again.
 *
 *
 * Explanation
 * Heap heap store k height difference that we need to use ladders.
 * Each move, if the height difference d > 0,
 * we push d into the priority queue pq.
 * If the size of queue exceed ladders,
 * it means we have to use bricks for one move.
 * Then we pop out the smallest difference, and reduce bricks.
 * If bricks < 0, we can't make this move, then we return current index i.
 * If we can reach the last building, we return A.length - 1.
 *
 *
 * Complexity
 * Time O(NlogK)
 * Space O(K)
 */
public class FarthestBuildingYouCanReach {
    public static void main(String[] args) {
        int[] heights = {14,3,19,3};
        int bricks = 17, ladders = 0;

        FarthestBuildingYouCanReach fb = new FarthestBuildingYouCanReach();
        int buildingNo = fb.furthestBuilding(heights, bricks, ladders);
        System.out.println("farthest building : " + buildingNo);
    }

    int max = 0;
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        dfs(heights, bricks, ladders, 0);
        return max;
    }

    public void dfs(int[] heights, int bricks, int ladders, int i) {
        if (i == heights.length) {
            max = i - 1;
            return;
        }


        if (i < heights.length - 1 && ladders == 0 && bricks < heights[i + 1] - heights[i]) {
            max = Math.max(max, i);
            return;
        }

        if (i < heights.length - 1 && heights[i + 1] > heights[i]) {
            if (bricks - (heights[i + 1] - heights[i]) >= 0)
                dfs(heights, bricks - (heights[i + 1] - heights[i]), ladders, i + 1);
            if (ladders - 1 >= 0)
                dfs(heights, bricks, ladders - 1, i + 1);
        } else {
            dfs(heights, bricks, ladders, i + 1);
        }
    }

    public int furthestBuildingOptimised(int[] A, int bricks, int ladders) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < A.length - 1; i++) {
            int d = A[i + 1] - A[i];
            if (d > 0)
                pq.add(d);

            if (pq.size() > ladders)
                bricks -= pq.poll();

            if (bricks < 0)
                return i;
        }

        return A.length - 1;
    }
}
