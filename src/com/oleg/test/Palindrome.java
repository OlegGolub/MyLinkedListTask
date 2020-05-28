package com.oleg.test;

public class Palindrome {
  public static boolean isPalindrome(int value){
    return isPalindrome(String.valueOf(value));
  }

  public static boolean isPalindrome(String value){
    int length = value.length();
    for(int i=0; i<length/2; i++){
      if(value.charAt(i)!=value.charAt(length-1-i)) {
        return false;
      }
    }
    return true;
  }
}
