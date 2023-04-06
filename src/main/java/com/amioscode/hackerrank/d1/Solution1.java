package com.amioscode.hackerrank.d1;

import java.io.*;

import java.util.*;
import java.util.function.BiFunction;

import java.util.stream.*;

import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'plusMinus' function below.
     *
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    static BiFunction<Double, Integer, Double> calcRatio = (n, s) -> n.doubleValue()/s;

    public static void plusMinus(List<Integer> arr) {
        // Write your code here

        Long positiveCount = arr.stream().filter(e-> e>0).count();
        Long negativeCount = arr.stream().filter(e-> e<0).count();
        Long zeroCount = arr.stream().filter(e-> e==0).count();

        System.out.println(String.format("%.6f",calcRatio.apply(positiveCount.doubleValue(),arr.size())));
        System.out.println(String.format("%.6f",calcRatio.apply(negativeCount.doubleValue(),arr.size())));
        System.out.println(String.format("%.6f",calcRatio.apply(zeroCount.doubleValue(),arr.size())));


    }

}

public class Solution1 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        Result.plusMinus(arr);

        bufferedReader.close();
    }
}
