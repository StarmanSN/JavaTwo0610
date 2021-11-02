package Homework5;

import java.util.Arrays;

public class Multithreading {

    public static void main(String[] args) {
        firstMethod();
        secondMethod();
    }

    public static void firstMethod() {
        int size = 100_000_00;
        float[] arr = new float[size];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1.0f;
        }
        Arrays.toString(arr);
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        System.out.println("First thread time: " + (System.currentTimeMillis() - startTime) + " ms.");
    }

    public static void secondMethod() {
        int size = 100_000_00;
        int half = size / 2;
        float[] arr = new float[size];
        Arrays.fill(arr, 1.0f);
        long startTime = System.currentTimeMillis();

        float[] leftHalf = new float[half];
        float[] rightHalf = new float[half];

        new Thread(() -> System.arraycopy(arr, 0, leftHalf, 0, half)).start();
        new Thread(() -> System.arraycopy(arr, half, rightHalf, 0, half)).start();

        Thread thread = new Thread(() -> {
            for (int i = 0; i < leftHalf.length; i++) {
                leftHalf[i] = 1.0f;
                leftHalf[i] = (float) (leftHalf[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
        });
        thread.start();

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < rightHalf.length; i++) {
                rightHalf[i] = 1.0f;
                rightHalf[i] = (float) (rightHalf[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
        });
        thread2.start();

        float[] mergedArr = new float[size];
        new Thread(() -> System.arraycopy(leftHalf, 0, mergedArr, 0, half)).start();
        new Thread(() -> System.arraycopy(rightHalf, 0, mergedArr, half, half)).start();
        Arrays.toString(mergedArr);

        Thread thread3 = new Thread(() -> {
            for (int i = 0; i < mergedArr.length; i++) {
                mergedArr[i] = 1.0f;
                mergedArr[i] = (float) (mergedArr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
        });
        thread3.start();

        System.out.println("Second thread time: " + (System.currentTimeMillis() - startTime) + " ms.");
    }
}
