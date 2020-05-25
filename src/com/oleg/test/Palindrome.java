package com.oleg.test;

public class Palindrome {
  public static boolean isPalindrome(int value){
    return isPalindrome(String.valueOf(value));
  }

  public static boolean isPalindrome(String value){
    String valueStr = String.valueOf(value);
    int length = valueStr.length();
    for(int i=0; i<length/2; i++){
      if(valueStr.charAt(i)!=valueStr.charAt(length-1-i)) {
        return false;
      }
    }
    return true;
  }
}
