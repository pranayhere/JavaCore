package com.pranay.interviewAChef.div0;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class NumberOfCredits {
    public static void main(String[] args) {
        InputReader in = new InputReader(System.in);

        int T = in.nextInt();
        for (int i = 0; i < T; i++) {
            int rtp = in.nextInt();
            int audit = in.nextInt();
            int non_rtp = in.nextInt();

            int ans = rtp * 4 + audit * 2;
            System.out.println(ans);
        }
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
