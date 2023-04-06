package com.amioscode.streams;

import com.amioscode.imperative.Main;

import java.util.List;
import java.util.stream.Collectors;

import static com.amioscode.streams._Stream.Gender.*;


public class _Stream {

    public static void main(String[] args) {
        List<Person> ppl = List.of(
                new Person("John",MALE),
                new Person("Maria",FEMALE),
                new Person("Aisha",FEMALE),
                new Person("Alex",MALE),
                new Person("Alice",FEMALE)
        );

        ppl.stream()
                .filter(p->MALE.equals(p.gender))
                .collect(Collectors.toList())
                .forEach(System.out::println);



//        ppl.stream()
//                .map(p->p.gender)
//                .collect(Collectors.toSet())
//                .forEach(System.out::println);

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
