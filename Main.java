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



//        TreeMap<String, String> tel = new TreeMap<>();
//        tel.put("Голубев", "+79648077863");
//        tel.put("Смирнов", "+79648047845");
//        tel.put("Кузнецов", "+79645077811");
//        tel.put("Голубев", "+796480777866");
//        tel.put("Петров", "+79648999809");
//        tel.put("Сомов", "+79648807867");
//
//        System.out.println(tel);
//        System.out.println();
//
//        String a = "Голубев ";
//        System.out.println("Вы ищите: " + a);
//
//        Set<Map.Entry<String, String>> tl = tel.entrySet();
//        System.out.println(tl);
//
//        for (Map.Entry<String, String> me : tl) {
//            if (me.getKey() == a) {
//                System.out.println(me.getKey() + " " + me.getValue());
//            }
//        }






    }
}
