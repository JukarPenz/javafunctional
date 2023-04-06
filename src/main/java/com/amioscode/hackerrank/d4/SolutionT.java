package com.amioscode.hackerrank.d4;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

class ResultT {

    /*
     * Complete the 'truckTour' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts 2D_INTEGER_ARRAY petrolpumps as parameter.
     */

    public static int truckTour(List<List<Integer>> petrolpumps) {
        // Write your code here
        long petrol=0;
        // long kms = 0;
        int idx = 0;
        for (List<Integer> l : petrolpumps) {
            //System.out.println(l+". indexOf: "+petrolpumps.indexOf(l));
            long currPerf = l.get(0)-l.get(1);
            //long prevP=petrol;

            // if(currPerf+petrol>l.get(1)){
            if(currPerf+petrol>=0){
                petrol = petrol + currPerf;
                idx=idx==0?petrolpumps.indexOf(l):idx;
            }
            else{
                petrol = 0;
                idx=0;
                // kms=0;
            }
            // System.out.println("pl: " + prevP + "@" +petrolpumps.indexOf(l)+ ". ("+l.get(0)+","+l.get(1)+"). currPerf: "+currPerf+". dist: "+l.get(1)+". newPetrol: "+petrol+" idx: " + idx);

        }

        // petrolpumps.stream().filter(l->{
        //     List<Integer> ll = l.subList(1, petrolpumps.size()-1);
        //     System.out.println();
        // });

        return idx;
    }

}

public class SolutionT {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> petrolpumps = new ArrayList<>();

        IntStream.range(0, n).forEach(i -> {
            try {
                petrolpumps.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int result = ResultT.truckTour(petrolpumps);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
