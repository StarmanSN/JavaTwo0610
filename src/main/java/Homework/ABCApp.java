package Homework;

public class ABCApp {
    private final Object lock = new Object();
    private volatile String currentLetter = "A";

    public static void main(String[] args) {
        ABCApp app = new ABCApp();
        Thread t1 = new Thread(app::printA);
        Thread t2 = new Thread(app::printB);
        Thread t3 = new Thread(app::printC);
        t1.start();
        t2.start();
        t3.start();

    }

    public void printA() {
        synchronized (lock) {
            try {
                for (int i = 0; i < 5; i++) {
                    while (!currentLetter.equals("A")) {
                        lock.wait();
                    }
                    System.out.print("A");
                    currentLetter = "B";
                    lock.notifyAll();
                }
            } catch (InterruptedException ie) {
                ie.printStackTrace();
            }
        }
    }

    public void printB() {
        synchronized (lock) {
            try {
                for (int i = 0; i < 5; i++) {
                    while (!currentLetter.equals("B")) {
                        lock.wait();
                    }
                    System.out.print("B");
                    currentLetter = "C";
                    lock.notifyAll();
                }
            } catch (InterruptedException ie) {
                ie.printStackTrace();
            }
        }
    }

    public void printC() {
        synchronized (lock) {
            try {
                for (int i = 0; i < 5; i++) {
                    while (!currentLetter.equals("C")) {
                        lock.wait();
                    }
                    System.out.print("C");
                    currentLetter = "A";
                    lock.notifyAll();
                }
            } catch (InterruptedException ie) {
                ie.printStackTrace();
            }
        }
    }
}
