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
        map.put("key", 100); // изначальное значение в 100 в ключе
        map.put("key", 200); // перезаписали значение

        map.containsKey("key"); // содержание ключа
        map.remove("key"); // удаление
        map.size(); // размер
        map.getOrDefault("key123", 10); // return default если такого объекта нет
        map.get("key"); // return null если такого объекта нет
        map.isEmpty(); // проверка на пустоту
        map.values(); // Collection (все значения, которые могут повторяться)
        map.keySet(); // set (множество, только уникальные значения)

        Set<Integer> set = new HashSet<>();

    }

}
