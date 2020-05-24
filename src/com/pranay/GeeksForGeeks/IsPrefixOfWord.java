package com.pranay.GeeksForGeeks;

public class IsPrefixOfWord {
    public static void main(String[] args) {
        String sentence = "i love eating burger", searchWord = "burg";
        int idx = isPrefixOfWord(sentence, searchWord);
        System.out.println("Index : " + idx);
    }

    private static int isPrefixOfWord(String sentence, String searchWord) {
        String[] words = sentence.split(" ");
        for (int i = 0; i< words.length; i++) {
            if (words[i].startsWith(searchWord)) {
                return i + 1;
            }
        }
        return -1;
    }
}
