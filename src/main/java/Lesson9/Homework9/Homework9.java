package Lesson9.Homework9;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Homework9 {

    public static void main(String[] args) {
        week();
        arrayToList();
    }

    /**
     * Сделал по простому, взял один элемент и поменял его на другой и обратно, по другому не знаю как можно сделать.
     */

    public static void week() {
        String[] days = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};
        for (int i = 0; i < days.length; i++) {
            String str = days[1];
            days[1] = days[2];
            days[2] = str;
        }
        System.out.println(Arrays.toString(days));
    }

    public static void arrayToList() {
        String[] days = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};
        List<String> list = new ArrayList<>();
        list = Arrays.asList(days);
        for (String str : days) {
            System.out.println(" " + str);
        }
        System.out.println();
        list = new ArrayList<String>();
        Collections.addAll(list, days);
        list.add("Sunday");
        for (String str1 : list) {
            System.out.println(str1);
        }
    }
}
