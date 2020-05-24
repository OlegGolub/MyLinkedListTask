package com.oleg.test;

//Как изменить порядок элементов в строке на обратный без использования вспомогательных классов?
public class StringReplacer {

  public static String mirrorString(String source) {
    if (source == null || source.isEmpty()) {
      return source;
    }
    char array[] = source.toCharArray();
    int lastIndex = (source.length() - 1);
    for (int i = 0; i <= lastIndex/2; i++) {
      char temp = array[i];
      array[i] = array[lastIndex - i];
      array[lastIndex - i] = temp;
    }

    return new String(array);
  }

}
