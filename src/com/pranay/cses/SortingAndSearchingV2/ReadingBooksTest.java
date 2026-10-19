package com.pranay.cses.SortingAndSearchingV2;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

/**
 * Local test cases for {@link ReadingBooks}.
 * Run main: each case feeds input to ReadingBooks.main and compares stdout.
 */
public class ReadingBooksTest {

    // { name, input, expected output }
    private static final String[][] CASES = {
            {"sample", "3\n2 8 3\n", "16"},
            {"single book", "1\n5\n", "10"},
            {"two equal books", "2\n4 4\n", "8"},
            {"all equal", "3\n2 2 2\n", "6"},
            {"one book longer than all others together", "3\n1 1 10\n", "20"},
            {"no dominant book", "4\n3 3 3 4\n", "13"},
            {"longest equals the rest", "3\n2 3 5\n", "10"},
            {"unsorted", "4\n7 1 4 2\n", "14"},
            {"two max books, overflows int", "2\n1000000000 1000000000\n", "2000000000"},
            {"sum overflows int (n = 200000, t = 10^9)", maxInput(200000), "200000000000000"},
    };

    // n books, each taking 10^9
    private static String maxInput(int n) {
        StringBuilder sb = new StringBuilder().append(n).append('\n');
        for (int i = 0; i < n; i++) {
            sb.append("1000000000 ");
        }
        return sb.append('\n').toString();
    }

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
                ReadingBooks.main(new String[0]);
            } finally {
                System.setIn(originalIn);
                System.setOut(originalOut);
            }

            String actual = out.toString().replace("\r\n", "\n").trim();
            boolean ok = actual.equals(expected);
            if (ok) passed++;

            System.out.printf("#%d %-46s %s%n", i + 1, name, ok ? "PASS" : "FAIL");
            if (!ok) {
                System.out.println("   expected: " + expected.replace("\n", " "));
                System.out.println("   got:      " + actual.replace("\n", " "));
            }
        }

        System.out.printf("%n%d/%d passed%n", passed, CASES.length);
    }
}
