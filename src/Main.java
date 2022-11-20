package src;

public class Main {
    public static void main(String[] args) {

        int option;

        Menu.showInitialGreeting();

        do {

            Menu.showMenu();
            option = Menu.askForInteger("Please choose an option: ", 1, 4);
            Menu.runSelectedOption(option);

        } while (option != 4);

    }

}