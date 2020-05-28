package com.oleg.test;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

/**
 Даны N файлов log. Необходимо за минимально возможное время вычислить распределение возникновения ошибок (ERROR) за каждый час/минуту/. Соответствующие результаты вывести в отдельный файл Statistics.

    Пример лог файла (формат дат выбирается самостоятельно)
    2019-01-01T00:12:01.001;ERROR; Ошибка 1
    2019-01-01T00:12:01.004;ERROR; Ошибка 2
    2019-01-01T00:12:01.006;ERROR; Ошибка 3
    2019-01-02T00:13:02.000;WARN; Предупреждение 1
    2019-01-02T00:13:02.002;ERROR; Ошибка 5
    2019-01-03T00:14:03.003;ERROR; Ошибка 6

    Таких файлов N (<10).
    В файле отчета должны быть  (примерно) такие записи:
    2019-01-01, 11.00-12.00 Количество ошибок: 3
    2019-01-02, 12.00-13.00 Количество ошибок: 1
    2019-01-03, 14.00-15.00 Количество ошибок: 1
*/
public class LogReader {
//
//  public static List<String> files = {
//
//
//
//  };
//
//  public LogReader() throws FileNotFoundException {
//    String fileName  = "fdtgrt";
//    try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
//      stream.forEach(System.out::println);
//    } catch (IOException e) {
//      e.printStackTrace();
//    }
//
//
//    try (BufferedReader br = Files.newBufferedReader(Paths.get(fileName))) {
//
//      //br returns as stream and convert it into a List
//      String line  = br.readLine();
//      parse
//
//          year2
//            month12
//                day31
//                  hour24
//                    minutes 60
//
//        class MyLogStatistic(){
//          ArrayList year = new ArrayList(2);
//          Map month = EnumMap<month, >();
//          Map days  = EnumMap
//          Map hour = EnumMap
//          Map min  = EnumMap
//
//      }
//
//    } catch (IOException e) {
//      e.printStackTrace();
//    }
//
//  }
}
