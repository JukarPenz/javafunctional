package com.amioscode.imperative;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static com.amioscode.imperative.Main.Gender.*;
public class Main {

    public static void main(String[] args) {

        List<Person> people = List.of(
                new Person("John",MALE),
                new Person("Maria",FEMALE),
                new Person("Aisha",FEMALE),
                new Person("Alex",MALE),
                new Person("Alice",FEMALE)
        );

        List<Person> females=new ArrayList<Person>();
        for(Person p:people){
            if(FEMALE.equals(p.gender)){
                females.add(p);
            }
        }

        List<Person> males=new ArrayList<Person>();
        for(Person p:people){
            if(MALE.equals(p.gender)){
                males.add(p);
            }
        }

        for (Person p : females) {
            System.out.println(p);
        }

        //Declarative approach
        System.out.println("//Declarative approach");
        System.out.println("//Declarative Females");
        people.stream()
                .filter(p -> FEMALE.equals(p.gender))
                //.collect(Collectors.toList())
                .forEach(System.out::println);

        System.out.println("//Declarative Males");
        List<Person> dm= people.stream()
                .filter(p -> MALE.equals(p.gender))
                .collect(Collectors.toList());
       dm.forEach(System.out::println);

    }

    static class Person{
        private final String name;
        private final Gender gender;

        Person(String name, Gender gender){
            this.name = name;
            this.gender = gender;
        }

        @Override
        public String toString() {
            return "Name: " + this.name + ", Gender: " + this.gender;
        }
    }

    enum Gender{
        MALE, FEMALE
    }

}
