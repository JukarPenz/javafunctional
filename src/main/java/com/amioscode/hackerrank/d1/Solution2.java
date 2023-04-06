package com.amioscode.hackerrank.d1;

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result2 {

    /*
     * Complete the 'miniMaxSum' function below.
     *
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static void miniMaxSum(List<Integer> arr) {
        // Write your code here

        List<Integer> sorted = arr.stream().sorted().collect(Collectors.toList());
        //System.out.println(sorted);

        Long minSum = sorted.stream().limit(4).collect(Collectors.summingLong(w->w));
        Long maxSum = sorted.stream().skip(arr.size()-4).collect(Collectors.summingLong(w->w));

        System.out.println(minSum + " " + maxSum);

    }

}

public class Solution2 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        Result2.miniMaxSum(arr);

        bufferedReader.close();
    }
}
