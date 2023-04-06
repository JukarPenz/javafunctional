package com.amioscode.datastructures;

import java.util.LinkedList;
import java.util.ListIterator;

public class WorkingLinkedList {

    public static void main(String[] args) {
        LinkedList<WorkingQueue.Person> ll = new LinkedList<>();
        ll.add(new WorkingQueue.Person("A", 1));
        ll.add(new WorkingQueue.Person("B", 2));
        //ll.add(new Person("C", 3));
        ll.add(new WorkingQueue.Person("D", 4));
//        ll.add(new Person("E", 5));
//        ll.add(new Person("F", 6));
//        ll.add(new Person("G", 7));
        ListIterator<WorkingQueue.Person> it = ll.listIterator();
        while(it.hasPrevious()){
            System.out.println("Previouing: " + it.previous());
        }
        while(it.hasNext()){
            System.out.println("Nexting: "+it.next());
        }
        while(it.hasPrevious()){
            System.out.println("Aftering: " + it.previous());
        }

        System.out.println(ll);
        System.out.println(ll.poll());
        System.out.println(ll.peek());
        System.out.println(ll.poll());
        System.out.println(ll.peekFirst());

    }

}
