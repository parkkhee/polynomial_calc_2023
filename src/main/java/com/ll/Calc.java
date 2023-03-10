package com.ll;

import java.util.ArrayList;
import java.util.Arrays;

public class Calc {

    public static int run(String str) {
        int answer=0;
        str = str.replaceAll("- ", "+ -");

        String[] num = str.split(" \\+ ");

        for (int i = 0; i < num.length; i++) {
//            System.out.println(num[i]);
            answer += Integer.parseInt(num[i]);
        }


        return answer;

    }

}
