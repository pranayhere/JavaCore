package com.pranay.cses.SortingAndSearchingV2;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

/**
 * Local test cases for {@link CollectingNumbers}.
 * Run main: each case feeds input to CollectingNumbers.main and compares stdout.
 */
public class CollectingNumbersTest {

    // { name, input, expected output }
    private static final String[][] CASES = {
            {"sample", "5\n4 2 1 5 3\n", "3"},
            {"single number", "1\n1\n", "1"},
            {"already sorted", "5\n1 2 3 4 5\n", "1"},
            {"reverse order", "5\n5 4 3 2 1\n", "5"},
            {"two numbers swapped", "2\n2 1\n", "2"},
            {"pairs swapped", "6\n2 1 4 3 6 5\n", "4"},
            {"one number out of place at the end", "5\n2 3 4 5 1\n", "2"},
            {"one number out of place at the start", "5\n5 1 2 3 4\n", "2"},
            {"interleaved halves", "6\n4 1 5 2 6 3\n", "2"},
            {"increasing runs", "8\n3 4 1 2 7 8 5 6\n", "3"},
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
                CollectingNumbers.main(new String[0]);
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
