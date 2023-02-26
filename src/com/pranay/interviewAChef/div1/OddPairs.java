package com.pranay.interviewAChef.div1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class OddPairs {
    public static void main(String[] args) {
        InputReader in = new InputReader(System.in);
        OddPairs op = new OddPairs();

        int T = in.nextInt();
        for (int i = 0; i < T; i++) {
            int n = in.nextInt();

            long pairs = op.oddPairs(n);
            System.out.println(pairs);
        }
    }

    private long oddPairs(int R) {
        int odds = R / 2;
        if (R % 2 != 0)
            odds += 1;

        int evens = R - odds;
        return 2L * odds * evens;
    }

    static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }
    }
}
