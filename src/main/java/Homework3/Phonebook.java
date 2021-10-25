package Homework3;

import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;

public class Phonebook {

    Map<Integer, String> phonebook = new TreeMap<>();

    public void addSubscriber(Integer number, String lastName) {
        this.phonebook.put(number, lastName);
    }

    public void getNumber(String lastName) {
        Set<Map.Entry<Integer, String>> set = phonebook.entrySet();
        System.out.println("Номер телефона по фамилии: " + lastName);
        for (Map.Entry<Integer, String> phone : set) {
            if (Objects.equals(phone.getValue(), lastName)) {
                System.out.println(phone.getKey());
            }
        }
    }
}
