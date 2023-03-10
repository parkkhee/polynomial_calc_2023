package com.ll;

import java.util.ArrayList;
import java.util.Arrays;

public class Calc {

    public static int run(String str) {
        int answer=0;
        boolean includeMul = false;
        if (str.contains("*")) {
            includeMul = true;
        }

        if (includeMul) {

            String[] num = str.split(" \\* ");
            int answerM =1;
            for (String s : num) {
                answerM *= Integer.parseInt(s);
            }
            return answerM;

        }else {
            str = str.replaceAll("- ", "+ -");

            String[] num = str.split(" \\+ ");

            for (int i = 0; i < num.length; i++) {
//            System.out.println(num[i]);
                answer += Integer.parseInt(num[i]);
            }
        }


        return answer;

    }

}
