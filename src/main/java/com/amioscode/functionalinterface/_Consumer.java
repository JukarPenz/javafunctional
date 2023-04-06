package com.amioscode.functionalinterface;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class _Consumer {

    public static void main(String[] args) {
        greet.accept(new Customer("Maria", "81184557"));
        replace.accept(new Customer("Maria", "81184557"), " 01800 6447 88");
    }


    static Consumer<Customer> greet = c -> System.out.println("Hello dear  " + c.name +", thanks from registering your phone number: " + c.phone );
    static BiConsumer<Customer, String> replace = (c, p) -> System.out.println("Hi dear " + c.name+ ", we will replace your current phone number: " + c.phone + " to the new one: " + p );

    static class Customer{
        private final String name;
        private final String phone;

        public Customer(String name, String phone) {
            this.name = name;
            this.phone = phone;
        }
    }
}
