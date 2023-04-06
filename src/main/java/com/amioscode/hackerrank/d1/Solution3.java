package com.amioscode.hackerrank.d1;

import java.io.*;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.function.*;

import static java.util.stream.Collectors.joining;

class Result3 {

    /*
     * Complete the 'timeConversion' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String timeConversion(String s) {
        // Write your code here
        //Mine
        String [] hs = s.split(":");
        Integer hr = Integer.parseInt(hs[0]);

        //hr= isPM.test(s)? hr == 12 ?  0 : hr+12:hr;
        hr= isPM.test(s)? hr == 12 ?  hr :  hr+12 : hr == 12 ?  0 :  hr;
        String mine = String.format("%02d",hr)+":"+hs[1]+":"+hs[2].replaceAll("\\p{L}", "");

        //Javas
        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("hh:mm:ssa", Locale.ENGLISH);
        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");

        LocalTime time = LocalTime.parse(s, inputFormatter);
        String javas = time.format(outputFormatter);
        //System.out.println(formattedTime); // Output: 19:05:45
        return (mine.equals(javas)? mine: null);

    }

    static Predicate<String> isPM = s-> s.endsWith("PM");

}

public class Solution3 {
    public static void main(String[] args) throws IOException {
        //BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = "12:05:45AM";

        String result = Result3.timeConversion(s);
        System.out.println(result);

/*
        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
*/
    }
}

