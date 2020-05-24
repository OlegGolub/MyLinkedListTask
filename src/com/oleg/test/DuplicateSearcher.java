package com.oleg.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class DuplicateSearcher {
  //Как найти продублированные элементы в массиве, если их больше одного?
  public static  <E> DuplicateSearcher.DuplcateInfo getDuplicate(List<E> sourceList) {
    E element = null;
    int count = 0;
    if (sourceList == null || sourceList.isEmpty()) {
      throw new RuntimeException("Empty array");
    }

    Set set  = new HashSet<>();
    ArrayList indexes = new ArrayList(sourceList.size());
    for (int i = 0; i < sourceList.size(); i++) {
      E e = sourceList.get(i);
      if (set.contains(e)) {
        element = e;
        count++;
        indexes.add(i);
      } else {
        set.add(e);
      }
    }
    indexes.trimToSize();

    return new DuplcateInfo(element, count, indexes);
  }
  public static class DuplcateInfo<E>{
      int count;
      E element;
      List<Integer> indexes;
      DuplcateInfo(E element, int count,  List indexes){
        this.count=count;
        this.element=element;
        this.indexes = indexes;
    }

    @Override
    public String toString() {
      return "DuplcateInfo{" +
          "count=" + count +
          ", element=" + element +
          ", indexes=" + indexes +
          '}';
    }
  }
}
