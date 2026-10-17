package com.pranay.cses.SortingAndSearchingV2;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

/**
 * Local test cases for {@link JosephusProblemII}.
 * Run main: each case feeds input to JosephusProblemII.main and compares stdout,
 * ignoring whether answers are separated by spaces or newlines.
 */
public class JosephusProblemIITest {

    // { name, input, expected output (removal order, separated by spaces) }
    private static final String[][] CASES = {
            {"sample", "7 2\n", "3 6 2 7 5 1 4"},
            {"one child", "1 0\n", "1"},
            {"one child, huge k", "1 1000000000\n", "1"},
            {"k = 0, removed in order", "5 0\n", "1 2 3 4 5"},
            {"k = 1, same as Josephus I", "7 1\n", "2 4 6 1 5 3 7"},
            {"k = n - 1", "5 4\n", "5 1 3 4 2"},
            {"k = n", "5 5\n", "1 3 2 5 4"},
            {"k larger than n", "4 10\n", "3 1 2 4"},
            {"huge k", "6 1000000000\n", "5 6 1 3 4 2"},
            {"ten children, k = 3", "10 3\n", "4 8 2 7 3 10 9 1 6 5"},
            {"two children, odd k", "2 3\n", "2 1"},
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
                JosephusProblemII.main(new String[0]);
            } finally {
                System.setIn(originalIn);
                System.setOut(originalOut);
            }

            // answers may be separated by spaces or newlines, so compare them as tokens
            String actual = out.toString().trim().replaceAll("\\s+", " ");
            boolean ok = actual.equals(expected);
            if (ok) passed++;

            System.out.printf("#%d %-38s %s%n", i + 1, name, ok ? "PASS" : "FAIL");
            if (!ok) {
                System.out.println("   expected: " + expected);
                System.out.println("   got:      " + actual);
            }
        }

        System.out.printf("%n%d/%d passed%n", passed, CASES.length);
    }
}
