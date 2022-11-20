package src;

import java.lang.reflect.Field;
import java.util.LinkedList;

public class SortingAlgorithms {

    //Aquesta funció només s'utilitza per a printejar l'array d'objectes
    //completa per pantalla (per testejar). S'ha de borrar al final.
    private static void printAllDatasetObjects (LinkedList<Vessel> vessels) {
        for(Vessel vessel: vessels) {
            System.out.print("\n\n");
            for (Field field : vessel.getClass().getDeclaredFields()) {
                String name = field.getName();
                Object value;
                try {
                    value = field.get(vessel);
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
                System.out.printf("%s: %s%n", name, value);
            }
        }
    }

    public static void quickSortAge (LinkedList<Vessel> vessels) {

    }

    public static void mergeSortName (LinkedList<Vessel> vessels) {

    }

    public static void bucketSortCapabilities (LinkedList<Vessel> vessels) {
        //Per ordenar vaixells per prestacions, primer hem de ponderar els seus
        //atributs (pes, eslora, capacitat, velocitat max) amb un pes diferent
        //cadascun. Un cop això estigui fet, per cada vaixell tindrem un resultat
        //de la suma ponderada de les seves prestacions. Aquest resultat es el que
        //utilitzarem per a ordenar els vaixells

    }

}
