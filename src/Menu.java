package src;

import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Scanner;

public class Menu {

    public static void runSelectedOption(int option, LinkedList<Vessel> vessels) {

        switch (option) {

            case 1:
                SortingAlgorithms.quickSortAge(vessels);
                break;

            case 2:
                //Variable n para el tamaño del linkedList
                int n = vessels.size();

                //Variable para el for
                int i;

                //Ordena la lista mediante la funcion de mergeSort
                SortingAlgorithms.mergeSort_sort(vessels, 0, n - 1);

                //Listar la lista de barcos ordenado alfabeticamente.
                System.out.println("Nombre de Barcos:");
                for (i = 0; i <= vessels.size() - 1; i++){
                    System.out.println("- " + vessels.get(i).getName());
                }
                break;

            case 3:
                SortingAlgorithms.bucketSortCapabilities(vessels);
                break;

            case 4:
                System.out.print("\n───────────────────────────────────────────────────────────\n" +
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
                        "───────────────────────────────────────────────────────────\n");
                break;

        }
    }


    static int askForInteger(String message, int min, int max) {

        Scanner s = new Scanner(System.in);

        int option = min - 1;

        do {
            System.out.print(message);
            try {
                option = s.nextInt();
                if (option < min || option > max) {
                    System.out.printf("\nPlease enter a number between %d and %d.%n\n", min, max);
                }
            } catch (InputMismatchException e) {
                System.out.println("\nPlease enter a number.\n");
            } finally {
                s.nextLine();
            }
        } while (option < min || option > max);

        return option;
    }

    public static LinkedList<Vessel> DatasetSelection() {

        LinkedList<Vessel> vessels;
        int option;

        System.out.println("\nWelcome to CatTheHobie!");

        System.out.println("\nDataset selection");

        System.out.print("\n\t1) fleetXS.txt");
        System.out.print("\n\t2) fleetS.txt");
        System.out.print("\n\t3) fleetM.txt");
        System.out.println("\n\t4) fleetL.txt\n");

        option = Menu.askForInteger("Please choose an option: ", 1, 4);

        switch (option) {
            case 1:
                vessels = DatasetLoader.loadVessels("fleetXS.txt");
                break;

            case 2:
                vessels = DatasetLoader.loadVessels("fleetS.txt");
                break;

            case 3:
                vessels = DatasetLoader.loadVessels("fleetM.txt");
                break;

            case 4:
                vessels = DatasetLoader.loadVessels("fleetL.txt");
                break;

            default:
                vessels = DatasetLoader.loadVessels("fleetXS.txt");
                break;
        }


        return vessels;
    }

    public static void show() {
        System.out.println(
                        "\n--------------------------------------------------------------------\n" +
                        "\nWhat do you want to do?\n\n" +
                        "   1. Sort vessels by age\n" +
                        "   2. Sort vessels by name\n" +
                        "   3. Sort vessels by capabilities\n" +
                        "   4. Exit\n\n--------------------------------------------------------------------\n");
    }

}
