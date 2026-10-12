package com.pranay.cses.SortingAndSearchingV2;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

/**
 * Local test cases for {@link MissingCoinSum}.
 * Run main: each case feeds input to MissingCoinSum.main and compares stdout.
 */
public class MissingCoinSumTest {

    // { name, input, expected output }
    private static final String[][] CASES = {
            {"sample", "5\n2 9 1 2 7\n", "6"},
            {"single coin of 1", "1\n1\n", "2"},
            {"single coin of 2", "1\n2\n", "1"},
            {"no coin of 1", "3\n2 3 4\n", "1"},
            {"powers of two", "4\n1 2 4 8\n", "16"},
            {"all ones", "5\n1 1 1 1 1\n", "6"},
            {"gap after a few coins", "3\n1 2 5\n", "4"},
            {"coin exactly one above reachable sum", "3\n1 2 4\n", "8"},
            {"unsorted input", "5\n8 1 4 2 1\n", "17"},
            {"max values only", "2\n1000000000 1000000000\n", "1"},
            {"answer overflows int", "32\n1 2 4 8 16 32 64 128 256 512 1024 2048 4096 8192 16384 32768 65536 131072 262144 524288 1048576 2097152 4194304 8388608 16777216 33554432 67108864 134217728 268435456 536870912 1000000000 1000000000\n", "3073741824"},
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
                MissingCoinSum.main(new String[0]);
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
