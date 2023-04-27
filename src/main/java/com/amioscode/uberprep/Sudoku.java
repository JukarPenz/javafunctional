package com.amioscode.uberprep;
/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;
import java.util.stream.Collectors;

/* Name of the class has to be "Main" only if the class is public. */
class Sudoku
{
    public static void main (String[] args) throws java.lang.Exception{

        char ca = 0;
        System.out.println(ca);

        int sl = solution("abca","xyzbac");
        System.out.println(sl);

        // your code goes here

        int [][] sd = {{8,4,9,0,0,3,5,7,0},
                {0,1,0,0,0,0,0,0,0},
                {7,0,0,0,9,0,0,8,3},
                {0,0,0,9,4,6,7,0,0},
                {0,8,0,0,5,0,0,4,0},
                {0,0,6,8,7,2,0,0,0},
                {5,7,0,0,1,0,0,0,4},
                {0,0,0,0,0,0,0,1,0},
                {0,2,1,7,0,0,8,6,5}};
        //fillSudoku(sd);
        int [] b={3,2,1,7,4,9,8,6,5,0,-1};

        Map<String,Integer> mp=new HashMap<>();
        mp.put("j",2);
        mp.put("j",2);
        mp.put("j",2);
        mp.put("j",2);
        mp.put("j",5);
        mp.put("k",4);
        mp.put("i",2);
        mp.put("a",6);

        for(Map.Entry<String,Integer> me:mp.entrySet()){
//            System.out.println(me.getKey()+"->"+me.getValue());
        }

        mp.forEach((mk, mv)-> {
//            System.out.println(mk+" => " + mv);
        });

        int s=5;
        //System.out.println("Found " + s + " @ arr[" +binarySearch(b,s)+"]");

//        System.out.println("Fib: "+fib(5));
//        for (int i = 0; i < 10; i++) {
//            System.out.println("Fib " + i + ": "+ fib(i));
//        }
        System.out.println(Math.pow(0,2));
         //fact(3);
    }

    static void fact(int n){
        if(n==0)
            System.out.println("******");
        for(int i=0;i<n;i++)
            fact(n-1);
    }

    static int fib(int n){
        //System.out.print(n+" ");
        if(n==0)
            return 0;
        if(n==1){
            return 1;
        }
        return fib(n-1) + fib(n-2);
    }

    static int binarySearch(int [] arr, int t){
        //Arrays.sort(arr);
        //Arrays.stream(arr).boxed().collect(Collectors.toList());

        System.out.println(Arrays.stream(arr).boxed().collect(Collectors.toList()));
        int f=0;

        int len = arr.length;
        int sta = 0;
        int mid = len/2;

        int br =0;

        while(br++<10 && arr[mid]!=t){
        //while(br++<10 && sta<=len){
            mid=(len-sta)/2+sta;
            System.out.println(br+"-arr["+mid+"]="+arr[mid]);
            if(t<arr[mid]){
                len=mid-1;
            }
            else{
                sta=mid+1;
            }
        }
        return mid;
    }


    static void fillSudoku(int [][] sd){
        for(int i=0; i< sd.length-1; i++){
            int[] ci = sd[i];
            for(int j=0; j<ci.length-1;j++){
                int cj=ci[j];
                System.out.print(cj+" ");
            }
            System.out.println();
        }
    }

    static int solution(String s1, String s2) {

        //imperative
        if(false){
            char [] sca = s2.toCharArray();
            int cn = 0;
            for(char cs: s1.toCharArray()){
                for (int i = 0; i < sca.length; i++) {
                    if(cs==sca[i]){
                        cn++;
                        sca[i]=0;
                        break;
                    }
                }
            }
            return cn;
        }

        //unique differences
        if(false){
            //List<Integer> l = s1.chars().boxed().distinct().collect(Collectors.toMap(n->n,n->n));
            Map<Integer,Integer>  m = s1.chars().boxed().distinct().collect(Collectors.toMap(n->n,n->n));
            Map<Integer,Integer>  m2 = s2.chars().boxed().distinct().collect(Collectors.toMap(n->n,n->n));
            System.out.println(m);
            System.out.println(m2);
            if(true){
                return (int) m.keySet().stream().filter(mi-> m2.containsKey(mi)).count();
            }
        }

        //functional
        List<Integer> l1 = s1.chars().boxed().toList();
        List<Integer> l2 = s2.chars().boxed().collect(Collectors.toList());
        //int c=0;
        List<Integer> newl = new ArrayList<Integer>();
        l1.forEach(li->{
            if(l2!=null&&!l2.isEmpty())
                for(int i=0;i<l2.size();i++){
                    if(li==l2.get(i).intValue()){
                        newl.add(li);
                        l2.remove(i);
                        break;
                    }
                }
        });

        return newl.size();
    }



}
