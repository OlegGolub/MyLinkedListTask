package com.oleg.test;

import java.util.*;

public class ArrayListConcurrentModification {
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        list.add("a");
        list.add("b");
        list.add("c");

        Set set = new HashSet();
        set.add(null);

        Map map = new TreeMap();
        map.put(null,  "null"); // ошибки нет!

        if (true) return;
        Set map2 = new TreeSet<>();
        map2.add(null); // ошибки нет!

        ListIterator reverseIt = list.listIterator(list.size()-1);
        System.out.println("1------------");
        while(reverseIt.hasPrevious()){
            if(reverseIt.previous()=="b")
                System.out.println("2.5------------");
                //reverseIt.add("NEW");
                //list.add("NEW");
        }
        System.out.println("2------------");
        int i=0;
        //while(reverseIt.hasPrevious()){
        while(i<10){
            list.forEach(System.out::println);
            System.out.println("value:" + reverseIt.next());
            reverseIt.remove();
            System.out.println(list.size());
            list.add("22");
            System.out.println(list.size());
            i++;
        }
        if (true) return;



        ListIterator<String> iterator = list.listIterator();

        while(iterator.hasNext()){

            String str = iterator.next();
            System.out.print(str+" ");

            if(str.equals("b"))
                list.add("b2");   //will throw ConcurrentModificationException

        }

        System.out.println("\nAfter iteration list is : "+list);

    }
}
