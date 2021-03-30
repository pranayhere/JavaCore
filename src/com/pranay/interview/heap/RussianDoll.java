package com.pranay.interview.heap;


import java.util.PriorityQueue;

class Env {
    int w;
    int h;
    int area;

    public Env(int wi, int hi, int ar) {
        w = wi;
        h = hi;
        area = ar;
    }

    @Override
    public String toString() {
        return "Env{" +
                "w=" + w +
                ", h=" + h +
                ", area=" + area +
                '}';
    }
}

public class RussianDoll {
    public static void main(String[] args) {
//        int[][] envelopes = {{5,4},{6,4},{6,7},{2,3}};
        int[][] envelopes = {{2, 100}, {3, 200}, {4, 300}, {5, 500}, {5, 400}, {5, 250}, {6, 370}, {6, 360}, {7, 380}};
        RussianDoll rd = new RussianDoll();
        int ans = rd.maxEnvelopes(envelopes);
        System.out.println(ans);
    }

    public int maxEnvelopes(int[][] envelopes) {
        PriorityQueue<Env> pq = new PriorityQueue<>((a, b) -> a.w == b.w ? a.h - b.h : a.w - b.w);

        for (int[] e : envelopes) {
            pq.offer(new Env(e[0], e[1], e[0] * e[1]));
        }

        int cnt = 0;
        Env max = new Env(-1, -1, -1);

        while (!pq.isEmpty()) {
            Env curr = pq.poll();

            if (curr.h > max.h && curr.w > max.w) {
                cnt++;
                max = curr;
            }

        }

        return cnt;
    }
}
