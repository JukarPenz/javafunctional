package com.amioscode.hackerrank.d4;

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

class Result2 {

    /*
     * Complete the 'superDigit' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. STRING n
     *  2. INTEGER k
     */

    //Muy mal codigo, lentisimo
    public static int superDigitW(String no, int k) {
        // Write your code here
        int sd = 0;

        String n = "";
        for (int i = 0; i < k; i++) {
            n=n+no;
        }
        System.out.println("Testing: "+n);

        char sn [] = n.toCharArray();
        for (char c : sn) {
            sd = sd + Character.getNumericValue(c);
        }
        //sd = sd * k;
        // System.out.println("sd: " + sd);
        // System.out.println("Value: "+n+", sd: "+sd);
        if(sd>=10){
            sd = superDigitW(Integer.valueOf(sd).toString(), 1);
        }
        return sd;
    }


    public static int superDigit(String n, int k) {


        // Write your code here
        Long sd = 0l;
        char sn [] = n.toCharArray();
        for (char c : sn) {
            sd = sd + Character.getNumericValue(c);
        }
        sd = sd * k;
        // System.out.println("sd: " + sd);
        // System.out.println("Value: "+n+", sd: "+sd);
        if(sd>=10){
            sd = (long) superDigit(sd.toString(), 1);
        }
        return sd.intValue();
    }

}

public class Solution2 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        String n = firstMultipleInput[0];

        int k = Integer.parseInt(firstMultipleInput[1]);

        int result = Result2.superDigit(n, k);
        System.out.println(result);

//        bufferedWriter.write(String.valueOf(result));
//        bufferedWriter.newLine();

        bufferedReader.close();
//        bufferedWriter.close();
    }
}
