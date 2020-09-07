package com.oleg.test;

import java.math.BigInteger;
import java.util.Arrays;

public class SortedArrayMerge {

    public static BigInteger[] mergeASC(BigInteger[] array1, BigInteger[] array2) {

        BigInteger[] mergedArray= new BigInteger[array1.length+array2.length];
        int mergedIndex=0;
        int arr1Index=0;
        int arr2Index=0;
        int length1=array1.length;
        int length2=array2.length;

        while(arr1Index<length1 && arr2Index<length2 ) {
            if (array1[arr1Index].compareTo(array2[arr2Index]) <= 0) {
                mergedArray[mergedIndex++] = array1[arr1Index++];
            } else {
                mergedArray[mergedIndex++] = array2[arr2Index++];
            }
        }

        while(arr1Index<length1)
            mergedArray[mergedIndex++]=array1[arr1Index++];

        while(arr2Index<length2)
            mergedArray[mergedIndex++]=array2[arr2Index++];

        return mergedArray;
    }

    public static void main(String[] args) {
        BigInteger[] arr1 = {
                BigInteger.valueOf(20),
                BigInteger.valueOf(30),
                BigInteger.valueOf(40),
                BigInteger.valueOf(50),
                BigInteger.valueOf(60),
                BigInteger.valueOf(70)};
        BigInteger[] arr2 = {
                BigInteger.valueOf(15),
                BigInteger.valueOf(25),
                BigInteger.valueOf(35),
                BigInteger.valueOf(45),
                BigInteger.valueOf(55),
                BigInteger.valueOf(65),
                BigInteger.valueOf(75),
                BigInteger.valueOf(85)};

        BigInteger[] dst = SortedArrayMerge.mergeASC(arr1, arr2);
        System.out.println("Merge result: " + Arrays.asList(dst));
    }
}
