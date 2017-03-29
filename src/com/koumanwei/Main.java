package com.koumanwei;

public class Main {
    public static void main(String[] args) {
        String str = "{\"val\":\"home\"}";
        String s = method(str);
        System.out.println(s);
    }

    public static String method(String str) {

        return str.replace("\"", "\\\"");
    }
}
