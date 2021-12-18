package Lesson14.Homework;

import java.util.Arrays;

public class Main {

    public static int[] getArr(int[] arr) {
        int x = 0;
        int[] result = null;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 4) {
                x = arr[i];
                result = new int[arr.length - i - 1];

                for (int j = i + 1, k = 0; j < arr.length; j++, k++) {
                    if (arr[j] == 4) continue;
                    result[k] = arr[j];
                }
            }
        }
        try {
            x = 1 / x;
        } catch (ArithmeticException e) {
            throw new RuntimeException();
        }
        return result;
    }

    public static boolean checkArr(Integer[] arr) {
        if (Arrays.asList(arr).contains(1) && Arrays.asList(arr).contains(4)) {
                return true;
            }
        return false;
    }
}