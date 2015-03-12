package collections;

import utils.Printer;

import java.util.Date;
import java.util.Map;

import java.util.WeakHashMap;

/**
 * Created by user on 03.03.15.
 */
public class WeakHashMapImpl {
    public static void main(String[] args) {

        Map<Date, String> map = new WeakHashMap<>();
        Date date = new Date();
        Date date2 = new Date();
        map.put(date, "test");
        map.put(date2, "test2");
        date = null;
        System.gc();

        print(map);

        Printer.PrinterM printerM = new Printer.PrinterM();
        printerM.printM(map);
    }

    public static <K, V> void print(Map<K, V> map) {

        for (int i = 0; i < 10000; i++) {
            map.forEach((K, V) -> System.out.println(K.toString() + " : " + V.toString()));
        }
    }
}
