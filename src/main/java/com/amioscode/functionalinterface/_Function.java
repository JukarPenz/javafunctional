package com.amioscode.functionalinterface;

import java.util.function.BiFunction;
import java.util.function.Function;

public class _Function {

    public static void main(String[] args) {
        int increment = increment(124);
        System.out.println(increment);

        System.out.println(incrementByXFunction.apply(3,4));
        System.out.println(incrementByXFunction.andThen(multByTen).apply(3,2));
    }

    static BiFunction<Integer, Integer, Integer> incrementByXFunction = (nu, mu) -> nu*mu;

    static Function<Integer, Integer> multByTen = n -> n*10;

    static int increment(int n){
        return n+1;
    }
}
