package com.pranay.cses.SortingAndSearchingV2;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

/**
 * Local test cases for {@link CollectingNumbersII}.
 * Run main: each case feeds input to CollectingNumbersII.main and compares stdout.
 */
public class CollectingNumbersIITest {

    // { name, input, expected output (one line per swap) }
    private static final String[][] CASES = {
            {"sample", "5 3\n4 2 1 5 3\n2 3\n1 5\n2 3\n", "2\n3\n4"},
            {"single number, swap with itself", "1 1\n1\n1 1\n", "1"},
            {"swap a position with itself", "3 2\n3 1 2\n2 2\n1 1\n", "2\n2"},
            {"swap two neighbouring values", "4 1\n1 2 3 4\n2 3\n", "2"},
            {"swap then swap back", "3 2\n2 1 3\n1 2\n1 2\n", "1\n2"},
            {"sort with swaps", "3 1\n3 2 1\n1 3\n", "1"},
            {"swap values that are far apart", "5 1\n1 2 3 4 5\n1 5\n", "3"},
            {"swap x and x+1 when they are adjacent in position", "4 2\n2 1 3 4\n1 2\n2 3\n", "1\n2"},
            {"many swaps", "5 5\n5 3 1 4 2\n1 2\n3 5\n2 4\n1 5\n3 3\n", "3\n4\n3\n2\n2"},
            {"same pair given as b a", "5 2\n4 2 1 5 3\n3 2\n5 1\n", "2\n3"},
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
                CollectingNumbersII.main(new String[0]);
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
