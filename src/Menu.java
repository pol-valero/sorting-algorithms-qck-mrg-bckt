package src;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {

    public static void runOption(int option, Scanner s) {


        System.out.println();

        switch (option) {
            case 1:

                System.out.println("⣿⣿⣿⣿⣿⣿\n" +
                        "⣿⣿\n" +
                        "⣿⣿⣿⣿\n" +
                        "⣿⣿\n" +
                        "⣿⣿\n" +
                        "⣿⣿");
                break;

            case 2:

                break;
            case 3:

                break;
            case 4:
                System.out.println("───────────────────────────────────────────────────────────\n" +
                        "─██████████████───████████──████████─██████████████─██████─\n" +
                        "─██░░░░░░░░░░██───██░░░░██──██░░░░██─██░░░░░░░░░░██─██░░██─\n" +
                        "─██░░██████░░██───████░░██──██░░████─██░░██████████─██░░██─\n" +
                        "─██░░██──██░░██─────██░░░░██░░░░██───██░░██─────────██░░██─\n" +
                        "─██░░██████░░████───████░░░░░░████───██░░██████████─██░░██─\n" +
                        "─██░░░░░░░░░░░░██─────████░░████─────██░░░░░░░░░░██─██░░██─\n" +
                        "─██░░████████░░██───────██░░██───────██░░██████████─██████─\n" +
                        "─██░░██────██░░██───────██░░██───────██░░██────────────────\n" +
                        "─██░░████████░░██───────██░░██───────██░░██████████─██████─\n" +
                        "─██░░░░░░░░░░░░██───────██░░██───────██░░░░░░░░░░██─██░░██─\n" +
                        "─████████████████───────██████───────██████████████─██████─\n" +
                        "───────────────────────────────────────────────────────────");
                break;

        }

        System.out.println();
    }


    /**
     * Descripcion: Pregunt
     */
    static int askForInteger(String message, int min, int max, Scanner s) {
        int option = min - 1;

        do {
            System.out.print(message);
            try {
                option = s.nextInt();
                if (option < min || option > max) {
                    System.out.printf("Please enter a number between %d and %d.%n", min, max);
                }
            } catch (InputMismatchException e) {
                System.out.println("Please enter a number.");
            } finally {
                s.nextLine();
            }
        } while (option < min || option > max);

        return option;
    }

    public static void ShowMenu() {
        System.out.println(
                "Welcome to CatTheHobie!\n--------------------------------------------------------------------------\nWhat do you want to do?\n\n" +
                        "   1. Embarcacions en funció de l’antiguitat\n" +
                        "   2. Embarcacions en funció del nom\n" +
                        "   3. Embarcacions en funció de les prestacions\n" +
                        "   4. Exit\n--------------------------------------------------------------------------\n");
    }
}
