package com.amioscode.hackerrank.d1;

import java.io.*;
import java.util.*;
import java.util.stream.*;


import static java.util.stream.Collectors.joining;


class ResultTest {

    /*
     * Complete the 'findMedian' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static int findMedian(List<Integer> arr) {
        // Write your code here
        List<Integer> st = arr.stream().sorted().collect(Collectors.toList());
        System.out.println(st);
        int pos = st.size() > 1 ? (st.size()-1)/2 : 0 ;
        System.out.println(st.get(pos));
        return st.get(pos);

    }

}
public class SolutionTest {
    public static void main(String[] args) throws IOException {
        //BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        //int n = Integer.parseInt(bufferedReader.readLine().trim());

/*
        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());
*/
        List<Integer> arr = List.of(5,2,6,8,8,9,5,5,6);
        int result = ResultTest.findMedian(arr);

/*
        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
*/
    }
}
