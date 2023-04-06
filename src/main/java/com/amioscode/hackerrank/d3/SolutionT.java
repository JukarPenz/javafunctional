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


class ResultT {

    /*
     * Complete the 'palindromeIndex' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts STRING s as parameter.
     */

    public static int palindromeIndex2(String s) {
        // Write your code here
        String rs = new StringBuilder(s).reverse().toString();
        if(s.equals(rs)){
            return -1;
        }

        char[] cs = s.toCharArray();
        for (char c : cs) {

        }

        for (int i = 0; i < cs.length; i++) {
            StringBuilder found = new StringBuilder();
            //List<Character> cl = new ArrayList<Character>();

            for (int j = 0; j < cs.length; j++) {
                if(j==i){
                    continue;
                }
                //found=found+cs[j];
                found.append(cs[j]);
            }
            String rf = new StringBuilder(found).reverse().toString();
            if(found.toString().equals(rf.toString())){

                return i;
            }
        }

        return -1;
    }

    public static int palindromeIndex0(String s) {
        // Write your code here
        String rs = new StringBuilder(s).reverse().toString();
        if(s.equals(rs)){
            return -1;
        }


        char[] cs = s.toCharArray();
        for (int i = 0; i < cs.length; i++) {
            StringBuilder found = new StringBuilder();

            for (int j = 0; j < cs.length; j++) {
                if(j==i){
                    continue;
                }
                //found=found+cs[j];
                found.append(cs[j]);
            }
            //StringBuilder rf = new StringBuilder(found).reverse();
/*
            System.out.println(i);
            System.out.println(found);
            System.out.println(rf);
            System.out.println(found.toString().equals(rf.toString()));
            System.out.println("----------");
*/
            if(isPalindrome(found.toString(),0,found.length()-1)){
                return i;
            }
        }
        System.out.println("END");
        return -1;
    }
    private static boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public static int palindromeIndexO(String s) {
        // Write your code here
        String rs = new StringBuilder(s).reverse().toString();
        if(s.equals(rs)){
            return -1;
        }


        char[] cs = s.toCharArray();

        for (int i = 0; i < cs.length; i++) {
            StringBuilder found = new StringBuilder();
            //List<Character> cl = new ArrayList<Character>();

            for (int j = 0; j < cs.length; j++) {
                if(j==i){
                    continue;
                }
                    //found=found+cs[j];
                    found.append(cs[j]);
            }
            StringBuilder rf = new StringBuilder(found).reverse();
            System.out.println(i);
            System.out.println(found);
            System.out.println(rf);
            System.out.println(found.toString().equals(rf.toString()));
            System.out.println("----------");
            if(found.toString().equals(rf.toString())){
                return i;
            }
            else{
                //System.out.println();
            }
        }
        System.out.println("END");
        return -1;
    }

    public static int palindromeIndexSubstring(String s) {
        // Write your code here
        String rs = new StringBuilder(s).reverse().toString();
        if (s.equals(rs)) {
            return -1;
        }
        System.out.println(s);
        for (int i = 0; i < s.length(); i++) {
            String sub = s.substring(0,i)+s.substring(i+1,s.length());
            String subR = s.substring(i,i+1);
            System.out.println(subR+"->"+sub);
            String subPal = new StringBuilder(sub).reverse().toString();
            if (sub.equals(subPal)) {
                System.out.println("Pal found @ " + i);
                return i;
            }
        }

        return -1;
    }

