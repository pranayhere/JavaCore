package com.pranay.cses.SortingAndSearchingV2;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

/**
 * Local test cases for {@link FerrisWheel}.
 * Run main: each case feeds input to FerrisWheel.main and compares stdout.
 */
public class FerrisWheelTest {

    // { name, input, expected output }
    private static final String[][] CASES = {
            {"sample", "4 10\n7 2 3 9\n", "3"},
            {"single child", "1 5\n5\n", "1"},
            {"x = 1, nobody can pair", "3 1\n1 1 1\n", "3"},
            {"pairs sum exactly x", "4 10\n5 5 5 5\n", "2"},
            {"pair sum x + 1 does not fit", "2 10\n5 6\n", "2"},
            {"no two children fit together", "3 10\n6 7 8\n", "3"},
            {"everyone pairs up", "4 10\n1 2 3 4\n", "2"},
            {"odd count, one left alone", "5 10\n1 1 1 1 1\n", "3"},
            {"heaviest with lightest", "6 10\n9 1 8 2 7 3\n", "3"},
            {"many heavy, one light", "5 10\n1 2 9 9 9\n", "4"},
            {"custom1", "4 10\n2 4 6 8\n", "2"},
            {"max weights", "3 1000000000\n1000000000 500000000 500000000\n", "2"},
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
                FerrisWheel.main(new String[0]);
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
