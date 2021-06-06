package com.pranay.interview.heap;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/minimum-cost-to-hire-k-workers/
 */

class Worker {
    int quality;
    int wage;
    int ratio;

    public Worker (int q, int w) {
        quality = q;
        wage = w;
        ratio = w / q;
    }

    @Override
    public String toString() {
        return "Worker{" +
                "quality=" + quality +
                ", wage=" + wage +
                ", ratio=" + ratio +
                '}';
    }
}

public class MinCostToHireKWorkers {
    public static void main(String[] args) {
        int[] quality = {10,20,5};
        int[] wage = {70,50,30};
        int K = 2;

        double cost = mincostToHireWorkersHeap(quality, wage, K);
        System.out.println("Min cost : " + cost);
    }

//    private static double mincostToHireWorkers(int[] quality, int[] wage, int K) {
//        int minCost = Integer.MAX_VALUE;
//        int N = quality.length;
//
//        for (int captain = 0; captain < N; captain++) {
//            double factor = (double) wage[captain]/quality[captain];
//
//            List<Double> prices = new ArrayList<>();
//
//            for (int worker = 0; worker < N; worker++) {
//                double price = quality[worker] * factor;
//                if (price < wage[worker])
//                    continue;
//                prices.add(price);
//            }
//
//            if (prices.size() < K)
//                continue;
//
//            Collections.sort(prices);
//            int cost = 0;
//            for (int i = 0; i < K; i++) {
//                cost += prices.get(i);
//            }
//            minCost = Math.min(cost, minCost);
//        }
//        return minCost;
//    }

    private static double mincostToHireWorkersHeap(int[] quality, int[] wage, int K) {
        double minCost = 1e9;
        List<Worker> workers = new ArrayList<>();
        int N = quality.length;
        for (int i = 0; i < N; i++) {
            workers.add(new Worker(quality[i], wage[i]));
        }

        workers.sort((a, b) -> a.ratio - b.ratio);

        System.out.println(workers);
        PriorityQueue<Worker> maxHeap = new PriorityQueue<>((a, b) -> (b.quality - a.quality));
        int totalQuality = 0;

        for (Worker w: workers) {
            maxHeap.offer(w);
            totalQuality += w.quality;

            if (maxHeap.size() > K) {
                Worker polled = maxHeap.poll();
                totalQuality -= polled.quality;
            }

            System.out.println(totalQuality + " - " + w.ratio);
            if (maxHeap.size() == K) {
                minCost = Math.min(totalQuality * w.ratio, minCost);
            }
            System.out.println(maxHeap);
        }
        return minCost;
    }
}