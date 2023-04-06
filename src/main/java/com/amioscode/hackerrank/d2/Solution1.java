package com.amioscode.hackerrank.d2;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result1 {

    /*
     * Complete the 'lonelyinteger' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY a as parameter.
     */

    public static int lonelyinteger(List<Integer> a) {
        // Write your code here
        Map<Integer, Long> mg = a.stream().collect(Collectors.groupingBy(as-> as, Collectors.counting()));
        System.out.println(mg);

        Map<Long, Integer> ma = a.stream()
                .collect(Collectors
                .groupingBy(ai-> ai,Collectors.counting()))
                .entrySet()
                .stream()
                .filter(am->am.getValue()<2)
                .collect(Collectors.toMap(ai->ai.getValue(),au->au.getKey()))

                ;
        //ma.containsValue(1l);
        System.out.println(ma);
        System.out.println(ma.entrySet());
        System.out.println(ma.get(1l));

        return 3;
    }

}

public class Solution1 {
    public static void main(String[] args) throws IOException {
/*        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> a = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());*/

        List<Integer> a = List.of(3,2,1,1,1,3,2,5,7,7,9,9);

        int result = Result1.lonelyinteger(a);

/*
        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
*/
    }
}
