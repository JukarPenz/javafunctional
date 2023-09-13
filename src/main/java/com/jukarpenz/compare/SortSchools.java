package com.jukarpenz.compare;

import java.util.*;

class School {

    private int numOfStudents;
    private String name;
    public School(String name, int numOfStudents){
        this.name=name;
        this.numOfStudents=numOfStudents;
    }

    public int getNumOfStudents(){
        return this.numOfStudents;
    }

    public String getName(){
        return this.name;
    }
}

public class SortSchools implements Comparator<School> {

    @Override
    public int compare(School s1, School s2){
        if(s1.getNumOfStudents()==s2.getNumOfStudents()){
            return 0;
        }
        else{
            return s1.getNumOfStudents()>s2.getNumOfStudents() ? 1 : -1;
        }
    }

    public static void main(String[] args) {
        School s1 = new School("Mty", 358);
        School s2 = new School("Gdl", 625);
        School s3 = new School("Mex", 972);
        School s4 = new School("Tlc", 358);

        SortSchools ss = new SortSchools();

        List<School> scs=new ArrayList<School>();
        Collections.sort(scs,new SortSchools());

//        HashMap<Integer, String> mp = hasMap

        ss.validate(s1,s2);
        ss.validate(s2,s1);
        ss.validate(s1,s3);
        ss.validate(s2,s3);
        ss.validate(s3,s2);
        ss.validate(s3,s4);
        ss.validate(s1,s4);

    }

    void validate(School s1, School s2){
        int d = compare(s1,s2);
//        System.out.println("Comparing: " + d);
        switch(d){
            case 1: {
                System.out.println(" "+d+": "+s1.getName() +"("+s1.getNumOfStudents()+") has more students than " +s2.getName() + "("+s2.getNumOfStudents()+").");
                break;
            }
            case -1: {
                System.out.println(d+": "+s1.getName() +"("+s1.getNumOfStudents()+") has fewer students than " +s2.getName() + "("+s2.getNumOfStudents()+").");
                break;
            }
            default:
                System.out.println(" " +d+": Both schools " + s1.getName() + " and " + s2.getName() + " have the same number of students: "+ s1.getNumOfStudents() +"("+s2.getNumOfStudents()+").");
        }
    }
}
