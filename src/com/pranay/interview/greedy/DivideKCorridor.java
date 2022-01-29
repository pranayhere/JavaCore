package com.pranay.interview.greedy;

import java.util.ArrayList;
import java.util.List;

public class DivideKCorridor {
    public static void main(String[] args) {
        String corridor = "SSPPSPS";

        DivideKCorridor dc = new DivideKCorridor();
        int ans = dc.numberOfWays(corridor);
        System.out.println("No Of ways : " + ans);
    }

    public int numberOfWays(String corridor) {
        int mod = 1_000_000_000;

        List<Integer> seats = new ArrayList<>();
        for (int i = 0; i < corridor.length(); i++) {
            if (corridor.charAt(i) == 'S')
                seats.add(i);
        }

        if (seats.size() % 2 == 1 || seats.size() == 0) {
            return 0;
        }

        int ans = 1;
        int prev = seats.get(1);

        for (int i = 2; i < seats.size(); i += 2) {
            int length = seats.get(i) - prev;
            ans = (ans * length) % mod;

            prev = seats.get(i + 1);
        }

        return ans;
    }
}
