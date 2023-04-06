package com.amioscode.datastructures;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class WorkingSet {

    public static void main(String[] args) {
        Set<Ball> balls = new HashSet<>();
        balls.add(new Ball("blue"));
        balls.add(new Ball("blue"));
        balls.add(new Ball("blue"));
        balls.add(new Ball("blue"));
        balls.add(new Ball("yellow"));
        balls.add(new Ball("red"));
        balls.add(new Ball("green"));

        balls.add(new Ball("red"));

        balls.forEach(System.out::println);

//        for (Ball b :
//                balls) {
//
//        }

    }

    static record Ball(String color){}
}
