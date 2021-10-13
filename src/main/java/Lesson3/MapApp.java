package Lesson3;

import com.sun.source.doctree.SeeTree;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MapApp {
    public static void main(String[] args) {
        //equals
        //hashcode
        Map<String, Integer> map = new HashMap<>();
        map.put("key", 100);
        map.put("key", 200);

        map.containsKey("key");
        map.remove("key");
        map.size();
        map.getOrDefault("key123", 10); // return default
        map.get("key"); // return null
        map.isEmpty(); // проверка на пустоту
        map.values(); // Collection
        map.keySet(); // set

        Set<Integer> set = new HashSet<>();

    }

}
