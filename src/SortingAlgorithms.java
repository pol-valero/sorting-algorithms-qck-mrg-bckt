package src;

import java.util.LinkedList;

public class SortingAlgorithms {




    public static void quickSortAge(LinkedList<Vessel> vessels) {
        quickSortAge(vessels, 0, vessels.size() - 1);
    }

    private static void quickSortAge(LinkedList<Vessel> vessels, int i, int j) {
        int p;
        if (i >= j) {
            return;
        } else {
            p = partition(vessels, i, j);
            quickSortAge(vessels, i, p);
            quickSortAge(vessels, p + 1, j);

        }
    }

    private static int partition(LinkedList<Vessel> vessels, int i, int j) {

        Vessel auxVessel;

        int l, r;
        int middle;
        int pivot;

        l = i;
        r = j;

        middle = (i + j) / 2;

        pivot = vessels.get(middle).id;

        while (true) {

            while(vessels.get(l).id < pivot) {
                l++;
            }
            while(vessels.get(r).id > pivot) {
                r--;
            }

            if (l >= r) {
                return r;
            }

            auxVessel = vessels.get(l);
            vessels.set(l, vessels.get(r));
            vessels.set(r, auxVessel);

            l++;
            r--;

        }

    }

    //Funcion pantalla
    public static void mergeSortName(LinkedList<Vessel> vessels) {
        mergeSortName(vessels, 0, vessels.size() - 1);
    }


        /*Esta funcion divide la linked list en varias funciones, donde tambien llama a si mismo para seguir dividiendose hasta quedar 1 */

    public static void mergeSortName(LinkedList<Vessel> vessels, int left, int right) {
        if (left < right) {
            //Encuentra el punto medio del vector.
            int middle = (left + right) / 2;

            //Divide la primera y segunda mitad (llamada recursiva).
            mergeSortName(vessels, left, middle);
            mergeSortName(vessels, middle + 1, right);

            //Une las mitades.
            merge(vessels, left, middle, right);
        }
    }

    /* Esta funcion compara si la letra es mayor que el de la derecha, si es asi hace un swap dels dos objectes */

    private static void merge(LinkedList<Vessel> vessels, int left, int middle, int right) {

        int i, j, k;
        LinkedList<Vessel> B = null;

        for (i = left; i <= right; i++)      //copia ambas mitades en el array auxiliar
            B = (LinkedList<Vessel>) vessels.clone();

        i = left;
        j = middle + 1;
        k = left;


        while (i <= middle && j <= right) //copia el siguiente elemento más grande
            if (B.get(i).name.charAt(0) <= B.get(j).name.charAt(0))
                vessels.set(k++, B.get(i++));
            else
                vessels.set(k++, B.get(j++));

        while (i <= middle)                 //copia los elementos que quedan de la
            vessels.set(k++, B.get(i++));          //primera mitad (si los hay)
    }


        public static void bucketSortCapabilities (LinkedList <Vessel> vessels) {
            //Per ordenar vaixells per prestacions, primer hem de ponderar els seus
            //atributs (pes, eslora, capacitat, velocitat max) amb un pes diferent
            //cadascun. Un cop això estigui fet, per cada vaixell tindrem un resultat
            //de la suma ponderada de les seves prestacions. Aquest resultat es el que
            //utilitzarem per a ordenar els vaixells

        }
}






