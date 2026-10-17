package com.pranay.cses.SortingAndSearchingV2;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

/**
 * Local test cases for {@link DistinctValuesSubarrays}.
 * Run main: each case feeds input to DistinctValuesSubarrays.main and compares stdout.
 */
public class DistinctValuesSubarraysTest {

    // { name, input, expected output }
    private static final String[][] CASES = {
            {"sample", "4\n1 2 1 3\n", "8"},
            {"your example", "8\n1 2 3 2 4 5 6 5\n", "22"},
            {"single element", "1\n7\n", "1"},
            {"all distinct", "5\n1 2 3 4 5\n", "15"},
            {"all equal", "4\n4 4 4 4\n", "4"},
            {"repeat right next to each other", "4\n1 2 2 3\n", "6"},
            {"old repeat before window start (abba)", "4\n1 2 2 1\n", "6"},
            {"alternating two values", "5\n1 2 1 2 1\n", "9"},
            {"large values", "4\n1000000000 1 1000000000 999999999\n", "8"},
            {"random small", "10\n4 4 4 2 2 4 2 1 4 3\n", "20"},
            {"answer overflows int (n = 200000, all distinct)", distinctInput(200000), "20000100000"},
    };

    // n followed by 1 2 ... n: every subarray is distinct, answer n(n+1)/2
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
                DistinctValuesSubarrays.main(new String[0]);
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
