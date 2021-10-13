package Lesson3;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

public class TreeApp {
    // Comparable - interface
    // Comparator - abstract class

    public static void main(String[] args) {


        Map<String, Integer> map = new TreeMap<>();

        TreeSet<User> set = new TreeSet<>();
        set.add(new User(10));
        set.add(new User(6));
        set.add(new User(19));
        System.out.println(set);

        TreeSet<String> strings = new TreeSet<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int res = o1.length() - o2.length();
                if (res != 0) {
                    return res;
                }
                return o1.compareTo(o2);
            }
        });
        strings.add("a");
        strings.add("b");
        strings.add("aa");
        strings.add("bbb");
        strings.add("aaa");
        strings.add("bb");

        System.out.println(strings);

    }
}
