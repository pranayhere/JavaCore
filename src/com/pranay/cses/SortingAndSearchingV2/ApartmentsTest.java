package com.pranay.cses.SortingAndSearchingV2;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

/**
 * Local test cases for {@link Apartments}.
 * Run main: each case feeds input to Apartments.main and compares stdout.
 */
public class ApartmentsTest {

    // { name, input, expected output }
    private static final String[][] CASES = {
            {"sample", "4 3 5\n60 45 80 60\n30 60 75\n", "2"},
            {"apartment inside range", "1 1 5\n50\n52\n", "1"},
            {"apartment far outside range", "1 1 5\n50\n100\n", "0"},
            {"k = 0, exact matches only", "3 3 0\n1 2 3\n3 2 1\n", "3"},
            {"difference exactly k", "2 2 5\n10 20\n15 25\n", "2"},
            {"greedy pairing in order", "3 2 2\n1 5 9\n3 7\n", "2"},
            {"more apartments than applicants", "2 5 1\n100 200\n1 2 3 99 201\n", "2"},
            {"no apartment fits anyone", "3 3 1\n10 20 30\n1 2 3\n", "0"},
            {"duplicate sizes", "3 2 0\n5 5 5\n5 5\n", "2"},
            {"largest k", "2 3 1000000000\n1 1000000000\n1 1 1\n", "2"},
            {"CSES test 18", "5 2 2\n2 2 2 40 50\n40 50\n", "2"},
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
                Apartments.main(new String[0]);
            } finally {
                System.setIn(originalIn);
                System.setOut(originalOut);
            }

            String actual = out.toString().trim();
            boolean ok = actual.equals(expected);
            if (ok) passed++;

            System.out.printf("#%d %-34s expected %-6s got %-6s %s%n",
                    i + 1, name, expected, actual, ok ? "PASS" : "FAIL");
        }

        System.out.printf("%n%d/%d passed%n", passed, CASES.length);
    }
}
