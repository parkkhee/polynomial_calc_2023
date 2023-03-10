package com.ll;

public class Calc {

    public static int run(String str) {

        if (str.contains("+")) {
            String[] bits = str.split(" \\+ ");

            int a = Integer.parseInt(bits[0]);
            int b = Integer.parseInt(bits[1]);

            return a + b;
        } else if (str.contains("-")) {
            String[] bits = str.split(" - ");

            int a = Integer.parseInt(bits[0]);
            int b = Integer.parseInt(bits[1]);

            return a - b;
        } else if (str.contains("*")) {
            String[] bits = str.split(" \\* ");

            int a = Integer.parseInt(bits[0]);
            int b = Integer.parseInt(bits[1]);

            return a * b;
        } else if (str.contains("/")) {
            String[] bits = str.split(" / ");

            int a = Integer.parseInt(bits[0]);
            int b = Integer.parseInt(bits[1]);

            return a / b;
        }


        return -1;

    }

}
