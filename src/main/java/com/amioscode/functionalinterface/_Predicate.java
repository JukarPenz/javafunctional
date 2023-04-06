package com.amioscode.functionalinterface;

import java.util.function.Predicate;

public class _Predicate {

    public static void main(String[] args) {
        System.out.println(isPhoneNumberValid("07000000000"));
        System.out.println(isPhoneNumberValid("09000050000"));
        System.out.println(isPhoneNumberValid("0700000000"));
        //System.out.println("09000000000");

        //
        System.out.println(isPhoneNumberValid.test("07000000000"));
        System.out.println(isPhoneNumberValid.test("09000050000"));
        System.out.println(isPhoneNumberValid.test("0700000000"));
        System.out.println(isPhoneNumberValid.and(containsNumber3).test("0700000000"));
        System.out.println(isPhoneNumberValid.and(containsNumber3).test("0703000000"));
        System.out.println(isPhoneNumberValid.and(containsNumber3).test("07030000006"));

    }

    static boolean isPhoneNumberValid(String pn){
        return pn.startsWith("07") & pn.length() == 11;
    }

    static Predicate<String> isPhoneNumberValid = p -> p.startsWith("07") & p.length() == 11;
    static Predicate<String> containsNumber3 = p -> p.contains("3");

}
