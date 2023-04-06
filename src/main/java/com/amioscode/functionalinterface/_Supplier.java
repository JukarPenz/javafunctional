package com.amioscode.functionalinterface;

import java.util.List;
import java.util.function.Supplier;

public class _Supplier {

    public static void main(String[] args) {

        System.out.println(getDBConnectionUrl());
        System.out.println(getDBConnectionURL.get());
    }

    static Supplier<List<String>> getDBConnectionURL = () -> List.of("jdbc://localhost:1433/users");
    //static Bi
    static String getDBConnectionUrl(){
        return "jdbc://localhost:1433/users";
    }
}
