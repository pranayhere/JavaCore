package com.pranay.GeeksForGeeks;

class ShortenerServiceUtils {

    public static String encode(String code) {
        char[] str = code.toCharArray();
        for(int i=0; i<str.length-1; i+=2) {
            char temp = str[i];
            str[i] = str[i+1];
            str[i+1] = temp;
        }
        return new String(str);
    }

    public static String decode(String code) {
        return ShortenerServiceUtils.encode(code);
    }

    public static void main(String[] args) {
        String one = "a";
        String two = "ab";
        String three = "abc";
        String four = "abcd";
        String five = "abcde";
        String six = "abcdef";

        System.out.println(one);
        System.out.println(ShortenerServiceUtils.encode(one));
        System.out.println(ShortenerServiceUtils.decode(ShortenerServiceUtils.encode(one)));

        System.out.println();

        System.out.println(two);
        System.out.println(ShortenerServiceUtils.encode(two));
        System.out.println(ShortenerServiceUtils.decode(ShortenerServiceUtils.encode(two)));

        System.out.println();

        System.out.println(three);
        System.out.println(ShortenerServiceUtils.encode(three));
        System.out.println(ShortenerServiceUtils.decode(ShortenerServiceUtils.encode(three)));

        System.out.println();

        System.out.println(four);
        System.out.println(ShortenerServiceUtils.encode(four));
        System.out.println(ShortenerServiceUtils.decode(ShortenerServiceUtils.encode(four)));

        System.out.println();

        System.out.println(five);
        System.out.println(ShortenerServiceUtils.encode(five));
        System.out.println(ShortenerServiceUtils.decode(ShortenerServiceUtils.encode(five)));

        System.out.println();

        System.out.println(six);
        System.out.println(ShortenerServiceUtils.encode(six));
        System.out.println(ShortenerServiceUtils.decode(ShortenerServiceUtils.encode(six)));
    }
}
