package com.amioscode.hackerrank.d3;

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



class ResultTest2 {

    /*
     * Complete the 'palindromeIndex' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts STRING s as parameter.
     */
    public static int palindromeIndexByChatGPT(String s) {
        if (isPalindrome(s)) {
            return -1;
        }
        return IntStream.range(0, s.length())
                .filter(i -> isPalindrome(s.substring(0, i) + s.substring(i + 1)))
                .findFirst()
                .orElse(-1);
    }

    private static boolean isPalindrome(String s) {
        return s.equals(new StringBuilder(s).reverse().toString());
    }
    public static int palindromeIndex(String s) {
        // Write your code here
        System.out.println("Testing: "+s);
        if(s.equals(new StringBuilder(s).reverse().toString())){
            return -1;
        }
        for(int i=0;i<s.length();i++){
            String sub = s.substring(0,i) + s.substring(i+1,s.length());
            if(sub.equals(new StringBuilder(sub).reverse().toString())){
                return i;
            }
        }
        return -1;
    }

}

public class SolutionTest2 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                String s = bufferedReader.readLine();

                int result = ResultTest2.palindromeIndex(s);

                bufferedWriter.write(String.valueOf(result));
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
