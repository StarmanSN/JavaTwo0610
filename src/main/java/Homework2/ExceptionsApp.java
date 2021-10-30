package Homework2;

public class ExceptionsApp {
    public static void main(String[] args) throws MyArraySizeException, MyArrayDataException {

        String[][] arr = {
                {"1", "2", "3"},
                {"1", "2", "3", "4"},
                {"1", "2", "3", "1"},
                {"1", "2", "3", "7"},
        };
        try {
            String[][] arr2 = {
                    {"1", "2", "3", "4"},
                    {"1", "2", "3", "4"},
                    {"1", "2", "3", "4"},
                    {"1", "2", "3", "4"},
            };
            try {
                System.out.println(someMethod(arr));

            } catch (MyArraySizeException me) {
                me.printStackTrace();
            }

            System.out.println(someMethod(arr2));

        } catch (MyArrayDataException de) {
            System.err.println("Ошибка в ячейке " + (de.i + 1) + " " + (de.j + 1));
            de.printStackTrace();
        }
    }

    static int someMethod(String[][] array) {
        int count = 0;
        if (array.length != 4) throw new MyArraySizeException("Неверное количество строк в массиве");
        {
            for (int i = 0; i < array.length; i++) {
                if (array[i].length != 4)
                    throw new MyArraySizeException("Неверное количество столбцов в строке " + (i + 1));
                for (int j = 0; j < array.length; j++) {
                    try {
                        count += Integer.parseInt(array[i][j]);
                    } catch (NumberFormatException ex) {
                        throw new MyArrayDataException(ex.getMessage(), i, j);
                    }
                }
            }
            return count;
        }
    }
}