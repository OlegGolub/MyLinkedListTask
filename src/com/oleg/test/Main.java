package com.oleg.test;

import static com.oleg.test.PrimitiveArray.*;

import java.util.Arrays;
import java.util.List;
import java.lang.Integer;
import java.util.Random;
import java.util.stream.DoubleStream;

public class Main {
  static int data = 0;
  static boolean run = true;

    public static void main(String[] args) {



//      new Thread(() -> {data = 1;run = false;}).start();
//
//      while (run) {/*NOP*/};
//      System.out.println(" test volatile: "+data);

      //testUtil1();
      //testMyList();

      //List listWithDuplicates = Arrays.asList("1", "1", "2");
      //DuplicateSearcher.DuplcateInfo info= DuplicateSearcher.getDuplicate(listWithDuplicates);

      MyLinkedListVer1 list = new MyLinkedListVer1();
      list.add(1);
      list.add(2);
      list.add(3);
      list.add(4);
      list.add(5);
      list.add(6);
      list.add(7);
      list.add(8);
      list.add(9);
      list.add(10);
      Integer data = (Integer) list.getIFromTheLast(3);



      list.printReverse(list.head);
      double[]  sourceArray = {4,5,6,6,7,87,4,9,9,90};
      DoubleStream doubleStream1 = DoubleStream.of(sourceArray);
      doubleStream1.forEach(e->System.out.print(" "+e));

      //List<Integer>  fi = Fibonacci.getFibonacci(10);
      //System.out.println("Fi test are :["+fi + "]");

      //System.out.println("Searcher duplicates: src=["+listWithDuplicates.toString()+"] dupl is : ["+info+"]");


      //testMyListInteger();

     // String test = "123456789";
     // String mirror = StringReplacer.mirrorString(test);
     // System.out.println("Mirror: [" + test +"] became: [" + mirror + "]");

      //testMiddle();

     // testCycled();

    //  testMiddle();

//      System.out.println("Is digit: 32432432423 a palindrome: "+ Palindrome.isPalindrome(322432423));
//      System.out.println("Is digit: 123321 a palindrome: "+ Palindrome.isPalindrome(123321));
//      System.out.println("Is digit: 77 a palindrome: "+ Palindrome.isPalindrome(77));
//      System.out.println("Is digit: 1 a palindrome: "+ Palindrome.isPalindrome(1));
//      System.out.println("Is digit: 23 a palindrome: "+ Palindrome.isPalindrome(23));
    }

    public static void testUtil1(){
      int[] example ={1,4,5,6,7,898,2,4,56};

      System.out.println("Array 1 " + getList1(example).toString());

      System.out.println("Array 2 " + getList2(example).toString());

      System.out.println("Array 3 " + getList3(example).toString());

      System.out.println("Array 4 " + getList4(example).toString());

      int [] dst1 = sort(example);
      System.out.println("Array dst1 " + getList1(dst1).toString());

      int [] dst2 = example;
      sortPuzeric(dst2);
      System.out.println("Array dst2" + getList1(dst2).toString());
    }

    public static void testMyList(){
      MyLinkedListVer1 myList  = new MyLinkedListVer1();
      myList.add("1");
      myList.add("3");
      myList.add("13");
        myList.add("11");
      myList.add("14");
      myList.add("51");
      myList.add("65");
      System.out.println(myList.toString());
      System.out.println("Middle is : " +myList.getMiddle());
      assert myList.getMiddle()=="11";
    }

  public static void testMyListInteger(){
  System.out.println("testMyListInteger");
    MyLinkedListVer1 myList  =new MyLinkedListVer1();
    myList.add(Integer.valueOf("1"));
    myList.add(Integer.valueOf("3"));
    myList.add(Integer.valueOf("13"));
    myList.add(Integer.valueOf("11"));
    myList.add(Integer.valueOf("14"));
    myList.add(Integer.valueOf("51"));
    myList.add(Integer.valueOf("65"));
    System.out.println(myList.toString());
    System.out.println("Middle is : " +myList.getMiddle());
    assert myList.getMiddle()=="11";
  }

  public static void testMiddle(){
    System.out.println("textCycled");
    MyLinkedListVer1<Integer> list = makeList(3);
    System.out.println(list.toString());
    Integer middle = list.getMiddle();
    System.out.println("Middle is :" + middle);
  }

  public static void testCycled(){
    System.out.println("textCycled");
    MyLinkedListVer1<Integer> list = makeList(20);
    System.out.println(list.toString());
    list.makeCycled();
    System.out.println("Is cycled: "+ list.isCycled());
    try {
      list.toString();
    }
    catch (Error e){
      System.out.println("List is cycled Error");
    }

  }
  public static MyLinkedListVer1 makeList(int lenght){
      if (lenght==0) lenght=10;

    MyLinkedListVer1 list = new MyLinkedListVer1();
      Random random = new Random();
      while(lenght-->0){
        list.add(random.nextInt(1000));
      }
      return list;
  }
}


