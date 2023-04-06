package com.amioscode.datastructures;

import java.util.HashMap;
import java.util.Map;

public class WorkingMaps {

    public static void main(String[] args) {
        Map<Integer,Person> map = new HashMap<Integer,Person>();
        map.put(1,new Person("Alex"));
        map.put(22,new Person("Alexa"));
        map.put(13,new Person("Mariam"));
        map.put(4,new Person("Mariam"));
        map.put(22,new Person("New Alexa"));

        System.out.println(map);
        System.out.println(map.entrySet());
        System.out.println(map.keySet());

        map.entrySet().forEach(m-> {
            System.out.println(m.getKey()+"->"+m.getValue());
        });

        map.forEach((k,v)->{
            System.out.println(v.name);
        });
    }

    record Person(String name){};
}
