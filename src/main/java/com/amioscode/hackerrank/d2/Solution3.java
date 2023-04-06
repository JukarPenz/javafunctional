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

class Result3 {

    /*
     * Complete the 'countingSort' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static List<String> countingSort(List<Integer> arr) {
        // Write your code here
        Map<Integer, Integer> marr = new HashMap<Integer,Integer>();
        for(int a: arr){
            int currentCount = marr.containsKey(a) ? marr.get(a) : 0;
            marr.put(a,currentCount+1);
        }

        Map<Integer,Long> map = arr.stream()
                .collect(Collectors.groupingBy(ai->ai, Collectors.counting()));

        List<String> result = new ArrayList<String>();

        StringBuilder sb = new StringBuilder("[");
        for(int j=0; j<100; j++){
            //result.add(marr.containsKey(j) ? marr.get(j) : 0);
            int length = j<9 ? 1 : 2 ;
            String sf = "";
            if(map.containsKey(j)){
                length = Math.max(map.get(j).toString().length(),length);
            }
            sf = "%0"+length+"d";
            result.add(map.containsKey(j) ? String.format(sf,map.get(j).intValue()) : String.format(sf,0));
            sb.append(String.format(sf,j));
            if(j<99){
                sb.append(", ");
            }
        }
        sb.append("]");
        System.out.println("Number: "+sb);
        System.out.println("#Times: "+result);

        return result;


    }

}

public class Solution3 {
    public static void main(String[] args) throws IOException {
        List<Integer> arr = new ArrayList<>(List.of(250,96,96,0,0,0,0,0,63, 25, 73, 1, 98, 73, 56, 84, 86, 57, 16, 83, 8, 25, 81, 56, 9, 53, 98, 67, 99, 12, 83, 89, 80, 91, 39, 86, 76, 85, 74, 39, 25, 90, 59, 10, 94, 32, 44, 3, 89, 30, 27, 79, 46, 96, 27, 32, 18, 21, 92, 69, 81, 40, 40, 34, 68, 78, 24, 87, 42, 69, 23, 41, 78, 22, 6, 90, 99, 89, 50, 30, 20, 1, 43, 3, 70, 95, 33, 46, 44, 9, 69, 48, 33, 60, 65, 16, 82, 67, 61, 32, 21, 79, 75, 75, 13, 87, 70, 33,96,0,0,0,0,0,63, 25, 73, 1, 98, 73, 56, 84, 86, 57, 16, 83, 8, 25, 81, 56, 9, 53, 98, 67, 99, 12, 83, 89, 80, 91, 39, 86, 76, 85, 74, 39, 25, 90, 59, 10, 94, 32, 44, 3, 89, 30, 27, 79, 46, 96, 27, 32, 18, 21, 92, 69, 81, 40, 40, 34, 68, 78, 24, 87, 42, 69, 23, 41, 78, 22, 6, 90, 99, 89, 50, 30, 20, 1, 43, 3, 70, 95, 33, 46, 44, 9, 69, 48, 33, 60, 65, 16, 82, 67, 61, 32, 21, 79, 75, 75, 13, 87, 70, 33));
        for (int i = 0; i < 120; i++) {
            arr.add(0);
        }

        List<String> result = Result3.countingSort(arr);
        //System.out.println(result);

    }
}
