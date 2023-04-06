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


class ResultT {

    /*
     * Complete the 'flippingMatrix' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts 2D_INTEGER_ARRAY matrix as parameter.
     */

    public static int flippingMatrix(List<List<Integer>> m) {
        // Write your code here
        //get nxn sum, and then reversed sum
        //reverse columns so get the max sum in qxq
        //reverse rows so get the max sum in qxq

        int n = m.size()/2;
        int n2 = 2*n;
        int mySum = 0;
        //int[n][n] nr = new int[];

        for (int i = 0, ri=n2-1; i < n; i++, ri--) {
            for (int j = 0, rj=n2-1; j < n; j++, rj--) {
            //System.out.println("Choosing max from: (i,j):["+i+","+j+"]; (ri,rj): ["+ri+","+rj+"]");
            //was complicated to understand the explaination
            //this is mine
                int maxs =
                Math.max(
                        m.get(i).get(j) , Math.max(m.get(i).get(rj),
                        Math.max(m.get(ri).get(j), m.get(ri).get(rj))));
                        System.out.println("Maxs("+i+","+j+"): "+maxs);
                mySum=mySum+maxs;
            }
        }
        System.out.println("MySum: "+ mySum);

        //youtubes
        List<List<Integer>> matrix = m;
        int suma  = 0;
        for (int i = 0; i < n; i++) {
            int reversedSum = 0;
            for(int j=0; j<n; j++){
                int maxs = Math.max(matrix.get(i).get(j), Math.max(matrix.get(i).get(matrix.size()-1-j),
                                Math.max(matrix.get(matrix.size()-1-i).get(j), matrix.get(matrix.size()-1-i).get(matrix.size()-1-j))));
                suma = suma + maxs;

                System.out.println("Maxs("+i+","+j+"): "+maxs);
            }
        }

        //return flipRes;
        int largestSum = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                largestSum += Math.max(matrix.get(i).get(j), Math.max(matrix.get(i).get(matrix.size()-j-1),
                        Math.max(matrix.get(matrix.size()-i-1).get(j), matrix.get(matrix.size()-i-1).get(matrix.size()-j-1))));
            }
        }

        if(mySum != suma || mySum != largestSum){
            System.out.println("Retorno " + 1);
            return 1;
        }
        System.out.println("Retorno mySum: " + mySum);
        return mySum;
    }
/*
STDIN           Function
-----           --------
1               q = 1
2               n = 2
112 42 83 119   matrix = [[112, 42, 83, 119], [56, 125, 56, 49], \
56 125 56 49              [15, 78, 101, 43], [62, 98, 114, 108]]
15 78 101 43
62 98 114 108
*/
}
public class SolutionT {
    public static void main(String[] args) throws IOException {

                List<List<Integer>> matrix = new ArrayList<>(
                        List.of(new ArrayList<>(List.of(112, 42, 83, 119)),
                                new ArrayList<>(List.of(56, 125, 56, 49)),
                                new ArrayList<>(List.of(15, 78, 101, 43)),
                                new ArrayList<>(List.of(62, 98, 114, 108))
                            ));
                int result = ResultT.flippingMatrix(matrix);
    }
}
