package Homework3;

public class Main {
    public static void main(String[] args) {
        NewPhonebook newPhonebook = new NewPhonebook();
        newPhonebook.add("James", 8435831);
        newPhonebook.add("Ko", 843583211);
        newPhonebook.add("Hi", 84351341);
        newPhonebook.add("Mee", 843583431);

        newPhonebook.getPhones("James");
        newPhonebook.getPhones("Mee");

    }
}
