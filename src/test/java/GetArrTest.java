import Lesson14.Homework.Main;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class GetArrTest {
    private static Main main;

    @BeforeEach
    void init() {
        System.out.println("Initialization");
        main = new Main();
    }

    @AfterEach
    void finish() {
        System.out.println("Test finished \n");
    }

    @Test
    void test() {
        Assertions.assertEquals("[1, 7]", Arrays.toString(main.getArr(new int[]{1, 2, 4, 4, 2, 3, 4, 1, 7})));
    }

    @Test
     void test2() {

        Assertions.assertEquals("[2, 8, 9, 2]", Arrays.toString(main.getArr(new int[]{5, 3, 8, 6, 4, 2, 8, 9, 2})));
    }

    @Test
    void test3() {
        Assertions.assertEquals("[3, 6, 5, 1, 10]", Arrays.toString(main.getArr(new int[]{1, 1, 1, 5, 2, 4, 3, 6, 5, 1, 10})));
    }
}
