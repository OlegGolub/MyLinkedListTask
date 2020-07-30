package com.oleg.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class PrimitiveArray {
  /** Дан массив double[ N ], необходимо реализовать на Java метод, возвращающий частное от деления разности максимального с минимальным элементов
   и среднего арифметического значения элементов массива.
   В случае ошибки требуемый метод должен возвращать только указанный Exception.
   */

  public static List getList1(int[] arrayInts){
    return IntStream.of(arrayInts).boxed().collect(Collectors.toList());
  }

  public static List getList2(int[] arrayInts){
    return Arrays.stream(arrayInts).boxed().collect(Collectors.toList());
  }

  // не работает!  Создается ЛИСт с ОДНИМ элементов ввиде массива
  public static List getList3(int[] arrayInts){
    List<?> list = Arrays.asList(arrayInts);
    List list2  = Stream.of(arrayInts).collect(Collectors.toList());
    return list;
  }

  public static List getList4(int[] arrayList){
    List  list = new ArrayList<Integer>(arrayList.length);
    for(int i = 0; i< arrayList.length; i++) {
      list.add(arrayList[i]);
    }
    return list;
  }

  public static List getList5(int[] arrayInts){
    return Stream.of(arrayInts).collect(Collectors.toList());
  }


  public static int[] sort(int[] sourceArray) throws RuntimeException{
    if(sourceArray==null || sourceArray.length==0) throw new RuntimeException("No array");

    List<Integer> list = getList1(sourceArray);
    list.sort(null);

    int[] array = list.stream().mapToInt(i->i).toArray();
    return array;
  }

  public static int[] sort1(int[] sourceArray) throws RuntimeException{
    if(sourceArray==null || sourceArray.length==0) throw new RuntimeException("No array");

    int [] dst = new int[sourceArray.length];

    Arrays.sort(dst);

    return dst;
  }

  public static void sortPuzeric(int[] sourceArray) throws RuntimeException {
    for (int j = 0; j < sourceArray.length-2; j++) {
      for (int i = 0; i <= sourceArray.length - 2 - j; i++) {
        if (sourceArray[i] > sourceArray[i + 1])
          swap(i, i + 1, sourceArray);
      }
    }
  }

  public static void swap(int in1, int in2,  int [] sourceArray ){
    int temp = sourceArray[in2];
    sourceArray[in2] = sourceArray[in1];
    sourceArray[in1]=temp;
  }

  public static void filterTripleA(Collection<String> strings) throws RuntimeException{

    if(strings==null)  return;

    strings.stream().filter(str-> !str.startsWith("aaa")).collect(Collectors.toList());

    Iterator iterator = strings.iterator();
    while(iterator.hasNext()) {
      String str = (String) iterator.next();
      if (str.startsWith("aaa")) {
        iterator.remove();
      }
    }
  }

  public static double foo(double[] sourceArray) throws RuntimeException {
    if (sourceArray==null || sourceArray.length==0)  throw new RuntimeException("null");

    //1
    DoubleStream.of(sourceArray).boxed().collect(Collectors.toList());

    //2
    Arrays.stream(sourceArray).boxed().collect(Collectors.toList());

    //3
    List<Double> list = new ArrayList<>(sourceArray.length);
    for(int i = 0; i< sourceArray.length; i++){
      list.add(sourceArray[i]);
    }

    //4
    DoubleStream doubleStream1 = DoubleStream.of(sourceArray);

    DoubleStream doubleStream = list.stream().mapToDouble(e->e.longValue());

    double average =  doubleStream.average().getAsDouble(); // must be
    if(average==0) throw  new RuntimeException();
    double max = doubleStream.max().getAsDouble();
    double min = doubleStream.min().getAsDouble();
    double result = (max-min) % average;
    return  result;
  }

  public static void main(String[] args) {
      int[] array  ={1,2,3,4,5,45,7};
      List<Integer>  lI = IntStream.of(array).boxed().collect(Collectors.toList());
     System.out.println(lI.toString());
  }

}
