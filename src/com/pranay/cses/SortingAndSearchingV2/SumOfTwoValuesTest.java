package com.pranay.cses.SortingAndSearchingV2;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

/**
 * Local test cases for {@link SumOfTwoValues}.
 * Any valid pair is accepted, so instead of comparing exact output this checks
 * that the printed positions are distinct, in range, and sum to x.
 */
public class SumOfTwoValuesTest {

    // { name, input, "POSSIBLE" or "IMPOSSIBLE" }
    private static final String[][] CASES = {
            {"sample", "4 8\n2 7 5 1\n", "POSSIBLE"},
            {"single element", "1 5\n5\n", "IMPOSSIBLE"},
            {"no pair sums to x", "3 10\n1 2 3\n", "IMPOSSIBLE"},
            {"x smaller than every value", "3 2\n5 6 7\n", "IMPOSSIBLE"},
            {"same value at two positions", "2 10\n5 5\n", "POSSIBLE"},
            {"x/2 appears once, can't reuse it", "3 10\n5 1 2\n", "IMPOSSIBLE"},
            {"pair at the ends", "5 9\n1 3 3 3 8\n", "POSSIBLE"},
            {"all values equal", "5 4\n2 2 2 2 2\n", "POSSIBLE"},
            {"positions must be original, not sorted", "4 6\n5 3 4 1\n", "POSSIBLE"},
            {"odd target", "4 7\n1 2 3 4\n", "POSSIBLE"},
            {"max values, pair exists", "2 1000000000\n999999999 1\n", "POSSIBLE"},
            {"max values, sum too big", "2 1000000000\n1000000000 1000000000\n", "IMPOSSIBLE"},
    };

    public static void main(String[] args) throws Exception {
        InputStream originalIn = System.in;
        PrintStream originalOut = System.out;
        int passed = 0;

        for (int i = 0; i < CASES.length; i++) {
            String name = CASES[i][0], input = CASES[i][1], expected = CASES[i][2];

            ByteArrayOutputStream out = new ByteArrayOutputStream();
            System.setIn(new ByteArrayInputStream(input.getBytes()));
            System.setOut(new PrintStream(out));
            try {
                SumOfTwoValues.main(new String[0]);
            } finally {
                System.setIn(originalIn);
                System.setOut(originalOut);
            }

            String actual = out.toString().replace("\r\n", "\n").trim();
            String error = check(input, expected, actual);
            if (error == null) passed++;

            System.out.printf("#%d %-40s %s%n", i + 1, name, error == null ? "PASS" : "FAIL");
            if (error != null) {
                System.out.println("   " + error);
            }
        }

        System.out.printf("%n%d/%d passed%n", passed, CASES.length);
    }

    // returns null if the output is a valid answer, otherwise the reason it isn't
    private static String check(String input, String expected, String actual) {
        String[] tok = input.trim().split("\\s+");
        int n = Integer.parseInt(tok[0]);
        long x = Long.parseLong(tok[1]);
        long[] a = new long[n];
        for (int k = 0; k < n; k++) {
            a[k] = Long.parseLong(tok[2 + k]);
        }

        if (expected.equals("IMPOSSIBLE")) {
            return actual.equals("IMPOSSIBLE") ? null : "expected IMPOSSIBLE, got: " + actual;
        }

        String[] p = actual.split("\\s+");
        if (p.length != 2) {
            return "expected two positions, got: " + actual;
        }
        int i, j;
        try {
            i = Integer.parseInt(p[0]);
            j = Integer.parseInt(p[1]);
        } catch (NumberFormatException e) {
            return "expected two positions, got: " + actual;
        }
        if (i < 1 || i > n || j < 1 || j > n) {
            return "position out of range 1.." + n + ": " + actual;
        }
        if (i == j) {
            return "positions must be distinct: " + actual;
        }
        if (a[i - 1] + a[j - 1] != x) {
            return "a[" + i + "] + a[" + j + "] = " + (a[i - 1] + a[j - 1]) + ", not " + x;
        }
        return null;
    }
}
