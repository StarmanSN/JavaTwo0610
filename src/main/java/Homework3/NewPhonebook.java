package Homework3;

import java.util.*;

public class NewPhonebook {

    private Map<String, Set<String>> map = new HashMap<>();

    public void add(String name, int phoneNumber) {
        if (map.containsKey(name)) {
            map.get(name).add(String.valueOf(phoneNumber));
        } else {
            Set<String> set = new HashSet<>();
            set.add(String.valueOf(phoneNumber));
            map.put(name, set);
        }
    }
        public Set<String> getPhones (String name){
            return map.getOrDefault(name, Collections.emptySet());
        }

}