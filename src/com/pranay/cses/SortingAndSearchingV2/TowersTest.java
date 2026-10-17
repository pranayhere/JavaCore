package com.pranay.cses.SortingAndSearchingV2;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

/**
 * Local test cases for {@link Towers}.
 * Run main: each case feeds input to Towers.main and compares stdout.
 */
public class TowersTest {

    // { name, input, expected output }
    private static final String[][] CASES = {
            {"sample", "5\n3 8 2 1 5\n", "2"},
            {"single cube", "1\n4\n", "1"},
            {"strictly decreasing, one tower", "5\n5 4 3 2 1\n", "1"},
            {"strictly increasing, one tower each", "5\n1 2 3 4 5\n", "5"},
            {"equal cubes can't stack", "3\n3 3 3\n", "3"},
            {"equal then smaller", "4\n5 5 4 4\n", "2"},
            {"largest top that fits is the wrong choice", "6\n3 6 2 5 1 3\n", "2"},
            {"two interleaved decreasing runs", "6\n5 10 4 9 3 8\n", "2"},
            {"new tower only when nothing fits", "6\n2 1 3 2 4 3\n", "3"},
            {"large sizes", "4\n1000000000 1 1000000000 999999999\n", "2"},
            {"all ones", "5\n1 1 1 1 1\n", "5"},
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
                Towers.main(new String[0]);
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
