import Lesson14.Homework.Main;
import org.junit.jupiter.api.*;

public class CheckArrTest {
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
        Assertions.assertTrue(main.checkArr(new Integer[]{1, 1, 1, 4, 4, 1, 4, 4}));
    }

    @Test
    void test2() {
        Assertions.assertFalse(main.checkArr(new Integer[]{1, 1, 1, 1, 1, 1, 1}));
    }

    @Test
    void test3() {
        Assertions.assertFalse(main.checkArr(new Integer[]{4, 4, 4, 4}));
    }

    @Test
    void test4() {
        Assertions.assertTrue(main.checkArr(new Integer[]{1, 4, 4, 1, 1, 4, 3}));
    }
}
