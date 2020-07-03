package com.pranay.interview.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class PrisonCellAfterNDays {
    public static void main(String[] args) {
        int[] cells = {0,0,0,0,0,0,0,0};
        int N = 1000000;
        int[] ans = prisonAfterNDays(cells, N);
        System.out.println(Arrays.toString(ans));
    }

    private static int[] prisonCellsAfterNDays(int[] cells, int N) {
        while (N > 0) {
            N--;
            int[] cells2 = new int[8];
            for (int i = 1; i < 7; i++) {
                cells2[i] = cells[i - 1] == cells[i + 1] ? 1 : 0;
            }
            cells = cells2;
            System.out.println(Arrays.toString(cells));
        }
        return cells;
    }

    // Memo
    private static int[] prisonCellsAfterNDaysMemo (int[] cells, int N) {
        System.out.println(Arrays.toString(cells));
        Map<String, Integer> seen = new HashMap<>();
        while (N > 0) {
            System.out.println("N : " + N);
            int[] cells2 = new int[8];
            seen.put(Arrays.toString(cells), N--);

            for (int i = 1; i < 7; i++) {
                cells2[i] = cells[i - 1] == cells[i + 1] ? 1 : 0;
            }

            cells = cells2;
            System.out.println(Arrays.toString(cells));

            if (seen.containsKey(Arrays.toString(cells))) {
                N %= seen.get(Arrays.toString(cells)) - N;
            }

        }
        System.out.println(seen);
        return cells;
    }

    public static int[] prisonAfterNDays(int[] cells, int N) {
        for (N = (N - 1) % 14 + 1; N > 0; --N) {
            System.out.println("N : " + N);
            int[] cells2 = new int[8];
            for (int i = 1; i < 7; ++i)
                cells2[i] = cells[i - 1] == cells[i + 1] ? 1 : 0;
            cells = cells2;
        }
        return cells;
    }
}
