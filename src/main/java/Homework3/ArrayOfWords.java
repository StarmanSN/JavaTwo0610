package Homework3;

import java.util.*;
import java.util.ArrayList;

public class ArrayOfWords {
    public static void main(String[] args) {

        List<String> words = Arrays.asList("вода", "дом", "трава", "трава",
                "еда", "трава", "вода", "дом", "трава", "трава", "еда", "трава");
        List<String> list = new ArrayList<>();

        System.out.println("Слова в массиве: " + words);
        System.out.println();
        System.out.println("Количество повторений слова \"вода\": " + Collections.frequency(words, "вода"));
        System.out.println("Количество повторений слова \"дом\": " + Collections.frequency(words, "дом"));
        System.out.println("Количество повторений слова \"трава\": " + Collections.frequency(words, "трава"));
        System.out.println("Количество повторений слова \"еда\": " + Collections.frequency(words, "еда"));
        System.out.println();

        int count = 0;
        for (String word : words) {
            int id = words.lastIndexOf(word);
            if (id == count) {
                list.add(word);
            }
            count++;

        }
        System.out.println("Уникальных слов - " + list.size() + ": " + list);
        System.out.println();

        /**
         * Не получается использовать эту реализацию для подстчета количества слов. Данный код получается использовать только в этом
         * месте, когда значения уже отсортированны по уникальности.
         */

      /*  Set<String> uniqueWords = new LinkedHashSet<>(list);
        for (String word : uniqueWords) {
            System.out.println("Количество повторения слова " + word.toUpperCase(Locale.ROOT) + ": " + Collections.frequency(list, words));
        }*/

    }
}
