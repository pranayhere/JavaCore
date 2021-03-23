package com.pranay.interview.heap;

import java.util.Arrays;
import java.util.PriorityQueue;

public class NumberOfOrdersInBacklog {
    public static void main(String[] args) {
        int[][] orders = {{944925198,885003661,0},{852263791,981056352,0},{16300530,415829909,0},{940927944,713835606,0},{606389372,407474168,1},{139563740,85382287,1},{700244880,901922025,1},{972900669,15506445,0},{576578542,65339074,0},{45972021,293765308,0},{464403992,97750995,0},{29659852,536508041,0},{799523481,299864737,0},{711908211,480514887,1},{354125407,677598767,1},{279004011,688916331,0},{263524013,64622178,0},{375395974,460070320,0},{971786816,379275200,1},{577774472,214070125,1},{987757349,711231195,0}};
        int backlog = getNumberOfBacklogOrders(orders);
        System.out.println("Ans : " + backlog);
    }

    private static int getNumberOfBacklogOrders(int[][] orders) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[0] - a[0]);

        for (int[] order: orders) {
            if (order[2] == 0) { // buy order
                if (minHeap.isEmpty()) {
                    maxHeap.add(order);
                } else {
                    while (order[1] > 0 && !minHeap.isEmpty() && minHeap.peek()[0] <= order[0]) {
                        int[] sellOrder = minHeap.poll();

                        if (sellOrder[1] > order[1]) {
                            sellOrder[1] = sellOrder[1] - order[1];
                            minHeap.add(sellOrder);
                            order[1] = 0;
                        } else {
                            order[1] = order[1] - sellOrder[1];
                        }
                    }

                    if (order[1] > 0)
                        maxHeap.add(order);
                }
            }

            if (order[2] == 1) { // sell order
                if (maxHeap.isEmpty()) {
                    minHeap.add(order);
                } else {
                    while (order[1] > 0 && !maxHeap.isEmpty() && maxHeap.peek()[0] >= order[0]) {
                        int[] buyOrder = maxHeap.poll();

                        if (buyOrder[1] > order[1]) {
                            buyOrder[1] = buyOrder[1] - order[1];
                            maxHeap.add(buyOrder);
                            order[1] = 0;
                        } else {
                            order[1] = order[1] - buyOrder[1];
                        }
                    }

                    if (order[1] > 0)
                        minHeap.add(order);
                }
            }
        }

        long ans = 0;

        while (!maxHeap.isEmpty()) {
            int[] arr = maxHeap.poll();
            System.out.println("buy: " + Arrays.toString(arr));
            ans += arr[1];
        }

        while (!minHeap.isEmpty()) {
            int[] arr = minHeap.poll();
            System.out.println("sell: " + Arrays.toString(arr));
            ans += arr[1];
        }

        System.out.println("ans : " + ans);
        return (int) (ans % 1_000_000_007);
    }
}
