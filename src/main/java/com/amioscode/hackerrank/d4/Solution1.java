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

class Result1 {

    /*
     * Complete the 'gridChallenge' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING_ARRAY grid as parameter.
     */

    public static String gridChallenge(List<String> grid) {
        // Write your code here
        String res = "YES";

        //System.out.println(grid.get(0));
        List<String> sortedRows = new ArrayList<String>();

        grid.stream().forEach(s->{
            sortedRows.add(s.chars()
                    .mapToObj(c -> String.valueOf((char) c))
                    .collect(Collectors.toList())
                    .stream().sorted()
                    .collect(Collectors.joining("")));
        });


        int rowSize = sortedRows.size();
        int colSize = sortedRows.get(0).length();

        columnLoop:
        for (int c = 0; c <= colSize-1; c++) {
            int prevCell = 0;
            for (int r = 0; r <= rowSize-1; r++) {
                //this shouldnt need to be validated, as the grid should be nxn
                // if(sortedRows.get(r).length()!=sortedRows.size()){
                // return "NO";
                // }
                colSize=sortedRows.get(r).length();

                int cell = sortedRows.get(r).charAt(c);
                // System.out.println("Validando: " + sortedRows.get(r).charAt(c) + "("+ ((int)sortedRows.get(r).charAt(c)) +") to: " + ((char) prevCell) + "("+prevCell+")" );
                if(!(cell>=prevCell) && cell<=(int)'z'){
                    res = "NO";
                    break columnLoop;
                    //return "NO";
                }
                prevCell=cell;
            }

        }

        // sortedRows.stream().forEach(s->{
        //         System.out.println(s);
        // });
        //System.out.println("res");
        return res;
    }

}

 class Solution10{
    public static void maisn(String[] args) throws IOException {

        int t = 1;

        StringBuilder sb = new StringBuilder("");

        IntStream.range(0, t).forEach(tItr -> {
            try {
                int n = 5;



//                List<String> grid = List.of("ppp","ypp","wyw");
//                System.out.println(Result1.gridChallenge(List.of("ppp","ypp","wyw")));
//                System.out.println(Result1.gridChallenge(List.of("ppp","ypp","zyw")));
//                System.out.println(Result1.gridChallenge(List.of("lyivr","jgfew","uweor","qxwyr","uikjd")));
//                System.out.println(Result1.gridChallenge(List.of("l")));
                System.out.println(Result1.gridChallenge(List.of(
                        "vzzrxgrnvpyjotknhbkiiifbiuwcpvmfapjxntw",
                        "pisviqkjniiwmyshjknxlpksbsdrhspmyvvduzs",
                        "aobisvvwgybnimvybokglhspetkanqleddgedot",
                        "rezemaxkxecxwimxaeczghyrnyjvolfxtsaafvw",
                        "ndwpbvwjiqyrmxpvguzngmbbwjvetbzjnztgoon",
                        "kjpzezwjlpmcduyuestpojisaqtuzogmkkpqwuv",
                        "coboywgjbwdxzgcrydxvufuqmytavfvnangydcd",
                        "vlupqopswxwcdniowxnqxclnafbytnokpsxlvdv",
                        "osrxkmpxetcgvujgrssfdhnomxogwfjsyvabifv",
                        "dusxcvzragkjrskllgrwnfmikyiwfslyzrvtqfa",
                        "spxwiblilwbussklwfutvicmzkafkwjcfzqjkzh",
                        "fkohggspbbfvudtqgjpjuvywzxsdwwmmknigfuk",
                        "hkplzjrshzabtkjowvqxxiilujkkgbfmxexbebx",
                        "wzkccnyjhaubiiilpktcwkpnxoxxiufypqeqqky",
                        "sntrbgbdyitfnamzevypgaowqizgaedcdboqxaw",
                        "xslgigeifaqqzvqjcnoqxqdovpfbszvmfrjhmqt",
                        "kakeviomxlknqmocskoteeyrskvkkshezjllmyv",
                        "pekogeckvoxrzmufdijhbdztktsavvzyrlaxpvn",
                        "pfdeemegondceocgdeexavdbaruhtivxdxgvasx",
                        "hdllduyljbjgjifowdecegdmwuuynznggoimtoh",
                        "rjpbtxshbohnvrpuyogrriwapvjgupiumsinxry",
                        "kzypvfegsllncdoldpbhyhxwnxkqokppnkltdgq",
                        "cldnrmfywtadiuktaqyqudihncxlzeabveoetek",
                        "ztzmrjqpgbrjildvjccaftrmdcgysegdtoojjwk",
                        "bofksxvfhtcfhrgfsshpiwqrlqggbfqklllziky",
                        "seyuhbroajuqjxqkyhqvlleqdwmfgsgebaxsvpq",
                        "hltpxpuaxsibtkpoqialowvkdlkbyhakbefzgzn",
                        "fvkyzegsdfawenripawinuvdlhvwwrleqwtygcs",
                        "dugyunxtuzbgdnjpanaugtdvoemczinalxvtygl",
                        "dyizgkfpbhhabdfrkepzruaiwgpgxtdfnendnhl",
                        "feckqnckvsulwuvfoopnnyyhqdxmwxjrawkwxsv",
                        "xqmnthpkodufmwzpoczvenzxehrdqqpzgnnqkdd",
                        "qhmtpvgwnqeztvffmnrihwfqdsdkljvanccmsyg",
                        "dwupgfksdevslhkdrcmytdpafyijgjbfssyouza",
                        "endhjybrgxkbpglsfrvsqvbikfwcxnjtvyntofj",
                        "ipyowznudnfjiqmpsivlwmauyexkrnsxntddcrs",
                        "ygvaslfhmlxcggqsemzcuwhnrljejhwkshmuxmw",
                        "ephqftahxlrjoclovgirvwdfclqtpubzpsllcsc",
                        "nwdjeczlgdjeziimhkatazntvjcywwpefbjzjyw"
                        )
                ));


            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });
    }
}

public class Solution1 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

//        System.out.println(Result1.gridChallenge(List.of("zx","fw")));
//        if(true) System.exit(2);
        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                List<String> grid = IntStream.range(0, n).mapToObj(i -> {
                            try {
                                return bufferedReader.readLine();
                            } catch (IOException ex) {
                                throw new RuntimeException(ex);
                            }
                        })
                        .collect(toList());

                String result = Result1.gridChallenge(grid);
                System.out.println(result);

//                bufferedWriter.write(result);
//                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
//        bufferedWriter.close();
    }
}
