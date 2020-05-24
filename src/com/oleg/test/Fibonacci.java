package com.oleg.test;

import java.util.ArrayList;
import java.util.List;

public class Fibonacci {
   private Fibonacci(){};

   //Напишите программу для вывода чисел Фибоначчи
  public static List<Integer> getFibonacci(int number){
   List list = new ArrayList(number);
    for(int i=0; i<number;i++){
      list.add(getFibonacciDigit(i));
    }
    return list;
  }

  public static int getFibonacciDigit(int index) {
    if (index <2) return 1;
      return getFibonacciDigit(index - 2) + getFibonacciDigit(index - 1);
  }
}