package com.ll;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Calc {

    public static int run(String str) {
        str = str.trim();
        int answer=0;

        str = black(str);

        // 단일항이 입력되면 바로 리턴
        if (!str.contains(" ")) return Integer.parseInt(str);

        boolean needToMulti = str.contains(" * ");
        boolean needToPlus = str.contains(" + ") || str.contains(" - ");
        boolean needToSplit =  str.contains("(") || str.contains(")");

        boolean needToCompound = needToMulti && needToPlus;
        if ( needToSplit ) {

            int splitPointIndex = findSplitPointIndex(str);

            String firstExp = str.substring(0, splitPointIndex);
            String secondExp = str.substring(splitPointIndex + 1);

            char operationCode = str.charAt(splitPointIndex);

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


        else if (needToMulti) {

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
        int outerBracketsCount = 0;

        while (str.charAt(outerBracketsCount) == '(' && str.charAt(str.length() - 1 - outerBracketsCount) == ')') {
            outerBracketsCount++;
        }

        if (outerBracketsCount == 0) return str;

        return str.substring(outerBracketsCount, str.length() - outerBracketsCount);

    }

    //( 과 ) 의 사이
    private static int findSplitPointIndexBy(String exp, char findChar) {
        int bracketsCount = 0;

        for (int i = 0; i < exp.length(); i++) {
            char c = exp.charAt(i);

            if ( c == '(' ) {
                bracketsCount++;
            }
            else if ( c == ')' ) {
                bracketsCount--;
            }
            else if ( c == findChar ) {
                if ( bracketsCount == 0 ) return i;
            }
        }

        return -1;
    }

    private static int findSplitPointIndex(String exp) {
        int index = findSplitPointIndexBy(exp, '+');

        if ( index >= 0 ) return index;

        return findSplitPointIndexBy(exp, '*');
    }


}
