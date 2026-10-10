package com.pranay.cses.SortingAndSearchingV2;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

/**
 * Local test cases for {@link RestaurantCustomers}.
 * Run main: each case feeds input to RestaurantCustomers.main and compares stdout.
 */
public class RestaurantCustomersTest {

    // { name, input, expected output }
    private static final String[][] CASES = {
            {"sample", "3\n5 8\n2 4\n3 9\n", "2"},
            {"single customer", "1\n1 2\n", "1"},
            {"no overlap", "3\n1 2\n3 4\n5 6\n", "1"},
            {"leaves right before next arrives", "2\n1 3\n4 6\n", "1"},
            {"arrives right before other leaves", "2\n1 4\n3 6\n", "2"},
            {"nested stays", "3\n1 10\n2 9\n3 8\n", "3"},
            {"chain of pairwise overlaps", "3\n1 4\n3 6\n5 8\n", "2"},
            {"all present at one moment", "4\n1 100\n10 50\n20 30\n25 26\n", "4"},
            {"peak early, smaller group later", "5\n1 5\n2 6\n3 7\n8 10\n9 11\n", "3"},
            {"unsorted input", "4\n7 9\n1 3\n2 8\n4 5\n", "2"},
            {"max times", "2\n1 1000000000\n999999998 999999999\n", "2"},
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
                RestaurantCustomers.main(new String[0]);
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
