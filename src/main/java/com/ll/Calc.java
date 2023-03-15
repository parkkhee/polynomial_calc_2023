package com.ll;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Calc {

    public static int run(String str) {
        int answer=0;

        str = black(str);

        boolean needToMulti = str.contains(" * ");
        boolean needToPlus = str.contains(" + ") || str.contains(" - ");
        boolean needToSplit =  str.contains("(") || str.contains(")");

        boolean needToCompound = needToMulti && needToPlus;
        if ( needToSplit ) {
            int bracketsCount = 0;
            int splitPointIndex = -1;

            for ( int i = 0; i < str.length(); i++ ) {
                if ( str.charAt(i) == '(' ) {
                    bracketsCount++;
                }
                else if ( str.charAt(i) == ')' ) {
                    bracketsCount--;
                }

                if ( bracketsCount == 0 ) {
                    splitPointIndex = i;
                    break;
                }
            }

            String firstExp = str.substring(0, splitPointIndex + 1);
            String secondExp = str.substring(splitPointIndex + 4);

            char operationCode = str.charAt(splitPointIndex + 2);

            str = Calc.run(firstExp) + " " + operationCode + " " + Calc.run(secondExp);

            return Calc.run(str);
        }
        else if ( needToCompound ) {
            String[] bits = str.split(" \\+ ");

            String newExp = Arrays.stream(bits)
                    .mapToInt(Calc::run)
                    .mapToObj(e -> e + "")
                    .collect(Collectors.joining(" + "));

            return run(newExp);
        }


        if (needToMulti) {

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

    public static String black(String str) {
        while (str.charAt(0) == '(' && str.charAt(str.length() - 1) == ')') {

            str = str.substring(1, str.length() - 1);

        }
        return str;

    }

}
