import Car.Car;
import javafx.collections.transformation.SortedList;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        String[] arr = {"Яблоко", "Яблоко", "Банан", "Арбуз", "Груша", "Яблоко", "Банан",  "Арбуз", "Лимон", "Яблоко", "Банан", "Персик"};
        TreeMap<String, Integer> al = new TreeMap<>();

        for (String i : arr) {
            if (al.containsKey(i)) {
                al.put(i, al.get(i) + 1);
            } else al.put(i, 1);

        }
        System.out.println(al);

        System.out.println("Уникальные слова:");

        Set<Map.Entry<String, Integer>> tm = al.entrySet();
        for (Map.Entry<String, Integer> me : tm) {
            if (me.getValue() == 1) {
                System.out.println(me.getKey());
            }
        }

        System.out.println();

        System.out.println("Неуникальные слова:");
        for (Map.Entry<String, Integer> me : tm) {
            if (me.getValue() > 1) {
                System.out.println(me.getKey() + " ( " + me.getValue() + " повторений)");
            }
        }

        System.out.println();
        System.out.println();

        Phone phone = new Phone();
        phone.add("Семенов", "111111111");
        phone.add("Петров", "2222222222");
        phone.add("Семенов", "3333333333");
        phone.add("Кузнецов", "4444444444");
        phone.add("Хрусталев", "444444444");


        phone.print();

        phone.get("Семенов");
    }
}
