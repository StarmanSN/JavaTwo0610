package Lesson9.Homework9;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BoxApp {

    public static void main(String[] args) {
        Box<Orange> orangeBox = new Box<>();
        Box<Orange> orangeBox2 = new Box<>();
        Box<Apple> appleBox = new Box<>();
        Box<Apple> appleBox2 = new Box<>();

        for (int i = 0; i < 5; i++) {
            orangeBox.add(new Orange());
        }
        for (int i = 0; i < 5; i++) {
            orangeBox2.add(new Orange());
        }
        for (int i = 0; i < 5; i++) {
            appleBox.add(new Apple());
        }

        orangeBox.lookBox();
        appleBox.lookBox();

        float boxWeight = orangeBox.getWeight();
        float boxWeight2 = appleBox.getWeight();

        System.out.println("Вес коробки 1 с " + orangeBox.list.get(0).toString() + " " + boxWeight);
        System.out.println("Вес коробки 2 с " + orangeBox2.list.get(0).toString() + " " + boxWeight);
        System.out.println("Вес коробки 1 с " + appleBox.list.get(0).toString() + " " + boxWeight2);

        System.out.println(orangeBox.compare(appleBox));
        System.out.println(orangeBox.compare(orangeBox2));

        orangeBox.moveTo(orangeBox2);

        orangeBox.lookBox();
        orangeBox2.lookBox();
        appleBox.lookBox();
        appleBox2.lookBox();
    }

    public static class Box<B extends Fruits> {
        public List<B> list;

        public Box(List<B> list) {
            this.list = list;
        }

        public List<B> getList() {
            return list;
        }

        public void setList(List<B> list) {
            this.list = list;
        }

        @SafeVarargs
        public Box(B... fruit) {
            list = Arrays.asList(fruit);
        }

        public Box() {
            list = new ArrayList<B>();
        }

        public void add(B fruit) {
            list.add(fruit);
        }

        public void lookBox() {
            if (list.isEmpty()) {
                System.out.println("Эта коробка пуста.");
            } else {
                System.out.println("В коробке находятся " + list.get(0).toString() + " в количестве - " + list.size() + "шт.");
            }
        }

        public void moveTo(Box<B> box) {
            box.getList().addAll(list);
            list.clear();
        }

        public float getWeight() {
            if (list.isEmpty()) {
                return 0;
            } else {
                return list.size() * list.get(0).getWeight();
            }
        }

        public boolean compare(Box<? extends Fruits> box) {
            if (this.getWeight() == box.getWeight()) {
                System.out.println("Коробки одинаковые");
            }
            System.out.println("Коробки разные");
            return false;
        }

    }
}
