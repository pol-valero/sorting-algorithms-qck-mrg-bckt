package code;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int option = -1;
        do {
            Menu.ShowMenu();
            option = Menu.askForInteger("Please choose an option: ", 1, 4, s);
            Menu.runOption(option, s);
        } while (option != 4);
    }

}