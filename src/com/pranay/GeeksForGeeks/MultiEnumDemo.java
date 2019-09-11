package com.pranay.GeeksForGeeks;


import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;

public class MultiEnumDemo {

    public static void main(String[] args) throws UnsupportedEncodingException {
        String url = "pranaybsankpal%40gmail.com";
        String result = java.net.URLDecoder.decode(url, StandardCharsets.UTF_8.name());
        System.out.println(result);
    }
}