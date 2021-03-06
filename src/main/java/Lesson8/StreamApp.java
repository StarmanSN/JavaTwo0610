package Lesson8;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamApp {
    public static void main(String[] args) {
        Random random = new Random();

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            list.add(random.nextInt(100)); // вернет число от 0-99
        }
        System.out.println(list);

        Stream<Integer> stream = list.stream(); // list.iterator()

        //stream.forEach(i -> System.out.println(i));

        long count = list.stream()
                //.skip(50)
                .limit(50)
                .peek(i -> System.out.println(i))
                .filter(integer -> integer % 2 == 0)
                //.count();
                //.max(Comparator.naturalOrder()).get();    //максимвльный элемент

                .count();
                System.out.println(count);

                Stream<String> stringStream = Stream.of("aaaa", "bbbb", "cccc", "aaa", "aaaa", "bbb");

//                List<String> collect = stringStream
//                        .filter(s -> s.length() == 4)
//                        .map()

        Map<String, Integer> map = stringStream
                .collect(Collectors.toMap(str -> str, str -> 1, (v1, v2) -> v1 + 1));
        System.out.println(map);
    }
}
