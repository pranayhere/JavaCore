package com.pranay.GeeksForGeeks;

import javafx.util.Pair;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

public class MaxPointsFromCards {
    public static void main(String[] args) {
        int[] cardPoints = {1, 2, 3, 4, 5, 6, 1};
        int k = 3;
        int score = maxScore2(cardPoints, k);
        System.out.println("Score : " + score);
    }

    private static int maxScore(int[] nums, int givenK) {
        Queue<Pair<Pair<Integer, Integer>, Integer>> q = new ArrayDeque<>();
        int score = 0;
        int n = nums.length - 1;
        q.offer(new Pair<>(new Pair<>(0, n), 1));

        int[] leftSum = new int[nums.length];
        int[] rightSum = new int[nums.length];
        leftSum[0] = nums[0];
        rightSum[n] = nums[n];

        for (int i = 1; i <= n; i++) {
            leftSum[i] = nums[i] + leftSum[i - 1];
        }

        for (int i = n - 1; i >= 0; i--) {
            rightSum[i] = nums[i] + rightSum[i + 1];
        }

        while (!q.isEmpty() && q.peek().getValue() <= givenK) {
            System.out.println(q);
            Pair<Pair<Integer, Integer>, Integer> p = q.poll();
            Pair<Integer, Integer> key = p.getKey();
            int l = key.getKey();
            int r = key.getValue();
            int k = p.getValue();

            if (l > n || r < 0) {
                continue;
            }

            score = Math.max(leftSum[l], rightSum[r]);
            System.out.println("currScore = " + score);


            int newL = l + 1;
            int newR = r - 1;
            k++;

            q.offer(new Pair<>(new Pair<>(newL, r), k));
            q.offer(new Pair<>(new Pair<>(l, newR), k));
        }
        return score;
    }

    // sliding window
    public static int maxScore2(int[] cardPoints, int k) {
        int sum = 0;
        int n = cardPoints.length - 1;
        for (int i = n-k+1; i<= n; i++) {
            sum += cardPoints[i];
        }

        int ans = sum;
        for (int i =0; i<k; i++) {
            sum -= cardPoints[n-k+i];
            sum += cardPoints[i];
            ans = Math.max(ans, sum);
        }
        return ans;
    }
}
