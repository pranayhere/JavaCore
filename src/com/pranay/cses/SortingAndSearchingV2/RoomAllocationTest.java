package com.pranay.cses.SortingAndSearchingV2;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Local test cases for {@link RoomAllocation}.
 * Any valid allocation is accepted, so instead of comparing exact output this
 * checks that k is the minimum, every room number is in 1..k, and no two
 * customers in the same room overlap (a room is free again only from the day
 * after a departure).
 */
public class RoomAllocationTest {

    // { name, input }
    private static final String[][] CASES = {
            {"sample", "3\n1 2\n2 4\n4 4\n"},
            {"single customer", "1\n5 5\n"},
            {"same single day, three customers", "3\n1 1\n1 1\n1 1\n"},
            {"no overlap", "3\n1 2\n3 4\n5 6\n"},
            {"departure day equals next arrival", "2\n2 3\n3 4\n"},
            {"next arrival is the day after departure", "2\n1 2\n3 4\n"},
            {"nested stays", "3\n1 10\n2 9\n3 8\n"},
            {"unsorted input", "4\n5 6\n1 2\n3 4\n1 6\n"},
            {"room freed then reused", "4\n1 3\n2 5\n4 6\n6 7\n"},
            {"many short stays inside one long stay", "5\n1 100\n2 3\n4 5\n6 7\n8 9\n"},
            {"large days", "3\n1 1000000000\n999999999 1000000000\n1000000000 1000000000\n"},
            {"duplicates mixed with others", "6\n1 2\n1 2\n3 3\n2 3\n4 5\n4 5\n"},
    };

    public static void main(String[] args) throws Exception {
        InputStream originalIn = System.in;
        PrintStream originalOut = System.out;
        int passed = 0;

        for (int i = 0; i < CASES.length; i++) {
            String name = CASES[i][0], input = CASES[i][1];

            ByteArrayOutputStream out = new ByteArrayOutputStream();
            System.setIn(new ByteArrayInputStream(input.getBytes()));
            System.setOut(new PrintStream(out));
            try {
                RoomAllocation.main(new String[0]);
            } finally {
                System.setIn(originalIn);
                System.setOut(originalOut);
            }

            String actual = out.toString().trim();
            String error = check(input, actual);
            if (error == null) passed++;

            System.out.printf("#%d %-40s %s%n", i + 1, name, error == null ? "PASS" : "FAIL");
            if (error != null) {
                System.out.println("   " + error);
            }
        }

        System.out.printf("%n%d/%d passed%n", passed, CASES.length);
    }

    // returns null if the output is a valid optimal allocation, otherwise the reason it isn't
    static String check(String input, String actual) {
        String[] tok = input.trim().split("\\s+");
        int n = Integer.parseInt(tok[0]);
        long[] a = new long[n], b = new long[n];
        for (int i = 0; i < n; i++) {
            a[i] = Long.parseLong(tok[1 + 2 * i]);
            b[i] = Long.parseLong(tok[2 + 2 * i]);
        }
        int best = minRooms(a, b);

        if (actual.isEmpty()) {
            return "no output";
        }
        String[] out = actual.split("\\s+");
        int k;
        try {
            k = Integer.parseInt(out[0]);
        } catch (NumberFormatException e) {
            return "first value should be k, got: " + out[0];
        }
        if (k != best) {
            return "k = " + k + ", but the minimum is " + best;
        }
        if (out.length != n + 1) {
            return "expected " + n + " room numbers after k, got " + (out.length - 1);
        }

        List<List<Integer>> rooms = new ArrayList<>();
        for (int r = 0; r <= k; r++) rooms.add(new ArrayList<>());
        for (int i = 0; i < n; i++) {
            int r;
            try {
                r = Integer.parseInt(out[1 + i]);
            } catch (NumberFormatException e) {
                return "room number is not an integer: " + out[1 + i];
            }
            if (r < 1 || r > k) {
                return "customer " + (i + 1) + " got room " + r + ", outside 1.." + k;
            }
            rooms.get(r).add(i);
        }

        for (int r = 1; r <= k; r++) {
            List<Integer> g = rooms.get(r);
            g.sort((x, y) -> Long.compare(a[x], a[y]));
            for (int j = 1; j < g.size(); j++) {
                int p = g.get(j - 1), c = g.get(j);
                if (b[p] >= a[c]) {
                    return "room " + r + ": customer " + (p + 1) + " [" + a[p] + ", " + b[p] + "] and customer "
                            + (c + 1) + " [" + a[c] + ", " + b[c] + "] overlap";
                }
            }
        }
        return null;
    }

    // the most customers present on any single day (both a and b count as present)
    static int minRooms(long[] a, long[] b) {
        int n = a.length;
        long[] start = a.clone(), end = b.clone();
        Arrays.sort(start);
        Arrays.sort(end);
        int i = 0, j = 0, cur = 0, best = 0;
        while (i < n) {
            if (start[i] <= end[j]) {   // arrival on the departure day still overlaps
                cur++;
                best = Math.max(best, cur);
                i++;
            } else {
                cur--;
                j++;
            }
        }
        return best;
    }
}
