package Homework3;

public class PhonebookApp {

    public static void main(String[] args) {

        Phonebook phonebook = new Phonebook();

        phonebook.addSubscriber(892565642, "Stevens");
        phonebook.addSubscriber(89553135, "Chan");
        phonebook.addSubscriber(892145646, "McDonald");
        phonebook.addSubscriber(892145648, "Lee");
        phonebook.addSubscriber(892145645, "Lee");

        phonebook.getNumber("Stevens");
        phonebook.getNumber("Chan");
        phonebook.getNumber("Lee");

    }
}
