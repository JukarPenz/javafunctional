package com.amioscode.datastructures;

import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Queue;

public class WorkingQueue {

    public static void main(String[] args) {
        Queue<Person> sup = new LinkedList<>();
        sup.add(new Person("Ale",21));
        sup.add(new Person("Marion",18));
        sup.add(new Person("Ali",40));

        System.out.println(sup.size());
        System.out.println(sup.peek());
        System.out.println(sup.poll());
        System.out.println(sup.peek());
        System.out.println(sup.size());
    }

    static record Person(String name, int age){

    }
}
