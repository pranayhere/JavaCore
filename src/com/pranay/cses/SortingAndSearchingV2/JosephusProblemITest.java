package com.pranay.cses.SortingAndSearchingV2;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

/**
 * Local test cases for {@link JosephusProblemI}.
 * Run main: each case feeds input to JosephusProblemI.main and compares stdout,
 * ignoring whether answers are separated by spaces or newlines.
 */
public class JosephusProblemITest {

    // { name, input, expected output (removal order, separated by spaces) }
    private static final String[][] CASES = {
            {"sample", "7\n", "2 4 6 1 5 3 7"},
            {"one child", "1\n", "1"},
            {"two children", "2\n", "2 1"},
            {"three children", "3\n", "2 1 3"},
            {"four children", "4\n", "2 4 3 1"},
            {"five children", "5\n", "2 4 1 5 3"},
            {"power of two", "8\n", "2 4 6 8 3 7 5 1"},
            {"ten children", "10\n", "2 4 6 8 10 3 7 1 9 5"},
            {"power of two, larger", "16\n", "2 4 6 8 10 12 14 16 3 7 11 15 5 13 9 1"},
            {"odd, larger", "21\n", "2 4 6 8 10 12 14 16 18 20 1 5 9 13 17 21 7 15 3 19 11"},
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
                JosephusProblemI.main(new String[0]);
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
