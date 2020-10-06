package com.pranay.interview.hashing;

import java.util.ArrayList;
import java.util.List;

public class BusiestServer {
    public static void main(String[] args) {
        int k = 3;
        int[] arrival = {1, 2, 3, 4, 5};
        int[] load = {5, 2, 3, 3, 3};

        List<Integer> ans = busiestServers(k, arrival, load);
        System.out.println("Ans : " + ans);
    }

    private static List<Integer> busiestServers(int k, int[] arrival, int[] load) {
        int[] count = new int[k];
        int[] busy = new int[k];

        for (int i = 0; i < arrival.length; i++) {
            int server = i % k;
            int curr = server;
            boolean moved = false;

            while (arrival[i] < busy[server]) {
                server++;
                server %= k;
                moved = true;
                if (curr == server)
                    break;
            }

            if (moved && curr == server)
                continue;

            busy[server] = load[i] + arrival[i];
            count[server]++;
        }

        int max = 0;
        for (int i = 0; i < count.length; i++) {
            max = Math.max(max, count[i]);
        }


        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < count.length; i++) {
            if (count[i] == max)
                ans.add(i);
        }
        return ans;
    }
}
