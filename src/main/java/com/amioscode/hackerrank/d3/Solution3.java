package com.amioscode.hackerrank.d3;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.regex.*;

class Result3 {

    /*
     * Complete the 'caesarCipher' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. STRING s
     *  2. INTEGER k
     */


    public static String caesarCipher(String s, int k) {
        // Write your code here

        //String alf = "abcdefghijklmnopqrstuvwxyz";
        String cp = "";

        int mas = 'A';
        int mae = 'Z';
        int mis = 'a';
        int mie = 'z';
        int cipChar = 0;
        for (int i = 0; i < s.length(); i++) {
            int currentChar = s.charAt(i);

            //Mayusculas
            if(currentChar >= mas && currentChar <= mae ){
                //int offset = (cipChar - mae)%mas;
                cipChar = currentChar + k%(mae-mas+1);
                int offset = cipChar - mae;
                if(offset>0){
                    cipChar = mas + offset-1;
                    //cipChar = offset;
                    //System.out.println("curr: " + currentChar +"("+(char)currentChar+"). k: " + k +". k%(mae-mas): " + k%(mae-mas)+". Cip: " + cipChar+"("+(char)cipChar+")");
                }
            }
            else{
                //Minusculas
                if(currentChar >= mis && currentChar <= mie ){
                    int mins=k%(mie-mis+1);
                    if(currentChar+mins>mie){
                        //cipChar=mis+(mie-(k%(mie-mis)));
                        int minsOffset = currentChar+mins-mie-1;
                        cipChar=mis + minsOffset;
//                        System.out.println("curr: " + currentChar +"("+(char)currentChar+"). k: " + k +". k%(mie-mis): " + k%(mie-mis)+". Cip: " + cipChar+"("+(char)cipChar+")");
                    }
                    else{
                        cipChar = currentChar+mins;
                        //ok
                        //System.out.println("curr: " + currentChar +"("+(char)currentChar+"). k: " + k +". k%(mie-mis): " + k%(mie-mis)+". Cip: " + cipChar+"("+(char)cipChar+")");
                    }
                }
                //Special Chars
                else{
                    cipChar = currentChar;
                }
            }
            cp=cp+(char) cipChar;
        }
        return cp;

    }

    public static String caesarCipher2(String s, int k) {
        return s.chars() // Convert the string to a stream of Unicode code points
                .map(c -> { // Apply the cipher shift to each code point
                    if (Character.isUpperCase(c)) {
                        return ((c - 'A' + k) % 26) + 'A';
                    } else if (Character.isLowerCase(c)) {
                        return ((c - 'a' + k) % 26) + 'a';
                    } else {
                        return c;
                    }
                })
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append) // Collect the code points back into a string
                .toString();
    }
/*

    public static String caesarCipher(String s, int k) {
        // Write your code here

        //String alf = "abcdefghijklmnopqrstuvwxyz";
        String cp = "";

        int mas = 'A';
        int mae = 'Z';
        int mis = 'a';
        int mie = 'z';

        for (int i = 0; i < s.length(); i++) {
            //alf.charAt(i)=45;
            int currentChar = s.charAt(i);
            int cipChar = currentChar + k;

            //Mayusculas
            if(currentChar >= mas && currentChar <= mae ){
                int offset = cipChar - mae;
                if(offset>0){
                    //cipChar = cipChar-(zv-av);
                    cipChar = mas + offset-1;
                }
                cp=cp+(char) cipChar;//(currentChar+k);
            }
            else{
                //Minusculas
                if(currentChar >= mis && currentChar <= mie ){
                    int offset = cipChar - mie;
                    if(offset>0){
                        //cipChar = cipChar-(zv-av);
                        cipChar = mis + offset-1;
                        //cipChar = cipChar-mie+mis;
                    }
                    cp=cp+(char) cipChar;//(currentChar+k);
                }
                //Special Chars
                else{
                    cp=cp+(char) (currentChar);
                }
            }
        }

        //s.chars().forEach(c->{ });

        //for(char c:alf){}

        //String cp = alf.


        //System.out.println(alf.length() + " - " + alf.charAt(4));

        return cp;

    }
*/

}

public class Solution3 {
    public static void main(String[] args) throws IOException {
        int n = 10;
//10
//www.abc.xy
//87
        String s = "www.abc.xy";
        //s="APAmiddle-Outz";
        s="middle-Outz";
        int k = 2;
        s="Ciphering."; k=26;
        String result = Result3.caesarCipher(s, k);
        System.out.println("Result: " + result);
        s="middle-Outz"; k=2;
        result = Result3.caesarCipher(s, k);
        System.out.println("Result: " + result);

        cipher.accept("Ciphering.",26);
        cipher.accept("middle-Outz",2);
        cipher.accept("Hello_World!",4);

    }

    static BiConsumer<String, Integer> cipher = (s, k) ->{
        String rr = Result3.caesarCipher2(s,k);
        System.out.println("Rrr: " + rr);
    };
}
