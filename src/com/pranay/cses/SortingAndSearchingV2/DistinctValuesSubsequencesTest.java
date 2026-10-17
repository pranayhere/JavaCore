package com.pranay.cses.SortingAndSearchingV2;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

/**
 * Local test cases for {@link DistinctValuesSubsequences}.
 * Run main: each case feeds input to DistinctValuesSubsequences.main and compares stdout.
 */
public class DistinctValuesSubsequencesTest {

    // { name, input, expected output }
    private static final String[][] CASES = {
            {"sample", "4\n1 2 1 3\n", "11"},
            {"single element", "1\n7\n", "1"},
            {"all distinct", "5\n1 2 3 4 5\n", "31"},
            {"all equal", "4\n4 4 4 4\n", "4"},
            {"two values, repeated", "5\n1 2 1 2 1\n", "11"},
            {"each value twice", "6\n3 1 2 3 2 1\n", "26"},
            {"large values", "4\n1000000000 1 1000000000 999999999\n", "11"},
            {"random small", "12\n3 3 1 4 2 1 2 1 3 4 2 4\n", "255"},
            {"modulo needed (n = 200000, all distinct)", distinctInput(200000), "175895281"},
            {"n = 200000, all equal", sameInput(200000), "200000"},
    };

    // n followed by n copies of 1: only the n single-element subsequences are distinct
    private static String sameInput(int n) {
        StringBuilder sb = new StringBuilder().append(n).append('\n');
        for (int i = 1; i <= n; i++) {
            sb.append("1 ");
        }
        return sb.append('\n').toString();
    }

    // n followed by 1 2 ... n: every subsequence is distinct, answer 2^n - 1 (mod 10^9+7)
    private static String distinctInput(int n) {
        StringBuilder sb = new StringBuilder().append(n).append('\n');
        for (int i = 1; i <= n; i++) {
            sb.append(i).append(' ');
        }
        return sb.append('\n').toString();
    }

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
                DistinctValuesSubsequences.main(new String[0]);
            } finally {
                System.setIn(originalIn);
                System.setOut(originalOut);
            }

            String actual = out.toString().replace("\r\n", "\n").trim();
            boolean ok = actual.equals(expected);
            if (ok) passed++;

            System.out.printf("#%d %-50s %s%n", i + 1, name, ok ? "PASS" : "FAIL");
            if (!ok) {
                System.out.println("   expected: " + expected.replace("\n", " "));
                System.out.println("   got:      " + actual.replace("\n", " "));
            }
        }

        System.out.printf("%n%d/%d passed%n", passed, CASES.length);
    }
}
