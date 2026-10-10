package com.pranay.cses.SortingAndSearchingV2;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

/**
 * Local test cases for {@link ConcertTickets}.
 * Run main: each case feeds input to ConcertTickets.main and compares stdout.
 */
public class ConcertTicketsTest {

    // { name, input, expected output (one line per customer) }
    private static final String[][] CASES = {
            {"sample", "5 3\n5 3 7 8 5\n4 8 3\n", "3\n8\n-1"},
            {"exact price match", "1 1\n5\n5\n", "5"},
            {"every budget too low", "2 2\n5 6\n1 4\n", "-1\n-1"},
            {"tickets run out", "1 3\n5\n10 10 10\n", "5\n-1\n-1"},
            {"duplicate prices", "3 3\n5 5 5\n5 5 5\n", "5\n5\n5"},
            {"duplicates then sold out", "2 3\n5 5\n6 6 6\n", "5\n5\n-1"},
            {"nearest lower price each time", "4 3\n1 4 6 9\n8 8 8\n", "6\n4\n1"},
            {"arrival order matters", "3 3\n2 4 6\n3 7 5\n", "2\n6\n4"},
            {"more tickets than customers", "5 2\n10 20 30 40 50\n35 100\n", "30\n50"},
            {"cheapest gone, later customer fails", "3 4\n3 3 10\n2 10 10 3\n", "-1\n10\n3\n3"},
            {"max values", "2 2\n1000000000 1\n1000000000 999999999\n", "1000000000\n1"},
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
                ConcertTickets.main(new String[0]);
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
