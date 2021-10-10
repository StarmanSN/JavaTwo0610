package Lesson2.exception;

public class ExceptionsApp {

    public static void main(String[] args) {
        try {
            int a = 10;
            int b = 2;
            System.out.println("a/b = " + div(a, b));
            b = 0;
            System.out.println("a/b = " + div(a, b));

        } catch (Exception ae) { //ArithmeticException ae
            System.out.println("Поймал исключение");
            ae.printStackTrace(System.out);
        }
        System.out.println();
        System.out.println();
        System.out.println();

        // open file
        try {
            // read
            System.out.println(divFirstAndSecond(args));
        } catch (ArithmeticException ae) {
            System.out.println("Попытались поделить на 0");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Массив неподходящей длинны");
        } catch (Exception ex) {                 // от меньшего в большему
            System.out.println("Что-то другое");
        } finally {
            //close file
            System.out.println("Будет выполнена всегда");

        }
    }

    static int div(int a, int b) {
        return div2(a, b);
    }

    static int div2(int a, int b) {
        return a / b;
    }

    /**
     * Передали массив. Вернем результат деления первого на второе.
     * Не умеем делить на 10.
     * @param array
     * @return
     */

    static int divFirstAndSecond(String[] array) throws MyCustomException{

        int a = Integer.parseInt(array[0]);
        int b = Integer.parseInt(array[1]);
        if (b == 10) {
            throw new MyCustomException(10);
        }
        return a/b;
    }
}