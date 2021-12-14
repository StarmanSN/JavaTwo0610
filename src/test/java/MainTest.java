import Lesson14.Homework.Main;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class MainTest {
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
        Assertions.assertFalse(main.checkArr(new int[]{1,1,3,5,4,1,5,3,4}));
    }
}
