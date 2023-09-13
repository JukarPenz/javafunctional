package com.jukarpenz.ubr.ds.agraphs;

import java.io.*;
import java.util.*;

/*
Input: UBER
Input:
'E',  'U',  'I',  'K',  'F',  'U',  'B'
'W',  'Q',  'B',  'O',  'L' , 'X',  'E'
'T' , 'L',  'A',  'E',  'R',  'E',  'R'
'Y',  'Z',  'X',  'E',  'R',  'L',  'W'

'E',  'U',  'I',  'K',  'F',  'U',  'B'
'W',  'Q',  'B',  'O',  'L' , 'X',  'E'
'T' , 'L',  'A',  'E',  'R',  'E',  'R'
'Y',  'Z',  'X',  'E',  'R',  'L',  'W'

Output: true

mxn

---

Input: UBER
Input
‘U’, ‘B’
‘E’, ‘R’

# Output: false

*/

// Main class should be named 'Solution' and should not be public.
class Crossword {
    public static void main(String[] args) {

// 'E',  'U',  'I',  'K',  'F',  'U',  'B'
// 'W',  'Q',  'B',  'O',  'L' , 'X',  'E'
// 'T' , 'L',  'A',  'E',  'R',  'E',  'R'
// 'Y',  'Z',  'X',  'E',  'R',  'L',  'W'

        char[][] crossword = {
                {'E',  'U',  'I',  'K',  'F',  'U',  'B'},
                {'W',  'B',  'B',  'O',  'L' , 'X',  'E'},
                {'T' , 'E',  'A',  'E',  'R',  'E',  'R'},
                {'Y',  'R',  'X',  'E',  'R',  'L',  'W'}
        };

        String word = "UBER";
        Crossword s = new Crossword(crossword,word);
        boolean hw = s.hasWord(word);
        System.out.println("Has Word: " + hw);

    }

    char [][] crossword;
    String word;
    char[] wordArray;

    Crossword(char[][] cw, String w){
        this.crossword = Arrays.copyOf(cw,cw.length);
        this.word = w;
        this.wordArray=w.toCharArray();
    }

    boolean hasWord(String word, int dir){
        boolean r=false;
        switch(dir){
            case 0:break;
            case 1:
//                if(currPosI<1){
//                    return false;
//                }
        }
        return r;
    }
    boolean hasWord(String word ){
        boolean hasWord = false;
        // int currentWordPos = 0;
        //find First letter
        for(int i=0; i< crossword.length; i++){
            char [] jr=crossword[i];
            char firstLetter = wordArray[0];

            //iterate the wordArray.

            for(int j=0; j<jr.length; j++){
                char currentLetter = crossword [i][j];
                if(currentLetter==firstLetter){
                    //found firs Letter
                    //validate if the next letter is in either direction
                    boolean isLetterNext = isNextLetterNext(i,j, crossword, wordArray, i,direction);
                    //try next direction
                    //direction + 1;
                }
            }
        }

        return hasWord;
    }


    //0 first, 1 top, 2 top rihh, 3 tih-------
    int direction;

    boolean isNextLetterNext(int i, int j, char[][] crossword, char[] wordArray, int currentWordPos, int direction){
        boolean isNext = false;

        //TODO validate when it's the last letter'
        char nextLetter = wordArray[currentWordPos+1];

        //explore all the directions
        // cp (2,3)
        // (1,3)
        // (1,2)
        // (2,)

        // (1, 1)

        //bottom
        boolean isOnBottom = false;
        for(int fi=i+1; fi<crossword.length; fi++){
            char currentLetter = crossword[fi][j];
            System.out.println(nextLetter + "=?" + crossword[fi][j]);
            while(currentLetter==nextLetter){
                isOnBottom=true;
                isNextLetterNext(fi,j,crossword,wordArray,currentWordPos,direction);

//                isNextLettr(...., directoin );
            }
            //break;
        }

        //0 -> 1 -> 2 -> ... -> 5 word was found
        //need to konw direction

        return isNext;
    }

//  boolean isOnBottom(){
//         boolean isOnBottom = false;
//         for(int fi=i+1; fi<crossword.length; fi++){
//             char currentLetter = crossword[fi][j];
//             System.out.println(nextLetter + "=?" + crossword[fi][j]);
//             if(currentLetter==nextLetter){
//                 isOnBottom=true;
//                 //isOnBottom
//             }
//             //break;
//         }

//     }

    boolean searchDeepInDir(){

        switch(direction){

            case 1:
                //seatchOntop
                if(true){
//                    dearhDeepInDir(top);
//                    lastPosLEtter is found;
                }
                //break


        }


        //         //DIR1: TOP
        // //findTopLetter
        // boolean isOnTop = false;
        // if(i>0){
        //     char topLetter = crossword[i-1][j];
        //     isOnTop = nextLetter == topLetter;
        // }
        // if(isOnTop)
        //     direction = 1;


        // boolean isOnTopRight = false;

        return false;
    }




    //find the first letter
    //find the next one, in any direction
    //iterate the matrix
    //findNextLetter(int i, int y)
    //TODO validate if this would be efficient
    //isNextLetterAtLeft()
    //isNextLetterAtLeft()
    //isNextLetterAtLeft()



}
