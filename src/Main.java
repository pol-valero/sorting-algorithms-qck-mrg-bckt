package src;

import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {

        int option;

        LinkedList<Vessel> vessels;
        vessels = Menu.DatasetSelection();

        do {

            Menu.show();
            option = Menu.askForInteger("Please choose an option: ", 1, 4);
            Menu.runSelectedOption(option, vessels);

        } while (option != 4);

    }

}