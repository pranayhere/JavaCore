package com.pranay.interview.arrays.permutation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class ReinitializePermutation {
    public static void main(String[] args) {
        int n = 4;
        int ans = reinitializePermutation(n);
        System.out.println("Ans : " + ans);
    }
    public static int reinitializePermutation(int n) {
        HashSet<List<Integer>> hs = new HashSet<>();

        List<Integer> p = new ArrayList<>();
        for (int i = 0; i < n; i++)
            p.add(i);


        hs.add(new ArrayList<>(p));
        int cnt = 0;

        for (int i = 0; i < n; i++) {
            if (i > 0 && i % 2 == 0) {
                int temp = p.get(i / 2);
                int temp2 = p.get(i);
                p.remove(i / 2);
                p.add(i / 2,  p.get(i));
                p.add(i, temp);
                cnt++;
            } if (i % 2 == 1) {
                int temp = p.get(n / 2 + (i - 1) / 2);
                p.add(n / 2 + (i - 1) / 2, p.get(i));
                p.add(i, temp);
                cnt++;
            }

            System.out.println(p);

            if (cnt > 0 && hs.contains(p))
                break;
        }

        return cnt;
    }
}
