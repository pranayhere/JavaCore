package com.pranay.cses.SortingAndSearchingV2;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

/**
 * Local test cases for {@link StickLengths}.
 * Run main: each case feeds input to StickLengths.main and compares stdout.
 */
public class StickLengthsTest {

    // { name, input, expected output }
    private static final String[][] CASES = {
            {"sample", "5\n2 3 1 5 2\n", "5"},
            {"single stick", "1\n7\n", "0"},
            {"all equal", "3\n4 4 4\n", "0"},
            {"two sticks", "2\n1 10\n", "9"},
            {"even count", "4\n1 2 3 4\n", "4"},
            {"average is the wrong target", "3\n1 1 100\n", "99"},
            {"unsorted input", "5\n9 1 5 3 7\n", "12"},
            {"duplicates around the middle", "6\n2 2 2 2 9 9\n", "14"},
            {"max gap", "2\n1 1000000000\n", "999999999"},
            {"cost overflows int", "6\n1 1 1 1000000000 1000000000 1000000000\n", "2999999997"},
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
                StickLengths.main(new String[0]);
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
