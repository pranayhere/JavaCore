package com.pranay.cses.SortingAndSearchingV2;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

/**
 * Local test cases for {@link MaximumSubarraySum}.
 * Run main: each case feeds input to MaximumSubarraySum.main and compares stdout.
 */
public class MaximumSubarraySumTest {

    // { name, input, expected output }
    private static final String[][] CASES = {
            {"sample", "8\n-1 3 -2 5 3 -5 2 2\n", "9"},
            {"single positive", "1\n5\n", "5"},
            {"single negative", "1\n-5\n", "-5"},
            {"all negative, pick the largest", "3\n-3 -1 -2\n", "-1"},
            {"all positive, take everything", "4\n1 2 3 4\n", "10"},
            {"all zeros", "3\n0 0 0\n", "0"},
            {"negatives and a zero", "3\n-1 0 -2\n", "0"},
            {"restart after a big drop", "5\n2 -10 3 4 -1\n", "7"},
            {"small dip worth crossing", "5\n5 -2 5 -20 3\n", "8"},
            {"whole array is best", "3\n4 -1 4\n", "7"},
            {"sum overflows int", "3\n1000000000 1000000000 1000000000\n", "3000000000"},
            {"min values", "2\n-1000000000 -1000000000\n", "-1000000000"},
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
                MaximumSubarraySum.main(new String[0]);
            } finally {
                System.setIn(originalIn);
                System.setOut(originalOut);
            }

            String actual = out.toString().replace("\r\n", "\n").trim();
            boolean ok = actual.equals(expected);
            if (ok) passed++;

            System.out.printf("#%d %-38s %s%n", i + 1, name, ok ? "PASS" : "FAIL");
            if (!ok) {
                System.out.println("   expected: " + expected.replace("\n", " "));
                System.out.println("   got:      " + actual.replace("\n", " "));
            }
        }

        System.out.printf("%n%d/%d passed%n", passed, CASES.length);
    }
}
