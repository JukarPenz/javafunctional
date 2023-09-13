package com.jukarpenz.compare;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Student extends Person implements Comparable<Student>{

    private String name;
    private int age;

    public Student(String n, int a){
        this.name=n;
        this.age=a;
    }

    public int getAge(){
        return this.age;
    }

    public String getName(){
        return this.name;
    }

    public void setName(String n){
        this.name=n;
    }

    public void setAge(int a){
        this.age=a;
    }

    @Override
    public String toString(){
        return this.getName()+"("+this.getAge()+")";
    }

    public int compareTo(Student per){
        if(this.age==per.age){
            return 0;
        }
        else{
            return this.age > per.age ? 1 : -1;
        }
    }

    public static void main(String[] args) {
        Student s1 = new Student("Adam", 45);
        Student s2 = new Student("Steve", 60);
        Student s3 = new Student("George", 15);
        Student s4 = new Student("Lucas", 15);

        List<Student> sds = new ArrayList<Student>();
        sds.add(s1);
        sds.add(s2);
        sds.add(s3);
        sds.add(s4);


        System.out.println(sds);
        System.out.println(sds.stream().sorted().collect(Collectors.toList()));

        compare(s1,s2);
        compare(s2,s1);
        compare(s2,s3);
        compare(s4,s3);

    }

    private static void compare(Student s1, Student s2){
        int retVal = s1.compareTo(s2);
        switch(retVal){
            case -1:{
                System.out.println(retVal + ": The student " + s1.getName() + "("+s1.getAge()+") is younger than " + s2.getName()+"("+s2.getAge()+")" );
                break;
            }
            case 1: {
                System.out.println(retVal + ": The student " + s1.getName() + "("+s1.getAge()+") is older than " + s2.getName()+"("+s2.getAge()+")" );
                break;
            }
            default:{
                System.out.println(retVal + ": "+s1.getName() +" and " + s2.getName()+ " both students are the same age: " + s1.getAge());
            }
        }
    }

}