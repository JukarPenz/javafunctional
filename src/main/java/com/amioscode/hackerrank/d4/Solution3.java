package com.amioscode.hackerrank.d4;

import java.io.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Solution3T {

    public static void marro(String[] args) {
         int[] qa = {3,2,4,1};
        System.out.println(Arrays.stream(qa).boxed().collect(Collectors.toList()));
        //qa[1]=qa[3];
/*
        int i = 1, j=3;
        if(qa[i]>qa[j]){
            System.out.println(Arrays.stream(qa).boxed().collect(Collectors.toList()));
            int t = qa[i];
            System.out.println("t: " + t+". qa[i]: "+ qa[i]+". qa[j]: "+qa[j]);
            qa[i] = qa[j];
            System.out.println("t: " + t+". qa[i]: "+ qa[i]+". qa[j]: "+qa[j]);
            qa[j] = t;
            System.out.println("t: " + t+". qa[i]: "+ qa[i]+". qa[j]: "+qa[j]);
            System.out.println(Arrays.stream(qa).boxed().collect(Collectors.toList()));
        }
*/
//        System.out.println(Arrays.stream(qa).boxed().collect(Collectors.toList()));
//        if(true) System.exit(5);
//        List<Integer> ql = Arrays.asList(qa);
        for (int i = 0; i < qa.length; i++) {
            System.out.println("====================");
            System.out.println(i +": " + qa[i]);
            for (int j = 0; j < qa.length; j++) {
                if(qa[i]<qa[j]){
                    System.out.println(Arrays.stream(qa).boxed().collect(Collectors.toList()));
                    int t = qa[i];
                    qa[i] = qa[j];
                    qa[j] = t;
                    System.out.println(Arrays.stream(qa).boxed().collect(Collectors.toList()));
                }
            }

            System.out.println("--------------------------");
            System.out.println(Arrays.stream(qa).boxed().collect(Collectors.toList()));
        }


    }

}



class Result3 {

    /*
     * Complete the 'minimumBribes' function below.
     *
     * The function accepts INTEGER_ARRAY q as parameter.
     */

    public static void minimumBribes(List<Integer> qa) {
        int [] q = qa.stream().mapToInt(i->i).toArray();
        int mvs = 0;
        boolean isChaotic = false;

        for (int i = 0; i < q.length; i++) {
            if (q[i] - (i + 1) > 2) {
                isChaotic = true;
                break;
            }
            for (int j = Math.max(0, q[i] - 2); j < i; j++) {
                if (q[j] > q[i]) {
                    mvs++;
                }
            }
        }

        if (isChaotic) {
            System.out.println("Too chaotic");
        } else {
            System.out.println(mvs);
        }
    }
    public static void minimumBribesMine(List<Integer> q) {
        // Write your code here
        Long min = 0l;
        boolean cao = false;

        int [] qa = q.stream().mapToInt(i->i).toArray();
        System.out.println(Arrays.stream(qa).boxed().collect(Collectors.toList()));
        int mvs = 0;
        superFor:
        //for (int kk = 0; kk < qa.length; kk++)
        for (int i = 1; i <= qa.length-1; i++) {
            if(qa[i-1]==i){
                continue ;
            }
            //if(Math.abs(qa[i-1]-i)<3){
            if(Math.abs(qa[i-1]-i)<3){
                int nextpos = 0;
                if(qa[i-1]!=i+1){
                    System.out.println("Next post = 1 to "+qa[i-1]);
                   // nextpos=1;
                }
                if(qa[i-1]>qa[i+nextpos]){
                    System.out.println("Moving:i:"+i+", qa[i-1]("+qa[i-1]+")->qa[i]("+qa[i+nextpos]+"). " + mvs +"->");
                    mvs++;
                    int temp=qa[i-1];
                    qa[i-1] = qa[i+nextpos];
                    qa[i+nextpos]=temp;
                    System.out.println(Arrays.stream(qa).boxed().collect(Collectors.toList()));
                    continue superFor;
                }
                else{

                    System.out.println("NO MOVE:i:"+i+", qa[i-1]("+qa[i-1]+")->qa[i]("+qa[i]+"). " + mvs +"->"+Arrays.stream(qa).boxed().collect(Collectors.toList()));
                }
                //min = min + Math.abs((q.get(i-1)-i));
            }
            else{
                 System.out.println(" GOT Too chaotic @ " + qa[i-1] +"("+i+"). "+Arrays.stream(qa).boxed().collect(Collectors.toList()));
                cao=true;
                break superFor;
            }
        }
        // System.out.println("MOVS NEEDED " + mvs +"->"+Arrays.stream(qa).boxed().collect(Collectors.toList()));

/*
        //Object []  dd =q.toArray();

        int [] arr = q.stream().mapToInt(i->i).toArray();
        int n = arr.length;
        // for (int i = 0; i < n - 1; i++) {
        //     int ic = 0;
        //     for (int j = 0; j < n - i - 1; j++) {
        //         ic++;
        //         if (arr[j] > arr[j + 1]) {
        //             //ic++;
        //             int temp = arr[j];
        //             arr[j] = arr[j + 1];
        //             arr[j + 1] = temp;
        //                     System.out.println(ic +"->"+Arrays.stream(arr).boxed().collect(Collectors.toList()));
        //         }
        //     }
        // }


        for (int i = 0; i < qa.length; i++) {
            int ic = 0;
                            System.out.println(Arrays.stream(qa).boxed().collect(Collectors.toList()));
            for (int j = 0; j < qa.length; j++) {
                if(qa[i]<qa[j]){
                    ic++;
                    int temp=qa[i];
                    qa[i] = qa[j];
                    qa[j]=temp;
                            System.out.println(ic+"->"+Arrays.stream(qa).boxed().collect(Collectors.toList()));
                }
            }

        }
                            System.out.println(Arrays.stream(arr).boxed().collect(Collectors.toList()));


        // for (int i = 0; i < qa.length; i++) {
        //     //System.out.println(i +": " + qa[i]);
        //     int current = qa[i];

        //     for (int j = 0; j < qa.length; j++) {
        //         int comp = qa[j];
        //         if(current>comp){

        //         }
        //     }
        // }

        if(!cao)
            System.out.println(min);
*/
        if(cao){
            System.out.println("Too chaotic");
        }
        else{
            System.out.println(mvs);
        }

    }

}

public class Solution3 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                List<Integer> q = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList());

                Result3.minimumBribes(q);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
    }
}

