package Lesson5;

public class ThreadApp {
    public static void main(String[] args) throws InterruptedException {
        Thread.sleep(1000);
        new Thread(() -> {
            try {
                Thread.sleep(3000); //3 sec
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName());
        }).start();

        new Thread(() -> {
            System.out.println(Thread.currentThread().getName());
        }).start();

        Thread thread = new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Deamon " + Thread.currentThread().getName());
        });
        thread.setDaemon(true);
        thread.start();
    }
}
