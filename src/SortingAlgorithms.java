package src;

import java.lang.reflect.Field;
import java.util.LinkedList;

public class SortingAlgorithms {

    //Aquesta funció només s'utilitza per a printejar l'array d'objectes
    //completa per pantalla (per testejar). S'ha de borrar al final.
    private static void printAllDatasetObjects(LinkedList<Vessel> vessels) {
        for (Vessel vessel : vessels) {
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

    public static void quickSortAge(LinkedList<Vessel> vessels) {

    }

    /*Esta funcion divide la linked list en varias funciones, donde tambien llama a si mismo para seguir dividiendose hasta quedar 1 */

    public static void mergeSort_sort(LinkedList<Vessel> vessels, int left, int right) {
        if (left < right) {
            //Encuentra el punto medio del vector.
            int middle = (left + right) / 2;

            //Divide la primera y segunda mitad (llamada recursiva).
            mergeSort_sort(vessels, left, middle);
            mergeSort_sort(vessels, middle + 1, right);

            //Une las mitades.
            mergeSort_merge(vessels, left, middle, right);
        }
    }

    /* Esta funcion compara si la letra es mayor que el de la derecha, si es asi hace un swap dels dos objectes */

    private static void mergeSort_merge(LinkedList<Vessel> vessels, int left, int middle, int right) {

        int i, j, k;
        LinkedList<Vessel> B = null;

        for (i = left; i <= right; i++)      //copia ambas mitades en el array auxiliar
            B = (LinkedList<Vessel>) vessels.clone();

        i = left;
        j = middle + 1;
        k = left;


        while (i <= middle && j <= right) //copia el siguiente elemento más grande
            if (Character.compare(B.get(i).getName().charAt(0), B.get(j).getName().charAt(0)) <= 0)
                vessels.set(k++, B.get(i++));
            else
                vessels.set(k++, B.get(j++));

        while (i <= middle)                 //copia los elementos que quedan de la
            vessels.set(k++, B.get(i++));          //primera mitad (si los hay)
    }


        public static void bucketSortCapabilities (LinkedList < Vessel > vessels) {
            //Per ordenar vaixells per prestacions, primer hem de ponderar els seus
            //atributs (pes, eslora, capacitat, velocitat max) amb un pes diferent
            //cadascun. Un cop això estigui fet, per cada vaixell tindrem un resultat
            //de la suma ponderada de les seves prestacions. Aquest resultat es el que
            //utilitzarem per a ordenar els vaixells

        }
}






