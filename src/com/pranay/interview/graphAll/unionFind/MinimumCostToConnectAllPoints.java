package com.pranay.interview.graphAll.unionFind;

import java.util.PriorityQueue;

/**
 * 1584. Min Cost to Connect All Points
 * https://leetcode.com/problems/min-cost-to-connect-all-points/
 *
 * This problem is minimum spanning tree (mst) problem where we need to find the minimum cost to connect every point.
 * Step:
 *
 * 1. Consider each point as a single set
 * 2. Get the distance of each point from every point
 * 3. Sort the distance on increasing order because we need to consider the nearest point first (aka: greedy )
 * 4. If two point are not connected already ( i.e. If they are on different set), connect them and add on cost ( cost +=cost[i])
 * 5. Do this till end of the connections.
 */
public class MinimumCostToConnectAllPoints {
    public static void main(String[] args) {
        int[][] points = {{0, 0}, {2, 2}, {3, 10}, {5, 2}, {7, 0}};
        MinimumCostToConnectAllPoints mst = new MinimumCostToConnectAllPoints();
        int cost = mst.minCostConnectPoints(points);
        System.out.println("Min Cost : " + cost);
    }

    int[] parent;

    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        //Store the distnace on min heap
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int dist = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
                pq.add(new int[]{dist, i, j});
            }
        }

        parent = new int[n];
        //Initialize the parent with self
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        int cost = 0;
        int count = n;//to optimize the priority queue look-up
        while (pq.size() > 0 && count > 0) {
            //get min
            int[] curr = pq.remove();
            //We need to consider the new point if they have different parent
            if (getParent(curr[1]) != getParent(curr[2])) {
                cost += curr[0];
                union(curr[1], curr[2]);
                count--;
            }
        }
        return cost;
    }

    public void union(int x, int y) {
        int pX = getParent(x);
        int pY = getParent(y);

        if (pX != pY) {
            parent[pY] = pX;
            parent[y] = pX;
        }
    }

    public int getParent(int x) {
        if(x!=parent[x])
            parent[x] = getParent(parent[x]);
        return parent[x];
    }
}