        public static int palindromeIndexReversed(String s) {
        // Write your code here
        String rs = new StringBuilder(s).reverse().toString();
        if(s.equals(rs)){
            return -1;
        }

        //for (int i = 0; i < ((s.length()/2)+1); i++) {
        for (int i = 0; i < s.length(); i++) {
            boolean palindrome = false;
            int pos = 0;
            System.out.println("=========="+s+"("+s.length()+")===========");
            System.out.println("Skipping " + s.charAt(i) +" @ " + "["+i+"]");

            //for (int j = 0; j < ((s.length()/2)+1); j++) {
            for (int j = 0; j < s.length(); j++) {
                //skip char i
                if(i==j){
                    System.out.println("Skept: " + s.charAt(j));
                    pos++;
                    //continue;
                }
                else{
                    System.out.print("Comparing s("+j+")=?s("+(s.length()-1-j+pos)+")->"+s.charAt(j)+"-"+(s.charAt(s.length()-1-j+pos)));
                    System.out.println(": "+(s.charAt(j)==s.charAt(s.length()-1-j+pos)));
                    System.out.println("---------");
                    if(s.charAt(j)==s.charAt(s.length()-1-j+pos)){
                        palindrome = true;
                        //todo break;
                    }
                    else{
                        palindrome=false;
                        break;
                    }
                }
            }
            //palindrome=true;
            if(palindrome){
                System.out.println("Plindro[@]"+i+"("+s.charAt(i)+"): " + palindrome);
                return i;
            }
        }

        return -1;

    }

    public static int palindromeIndexFn(String s) {
        // Write your code here
        if(isPalindrome.apply(s)){
            System.out.println("Palindrome already: " + s);
            return -1;
        }

        for(int i = 0; i<s.length();i++){
            StringBuilder testPal = new StringBuilder();
            for (int j = 0; j < s.length(); j++) {
                //iterate to exclude charAt(i)
                if(i==j){
                    //exclude this char
                    continue;
                }
                testPal.append(s.charAt(j));
            }
            System.out.println("Testing pal at ["+i+"]: " + s );
            if(isPalindrome.apply(testPal.toString())){
                System.out.println("Found at["+i+"]: " + s);
                return i;
            }
        }
        return -1;

    }

    static Function<String, Boolean> isPalindrome = (s-> {
        int start = 0;
        int end = s.length()-1;
        while(start<end){
            if(s.charAt(start)!=s.charAt(end)){
                return false;
            }
            start ++;
            end --;
        }
        return true;
    });




    public static int palindromeIndexCGPT(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                if (isPalindrome(s, left + 1, right)) {
                    return left;
                } else if (isPalindrome(s, left, right - 1)) {
                    return right;
                } else {
                    return -1;
                }
            }
            left++;
            right--;
        }

        return -1;
    }
    public static int palindromeIndex(String s) {
        // Write your code here
        if (isPalindrome.apply(s)) {
            return -1;
        }//"abcfbbfba"

        int start = 0;
        int end = s.length() - 1;
        while (start < end) {

            if (s.charAt(start) != s.charAt(end)) {
                if (isPalindrome(s, start + 1, end)) {
                    return start;
                } else {
                    if (isPalindrome(s, start, end - 1)) {
                        return end;
                    } else {
                        //theres more than 2 incorrect chars
                        return -40;
                    }
                }
            }
            start++;
            end--;
            //return -11;
        }
            return -10;
        }

    public static int palindromeIndexFinal(String s) {
        // Write your code here

        // Write your code here

        int start = 0;
        int end = s.length()-1;
        while(start<end){
            if(s.charAt(start)!=s.charAt(end)){
                if(isPalindrome(s, start+1, end)){
                    return start;
                }
                else if(isPalindrome(s,start,end-1)){
                    return end;
                }
                else{
                    //if there was more than 1 incorrect chars we needed to validate this as well
                    return -20;
                }
            }
            start ++;
            end--;
        }

        return -1;
    }



}


public class SolutionT {
    public static void main(String[] args) throws IOException {
        StringBuilder ss = new StringBuilder();
        ss.append("Result: "+ResultT.palindromeIndexFinal("abcfbbwsfba")).append("\n");
        ss.append("Result: "+ResultT.palindromeIndexFinal("aaab")).append("\n");
        ss.append("Result: "+ResultT.palindromeIndexFinal("baa")).append("\n");
        ss.append("Result: "+ResultT.palindromeIndexFinal("aaa")).append("\n");
        ss.append("Result: "+ResultT.palindromeIndexFinal("prcoitfiptvcxrvoalqmfpnqyhrubxspplrftomfehbbhefmotfrlppsxburhyqnpfmqlaorxcvtpiftiocrp")).append("\n");
        System.out.println(ss);
    }
}

