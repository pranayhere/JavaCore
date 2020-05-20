package com.pranay.Leetcode31DaysOfMay;

import java.util.Stack;

public class StockSpanner {
//  [100, 80, 60, 70, 60, 75, 85]
    Stack<Integer> prices, weights;

    public StockSpanner() {
        prices = new Stack<>();
        weights = new Stack<>();
    }

    private int next(int price) {
        int w = 1;
        while (!prices.isEmpty() && prices.peek() <= price) {
            prices.pop();
            w += weights.pop();
        }

        prices.push(price);
        weights.push(w);
        System.out.println(prices);
        System.out.println(weights);

        return w;
    }

    public static void main(String[] args) {
        StockSpanner s = new StockSpanner();
        System.out.println(s.next(100));
        System.out.println(s.next(80));
        System.out.println(s.next(60));
        System.out.println(s.next(70));
        System.out.println(s.next(60));
        System.out.println(s.next(75));
        System.out.println(s.next(85));
    }
}
