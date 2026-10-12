package com.pranay.cses.SortingAndSearchingV2;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

/**
 * Local test cases for {@link MovieFestival}.
 * Run main: each case feeds input to MovieFestival.main and compares stdout.
 */
public class MovieFestivalTest {

    // { name, input, expected output }
    private static final String[][] CASES = {
            {"sample", "3\n3 5\n4 9\n5 8\n", "2"},
            {"single movie", "1\n1 2\n", "1"},
            {"end time equals next start", "3\n1 2\n2 3\n3 4\n", "3"},
            {"all overlap", "3\n1 10\n2 9\n3 8\n", "1"},
            {"one long vs two short", "3\n1 100\n2 3\n4 5\n", "2"},
            {"earliest start is a trap", "3\n1 10\n2 4\n5 7\n", "2"},
            {"shortest movie is a trap", "3\n1 5\n4 7\n6 10\n", "2"},
            {"identical movies", "3\n1 3\n1 3\n1 3\n", "1"},
            {"same end time", "3\n1 5\n2 5\n5 6\n", "2"},
            {"unsorted, all disjoint", "4\n7 8\n1 2\n5 6\n3 4\n", "4"},
            {"nested and chained", "4\n1 4\n2 3\n3 6\n5 7\n", "2"},
            {"max times", "2\n1 1000000000\n999999999 1000000000\n", "1"},
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
                MovieFestival.main(new String[0]);
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
