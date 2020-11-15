package com.pranay.interview.arrays;

public class SentenceScreenFitting {
    public static void main(String[] args) {
        int rows = 3, cols = 6;
        String[] sentence = {"a", "bcd", "e"};

        int count = wordsTyping(sentence, rows, cols);
        System.out.println("Count : " + count);
    }

    private static int wordsTyping(String[] sentence, int rows, int cols) {
        String sent = String.join(" ", sentence) + " ";
        int pos = 0, len = sent.length();

        for (int i = 0; i < rows; i++) {
            pos += cols;

            while (pos >= 0 && sent.charAt(pos % len) != ' ') {
                pos--;
            }
            pos++;
        }
        return pos / len;
    }

    private static int wordsTyping2(String[] sentence, int rows, int cols) {
        int available = 0;
        int wordCount = 0;
        int j = 0;
        for (int i = 0; i < rows; i++) {
            available = cols;

            while (j < sentence.length) {
                if (available < sentence[j].length()) {
                    break;
                }

                available -= sentence[j++].length();

                wordCount++;
                if (available > 0)
                    available--;

                if (j >= sentence.length)
                    j = 0;
            }
        }

        return wordCount / sentence.length;
    }
}
