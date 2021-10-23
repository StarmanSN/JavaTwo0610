package Lesson4;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

public class IterableApp {
    public static void main(String[] args) {
        List<String> list = List.of("one", "two", "three");
        Iterator<String> iterator = list.iterator();
        list = new ArrayList<>(list);
        while (iterator.hasNext()) {
            String str = iterator.next();
            System.out.println(str);
        }
        // remove if < 4
        iterator = list.iterator();
        while (iterator.hasNext()) {
            String str = iterator.next();
            if (str.length() < 4) {
                iterator.remove();
            }
        }
        list.add("aa");
        list.removeIf(str -> str.length() < 4); // Удали, если длина строки меньше 4

        list.stream()
                .filter(x -> x.length() > 4)
                .map(x -> x.length())
                .forEach(x -> System.out.println(x));
        System.out.println(list);

        String s = "abc";
        s.toUpperCase(Locale.ROOT); // s = s.toUpperCase(Locale.ROOT) -> ABC
        System.out.println(s);
        // abc
    }
}
